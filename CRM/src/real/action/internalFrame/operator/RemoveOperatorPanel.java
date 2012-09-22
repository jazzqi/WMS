package real.action.internalFrame.operator;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import real.action.dao.*;
import real.action.data.*;


public class RemoveOperatorPanel extends JPanel implements ActionListener{
	protected JTextField name;
	protected JButton delete,reset;
	public RemoveOperatorPanel(){
		delete=new JButton("删除");
		reset=new JButton("重置");
		delete.addActionListener(this);
		reset.addActionListener(this);
		
		this.setLayout(new GridLayout(2,1));
		JPanel jp1=new JPanel();
		jp1.add(new JLabel("操作员姓名："));
		jp1.add(name=new JTextField(16));
		this.add(jp1);
		JPanel jp2=new JPanel();
		jp2.add(delete);
		jp2.add(reset);
		this.add(jp2);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==delete){
			UserData userdata=new UserData(name.getText());
			UserDao userdao=new UserDao();
			if(userdao.deleteUser(userdata))
				JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==reset){
			name.setText("");
		}
	}
}