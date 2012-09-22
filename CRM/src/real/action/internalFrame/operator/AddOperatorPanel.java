package real.action.internalFrame.operator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import real.action.data.UserData;
import real.action.dao.*;
public class AddOperatorPanel extends JPanel implements ActionListener{
	protected JTextField name;
	protected JButton submit,reset;
	protected JPasswordField passwd,confirm;
	public AddOperatorPanel(){
		submit=new JButton("添加");
		reset=new JButton("重置");
		submit.addActionListener(this);
		reset.addActionListener(this);
		this.setLayout(new GridLayout(4,1));
		JPanel jp1=new JPanel();
		jp1.add(new JLabel("用户名："));
		jp1.add(name=new JTextField(16));
		this.add(jp1);
		JPanel jp2=new JPanel();
		jp2.add(new JLabel("密码："));
		jp2.add(passwd=new JPasswordField(16));
		this.add(jp2);
		JPanel jp3=new JPanel();
		jp3.add(new JLabel("确认密码："));
		jp3.add(confirm=new JPasswordField(16));
		this.add(jp3);		
		JPanel jp4=new JPanel();
		jp4.add(submit);
		jp4.add(reset);
		this.add(jp4);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==submit){
			if(passwd.getText().equals(confirm.getText())){
				char[] p=passwd.getPassword();
				byte[] pb=new byte[p.length];
				for(int i=0;i<p.length;i++){
					pb[i]=(byte)p[i];
				}
				String passwdStr=real.action.MD5.MD5.getMD5(pb);
				UserData userdata=new UserData(name.getText(),passwdStr);
				UserDao userdao=new UserDao();
				if(userdao.addUser(userdata))	JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
				else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			}else JOptionPane.showMessageDialog(this, "两次输入的密码不匹配","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==reset){
			name.setText("");
			passwd.setText("");
			confirm.setText("");
		}
	}
}
