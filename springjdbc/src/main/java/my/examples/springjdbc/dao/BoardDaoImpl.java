package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.Board;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static my.examples.springjdbc.dao.BoardDaoSqls.getBoards;

public class BoardDaoImpl implements BoardDao {
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    @Override
    public Board getBoard(long post_id) {
        Board board = null;
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("post_id", post_id);
        try {
            board = jdbc.queryForObject(getBoards, paraMap, rowMapper);
        }catch(Exception ex){
            System.out.println("게시물이 없습니다.");
        }

        return board;
    }


    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> list = new ArrayList<>();
        Map<String, Object> paraMap = new HashMap<>(start, limit);
        try{
           list = jdbc.query(getBoards, paraMap,rowMapper);

//         list.forEach((free) -> System.out.println(free));
        }catch(Exception ex){
            System.out.println("게시물이 없습니다.");
        }
        return list;
    }
}
