package real.action.data;

import real.action.dao.SupplierDao;

public class ProductData{
	private String prod_name,type;
	private float quantity,price;
	private int prod_id,sup_id;
	private String sup_name;
	
	public ProductData(int id){
		this.prod_id=id;
		
		this.prod_name=null;
		this.price=0;
		this.type=null;
		this.quantity=0;
		this.sup_name=null;
		this.sup_id=0;
	}
	public ProductData(int id,String name,float price,String type,float quantity,int sup_id){
		this.prod_id=id;
		this.prod_name=name;
		this.price=price;
		this.type=type;
		this.quantity=quantity;
		this.sup_id=sup_id;
	}
	public ProductData(int id,String name,float price,String type,float quantity,String sup_name){//传入供应商名时，查询数据库并得出供应商的ID
		this.prod_id=id;
		this.prod_name=name;
		this.price=price;
		this.type=type;
		this.quantity=quantity;
		this.sup_name=sup_name;
		this.sup_id=SupplierDao.getSup_id(sup_name);
	}
	public void setProd_id(int id){
		this.prod_id=id;
	}
	public void setProd_name(String name){
		this.prod_name=name;
	}
	public void setPrice(float price){
		this.price=price;
	}
	public void setType(String type){
		this.type=type;
	}
	public void setQuantity(float quantity){
		this.quantity=quantity;
	}
	public void setSup_id(int sup_id){
		this.sup_id=sup_id;
	}

	public int getProd_id(){
		return prod_id;
	}
	public String getProd_name(){
		return prod_name;
	}
	public float getPrice(){
		return price;
	}
	public String getType(){
		return type;
	}
	public float getQuantity(){
		return quantity;
	}
	public int getSup_id(){
		return sup_id;
	}
}
