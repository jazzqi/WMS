package real.action.internalFrame;

import javax.swing.*;

import real.action.internalFrame.operator.AddOperatorPanel;
import real.action.internalFrame.operator.RemoveOperatorPanel;
import real.action.internalFrame.supplier.AddSupplierPanel;
import real.action.internalFrame.supplier.ModifySupplierPanel;

public class SupplierManagePanel extends JInternalFrame{//名为Panel，实为Frame
	public SupplierManagePanel(){
		super("供应商信息管理");
		JTabbedPane tabpane=new JTabbedPane();
		tabpane.add(new AddSupplierPanel(),"添加供应商");
		tabpane.add(new ModifySupplierPanel(),"删除或修改供应商信息");
		this.setContentPane(tabpane);
		this.setClosable(true);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}
}