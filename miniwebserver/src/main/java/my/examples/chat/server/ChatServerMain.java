package my.examples.chat.server;

public class ChatServerMain {
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer(9999);
        chatServer.run();
    }
}
