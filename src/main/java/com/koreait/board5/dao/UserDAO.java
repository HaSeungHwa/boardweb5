package com.koreait.board5.dao;

import com.koreait.board5.model.UserVO;
import com.koreait.board5.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public static int login(UserVO inputIdPw) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_user WHERE uid = ?";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, inputIdPw.getUid());
            rs = ps.executeQuery();
            if (rs.next()) {
                inputIdPw.setIuser(rs.getInt("iuser"));
                inputIdPw.setNm(rs.getString("nm"));

                String upw = rs.getString("upw");
                return upw.equals(inputIdPw.getUpw()) ? 1 : 3;
            }
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }

    public static int join(UserVO joinUser) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_user (uid, upw, nm, gender) VALUES (?, ?, ?, ?)";
        try {
            con = DbUtils.getCon();
            ps= con.prepareStatement(sql);
            ps.setString(1, joinUser.getUid());
            ps.setString(2, joinUser.getUpw());
            ps.setString(3, joinUser.getNm());
            ps.setInt(4, joinUser.getGender());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }
}
