package real.action.internalFrame.supplier;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import real.action.dao.ProductDao;
import real.action.dao.SupplierDao;
import real.action.data.ProductData;
import real.action.data.SupplierData;

public class ModifySupplierPanel extends JPanel implements ActionListener{
	private JComboBox id;
	private JTextField postcode,name,address,phone,fax,relationer,email;
	private JButton modify,reset,delete;
	private JPanel jp[];
	public ModifySupplierPanel(){
		this.setLayout(new GridLayout(6,1));
		jp=new JPanel[6];
		
		for(int i=0;i<6;i++){
			jp[i]=new JPanel();
			this.add(jp[i]);
		}
		
		//jp[0]=new JPanel();
		jp[0].add(new JLabel("ID: "));
		jp[0].add(id=new JComboBox(SupplierDao.getAllIDs()));
		id.addActionListener(this);
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
		jp[5].add(delete=new JButton("删除"));
		jp[5].add(modify=new JButton("修改"));
		jp[5].add(reset=new JButton("重置"));
		delete.addActionListener(this);
		modify.addActionListener(this);
		reset.addActionListener(this);
		//insert.addActionListener(this);
		//reset.addActionListener(this);
	}
	public void showSupplierInfo(int id){//选择id后，在界面上显示详细信息
		SupplierData sup=SupplierDao.getSupplier(id);
		this.postcode.setText(sup.getPostcode());
		this.name.setText(sup.getSup_name());
		this.address.setText(sup.getSup_address());
		this.phone.setText(sup.getSup_telephone());
		this.fax.setText(sup.getSup_fax());
		this.relationer.setText(sup.getSup_fax());
		this.email.setText(sup.getSup_email());
	}
	public void updateUIs(){//删除项目后，刷新界面，重新读数据库生成一个JComboBox，其他的内容设置为空
		jp[0].removeAll();
		jp[0].add(new JLabel("ID: "));
		jp[0].add(id=new JComboBox(SupplierDao.getAllIDs()));
		id.addActionListener(this);
		jp[0].add(new JLabel("邮编: "));
		jp[0].add(postcode=new JTextField(15));;
		jp[0].updateUI();
		
		this.name.setText("");
		this.address.setText("");
		this.phone.setText("");
		this.fax.setText("");
		this.relationer.setText("");
		this.email.setText("");
	}
	public void actionPerformed (ActionEvent e){
		if(e.getSource()==id){
			JComboBox b=(JComboBox)e.getSource();
			showSupplierInfo(Integer.parseInt(b.getSelectedItem().toString()));
		}else if(e.getSource()==modify){
			int _id=Integer.parseInt(id.getSelectedItem().toString());
			String _name=name.getText();
			String _address=address.getText();
			String _postcode=postcode.getText();
			String _telephone=phone.getText();
			String _fax=fax.getText();
			String _relationer=relationer.getText();
			String _email=email.getText();
			SupplierData sup=new SupplierData(_id,_name,_address,_postcode,_telephone,_fax,_relationer,_email);
			if(SupplierDao.modifySupplier(sup))		JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==reset){
			showSupplierInfo(Integer.parseInt(id.getSelectedItem().toString()));
		}else if(e.getSource()==delete){
			int _id=Integer.parseInt(id.getSelectedItem().toString());
			SupplierData sup=new SupplierData(_id);
			if(SupplierDao.deleteSupplier(sup))	JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			updateUIs();
		}
	}
}