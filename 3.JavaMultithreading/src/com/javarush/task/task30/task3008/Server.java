package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> entry: connectionMap.entrySet()) {
            String clientName = entry.getKey();
            Connection connection = entry.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                 ConsoleHelper.writeMessage("I'm sorry. An error occurred while sending the message to " + clientName);
            }
        }
    }
    private static class Handler extends Thread{
        public Socket socket;
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true) {
               connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME) {
                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }
    private void sendListOfUsers(Connection connection, String userName) throws IOException{
        String name;
        for (Map.Entry map :connectionMap.entrySet()) {
            name = map.getKey().toString();
            if (!name.equals(userName)) {
                 Message messageWithUserList = new Message(MessageType.USER_ADDED, name);
                 connection.send(messageWithUserList);
            }
        }
    }

    private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                   Message getRecieve = connection.receive();
                   String message;
                   if(MessageType.TEXT.equals(getRecieve.getType())){
                       message = userName + ": " + getRecieve.getData();
                       sendBroadcastMessage(new Message(MessageType.TEXT,message));
                   } else
                        ConsoleHelper.writeMessage("Данное сообщение не является текстом");
            }
    }
        @Override
        public void run() {
            String userName ="";
            System.out.println(socket.getRemoteSocketAddress());
         try (Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                sendListOfUsers(connection,userName);
                serverMainLoop(connection,userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            } catch (IOException | ClassNotFoundException e) {
             ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
         }
         ConsoleHelper.writeMessage("Соединение закрыто");
        }

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
    public static void main(String[] args) throws IOException{
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            ConsoleHelper.writeMessage("Server is started");
            while (true){
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }

        }catch (Exception e){
            ConsoleHelper.writeMessage("Error connection");
        }
    }
}
