package real.action.internalFrame.product;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import real.action.dao.ProductDao;
import real.action.dao.SupplierDao;
import real.action.data.*;

public class AddProductPanel extends JPanel implements ActionListener{
	private JTextField id,name,price,type,quantity;
	private JComboBox supplier;
	private JButton insert,reset;
	public AddProductPanel(){
		this.setLayout(new GridLayout(7,2));

		JPanel jp1=new JPanel();
		id=new JTextField(30);
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
		insert=new JButton("添加");
		insert.addActionListener(this);
		reset=new JButton("重置");
		reset.addActionListener(this);
		jp7.add(insert);
		jp7.add(reset);
		this.add(jp7);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==insert){
			int idInt=Integer.parseInt(id.getText());
			float priceFloat=Float.parseFloat(price.getText());
			float quantityFloat=Float.parseFloat(quantity.getText());
			ProductData productdata=new ProductData(idInt,name.getText(),priceFloat,type.getText(),quantityFloat,supplier.getSelectedItem().toString());
			ProductDao productdao=new ProductDao();
			if(productdao.insertProduct(productdata))	JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==reset){
			id.setText("");
			name.setText("");
			price.setText("");
			type.setText("");
			quantity.setText("");
		}
	}
}
