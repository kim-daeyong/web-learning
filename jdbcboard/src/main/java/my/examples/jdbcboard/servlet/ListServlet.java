package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    private static final int SIZE = 3; // 설정파일에서 읽어들이도록 수정한다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. page 값을 파라미터로 읽어들인다. 값이 없으면 기본값은 1페이지로 한다.
        String pageStr = req.getParameter("page");
        int page = 1;
        try{
            page = Integer.parseInt(pageStr);
        }catch(Exception ignore){}
        // 2. 1페이지란 0부터 시작하여 3건을 의미한다.
        BoardService boardService = new BoardServiceImpl();
        List<Board> boards = boardService.getBoards(page);
        // 4. request에 3에서 구한값을 setAttribute로 담아서 jsp에게 전달한다.
        req.setAttribute("boards", boards);
        // 5. jsp에서는 jstl과 el로 결과를 출력한다.

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/board.jsp");
        requestDispatcher.forward(req, resp);
    }
}
