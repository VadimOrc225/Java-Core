package org.core.les2JDK.client;

public interface ClientView {
    void sendMessage(String message);
    void disconnectedFromServer();
    void connectedToServer();
}