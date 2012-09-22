package real.action.data;

public class SupplierData{
	private int sup_id;
	private String sup_name,sup_address,postcode,sup_telephone,sup_fax,sup_relationer,sup_email;
	
	public SupplierData(int sup_id){
		this.sup_id=sup_id;
	}
	public SupplierData(int sup_id,String sup_name,String sup_address,String postcode,String sup_telephone,String sup_fax,String sup_relationer,String sup_email){
		this.sup_id=sup_id;
		this.sup_name=sup_name;
		this.sup_address=sup_address;
		this.postcode=postcode;
		this.sup_telephone=sup_telephone;
		this.sup_fax=sup_fax;
		this.sup_relationer=sup_relationer;
		this.sup_email=sup_email;
	}
	public void setSup_id(int a){
		this.sup_id=a;
	}
	public void setSup_name(String a){
		sup_name=a;
	}
	public void setSup_address(String a){
		sup_address=a;
	}
	public void setPostcode(String a){
		postcode=a;
	}
	public void setSup_telephone(String a){
		sup_telephone=a;
	}
	public void setSup_fax(String a){
		sup_fax=a;
	}
	public void setSup_relationer(String a){
		sup_relationer=a;
	}
	public void setSup_email(String a){
		sup_email=a;
	}
	
	
	public int getSup_id(){
		return sup_id;
	}
	public String getSup_name(){
		return sup_name;
	}
	public String getSup_address(){
		return sup_address;
	}
	public String getPostcode(){
		return postcode;
	}
	public String getSup_telephone(){
		return sup_telephone;
	}
	public String getSup_fax(){
		return sup_fax;
	}
	public String getSup_relationer(){
		return sup_relationer;
	}
	public String getSup_email(){
		return sup_email;
	}
}