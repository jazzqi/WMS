package real.action.internalFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import real.action.dao.ProductDao;
import real.action.dao.SupplierDao;
import real.action.data.MyTable;

public class CheckProductPanel extends JInternalFrame implements ActionListener{
	private JButton search,reset,export;
	private JTextField id,name,price,quantity,type,supid;
	private JPanel jp1;
	private JScrollPane jp1s;
	private MyTable table;
	private JComboBox idCompare,priceCompare,quantityCompare,supidCompare;
	private String[] compare={">","=","<"};
	public CheckProductPanel(){
		super("商品信息查询");
		this.setLayout(new BorderLayout());
		
		jp1=new JPanel(new BorderLayout());
		table=new MyTable(24,MyTable.getProductColNames());
		jp1s=new JScrollPane(table);
		jp1.add(jp1s,"Center");
		
		JPanel jp2=new JPanel(new GridLayout(7,1));
		this.add(jp1,"Center");
		this.add(jp2,"East");
		
		JPanel jp21=new JPanel();
		jp21.add(new JLabel("ID: "));
		jp21.add(idCompare=new JComboBox(compare));
		jp21.add(id=new JTextField(5));
		jp2.add(jp21);
		
		JPanel jp22=new JPanel();
		jp22.add(new JLabel("名称： "));
		jp22.add(name=new JTextField(5));
		jp2.add(jp22);
		
		JPanel jp23=new JPanel();
		jp23.add(new JLabel("价格： "));
		jp23.add(priceCompare=new JComboBox(compare));
		jp23.add(price=new JTextField(5));
		jp2.add(jp23);
		
		JPanel jp24=new JPanel();
		jp24.add(new JLabel("库存量： "));
		jp24.add(quantityCompare=new JComboBox(compare));
		jp24.add(quantity=new JTextField(5));
		jp2.add(jp24);
		
		JPanel jp25=new JPanel();
		jp25.add(new JLabel("种类： "));
		jp25.add(type=new JTextField(5));
		jp2.add(jp25);
		
		JPanel jp26=new JPanel();
		jp26.add(new JLabel("供应商ID： "));
		jp26.add(supidCompare=new JComboBox(compare));
		jp26.add(supid=new JTextField(5));
		jp2.add(jp26);
		
		search=new JButton("查询");
		reset=new JButton("重置");
		export=new JButton("导出");
		search.addActionListener(this);
		reset.addActionListener(this);
		export.addActionListener(this);
		JPanel jpBtns=new JPanel();
		jpBtns.add(search);
		jpBtns.add(reset);
		jpBtns.add(export);
		jp2.add(jpBtns);
		
		this.setClosable(true);
		this.pack();
		this.setVisible(true);
		this.setResizable(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==search){
			//获取搜索限定信息
			String _id=id.getText();
			String _name=name.getText();
			String _price=price.getText();
			String _quantity=quantity.getText();
			String _type=type.getText();
			String _supid=supid.getText();
			//获取比较运算符
			String _idCompare=idCompare.getSelectedItem().toString();
			String _priceCompare=priceCompare.getSelectedItem().toString();
			String _quantityCompare=quantityCompare.getSelectedItem().toString();
			String _supidCompare=supidCompare.getSelectedItem().toString();
			
			jp1.removeAll();
			table=new MyTable(ProductDao.searchProducts(_idCompare,_id,_name,_priceCompare,_price,_quantityCompare,_quantity,_type,_supidCompare,_supid));
			jp1s=new JScrollPane(table);
			jp1.add(jp1s,"Center");
			jp1.updateUI();
		}else if(e.getSource()==reset){
			id.setText("");
			name.setText("");
			price.setText("");
			quantity.setText("");
			type.setText("");
			supid.setText("");
			idCompare.setSelectedIndex(0);
			priceCompare.setSelectedIndex(0);
			quantityCompare.setSelectedIndex(0);
			supidCompare.setSelectedIndex(0);
		}else if(e.getSource()==export){
			if(table.getProdObjs()!=null){
				new ExportSearchResult(table.getProdObjs());
			}else	JOptionPane.showMessageDialog(this, "请在查询后使用导出功能","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}