package my.examples.springjdbc;

import my.examples.springjdbc.config.ApplicationConfig;
import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.Board;
import my.examples.springjdbc.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringBoardExam {
        public static void main(String[] args){
            ApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(ApplicationConfig.class);
            BoardDao boardDao = applicationContext.getBean(BoardDao.class);
//            int SIZE = 5;
//            int start = SIZE - SIZE;
//            int limit = SIZE;
//            List<Board> boards = boardDao.getBoards(start,limit);
        List<Board> boards = boardDao.getBoards(0,5);
            for(Board board : boards){
                System.out.println(board);
            }
//        boards.forEach((free) -> System.out.println(free));
            UserDao userDao = applicationContext.getBean(UserDao.class);

            List<User> users = userDao.selectAll();
            for(User user : users){
                System.out.println(user);
            }

    }

}
