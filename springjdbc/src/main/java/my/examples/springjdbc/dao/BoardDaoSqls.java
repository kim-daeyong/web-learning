package my.examples.springjdbc.dao;

public class BoardDaoSqls {

    public static final String getBoard = "SELECT post_id, nickname, title, content, regdate FROM freepost where post_id = :post_id ";
    public static final String SELECT_BY_PAGING =
            "select post_id, title, nickname, regdate, view, content  from freepost limit :start, :limit";
    public static final String addBoard = "INSERT  ";
}
