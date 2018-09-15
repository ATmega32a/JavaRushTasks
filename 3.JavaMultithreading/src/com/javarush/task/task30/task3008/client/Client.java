package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress(){
        return ConsoleHelper.readString();
    }
    protected int getServerPort(){
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            e.printStackTrace();
            ConsoleHelper.writeMessage(e.getMessage());
            clientConnected = false;
        }
    }
    public synchronized void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            wait();
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
        notify();
        if(clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
             else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        while (clientConnected){
            String messageRead =  ConsoleHelper.readString();
            if(messageRead.equals("exit")) break;
            if(shouldSendTextFromConsole()) sendTextMessage(messageRead);
        }
    }

    public class SocketThread extends Thread{
       protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
       }
       protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Пользователь " + userName + " присоединился к чату");
       }
       protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Пользователь " + userName + "покинул чат");
       }
       protected void notifyConnectionStatusChanged(boolean clientConnected){
            synchronized (Client.this){
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
       }
    protected void clientHandshake() throws IOException, ClassNotFoundException{
           while (true){
                Message message = connection.receive();
                if(MessageType.NAME_REQUEST.equals(message.getType())){
                   String userName =  getUserName();
                   Message messageToConsol = new Message(MessageType.USER_NAME,userName);
                   connection.send(messageToConsol);
                } else if(MessageType.NAME_ACCEPTED.equals(message.getType())){
                    notifyConnectionStatusChanged(true);
                    break;
                } else throw new IOException("Unexpected MessageType");
           }
    }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(MessageType.TEXT.equals(message.getType()))
                    processIncomingMessage(message.getData());
                    else
                        if(MessageType.USER_ADDED.equals(message.getType()))
                            informAboutAddingNewUser(message.getData());
                            else
                                if(MessageType.USER_REMOVED.equals(message.getType()))
                                    informAboutDeletingNewUser(message.getData());
                                    else
                                        throw new IOException("Unexpected MessageType");
                }
            }
        public void run(){
            try {
                Socket socket = new Socket(getServerAddress(),getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }

        }
        }
    
    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }

}

