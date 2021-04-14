package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;

public class Main {

    static PrintWriter out;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        URI uri = URI.create("ws://" + Config.IP + ":" + Config.PORT);
        MyWebSocketClient myWebSocketClient = new MyWebSocketClient(uri);
        myWebSocketClient.connect();
//        Socket clientSocket = new Socket(Config.IP, Config.PORT);
//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        String response = sendMessage("test");
//        System.out.println(response);
    }

    public static String sendMessage(String msg) {
        out.println(msg);
        String resp = null;
        try {
            resp = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }


    protected static void onRobotActionsReceived(List<RobotAction> robotActions) {
        //do something
        System.out.println(robotActions.toString());
    }
}
