package my.examples.springjdbc.dao;

public class BoardDaoSqls {

    public static final String getBoard = "SELECT post_id, nickname, title, content, regdate FROM freepost where post_id = :post_id ";
    public static final String getBoards = "select post_id,title,nickname,content,regdate,view from freepost ORDER BY post_id desc limit";

    public static final String addBoard = "INSERT  ";
}
