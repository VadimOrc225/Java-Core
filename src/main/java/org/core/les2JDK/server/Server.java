package org.core.les2JDK.server;

import org.core.les2JDK.client.Client;
import org.core.les2JDK.client.ClientGUI;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final String LOG_PATH = "./log.txt";

    static List<Client> clientList;
    private ServerView serverView;
    private Client client;
    static boolean work;

    public Server(ServerView serverView) {
        this.serverView = serverView;
//        this.client = client;
        clientList = new ArrayList<>();
    }

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public static void disconnectUser(Client client) {

        if (client != null) {
            System.out.println("$$$");
            clientList.remove(client);
            client.disconnectFromServer();

        }
    }

    public String getLog() {
        return readLog();
    }

    public String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void answerAll(String text) {
        for (Client client : clientList) {
            client.answerFromServer(text);
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void message(String text) {
        if (!work) {
            return;
        }
        serverView.appendLog(text);
        answerAll(text);
        saveInLog(text);
    }
}
