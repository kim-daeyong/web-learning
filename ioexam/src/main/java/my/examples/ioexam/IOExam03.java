package my.examples.ioexam;

import java.util.List;

public class IOExam03 {
    public static void main(String[] args){
        // 1. 폴더를 지정하면, 그 폴더와 그 이하의 정보들을 어떤 자료구조로
        //    만들어서 전달받고 싶다.
        // 2. Folder 클래스 안에는 읽어온 정보가 저장되어 있다.
        Folder folder = FileManager.scan("/Users/urstory/Desktop");
        System.out.println(folder);
        List<Folder> folders = folder.getFolders();
        for(Folder folder1 : folders){
            System.out.println(folder1.getName());
        }
    }
}
