package real.action.internalFrame;
import java.awt.*;
import java.awt.event.*;

import real.action.dao.ProductDao;
import real.action.data.ProductData;
import real.action.io.ProductIO;
import javax.swing.*;
public class OutportProductPanel extends JInternalFrame implements ActionListener{
	private JButton outportBtn,reset;
	private JLabel quantity;
	private JTextField outportQuantity;
	private JComboBox id;
	public OutportProductPanel(){
		super("出货");
		this.setLayout(new GridLayout(4,1));
		JPanel jp[]=new JPanel[4];
		for(int i=0;i<4;i++){
			this.add(jp[i]=new JPanel());
		}
		
		jp[0].add(new JLabel("商品ID："));
		jp[0].add(id=new JComboBox(ProductDao.getAllIDs()));
		jp[1].add(new JLabel("存货量："));
		jp[1].add(quantity=new JLabel(""));
		jp[2].add(new JLabel("出货量： "));
		jp[2].add(outportQuantity=new JTextField(15));
		jp[3].add(outportBtn=new JButton("出货"));
		jp[3].add(reset=new JButton("清空"));
		outportBtn.addActionListener(this);
		reset.addActionListener(this);
		id.addActionListener(this);
		
		this.setClosable(true);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}
	public void showQuantityInfo(int id){
		ProductData product=ProductDao.getProductbyID(id);
		this.quantity.setText(product.getQuantity()+"");
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==reset){
			outportQuantity.setText("");
		}else if(e.getSource()==outportBtn){
			ProductData product=new ProductData(Integer.parseInt(id.getSelectedItem().toString()));
			float _in=Float.parseFloat(outportQuantity.getText().toString());
			if(ProductIO.outportProduct(product, _in)){
				JOptionPane.showMessageDialog(this, "成功","系统提示！",JOptionPane.INFORMATION_MESSAGE);
				showQuantityInfo(Integer.parseInt(id.getSelectedItem().toString()));
				outportQuantity.setText("");
			}
			else JOptionPane.showMessageDialog(this, "失败","系统提示！",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==id){
			JComboBox b=(JComboBox)e.getSource();
			showQuantityInfo(Integer.parseInt(b.getSelectedItem().toString()));
		}
	}
}

