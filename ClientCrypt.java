package tcpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCrypt {
    private Socket ClientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public void StartConnection(String ip,int port) throws IOException {
        ClientSocket = new Socket(ip,port);
        out=new PrintWriter(ClientSocket.getOutputStream(),true);
        in=new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));

    }
    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        ClientSocket.close();
    }

}
