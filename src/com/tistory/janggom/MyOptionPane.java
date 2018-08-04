package com.tistory.janggom;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Field;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyOptionPane {
		

	public static String showAutoCloseDialog(Component component, int count,  String message, String title, Object[] options){
		return showAutoCloseDialog(component, count,  message, title, options, 0);
	}
	
	public static String showAutoCloseDialog(Component component, final int count, final String message, String title, final Object[] buttons, final int autoCloseIndex){
		
		if(count<0){
			
			throw new IllegalArgumentException("Argument count should positive value");	
		
		}
		
		final JLabel lbl = new JLabel("", JLabel.CENTER);
		final JOptionPane op = new JOptionPane(lbl, JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION, null, null, null);		
		
		if(buttons != null){		
			
			if(autoCloseIndex < 0 || autoCloseIndex >= buttons.length){
				
				throw new IndexOutOfBoundsException("Argument autoCloseIndex is illegal value");
			
			}					
			
			op.setOptions(buttons);
			op.setInitialValue(buttons[0]);			
		}
		
		final JDialog dlg = op.createDialog(component, title);
		
		Thread counter = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					for(int i = count; i >= 0 ; i-- ){
						
						lbl.setText(message + "("+String.valueOf(i) +")");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) { }
				
				op.setValue(buttons[buttons.length-1]);				
				dlg.setVisible(false);
				
			}
		});

		
		dlg.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				 
				op.setValue(buttons[buttons.length-1]);
				dlg.setVisible(false);
			
			}			
		});
		
		counter.start();
        dlg.setVisible(true);
 
        
        return (String)op.getValue();  
    }
}
