package real.action.dao;
import java.sql.*;

import real.action.data.SupplierData;
import real.action.sql.*;
public class SupplierDao{
	private String sql;
	Connection conn=null;
	PreparedStatement stm=null;
	public SupplierDao(){
		try {
			conn=ConnectionFactory.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int getSup_id(String sup_name){
		String sql2="select sup_id from suppliers where sup_name=?";
		Connection conn2=null;
		try {
			conn2 = ConnectionFactory.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm=conn2.prepareStatement(sql2);
			pstm.setString(1, sup_name);
			rs=pstm.executeQuery();
			if(rs.next()){
				return Integer.parseInt(rs.getString("sup_id"));
			}else	return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static boolean insertSupplier(SupplierData supplier){
		String sql2="insert into suppliers values (?,?,?,?,?,?,?,?)";
		Connection conn2=null;
		PreparedStatement pstm = null;
		try{
			conn2=ConnectionFactory.getConnection();
			pstm=conn2.prepareStatement(sql2);
			pstm.setInt(1, supplier.getSup_id());
			pstm.setString(2,supplier.getSup_name());
			pstm.setString(3, supplier.getSup_address());
			pstm.setString(4,supplier.getPostcode());
			pstm.setString(5, supplier.getSup_telephone());
			pstm.setString(6,supplier.getSup_fax());
			pstm.setString(7, supplier.getSup_relationer());
			pstm.setString(8, supplier.getSup_email());
			if(pstm.executeUpdate()==1){
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static boolean modifySupplier(SupplierData supplier){
		String sql2="update suppliers set sup_name=?,sup_address=?,postcode=?,sup_telephone=?,sup_fax=?,sup_relationer=?,sup_email=? where sup_id=?";
		Connection conn2=null;
		PreparedStatement pstm = null;
		try{
			conn2=ConnectionFactory.getConnection();
			pstm=conn2.prepareStatement(sql2);
			pstm.setString(1,supplier.getSup_name());
			pstm.setString(2, supplier.getSup_address());
			pstm.setString(3,supplier.getPostcode());
			pstm.setString(4, supplier.getSup_telephone());
			pstm.setString(5,supplier.getSup_fax());
			pstm.setString(6, supplier.getSup_relationer());
			pstm.setString(7, supplier.getSup_email());
			pstm.setInt(8, supplier.getSup_id());
			if(pstm.executeUpdate()==1){
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean deleteSupplier(SupplierData supplier){
		String sql2="delete from suppliers where sup_id=?";
		Connection conn2=null;
		PreparedStatement pstm = null;
		try {
			try {
				conn2=ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstm=conn2.prepareStatement(sql2);
			pstm.setInt(1, supplier.getSup_id());
			if(pstm.executeUpdate()==1){
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static SupplierData getSupplier(int sup_id){
		String sql2="select * from suppliers where sup_id=?";
		Connection conn2=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn2=ConnectionFactory.getConnection();
			pstm=conn2.prepareStatement(sql2);
			pstm.setInt(1, sup_id);
			rs=pstm.executeQuery();
			if(rs.next()){
				String sup_name=rs.getString("sup_name");
				String sup_address=rs.getString("sup_address");
				String postcode=rs.getString("postcode");
				String sup_telephone=rs.getString("sup_telephone");
				String sup_fax=rs.getString("sup_fax");
				String sup_relationer=rs.getString("sup_relationer");
				String sup_email=rs.getString("sup_email");
				return new SupplierData(sup_id, sup_name,sup_address,postcode,sup_telephone,sup_fax,sup_relationer,sup_email);
			}else return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static SupplierData[] getSuppliers(){
		String sql2="select * from suppliers";
		Connection conn2=null;
		SupplierData supplier[]=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn2=ConnectionFactory.getConnection();
			pstm=conn2.prepareStatement(sql2);
			rs=pstm.executeQuery();
			int i=0;
			rs.last();
			supplier=new SupplierData[rs.getRow()];
			rs.beforeFirst();
			while(rs.next()){
				int sup_id=Integer.parseInt(rs.getString("sup_id"));
				String sup_name=rs.getString("sup_name");
				String sup_address=rs.getString("sup_address");
				String postcode=rs.getString("postcode");
				String sup_telephone=rs.getString("sup_telephone");
				String sup_fax=rs.getString("sup_fax");
				String sup_relationer=rs.getString("sup_relationer");
				String sup_email=rs.getString("sup_email");
				supplier[i]=new SupplierData(sup_id, sup_name,sup_address,postcode,sup_telephone,sup_fax,sup_relationer,sup_email);
				i++;
			}	return supplier;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static String getSup_name(int sup_id){
		String sql2="select sup_name from suppliers where sup_id=?";
		Connection conn2=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn2=ConnectionFactory.getConnection();
			pstm=conn2.prepareStatement(sql2);
			pstm.setInt(1, sup_id);
			rs=pstm.executeQuery();
			if(rs.next()){
				return rs.getString("sup_name");
			}else return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static String[] getAllIDs(){
		String sql2="select sup_id from suppliers order by sup_id asc";
		String[] supplierIDs;
		Statement stm = null;
		ResultSet rs = null;
		try {
			Connection conn2=null;
			try {
				conn2 = ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stm=conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stm.executeQuery(sql2);
			rs.last();
			supplierIDs=new String[rs.getRow()];
			rs.beforeFirst();
			int i=0;
			while(rs.next()){
				supplierIDs[i]=rs.getString("sup_id");
				i++;
			}
			return supplierIDs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public static String[] getAllSupplierNames(){
		//sql="select suppliers.sup_name from suppliers,products where suppliers.sup_id=products.sup_id";
		String sql2="select sup_name from suppliers";
		String[] supplierNames;
		Statement stm = null;
		ResultSet rs = null;
		try {
			Connection conn2=null;
			try {
				conn2 = ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stm=conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stm.executeQuery(sql2);
			rs.last();
			supplierNames=new String[rs.getRow()];
			rs.beforeFirst();
			int i=0;
			while(rs.next()){
				supplierNames[i]=rs.getString("sup_name");
				i++;
			}
			return supplierNames;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
}