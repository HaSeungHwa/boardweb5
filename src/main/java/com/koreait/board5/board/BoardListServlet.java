package com.koreait.board5.board;

import com.koreait.board5.dao.BoardDAO;
import com.koreait.board5.model.BoardVO;
import com.koreait.board5.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<BoardVO> list = BoardDAO.selBoardList();
        req.setAttribute("listAll", list);

        String jsp = "/WEB-INF/view/board/list.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}