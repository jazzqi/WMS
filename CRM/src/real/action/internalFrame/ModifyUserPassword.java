package real.action.internalFrame;

import javax.swing.JInternalFrame;

public class ModifyUserPassword extends JInternalFrame{
	public ModifyUserPassword(){
		super("修改密码");
		//JInternalFrame frame=new JInternalFrame("修改密码");
		setClosable(true);
		add(new ModifyUserPasswordPanel());
		pack();
		setVisible(true);
		setResizable(false);
	}
}
