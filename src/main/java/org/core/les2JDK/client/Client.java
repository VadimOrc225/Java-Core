package org.core.les2JDK.client;
import org.core.les2JDK.server.Server;
public class Client {
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean connected;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(this)){
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            String log = server.readLog();
            if (log != null){
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }
    public void disconnectFromServer(){
        if (connected) {
            System.out.println("дошли до клиента");
            connected = false;
            server.disconnectUser(this);
            clientView.disconnectedFromServer();
            showOnWindow("Вы были отключены от сервера!");
        }
    }
    //нам посылают
    public void answerFromServer(String messageFromServer){
showOnWindow(messageFromServer);
    }

    //мы посылаем
    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                server.message(name + ": " + message);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    private void showOnWindow(String text){
        clientView.sendMessage(text);
    }
}


