package real.action.view;
import java.awt.*;
import javax.swing.*;

import real.action.thread.TimeDemo;
public class ImageDesktopPanel extends JDesktopPane{
	private Image image;
	
	public ImageDesktopPanel(Image image){ //首先构建一个构造方法.传入的参数是Image的文件路径
		this.image=image;
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
		setSize(size);  //设置JPanel的大小为Image图象的大小
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0,null); //用G 把Image画出来 
	}
}
