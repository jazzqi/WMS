package real.action.internalFrame;
import java.awt.*;
import real.action.data.UserData;
import java.awt.event.*;
import javax.swing.*;
import real.action.dao.*;

public class ModifyUserPasswordPanel extends JPanel implements ActionListener{
	protected JPasswordField passwd_old,passwd_new,confirm;
	protected JButton modify,reset;
	
	public ModifyUserPasswordPanel(){
		passwd_old=new JPasswordField(16);
		passwd_new=new JPasswordField(16);
		confirm=new JPasswordField(16);
		modify=new JButton("修改");
		reset=new JButton("重置");
		modify.addActionListener(this);
		reset.addActionListener(this);
		this.setLayout(new GridLayout(5,1));
		JPanel jp1=new JPanel();
		jp1.add(new JLabel("姓名："));
		jp1.add(new JLabel(real.action.view.login.LoginPanel.loggedID));//等待处理
		this.add(jp1);
		JPanel jp2=new JPanel();
		jp2.add(new JLabel("原始密码："));
		jp2.add(passwd_old);
		this.add(jp2);
		JPanel jp3=new JPanel();
		jp3.add(new JLabel("新密码："));
		jp3.add(passwd_new);
		this.add(jp3);
		JPanel jp4=new JPanel();
		jp4.add(new JLabel("确认密码："));
		jp4.add(confirm);
		this.add(jp4);
		JPanel jp5=new JPanel();
		jp5.add(modify);
		jp5.add(reset);
		this.add(jp5);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==modify){
			if(passwd_new.getText().equals(confirm.getText())){
				char[] p=passwd_old.getPassword();
				byte[] pb=new byte[p.length];
				for(int i=0;i<p.length;i++){
					pb[i]=(byte)p[i];
				}
				String passwd=real.action.MD5.MD5.getMD5(pb);
				
				char[] p2=passwd_new.getPassword();
				byte[] p2b=new byte[p2.length];
				for(int i=0;i<p2.length;i++){
					p2b[i]=(byte)p2[i];
				}
				String passwd2=real.action.MD5.MD5.getMD5(p2b);
				UserDao userdao=new UserDao();
				UserData userdata=new UserData(real.action.view.login.LoginPanel.loggedID,passwd);
				if(userdao.setPassword(userdata , passwd2))
					JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
				else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			}else JOptionPane.showMessageDialog(this, "两次密码输入不匹配","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==reset){
			passwd_old.setText("");
			passwd_new.setText("");
			confirm.setText("");
		}
	}
}