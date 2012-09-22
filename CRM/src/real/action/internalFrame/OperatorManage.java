package real.action.internalFrame;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import real.action.internalFrame.operator.*;

public class OperatorManage extends JInternalFrame{
	public OperatorManage(){
		super("管理员管理");
		JTabbedPane tabpane=new JTabbedPane();
		tabpane.add(new AddOperatorPanel(),"添加操作员");
		tabpane.add(new RemoveOperatorPanel(),"删除操作员");
		this.setContentPane(tabpane);
		this.setClosable(true);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}
}