




import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;

import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;


public class Window extends JFrame{
	JPanel panel0;
	
	JMenuBar menubar;
		JMenu menu;
			JMenuItem menuitem;
	
	StoreExtnd St=new StoreExtnd();
	SmetaExtnd Sm=new SmetaExtnd();
	//adhcdscjsdcdsjgcvscs
	int a=1+2;
	
	
	
	
	void SmNew(){
		
		
		}
	void SmOpen(){
		
			JFileChooser fileopen = new JFileChooser();
			int ret = fileopen.showOpenDialog(null);                
			if (ret == JFileChooser.APPROVE_OPTION) {
			    File file = fileopen.getSelectedFile();
			   
			    
				
				
			}
	}
	void SmClose(){
		
	}
	void SmCloseAll(){
		
	}
	void SmSave(){
		JFileChooser fileopen = new JFileChooser();
		int ret = fileopen.showSaveDialog(null);                
		if (ret == JFileChooser.APPROVE_OPTION) {
		    File file = fileopen.getSelectedFile();
		   
		    
			
			
		}
	}
	void SmSaveAs(){
		
	}
	void SmSaveAll(){
		
	}
	void SmExport(){
		
	}

	
	Window(){
		super("SmBuilder");
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		panel0=new JPanel();
		panel0.setLayout(null);
		
		menubar=new JMenuBar();
		menu= new JMenu("Смета");
		menuitem=new JMenuItem("Новая");
		menu.add(menuitem);
		menuitem.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			SmNew();
	 		}
	 	});
		menuitem=new JMenuItem("Открыть");
		menu.add(menuitem);
		menuitem.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			SmOpen();
	 		}
	 	});
		
		
		menuitem=new JMenuItem("Сохранить");
		menuitem.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			SmSave();
	 		}
	 	});
	
		menu.add(menuitem);
		menubar.add(menu);
		
		
		setJMenuBar(menubar);
		
		
		addComponentListener(new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub      
				Sm.setBounds(0, 0,panel0.getWidth(), panel0.getHeight());
				St.setBounds(0, 0,panel0.getWidth(), panel0.getHeight());
				
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				Sm.setBounds(0, 0,panel0.getWidth(), panel0.getHeight());		
				St.setBounds(0, 0,panel0.getWidth(), panel0.getHeight());
				
			}
		});
	
		panel0.add(Sm);
		St.setVisible(false);
		panel0.add(St);
		
		
		setContentPane(panel0);
	 	setSize(1024,720);	
	 	Sm.setBounds(0, 0,panel0.getWidth(), panel0.getHeight());
	 	St.setBounds(0, 0,panel0.getWidth(), panel0.getHeight());
	 	setMinimumSize(new Dimension(720,520));
	 	setResizable(true);
	 	setVisible(true);
	}
	class SmetaExtnd extends Smeta{
		@Override 
		void actions(int act){
			if(act==Smeta.TO_STORE){
				setVisible(false);
				St.setVisible(true);
			}
		}
	}
	class StoreExtnd extends Store{
		@Override 
		void actions(int act){
			if(act==Store.TO_SMETA){
				setVisible(false);
				Sm.setVisible(true);
			}else
			if(act==Store.ADD_TO_SMETA){
				
				Material localm=getActionMaterial();
				if(localm!=null)
				Sm.addMaterial(localm.copy());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Window();
	}

}

