package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
   public class BotSocketThread extends SocketThread{
       @Override
       protected void clientMainLoop() throws IOException, ClassNotFoundException{
           sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
           super.clientMainLoop();
       }
       @Override
       protected void processIncomingMessage(String message) {
           ConsoleHelper.writeMessage(message);

           if (message != null && message.contains(": ")) {
               String userName = message.split(": ")[0];
               String text = message.split(": ")[1];
               switch (text) {
                   case "дата":
                       assert false;
                       textAndDateFormatter(userName, "d.MM.YYYY");
                       break;
                   case "день":
                       assert false;
                       textAndDateFormatter(userName, "d");
                       break;
                   case "месяц":
                       assert false;
                       textAndDateFormatter(userName, "MMMM");
                       break;
                   case "год":
                       assert false;
                       textAndDateFormatter(userName,  "YYYY");
                       break;
                   case "время":
                       assert false;
                       textAndDateFormatter(userName, "H:mm:ss");
                       break;
                   case "час":
                       assert false;
                       textAndDateFormatter(userName, "H");
                       break;
                   case "минуты":
                       assert false;
                       textAndDateFormatter(userName,  "m");
                       break;
                   case "секунды":
                       assert false;
                       textAndDateFormatter(userName,  "s");
                       break;

               }
           }
       }
    }
    private void textAndDateFormatter(String userName, String dateFormat){
        DateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String dateFormatted = simpleDateFormat.format(Calendar.getInstance().getTime());
        sendTextMessage("Информация для " + userName+": " + dateFormatted);
    }
    @Override
    protected SocketThread getSocketThread(){
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole(){
        return false;
    }
    @Override
    protected String getUserName(){
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

}
