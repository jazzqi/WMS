package real.action.data;

import javax.swing.JTable;
import real.action.dao.*;
import real.action.dao.SupplierDao;

public class MyTable extends JTable{
	private static Object[][] prodObjs;
	private static Object[][] supObjs;
	public MyTable(int row,Object[] title){
		super(new Object[row][10],title);
	}
	public MyTable(ProductData products[]){
		super(getProductsArray(products),getProductColNames());
	}
	public MyTable(SupplierData suppliers[]){
		super(getSuppliersArray(suppliers),getSupplierColNames());
		System.out.print(getSupplierColNames().toString());
		//super(getSuppliersArray(suppliers),{"sup_id","sup_name","sup_address","postcode","sup_telephone","sup_fax","sup_relationer","sup_email"});
	}
	public MyTable(ProductData products){
		super(getProductsArray(products),getProductColNames());
	}
	public MyTable(SupplierData suppliers){
		super(getSuppliersArray(suppliers),getSupplierColNames());
	}
	public static Object[] getProductColNames(){
		Object title[]={"产品ID","名称","价格","种类","库存量","供应商ID","供应商名称"};
		return title;
	}
	public static Object[] getSupplierColNames(){
		Object title[]={"供应商ID","名称","地址","邮编","联系电话","传真","联系人","电子邮箱"};
		return title;
	}
	public static Object[][] getProductsArray(ProductData products){
		Object prodObjs[][]=new Object[1][7];
		prodObjs[0][0]=products.getProd_id()+"";
		prodObjs[0][1]=products.getProd_name();
		prodObjs[0][2]=products.getPrice()+"";
		prodObjs[0][3]=products.getType();
		prodObjs[0][4]=products.getQuantity()+"";
		prodObjs[0][5]=products.getSup_id()+"";
		prodObjs[0][6]=SupplierDao.getSup_name(products.getSup_id());
		return prodObjs;
	}
	public static Object[][] getProductsArray(ProductData products[]){
		prodObjs=new Object[products.length][7];
		for(int i=0;i<products.length;i++){
			prodObjs[i][0]=products[i].getProd_id()+"";
			prodObjs[i][1]=products[i].getProd_name();
			prodObjs[i][2]=products[i].getPrice()+"";
			prodObjs[i][3]=products[i].getType();
			prodObjs[i][4]=products[i].getQuantity()+"";
			prodObjs[i][5]=products[i].getSup_id()+"";
			prodObjs[i][6]=SupplierDao.getSup_name(products[i].getSup_id());
		}
		return prodObjs;
	}
	public static Object[][] getSuppliersArray(SupplierData suppliers){
		supObjs=new Object[1][8];
		supObjs[0][0]=suppliers.getSup_id()+"";
		supObjs[0][1]=suppliers.getSup_name();
		supObjs[0][2]=suppliers.getSup_address();
		supObjs[0][3]=suppliers.getPostcode();
		supObjs[0][4]=suppliers.getSup_telephone();
		supObjs[0][5]=suppliers.getSup_fax();
		supObjs[0][6]=suppliers.getSup_relationer();
		supObjs[0][7]=suppliers.getSup_email();
		return supObjs;
	}
	public static Object[][] getSuppliersArray(SupplierData suppliers[]){
		supObjs=new Object[suppliers.length][8];
		for(int i=0;i<suppliers.length;i++){
			supObjs[i][0]=suppliers[i].getSup_id()+"";
			supObjs[i][1]=suppliers[i].getSup_name();
			supObjs[i][2]=suppliers[i].getSup_address();
			supObjs[i][3]=suppliers[i].getPostcode();
			supObjs[i][4]=suppliers[i].getSup_telephone();
			supObjs[i][5]=suppliers[i].getSup_fax();
			supObjs[i][6]=suppliers[i].getSup_relationer();
			supObjs[i][7]=suppliers[i].getSup_email();
		}
		return supObjs;
	}
	public static Object[][] getProdObjs(){
		return prodObjs;
	}
	public static Object[][] getSupObjs(){
		return supObjs;
	}
}