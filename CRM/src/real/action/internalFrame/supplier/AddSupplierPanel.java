package real.action.internalFrame.supplier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import real.action.dao.SupplierDao;
import real.action.data.SupplierData;

public class AddSupplierPanel extends JPanel implements ActionListener{
	private JTextField id,postcode,name,address,phone,fax,relationer,email;
	private JButton insert,reset;
	public AddSupplierPanel(){
		this.setLayout(new GridLayout(6,1));
		JPanel jp[]=new JPanel[6];
		
		for(int i=0;i<6;i++){
			jp[i]=new JPanel();
			this.add(jp[i]);
		}
		
		//jp[0]=new JPanel();
		jp[0].add(new JLabel("ID: "));
		jp[0].add(id=new JTextField(15));
		jp[0].add(new JLabel("邮编: "));
		jp[0].add(postcode=new JTextField(15));

		//jp[1]=new JPanel();
		jp[1].add(new JLabel("姓名"));
		jp[1].add(name=new JTextField(30));
		
		//jp[2]=new JPanel();
		jp[2].add(new JLabel("地址："));
		jp[2].add(address=new JTextField(30));
		
		//jp[3]=new JPanel();
		jp[3].add(new JLabel("电话："));
		jp[3].add(phone=new JTextField(15));
		jp[3].add(new JLabel("传真："));
		jp[3].add(fax=new JTextField(15));
		
		//jp[4]=new JPanel();
		jp[4].add(new JLabel("联系人："));
		jp[4].add(relationer=new JTextField(15));
		jp[4].add(new JLabel("E-mail："));
		jp[4].add(email=new JTextField(15));
		
		//jp[5]=new JPanel();
		jp[5].add(insert=new JButton("添加"));
		jp[5].add(reset=new JButton("重置"));
		insert.addActionListener(this);
		reset.addActionListener(this);
		
	}
	public void actionPerformed (ActionEvent e){
		if(e.getSource()==insert){
			int _id=Integer.parseInt(id.getText());
			String _name=name.getText();
			String _address=address.getText();
			String _postcode=postcode.getText();
			String _telephone=phone.getText();
			String _fax=fax.getText();
			String _relationer=relationer.getText();
			String _email=email.getText();
			
			SupplierData sup=new SupplierData(_id,_name,_address,_postcode,_telephone,_fax,_relationer,_email);
			if(SupplierDao.insertSupplier(sup))	JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==reset){
			id.setText("");
			postcode.setText("");
			name.setText("");
			address.setText("");
			phone.setText("");
			fax.setText("");
			relationer.setText("");
			email.setText("");
		}
	}
}