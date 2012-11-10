package real.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import real.action.sql.ConnectionFactory;

public class LoginDao {
	public static boolean isLogin(String uname, String passwd) {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from users where u_name=? and u_password=?";
		try {
			conn = ConnectionFactory.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, uname);
			stm.setString(2, passwd);
			rs = stm.executeQuery();
			if (rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			// 因为使用ConnectionFactory工厂类维护一个线程安全的connection, 执行完成或发生异常时并不需要关闭conn!
			e.printStackTrace();
			return false;
		} finally {
			try {
				rs.close();
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}