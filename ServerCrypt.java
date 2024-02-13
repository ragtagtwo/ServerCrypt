package tcpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.concurrent.Callable;

public class ServerCrypt {
    private ServerSocket ServerSocket;
    private Socket ClientSocket;
    private PrintWriter out;
    private BufferedReader in ;




    public String encodeToBase64(String plainText) {
            byte[] plainBytes = plainText.getBytes();
            byte[] base64Bytes = Base64.getEncoder().encode(plainBytes);
            return new String(base64Bytes);
    }

    public void start(int port ) throws IOException {
        ServerSocket = new ServerSocket(port);
        ClientSocket= ServerSocket.accept();
        in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
        out = new PrintWriter(ClientSocket.getOutputStream(),true);
        String input;
        while((input=in.readLine())!=null){
            if(input.equals("end")){
                out.println("session terminated!");
                break;
            }
            String crypted=encodeToBase64(input);
            out.println(crypted);
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        ClientSocket.close();
        ServerSocket.close();
    }
    public static void main(String[] args) throws IOException {
        ServerCrypt server=new ServerCrypt();
        server.start(4444);
    }


}
