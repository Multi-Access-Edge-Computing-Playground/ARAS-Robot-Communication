package main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(Config.PORT);
        server.start();
    }

    protected static void onRobotActionsReceived(List<RobotAction> robotActions) {
        //do something
    }
}
