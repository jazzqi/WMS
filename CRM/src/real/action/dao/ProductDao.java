package real.action.dao;
import java.sql.*;

import real.action.data.*;
import real.action.sql.*;
public class ProductDao{	
	private String sql;
	Connection conn=null;
	PreparedStatement pstm=null;
	public ProductDao(){
		try {
			conn=ConnectionFactory.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String[] getAllIDs (){
		String sql2="select prod_id from products order by prod_id asc";
		String ids[]=null;
		Connection conn=null;
		try {
			try {
				conn = ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(sql2);
			rs.last();
			ids=new String[rs.getRow()];
			rs.beforeFirst();
			int i=0;
			while(rs.next()){
				ids[i]=rs.getString("prod_id");
				i++;
			}
			return ids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static ProductData[] searchProducts(String idCompare,String id,String name,String priceCompare,String price,String quantityCompare,String quantity,String type,String supidCompare,String supid){
		//String sql2="select * from products where prod_id"+idCompare+"? and prod_name=? and price"+priceCompare+"? and type=? and quantity"+quantityCompare+"? and sup_id"+supidCompare+"?";
		String sql2="select * from products where 1=1";
		//id==null?sql2=(sql2+" and prod_id"+idCompare+id.toString()):;
		if(!id.equals(""))	sql2=sql2+" and prod_id"+idCompare+id;
		if(!name.equals("")) sql2=sql2+" and prod_name='"+name+"'";
		if(!price.equals(""))	sql2=sql2+" and price"+priceCompare+price;
		if(!quantity.equals(""))	sql2=sql2+" and quantity"+quantityCompare+quantity;
		if(!type.equals(""))	sql2=sql2+" and type='"+type+"'";
		if(!supid.equals(""))	sql2=sql2+" and sup_id"+supidCompare+supid;
		Connection conn2=null;
		ProductData products[]=null;
		try{
			conn2=ConnectionFactory.getConnection();
			PreparedStatement stm2=conn2.prepareStatement(sql2);
			ResultSet rs=stm2.executeQuery();
			int i=0;
			rs.last();
			products=new ProductData[rs.getRow()];
			rs.beforeFirst();
			while(rs.next()){
				int _id=Integer.parseInt(rs.getString("prod_id"));
				String _name=rs.getString("prod_name");
				float _price=Float.parseFloat(rs.getString("price"));
				String _type=rs.getString("type");
				float _quantity=Float.parseFloat(rs.getString("quantity"));
				int _supid=Integer.parseInt(rs.getString("sup_id"));
				products[i]=new ProductData(_id,_name,_price,_type,_quantity,_supid);
				i++;
			}	return products;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static ProductData getProductbyID(int id){
		String sql="select * from products where prod_id=?";
		Connection conn2=null;
		PreparedStatement pstm;
		try {
			try {
				conn2=ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstm=conn2.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()){//将结果封装成一个ProductData的对象并返回
				return new ProductData(id,rs.getString("prod_name"),Float.parseFloat(rs.getString("price")),rs.getString("type"),Float.parseFloat(rs.getString("quantity")),Integer.parseInt(rs.getString("sup_id")));
			}else return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public static boolean modifyProduct (ProductData product){
		String sql2="update products set prod_name=?, price=?, type=?, quantity=?, sup_id=? where prod_id=?";
		Connection conn2=null;
		PreparedStatement pstm;
		try {
			try {
				conn2=ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstm=conn2.prepareStatement(sql2);
			pstm.setString(1, product.getProd_name());
			pstm.setFloat(2, product.getPrice());
			pstm.setString(3, product.getType());
			pstm.setFloat(4, product.getQuantity());
			pstm.setInt(5, product.getSup_id());
			pstm.setInt(6, product.getProd_id());
			
			if(pstm.executeUpdate()==1){
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static boolean deleteProduct (ProductData product){
		String sql2="delete from products where prod_id=?";
		Connection conn2=null;
		PreparedStatement pstm;
		try {
			try {
				conn2=ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstm=conn2.prepareStatement(sql2);
			pstm.setInt(1, product.getProd_id());
			if(pstm.executeUpdate()==1){
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean insertProduct (ProductData product){
		sql="insert into products values (?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, product.getProd_id());
			pstm.setString(2, product.getProd_name());
			pstm.setFloat(3, product.getPrice());
			pstm.setString(4, product.getType());
			pstm.setFloat(5, product.getQuantity());
			pstm.setInt(6, product.getSup_id());
			int i=pstm.executeUpdate();
			if(i==1)
				return true;
			else	return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
