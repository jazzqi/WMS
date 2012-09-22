package real.action.view.login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import real.action.view.main.*;
import real.action.dao.LoginDao;

public class LoginPanel extends JPanel implements ActionListener{
	public JButton loginBtn,exitBtn;
	public JTextField unameFld;
	public JPasswordField passwdFld;
	public JFrame app;
	public static String loggedID="";
	//JPanel southPane;
	public LoginPanel(JFrame app1){
		this.app=app1;
		loginBtn=new JButton("登入");
		exitBtn=new JButton("退出");
		loginBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		unameFld=new JTextField(16);
		passwdFld=new JPasswordField(16);
		this.setLayout(new GridLayout(3,1,12,22));
		JPanel jp1=new JPanel();
		jp1.add(new JLabel("Username: "),JLabel.CENTER);
		jp1.add(unameFld);
		JPanel jp2=new JPanel();
		jp2.add(new JLabel("Password: "));
		jp2.add(passwdFld);
		JPanel jp3=new JPanel();
		jp3.add(loginBtn);
		jp3.add(exitBtn);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		jp1.setOpaque(false);//使透明
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		this.setOpaque(false);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==loginBtn){
			char[] p=passwdFld.getPassword();
			byte p2b[]=new byte[p.length];
			for(int i=0;i<p.length;i++){
				p2b[i]=(byte)p[i];
				//passwd2+=p[i];
			}
			String passwd2=real.action.MD5.MD5.getMD5(p2b);//对密码进行MD5运算
			if(LoginDao.isLogin(unameFld.getText(),passwd2)){//登陆成功!
				System.out.print("hello"+unameFld.getText()+passwd2+"\n");
				loggedID=unameFld.getText();
				app.setVisible(false);
				//this.getParent().getParent().setVisible(false);
				new Storage();
			}else{
				JOptionPane.showMessageDialog(this,"您输入的账号或者密码错误，请输入正确信息！","系统提示",JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==exitBtn){
			System.exit(0);
		}
	}
}