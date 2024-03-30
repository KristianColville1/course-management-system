/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author kristian
 *
 * Handles the responsibility of resending requests internally. If we were using
 * as front-end other than the terminal this would not be necessary. We are
 * using this class to help route the user around the application.
 */
public class InternalRequestHandler {

    /**
     * Static method for sending internal requests.
     * 
     * @param originalRequest the original request made
     * @param path the destination of the new request
     * @param method of the new request
     * @return request
     */
    public static String sendRequest(
            IHttpRequest originalRequest,
            String path,
            String method) {
        HttpURLConnection connection = null;
        try {
            // construct URL from original request details
            String urlString
                    = String.format(
                            "%s:%d%s",
                            originalRequest.getScheme()
                            + "://"
                            + originalRequest.getServerName(),
                            originalRequest.getServerPort(),
                            path);
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod(method);

            // Read response
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream(),
                            "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
