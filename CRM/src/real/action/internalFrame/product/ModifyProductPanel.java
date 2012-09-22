package real.action.internalFrame.product;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import real.action.dao.ProductDao;
import real.action.dao.SupplierDao;
import real.action.data.ProductData;

public class ModifyProductPanel extends JPanel implements ActionListener,ItemListener{
	private JTextField name=null;
	private JTextField price=null;
	private JTextField type=null;
	private JTextField quantity=null;
	private JComboBox supplier,id;	
	private JButton verify,modify,reset,delete;
	private JPanel jp1=new JPanel();
	public ModifyProductPanel(){
		this.setLayout(new GridLayout(7,2));

		id=new JComboBox(ProductDao.getAllIDs());
		//id.addItemListener(this);
		id.addActionListener(this);
		jp1.add(new JLabel("ID: "));
		jp1.add(id);
		this.add(jp1);

		JPanel jp2=new JPanel();
		name=new JTextField(30);
		jp2.add(new JLabel("名称: "));
		jp2.add(name);
		this.add(jp2);

		JPanel jp3=new JPanel();
		price=new JTextField(30);
		jp3.add(new JLabel("价格: "));
		jp3.add(price);
		this.add(jp3);

		JPanel jp4=new JPanel();
		type=new JTextField(30);
		jp4.add(new JLabel("种类: "));
		jp4.add(type);
		this.add(jp4);

		JPanel jp5=new JPanel();
		quantity=new JTextField(30);
		jp5.add(new JLabel("数量: "));
		jp5.add(quantity);
		this.add(jp5);
		
		JPanel jp6=new JPanel();
		supplier=new JComboBox(SupplierDao.getAllSupplierNames());
		jp6.add(new JLabel("供应商: "));
		jp6.add(supplier);
		this.add(jp6);
		
		JPanel jp7=new JPanel();
		jp7.setLayout(new BorderLayout());
		verify=new JButton("核实");
		verify.addActionListener(this);
		modify=new JButton("修改");
		modify.addActionListener(this);
		reset=new JButton("重置");
		reset.addActionListener(this);
		delete=new JButton("删除");
		delete.addActionListener(this);
		JPanel jp7West=new JPanel();
		jp7West.add(verify);
		JPanel jp7Center=new JPanel();
		jp7Center.add(modify);
		jp7Center.add(reset);
		JPanel jp7East=new JPanel();
		jp7East.add(delete);
		jp7.add(jp7West,"West");
		jp7.add(jp7Center,"Center");
		jp7.add(jp7East,"East");
		this.add(jp7);
	}
	
	public void showProductInfo(int id){
		ProductData product=ProductDao.getProductbyID(id);//调用ProductDao的静态方法返回一个ProductData对象
		this.name.setText(product.getProd_name());
		this.price.setText(product.getPrice()+"");//primitive类型转换成String
		this.type.setText(product.getType());
		this.quantity.setText(product.getQuantity()+"");
		this.supplier.setSelectedItem(SupplierDao.getSup_name(product.getSup_id()));
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==verify){
			
		}else if(e.getSource()==modify){
			
			int _id=Integer.parseInt(id.getSelectedItem().toString());
			String _name=name.getText();
			float _price=Float.parseFloat(price.getText());
			String _type=type.getText();
			float _quantity=Float.parseFloat(quantity.getText());
			String _sup_name=supplier.getSelectedItem().toString();
			ProductData product=new ProductData(_id,_name,_price,_type,_quantity,_sup_name);
			
			if(ProductDao.modifyProduct(product))	JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			//id.updateUI();
		}else if(e.getSource()==reset){
			showProductInfo(Integer.parseInt(id.getSelectedItem().toString()));
		}else if(e.getSource()==delete){
			int _id=Integer.parseInt(id.getSelectedItem().toString());
			ProductData product=new ProductData(_id);
			if(ProductDao.deleteProduct(product))	JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			updateIDs();
		}else if(e.getSource()==id){
			JComboBox b=(JComboBox)e.getSource();
			showProductInfo(Integer.parseInt(b.getSelectedItem().toString()));
			//System.out.println(b.getSelectedItem());	
		}

	}
	public void updateIDs(){
		jp1.add(new JLabel("ID: "));
		id=new JComboBox(ProductDao.getAllIDs());
		jp1.removeAll();
		jp1.add(id);
		id.addActionListener(this);
		jp1.updateUI();
	}
	public void itemStateChanged(ItemEvent ee){//未使用
		System.out.println(ee.getItem());
	}
}