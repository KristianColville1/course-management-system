/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import cms.server.adapters.JettyHttpRequestAdapter;
import cms.server.adapters.JettyHttpResponseAdapter;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;
import cms.server.annotations.Route;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kristian
 *
 * Responsible for handling incoming HTTP requests. Routes the requests to the
 * appropriate controllers.
 *
 * Wraps incoming server request and response objects in abstract adapters.
 * Determines the appropriate controller to handle the request. Invokes the
 * controller with the abstract request and response object. Ensures that the
 * processed response is sent back to the client.
 */
public class RequestHandler extends AbstractHandler {

    // instance fields
    private final DynamicRouter router;

    /**
     * Default Constructor for RequestHandler
     *
     * Sets up the dynamic router to use.
     */
    public RequestHandler() {
        this.router = new DynamicRouter();
    }

    /**
     * Responsible for scanning controller classes for methods annotated with
     * {@code @Route} and registers these routes. Slightly more dynamic
     * approach.
     *
     * Each route is associated with a specific controller instance and a method
     * that handles the request.
     *
     * Assumes each controller class has a no-argument constructor and that the
     * methods handling routes take a {@code IHttpRequest} and
     * {@code IHttpResponse} as parameters.
     *
     * Exceptions during the creation of controller instances or method
     * invocation are wrapped and thrown again as RunTimeExceptions.
     */
    private void registerAnnotatedRoutes() {
        List<Class<? extends ControllerBase>> controllerClasses
                = new ArrayList<>();
        // TODO: Populate list above with Controller classes

        for (Class<? extends ControllerBase> controllerClass : controllerClasses) {
            for (Method method : controllerClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Route.class)) {
                    Route routeAnnotation = method.getAnnotation(Route.class);

                    // Instantiate the controller class
                    ControllerBase controllerInstance;
                    try {
                        controllerInstance = controllerClass.newInstance();

                        // ensures the method is accessible
                        method.setAccessible(true);

                        // Create a ServerRoute with the controller method logic
                        // encapsulated within a handleRequest invocation
                        ServerRoute route = new ServerRoute(
                                routeAnnotation.path(),
                                routeAnnotation.method(),
                                new ControllerBase() {
                            @Override
                            public void handleRequest(
                                    IHttpRequest request,
                                    IHttpResponse response) {
                                try {
                                    method.invoke(
                                            controllerInstance,
                                            request,
                                            response);
                                } catch (IllegalAccessException
                                        | InvocationTargetException e) {
                                    throw new RuntimeException(
                                            "Error while handling request",
                                            e);
                                }
                            }
                        }
                        );

                        // register the route with the router
                        router.registerRoute(route);

                    } catch (InstantiationException | IllegalAccessException e) {
                        // Log or handle the instantiation error as appropriate for your application
                        throw new RuntimeException("Failed to instantiate controller class", e);
                    }
                }
            }
        }
    }

    /**
     * Processes all HTTP requests and delegates the work to the controllers. It
     * is overridden from AbstractHandler and is called by the server for each
     * request. It adapts the request and response objects, performs the routing
     * and invokes controller logic.
     *
     * @param target of the request is used for routing
     * @param baseRequest is the raw request received by the server
     * @param request is the servlet request use for providing a HTTP request
     * view
     * @param response is the servlet response used for constructing HTTP
     * response
     * @throws IOException is an input or output exception occurs
     * @throws ServletException if an exception occurs that interrupts the
     * handlers operation
     */
    @Override
    public void handle(
            String target,
            Request baseRequest,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        IHttpRequest adaptedRequest = new JettyHttpRequestAdapter(request);
        IHttpResponse adaptedResponse = new JettyHttpResponseAdapter(response);

        // Delegate to the DynamicRouter for request routing
        router.routeRequest(adaptedRequest, adaptedResponse);
        baseRequest.setHandled(true);
    }
}
