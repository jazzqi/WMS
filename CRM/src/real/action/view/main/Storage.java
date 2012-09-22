package real.action.view.main;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.beans.PropertyVetoException;

import real.action.thread.TimeDemo;
import real.action.view.*;
import real.action.internalFrame.*;
import real.action.internalFrame.product.*;
import real.action.internalFrame.supplier.*;
import real.action.internalFrame.operator.*;

public class Storage extends JFrame implements ActionListener{
	private JButton operatorManagerBtn,changePasswdBtn, productManageBtn,checkProductBtn,supplierManagementBtn,inputProductBtn,outputProductBtn,checkSupplierBtn;
	protected JTabbedPane tabPane;
	public ImageDesktopPanel desktop;//实现了在JDesktopPane中绘制背景
	public Storage(){
		super("仓库管理系统 - 主界面");
		
		tabPane=new JTabbedPane();
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new BorderLayout());
		ImageIcon icon1a=new ImageIcon("res/ActionIcon/supplierManagement.png");
		ImageIcon icon1b=new ImageIcon("res/ActionIcon/productmanage.png");
		supplierManagementBtn=new JButton(icon1a);
		supplierManagementBtn.addActionListener(this);
		productManageBtn=new JButton(icon1b);
		productManageBtn.addActionListener(this);
		JPanel jp1Banner=new JPanel();
		jp1Banner.setLayout(new BorderLayout());
		jp1Banner.add(supplierManagementBtn,"West");
		jp1Banner.add(productManageBtn,"East");
		jp1.add(jp1Banner,"West");

		
		JPanel jp2=new JPanel();
		jp2.setLayout(new BorderLayout());
		JPanel jp2Banner=new JPanel();
		jp2Banner.setLayout(new BorderLayout());
		ImageIcon icon2a=new ImageIcon("res/ActionIcon/inputproduct.png");
		ImageIcon icon2b=new ImageIcon("res/ActionIcon/outputproduct.png");
		inputProductBtn=new JButton(icon2a);
		outputProductBtn=new JButton(icon2b);
		inputProductBtn.addActionListener(this);
		outputProductBtn.addActionListener(this);
		jp2Banner.add(inputProductBtn,"West");
		jp2Banner.add(outputProductBtn,"East");
		jp2.add(jp2Banner,"West");
		
		JPanel jp3=new JPanel();
		jp3.setLayout(new BorderLayout());
		JPanel jp3Banner=new JPanel();
		jp3Banner.setLayout(new BorderLayout());
		ImageIcon icon3a=new ImageIcon("res/ActionIcon/productmanage.png");
		ImageIcon icon3b=new ImageIcon("res/ActionIcon/checksupplier.png");
		checkProductBtn=new JButton(icon3a);
		checkProductBtn.addActionListener(this);
		checkSupplierBtn=new JButton(icon3b);
		checkSupplierBtn.addActionListener(this);
		jp3Banner.add(checkProductBtn,"West");
		jp3Banner.add(checkSupplierBtn,"East");
		jp3.add(jp3Banner,"West");


		JPanel jp4=new JPanel();
		jp4.setLayout(new BorderLayout());
		JPanel jp4Banner=new JPanel();
		ImageIcon icon4a=new ImageIcon("res/ActionIcon/operatorManager.png");
		ImageIcon icon4b=new ImageIcon("res/ActionIcon/changepassword.png");
		operatorManagerBtn=new JButton(icon4a);
		operatorManagerBtn.addActionListener(this);
		changePasswdBtn=new JButton(icon4b);
		changePasswdBtn.addActionListener(this);
		jp4Banner.setLayout(new BorderLayout());
		jp4Banner.add(operatorManagerBtn,"West");
		jp4Banner.add(changePasswdBtn,"East");
		jp4.add(jp4Banner,"West");
		
		tabPane.add(jp1,"基本数据");
		tabPane.add(jp2,"进货出货管理");
		tabPane.add(jp3,"查询视图");
		tabPane.add(jp4,"系统管理");
		tabPane.setOpaque(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(tabPane,"North");
		desktop=new ImageDesktopPanel(new ImageIcon("res/welcome.jpg").getImage());
		this.getContentPane().add(desktop,"Center");
		this.getContentPane().add(new TimeDemo(),"South");
		//this.set
		ImageJPanel imageJP = new ImageJPanel(new ImageIcon("res/welcome.jpg").getImage());
		this.setVisible(true);
		//this.pack();
		this.setSize(imageJP.getWidth(),imageJP.getHeight()+15);
		this.setLocation(100,90);
		this.setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==operatorManagerBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof OperatorManage){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}
			if(flag){
				OperatorManage frame=new OperatorManage();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource()==changePasswdBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof ModifyUserPassword){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}		
			if(flag){
				ModifyUserPassword frame=new ModifyUserPassword();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource()==productManageBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof ProductManagePanel){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}
			if(flag){
				ProductManagePanel frame=new ProductManagePanel();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource()==supplierManagementBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof SupplierManagePanel){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}
			if(flag){
				SupplierManagePanel frame=new SupplierManagePanel();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource()==inputProductBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof ImportProductPanel){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}
			if(flag){
				ImportProductPanel frame=new ImportProductPanel();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource()==outputProductBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof OutportProductPanel){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}
			if(flag){
				OutportProductPanel frame=new OutportProductPanel();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource()==checkSupplierBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof CheckSupplierPanel){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}
			if(flag){
				CheckSupplierPanel frame=new CheckSupplierPanel();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource()==checkProductBtn){
			JInternalFrame[] jf=desktop.getAllFrames();
			boolean flag=true;
			for(int i=0;i<jf.length;i++){
				if(jf[i]  instanceof CheckProductPanel){//
					try {
						jf[i].setSelected(flag);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=false;
					break;
				}
			}
			if(flag){
				CheckProductPanel frame=new CheckProductPanel();
				desktop.add(frame);
				try {
					frame.setSelected(flag);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}