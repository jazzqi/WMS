package real.action.internalFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import real.action.dao.SupplierDao;
import real.action.data.MyTable;
import real.action.internalFrame.operator.AddOperatorPanel;
import real.action.internalFrame.operator.RemoveOperatorPanel;

public class CheckSupplierPanel extends JInternalFrame implements ActionListener{
	private JComboBox idList;
	private JButton listAll;
	private MyTable table;
	private JPanel j2;
	private JScrollPane j2s;
	public CheckSupplierPanel(){
		super("供应商查询");
		this.setLayout(new BorderLayout());
		
		JPanel j1=new JPanel(new BorderLayout());
		JPanel j1a=new JPanel();
		j1a.add(new JLabel("选择供应商ID"));
		j1a.add(idList=new JComboBox(SupplierDao.getAllIDs()));
		idList.addActionListener(this);
		JPanel j1b=new JPanel();
		j1b.add(listAll=new JButton("查看所有供应商"));
		j1.add(j1a,"West");
		j1.add(j1b,"East");
		listAll.addActionListener(this);
		
		this.add(j1,"North");
		
		j2=new JPanel(new BorderLayout());
		table=new MyTable(15,MyTable.getSupplierColNames());
		j2s=new JScrollPane(table);
		j2.add(j2s,"Center");
		//j2.add(table);
		this.add(j2,"Center");
		
		this.setClosable(true);
		this.pack();
		this.setVisible(true);
		this.setResizable(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==idList){
			j2.removeAll();
			table=new MyTable(SupplierDao.getSupplier(Integer.parseInt(idList.getSelectedItem().toString())));
			j2s=new JScrollPane(table);
			j2.add(j2s,"Center");
			j2.updateUI();
		}else if(e.getSource()==listAll){
			j2.removeAll();
			table=new MyTable(SupplierDao.getSuppliers());
			j2s=new JScrollPane(table);
			j2.add(j2s,"Center");
			j2.updateUI();
		}
	}
}