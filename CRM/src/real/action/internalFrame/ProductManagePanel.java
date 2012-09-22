package real.action.internalFrame;
import real.action.internalFrame.product.*;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;


public class ProductManagePanel extends JInternalFrame{//名为Panel，实为Frame。
	public ProductManagePanel(){
		super("商品信息管理");
		JTabbedPane tabpane=new JTabbedPane();
		tabpane.add(new AddProductPanel(),"添加商品");
		tabpane.add(new ModifyProductPanel(),"修改与删除商品");
		this.setContentPane(tabpane);
		this.setClosable(true);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}
	
}