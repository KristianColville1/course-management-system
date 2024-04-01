/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.home.views;

import cms.mvc.views.BaseView;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.utils.Terminal;
import com.github.lalyos.jfiglet.FigletFont;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author kristian
 */
public class HomeView extends BaseView {

    private Map<Integer, String> userOptions;
    /**
     * Renders the heading content
     *
     * @param request
     * @param response
     */
    @Override
    protected void renderContent(
            IHttpRequest request,
            IHttpResponse response) {
        Terminal.clearConsole();
        Terminal.addDashHeader();
        try {
            System.out.println(
                    FigletFont.convertOneLine("WELCOME"));;
            System.out.println(
                    FigletFont.convertOneLine("--CMS--"));
            System.out.println("            "
                    + "        © Course Management System 2024");
            Terminal.addDashHeader();

            System.out.println("\n\n");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
