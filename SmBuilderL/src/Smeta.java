import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Smeta extends JPanel{
	static final int TO_STORE=0;
	JPanel description;
	JTextBoxNum tfnumber;
	JFormattedTextField tfdate = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));;
	JTextField tfobject;
	JTextField tfbuyer;
	JTextArea tfdescription;
	JLabel lbnumber;
	JLabel lbdate;
	JLabel lbobject;
	JLabel lbbuyer;
	JLabel lbdescription;
	JButton btsumma;
	JLabel lbsumma;
JSplitPane content;	
	JPanel pntop;
		JScrollPane scrollPane;
			JMultiTable table;
		JPanel navpanel;
			JButton btstore;
			JButton btdelete;
	JPanel pnbottom;
		JScrollPane scrollPane2;
			JPanel gridtb;
			JTextField params[];
		JPanel navpanel2;
			JButton btedit;
			JButton btfirstedit;
		
		//end
	String[] columnNames = {
	         "Код",
	         "Наименование",
	         "Стоимость",
	         "Множитель",
	         "Сумма"
	 };	
	
	int selectmaterial=-1;
	void reswin(){
		// TODO Auto-generated method stub
		content.setBounds(300, 0, getWidth()-300, getHeight());
		description.setBounds(0,0,300,getHeight());
		navpanel.setBounds(0,pntop.getHeight()-30, pntop.getWidth(), 30);
		navpanel2.setBounds(0,pnbottom.getHeight()-30, pnbottom.getWidth(), 30);
		scrollPane.setBounds(0, 0, pntop.getWidth(), pntop.getHeight()-30);
		scrollPane2.setBounds(0, 0, pnbottom.getWidth(), pnbottom.getHeight()-30);
		btdelete.setBounds(pntop.getWidth()-100, 0, 100, 30);
		btedit.setBounds(pnbottom.getWidth()-100, 0, 100, 30);
				
		if(pntop.getHeight()<content.getHeight()-200){
					
		}else{
					
			content.setDividerLocation(content.getHeight()-200);
		}
	}
	ArrayList<Material> materials=new ArrayList<Material>();
	//проверяет были ошибки или нет
    void setStore(int index){
    	if(index>=0&&index<materials.size()){
    		materials.get(index).setStore();
    		selectMaterial(index);
    	}
    }
	void addMaterial(Material m) {
		if(m!=null){
			
			materials.add(m);
		}
		reBuild();
	}
	 void deleteMaterial(int index) {
			// TODO Auto-generated method stub
		 if(index>=0&&index<materials.size()){
			 materials.remove(index);
		 }
		 reBuild();
	}
	void selectMaterial(int index){
		if(index>=0&&index<materials.size()){
			selectmaterial=index;
			gridtb.removeAll();
			Material m = materials.get(index);
			ArrayList<Parametr> paramlist=m.getParametrs();
			params=new JTextField[paramlist.size()+3];
			
			gridtb.add(new JLabel("Код"));
			params[0]=new JTextField(String.valueOf(m.getID()));
			params[0].setEditable(false);
			params[0].setMaximumSize( 
				     new Dimension(Integer.MAX_VALUE, params[0].getPreferredSize().height) );
			gridtb.add(params[0]);
			
			gridtb.add(new JLabel(" Наименование"));
			params[1]=new JTextField(m.getName());
			params[1].setEditable(false);
			params[1].setMaximumSize( 
				     new Dimension(Integer.MAX_VALUE, params[1].getPreferredSize().height) );
			gridtb.add(params[1]);
			
			gridtb.add(new JLabel("Множитель"));
			params[2]=new JTextField(String.valueOf(m.getCount()));
			params[2].setMaximumSize( 
				     new Dimension(Integer.MAX_VALUE, params[2].getPreferredSize().height) );
			gridtb.add(params[2]);
			
			for(int i=0;i<paramlist.size();i++){
				params[3+i]=new JTextField(paramlist.get(i).getValue());
				gridtb.add(new JLabel(paramlist.get(i).getCaption()));
				params[3+i].setMaximumSize( 
					     new Dimension(Integer.MAX_VALUE, params[3+i].getPreferredSize().height) );
				gridtb.add(params[3+i]);
			}
		}
		gridtb.revalidate();
		reswin();
	}
	void setParametrs(int index){
		if(index>=0&&index<materials.size()){
			String paramvalue[]=new String[params.length-3];
			materials.get(index).setCount(Integer.valueOf(params[2].getText()));
			for(int i=0;i<params.length-3;i++){
				paramvalue[i]=params[i+3].getText();
			}
			
			materials.get(index).setValues(paramvalue);
			
		}
	}
	void reBuild(){
		String[][] data=new String[materials.size()][];
		for(int i=0;i<materials.size();i++){
			Material m=materials.get(i);
			data[i]=new String[5];
			data[i][0]=String.valueOf(m.getID());
			data[i][1]=m.getName();
			data[i][2]=m.resultsome();
			if(m.hadError()){}else{
				try{
					double d = Double.valueOf(data[i][2]);
					d = d * 100;
					int i1 = (int) Math.round(d);
					d = (double)i1 / 100;
					data[i][2]=String.valueOf(d);
				}
				catch(Exception ex){
					
				}
				
			}
			data[i][3]=String.valueOf(m.getCount());
			data[i][4]=m.result();
			if(m.hadError()){}else{
				try{
					double d = Double.valueOf(data[i][4]);
					d = d * 100;
					int i1 = (int) Math.round(d);
					d = (double)i1 / 100;
					data[i][4]=String.valueOf(d);
				}
				catch(Exception ex){
					
				}
				
			}
		}
		
		
		table=new JMultiTable(data,columnNames);
		 JTable ltable=new JTable(table); 
	      ltable.getTableHeader().setReorderingAllowed(false);
	     
	     ltable.addMouseListener( new MouseAdapter()
		 	{
		 		public void mousePressed(MouseEvent event) {
		 			int r=ltable.getSelectedRow();
		 			selectMaterial(r);
		 			lbsumma.setText(String.valueOf(r));
		 		}
		 	});
	      
	      
	      scrollPane = new JScrollPane();
	      scrollPane.setViewportView(ltable);
	    
	      pntop.removeAll();
	      pntop.add(scrollPane);
	      pntop.add(navpanel);
	      reswin();
	      
	}
	String result(){
		double summa=0;
		boolean hadError=false;
		int poserror=0;
		for(int i=0;i<materials.size();i++){
			String localres=materials.get(i).result();
			if(materials.get(i).hadError()){
				hadError=true;
				poserror=i;
			}else{
				try{
					summa=summa+Double.valueOf(localres);
				}
				catch(Exception ex){
					hadError=true;
					poserror=i;
				}
				
			}
		}
		if(hadError){
			return "Произошла ошибка при вычисления стоимости (строка "+poserror+")";
		}else{
			double d = summa;
			 d = d * 100;
			 int i = (int) Math.round(d);
			 d = (double)i / 100;

			return String.valueOf(d);
		}
		
	}
	Smeta(){
		
		setLayout(null);
		pntop=new JPanel();pntop.setLayout(null);
		pnbottom=new JPanel();pnbottom.setLayout(null);
		
		gridtb = new JPanel();
		gridtb.setLayout(new BoxLayout(gridtb,BoxLayout.Y_AXIS));
		
		
		
		
		scrollPane2 = new JScrollPane(gridtb);
		
		//scrollPane2.add();
		
		
		
		pnbottom.add(scrollPane2);
		btedit=new JButton("Применить");
	    btedit.setBounds(pntop.getWidth()-100, 0, 100, 30);
	   
	    btfirstedit=new JButton("По умолчанию");
	    btfirstedit.setBounds(0, 0, 120, 30);
	    btfirstedit.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			setStore(selectmaterial);
	 			reBuild();
	 		}
	 	}); 
	    navpanel2=new JPanel();
	    navpanel2.setLayout(null);
	    navpanel2.setBounds(pnbottom.getHeight()-30, 0, 30, pnbottom.getWidth());
	    pnbottom.add(navpanel2);
	    navpanel2.add(btedit);
	    navpanel2.add(btfirstedit);
	    
		
       
      String[][] data = {
               
               
      };
       
      
      table = new JMultiTable(data, columnNames);
     
      JTable ltable=new JTable(table); 
      ltable.getTableHeader().setReorderingAllowed(false);
      ltable.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			int r=ltable.getSelectedRow();
	 			selectMaterial(r);
	 			
	 		}
	 	}); 
     
      btedit.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			
	 			setParametrs(selectmaterial);
	 			reBuild();
	 			
	 			
	 		}
	 	});
      scrollPane = new JScrollPane(ltable);	
      
      navpanel=new JPanel();
      navpanel.setLayout(null);
      navpanel.setBounds(pntop.getHeight()-30, 0, 30, pntop.getWidth());
      scrollPane2.setBounds(0, 0, pnbottom.getWidth(), pnbottom.getHeight());
      
      btstore=new JButton("Склад");
      btstore.setBounds(0, 0, 100, 30);
      
      btstore.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//при нажатие на секцию будет меняться ее тип
	 			actions(TO_STORE);
	 		}
	 	});
      navpanel.add(btstore);
      
      btdelete=new JButton("Удалить");
      btdelete.setBounds(pntop.getWidth()-100, 0, 100, 30);
      btdelete.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			int r=ltable.getSelectedRow();
	 			deleteMaterial(selectmaterial);
	 			
	 		}

			
	 	}); 
      
      navpanel.add(btdelete);
      
      pntop.add(scrollPane);
      pntop.add(navpanel);
      
		pntop.addComponentListener(new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				reswin();
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				reswin();
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				reswin();
			}
		      });
		
		
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
				reswin();
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				reswin();			
			}
		});
		
		
		
		
		

		content = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pntop, pnbottom);
		pnbottom.setMinimumSize(new Dimension(200,200));
		content.setDividerSize(8);
		content.setDividerLocation(600);
		
		content.setContinuousLayout(true);
		
		description=new JPanel();
		description.setBounds(0,0,300,getHeight());
		description.setLayout(null);
		
		tfnumber=new JTextBoxNum();
		tfnumber.setBounds(10, 30, 60, 30);
		
		tfdate=new JFormattedTextField(new Date());
		tfdate.setBounds(80, 30, 210, 30);
		
		
		tfobject=new JTextField();
		tfobject.setBounds(10, 100, 280, 30);
		
		
		tfbuyer=new JTextField();
		tfbuyer.setBounds(10, 170, 280, 30);
		
		tfdescription=new JTextArea();
		tfdescription.setBounds(10, 240, 280, 70);
		tfdescription.setLineWrap(true);
		
		lbnumber=new JLabel("Номер сметы от");
		lbnumber.setBounds(10, 10, 120, 20);
		
		
		
		
		lbobject=new JLabel("Объект");
		lbobject.setBounds(10, 80, 280, 20);
		
		
		lbbuyer=new JLabel("Заказчик");
		lbbuyer.setBounds(10, 150, 280, 20);
		
		lbdescription=new JLabel("Описание");
		lbdescription.setBounds(10, 220, 280, 20);
		
		lbsumma=new JLabel("Стоимость: ");
		lbsumma.setBounds(10, 360, 280, 20);
		
		btsumma=new JButton("Вычислить");
		btsumma.setBounds(10,320,110, 30);
		btsumma.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			
	 			lbsumma.setText("Стоимость: "+result()+" руб.");
	 		}
	 	});
		description.add(tfnumber);
		description.add(tfdate);
		description.add(tfobject);
		description.add(tfbuyer);
		description.add(tfdescription);
		description.add(lbnumber);
		
		description.add(lbobject);
		description.add(lbbuyer);
		description.add(lbdescription);
		description.add(lbsumma);
		description.add(btsumma);
		
		
		add(description);
		add(content);
	}
	
	void actions(int act){
		
	}
}
