package main;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.LinkedList;
import java.util.List;

public class Server extends WebSocketServer {

    public Server(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("connection opened!");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("connection closed because of: " + reason + "(code " + code + ")");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
        List<RobotAction> robotActions = new LinkedList<>();
        for (String key : jsonObject.keySet()) {
            robotActions.add(gson.fromJson(jsonObject.get(key), RobotAction.class));
        }
        Main.onRobotActionsReceived(robotActions);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.out.println("server error: " + ex.getMessage());
    }

    @Override
    public void onStart() {
        System.out.println("started server on port " + Config.PORT);
    }
}
