package com.koreait.board5.user;

import com.koreait.board5.dao.UserDAO;
import com.koreait.board5.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jsp = "/WEB-INF/view/user/login.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String strid = req.getParameter("inputId");
        String strpw = req.getParameter("inputPw");

        UserVO inputIdPw = new UserVO();
        inputIdPw.setUid(strid);
        inputIdPw.setUpw(strpw);

        int result = UserDAO.login(inputIdPw);
        if (result == 1) {
            inputIdPw.setUpw(null); // 자리차지 지워주기

            HttpSession session = req.getSession();
            session.setAttribute("loginUser", inputIdPw);
            
            res.sendRedirect("/board/list");
            return;
        }
        String err = null;
        switch (result) {
            case 0:
                err = "로그인 실패";
                break;
            case 2:
                err= "아이디를 확인해주세요";
                break;
            default:
                err= "비밀번호를 확인해주세요";
                break;
        }
        req.setAttribute("err", err);
        doGet(req, res);    //로긴페이지로
    }
}