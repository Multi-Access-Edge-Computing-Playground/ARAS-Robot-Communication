package main;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

public class MyWebSocketClient extends WebSocketClient {

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send("give data");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("received: " + message);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
        List<RobotAction> robotActions = new LinkedList<>();
        for (String key : jsonObject.keySet()) {
            robotActions.add(gson.fromJson(jsonObject.get(key), RobotAction.class));
        }
        Main.onRobotActionsReceived(robotActions);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("connection closed because: " + reason + " (code: " + code + ")");
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("error: " + ex.getMessage());
    }

}
