package org.core.les2JDK.server;

import org.core.les2JDK.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;


    JButton btnStart, btnStop;
    JTextArea log;

    public Server server;

    public ServerWindow() {
        this.server = new Server(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }


    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Server.work) {
                    appendLog("Сервер уже был запущен");
                } else {
                    Server.work = true;
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Server.work) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    Server.work = false;
                    for (Client client : server.clientList) {
                        disconnectUser(client);
                    }
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    public Server getConnection() {
        return new Server(this);

    }

    @Override
    public void sendMessage(String message) {
        server.message(message);

    }

    @Override
    public void disconnectUser(Client client) {
        Server.disconnectUser(client);
    }


    @Override
    public void appendLog(String text) {
        {
            log.append(text + "\n");
        }
    }
}