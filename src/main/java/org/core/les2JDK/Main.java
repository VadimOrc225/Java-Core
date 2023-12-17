package org.core.les2JDK;

import org.core.les2JDK.client.ClientGUI;
import org.core.les2JDK.server.Server;
import org.core.les2JDK.server.ServerView;
import org.core.les2JDK.server.ServerWindow;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);

    }
}

