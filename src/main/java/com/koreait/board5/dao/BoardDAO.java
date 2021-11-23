package com.koreait.board5.dao;

import com.koreait.board5.model.BoardVO;
import com.koreait.board5.model.UserVO;
import com.koreait.board5.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public static List<BoardVO> selBoardList() {
        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_board";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return list;
    }

    public static int insBoard(BoardVO inputTitCtn) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_board (title, ctnt, writer, rdt) VALUES (?, ?, ?, ?)";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, inputTitCtn.getTitle());
            ps.setString(2, inputTitCtn.getCtnt());
            ps.setInt(3, inputTitCtn.getWriter());
            ps.setString(4, inputTitCtn.getRdt());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }
}
