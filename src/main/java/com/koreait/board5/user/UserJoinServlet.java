package com.koreait.board5.user;

import com.koreait.board5.dao.UserDAO;
import com.koreait.board5.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jsp = "/WEB-INF/view/user/join.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String strid = req.getParameter("joinId");
        String strpw = req.getParameter("joinPw");
        String strnm = req.getParameter("joinNm");
        String strgender = req.getParameter("gender");
        int gender = Integer.parseInt(strgender);

        UserVO joinUser = new UserVO();
        joinUser.setUid(strid);
        joinUser.setUpw(strpw);
        joinUser.setNm(strnm);
        joinUser.setGender(gender);
        
        int result = UserDAO.join(joinUser);
        switch (result) {
            case 1:
                res.sendRedirect("/user/login");
                break;
            case 0:
                req.setAttribute("err", "가입 실패");
                doGet(req, res);    // 다시 Get으로
                break;
        }
    }
}