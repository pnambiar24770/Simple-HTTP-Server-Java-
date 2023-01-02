import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(24770);
        System.out.println("Listening for connection on port 24770....");
        while(true){
            /*final Socket clientSocket = server.accept();
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while(!line.isEmpty()){
                System.out.println(line);
                line=reader.readLine();

             */
            try(Socket socket=server.accept()){
                Date today=new Date();
                String httpResponse=" "+today;
                String test="HTTP/1.1 200 OK\r\n\r\n"+"Hello this is my HTTP server.I created it on";
                socket.getOutputStream().write(test.getBytes("UTF-8"));
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }


    }
}