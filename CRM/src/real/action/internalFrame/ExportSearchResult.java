package real.action.internalFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportSearchResult extends JInternalFrame{
	String path;
	public ExportSearchResult(Object[][] objs){
		String contents="";
		for(int i=0;i<objs.length;i++){
			for(int j=0;j<objs[i].length;j++){
				contents+=objs[i][j]+"\t";
			}
			contents+="\r\n";
		}
    	JFileChooser chooser=new JFileChooser();
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("所有文件","*");
    	chooser.setFileFilter(filter);
    	int returnVal=chooser.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           System.out.println("You chose to open this file: "+chooser.getSelectedFile().getName());
           path=chooser.getSelectedFile().getAbsolutePath()+".qf";
           byte[] byt=contents.getBytes();
	   		try{
	   			FileOutputStream fos=new FileOutputStream(path);
	   			fos.write(byt);
	   			//still needs utf-8 support
	   			fos.flush();
	   			fos.close();
	   		}catch(IOException eee){
	   			eee.printStackTrace();
	   		}
        }
	}
}
