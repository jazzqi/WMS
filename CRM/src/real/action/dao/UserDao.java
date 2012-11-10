package real.action.dao;
import real.action.sql.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import real.action.data.UserData;
import javax.swing.JOptionPane;

public class UserDao{
	private String sql;
	Connection conn=null;
	PreparedStatement stm=null;
	public UserDao(){
		try {
			conn=ConnectionFactory.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean setPassword(UserData user,String passwd2){
		if(this.getPassword(user).equals(user.getPasswd())){//验证输入的原密码与数据库中的密码是否匹配
			sql="update users set u_password=? where u_name=?";
			try {
				stm=conn.prepareStatement(sql);
				stm.setString(1, passwd2);
				stm.setString(2, user.getName());
				if(stm.executeUpdate()==1)	return true;
				else	return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} finally {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else return false;
		
	}
	public String getUsername(){
		return real.action.view.login.LoginPanel.loggedID;
	}
	private String getPassword(UserData user){//两个作用：1.返回密码，用于检查用户输入的密码是否正确。2返回null，说明用户不存在。
		sql="select * from users where u_name=?";
		ResultSet rs = null;
		try{
			stm=conn.prepareStatement(sql);
			stm.setString(1,user.getName());
			rs=stm.executeQuery();
			if(rs.next()){
				return rs.getString("u_password");
			}else return null;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
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
	public boolean addUser(UserData user){
		if(this.getPassword(user)==null){//判断用户是否已经存在
			sql="insert into users values (?,?,1)";
			try {
				stm=conn.prepareStatement(sql);
				stm.setString(1, user.getName());
				stm.setString(2, user.getPasswd());
				int i=stm.executeUpdate();
				if(i==1)	return true;
				else	return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} finally {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else return false;
	}
	public boolean deleteUser(UserData user){
		sql="delete from users where u_name=?";
		try{
			stm=conn.prepareStatement(sql);
			stm.setString(1, user.getName());
			int i=stm.executeUpdate();
			if(i==1)	return true;
			else	return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}