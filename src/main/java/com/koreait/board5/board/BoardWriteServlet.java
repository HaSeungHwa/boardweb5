package com.koreait.board5.board;

import com.koreait.board5.dao.BoardDAO;
import com.koreait.board5.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        String jsp = "/WEB-INF/view/board/write.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String strtitle = req.getParameter("writeTitle");
        String strctnt = req.getParameter("writeCtnt");

        

        BoardVO inputTitCtn = new BoardVO();
        inputTitCtn.setTitle(strtitle);
        inputTitCtn.setCtnt(strctnt);
        inputTitCtn.setWriter(writer);
        inputTitCtn.setRdt(rdt);
        int result = BoardDAO.insBoard(inputTitCtn);
    }
}