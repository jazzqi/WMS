package real.action.data;

public class UserData{
	private String passwd;
	private String name;
	
	public UserData(String name,String passwd){
		this.name=name;
		this.passwd=passwd;
	}
	public UserData(String name){
		this.name=name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPasswd(String passwd){
		this.passwd=passwd;
	}
	public String getName(){
		return name;
	}
	public String getPasswd(){
		return passwd;
	}
	
}