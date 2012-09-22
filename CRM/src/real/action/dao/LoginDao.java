package real.action.dao;
import real.action.sql.*;
import java.sql.*;
public class LoginDao{
	public static boolean isLogin(String uname,String passwd){
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		String sql="select * from users where u_name=? and u_password=?";
		try {
			conn=ConnectionFactory.getConnection();
			stm=conn.prepareStatement(sql);
			stm.setString(1, uname);
			stm.setString(2, passwd);
			rs=stm.executeQuery();
			if(rs.next())	return true;
			else	return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}