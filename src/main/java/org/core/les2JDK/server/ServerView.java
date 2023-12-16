package org.core.les2JDK.server;

import org.core.les2JDK.client.Client;

public interface ServerView {
    void sendMessage(String message);
    void disconnectUser(Client client);

    void appendLog(String text);
}
