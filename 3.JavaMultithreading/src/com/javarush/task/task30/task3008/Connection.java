package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable{
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public Connection(Socket socket) throws IOException{
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message)throws IOException{
        synchronized (out){
          //  ConsoleHelper.writeMessage(String.valueOf(message));
            out.writeObject(message);
            out.flush();
        }

    }

    public Message receive()throws IOException,ClassNotFoundException{
       Message message;
       synchronized (in){
          message = (Message) in.readObject();
         // ConsoleHelper.writeMessage(String.valueOf(message));
       }
       return message;
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException{
        out.close();
        in.close();
        socket.close();
    }
}
