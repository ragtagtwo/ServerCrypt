package tcpServer;

import java.io.IOException;

public class main {
    private ClientCrypt client ;
    public void setup() throws IOException {
        client = new ClientCrypt();
        client.StartConnection("127.0.0.1", 4444);
    }
    public void tearDown() throws IOException {
        client.stopConnection();
    }
    public void givenClient_whenServerEchosMessage_thenCorrect() throws IOException {
        String resp1 = client.sendMessage("hello");
        System.out.println(resp1);
        String resp2 = client.sendMessage("world");
        System.out.println(resp2);
        String resp3 = client.sendMessage("!");
        System.out.println(resp3);
        String resp4 = client.sendMessage("end");
        System.out.println(resp4);
    }
    public static void main(String args[]) throws IOException {
        main m=new main();
        m.setup();
        m.givenClient_whenServerEchosMessage_thenCorrect();
    }

}
