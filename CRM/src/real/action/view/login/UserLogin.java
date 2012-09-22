package real.action.view.login;
import java.awt.*;
import real.action.view.*;
import javax.swing.*;
import java.awt.event.*;

public class UserLogin extends JFrame{
	public UserLogin(){
		super("仓库管理系统");
		//设置背景
		ImageJPanel imageJP = new ImageJPanel(new ImageIcon("res/login.jpg").getImage());
		this.setContentPane(imageJP);
		this.setLayout(new BorderLayout());
		//设置标题
		JPanel jp=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel title=new JLabel("欢迎使用本系统");
		title.setFont(new Font("华文行楷",1,40));
		title.setForeground(Color.red);
		jp.add(title,JLabel.CENTER);
		jp.setOpaque(false);
		//
		this.add(jp,"North");
		this.add(new LoginPanel(this),"South");
		this.setSize(imageJP.getWidth(),imageJP.getHeight()-35);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 260);
		this.setResizable(false);
	}
	public static void main(String args[]){
		UserLogin app=new UserLogin();
		app.setVisible(true);
	}
}
