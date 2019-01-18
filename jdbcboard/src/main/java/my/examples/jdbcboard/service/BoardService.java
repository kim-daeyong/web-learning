package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.Board;

import java.util.List;

public interface BoardService {
    // page에 해당하는 목록을 읽어온다.
    // 전체 건수를 읽어온다.
    // 글을 읽어온다. (글읽기 + 조회수증가)
    // 글을 삭제한다.
    public List<Board> getBoards(int page);
    public Board getBoard(Long id);
    public void deleteBoard(Long id);

    void addBoard(Board board);

    void addReBoard(Board board);
}
