
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class webServer {

    public static void main(String args[]) {

        webServer ws = new webServer();
        ws.makeServer();
    }

    public void makeServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(7777);

            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            System.out.println("---------------------");

            // send HTTP Headers
            out.println("HTTP/1.1 200 OK");
            out.println("Server: Java HTTP Server from SSaurel : 1.0");
            out.println("Date: " + new Date());
            out.println("Content-type: html");
            out.println("Content-length: 101");
            out.println(); // blank line between headers and content, very important !
            out.flush(); // flush character output stream buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
