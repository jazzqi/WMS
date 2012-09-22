package real.action.io;
import java.sql.*;
import real.action.data.ProductData;
import real.action.sql.*;
public class ProductIO{
	public static boolean importProduct(ProductData product,float in){
		String sql="update products set quantity=quantity+? where prod_id=?";
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement pstm=conn.prepareCall(sql);
			pstm.setFloat(1, in);
			pstm.setInt(2, product.getProd_id());
			if(pstm.executeUpdate()==1)	return true;
			else	return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean outportProduct(ProductData product,float in){
		String sql="update products set quantity=quantity-? where prod_id=?";
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement pstm=conn.prepareCall(sql);
			pstm.setFloat(1, in);
			pstm.setInt(2, product.getProd_id());
			if(pstm.executeUpdate()==1)	return true;
			else	return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}