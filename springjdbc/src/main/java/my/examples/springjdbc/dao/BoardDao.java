package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.Board;

import java.util.List;

public interface BoardDao {
      public Board getBoard(long post_id);
//      public List<Board> getBoards();
      public List<Board> getBoards(int start, int limit);
//    public Long addBoard(Board board);
//    public Long deleteBoard(Board board);
//    public Board readBoard(Board board);


}
