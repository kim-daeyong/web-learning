package my.examples.chat.client;

import my.examples.chat.common.ChatUser;

public class ChatClientHandler extends Thread{
    private ChatUser chatUser;
    public ChatClientHandler(ChatUser chatUser){
        this.chatUser = chatUser;
    }

    public void run(){
        while(true){
            String line = chatUser.read();// 서버가 보내주는 정보를 읽어들인다.
            System.out.println(line);
        }
    }
}
