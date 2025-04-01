import java.awt.event.*;
import java.awt.*;
import java.sql.*;



class Primul extends Frame implements ActionListener {
	
	
	Introducere tmpCon;

	
	boolean flag=false;
	
	MenuBar mb;
	Menu file;
	
	Menu help;
	MenuItem conc;
	MenuItem disconc;
	MenuItem exit;
	
	Menu intr;
	MenuItem ok;
	
	
	public Primul() {
		super(" Formular ");
		this.addWindowListener (new WindowAdapter () 
				{
					public void windowClosing(WindowEvent e){
						System.exit(0);
						}
			
		 
		}); 
		
	}
	
	public void initializare(){
		setBackground(Color.lightGray);
		
		mb=new MenuBar();
		
		file =new Menu("File");
		conc=new MenuItem("Conectare");
		disconc=new MenuItem("Deconectare");
		exit=new MenuItem("Exit");
		file.add(conc);
		file.add(disconc);
		file.add(exit);
		conc.addActionListener(this);
		disconc.addActionListener(this);
		exit.addActionListener(this);
		help = new Menu ("Help ");
		
		intr=new Menu("Angajati");
		ok=new MenuItem("Introducere / Stergere date");
		ok.addActionListener(this);
		intr.add(ok);
		//intr.addActionListener(this);
		mb.add(file);
		mb.add(intr);
		mb.add(help);
		setMenuBar(mb);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	String comanda= e.getActionCommand();
	
	
	//file
	if(comanda =="Conectare") {
		                       tmpCon=new Introducere(this);
		                       tmpCon.initializare();
		                       tmpCon.setSize(300,180);
		                       tmpCon.show();
		                       if(Global.c!=null) flag=true;
		                       	
		                       	}
		                       	
		                       	
    if (comanda.equals("Deconectare")) {
     try{	Global.c.close(); }
     catch(Exception ex) {}
    	Global.c=null;
    	flag=false;
    	}
    	
   if(comanda.equals("Exit")){
    	 System.exit(0);    	 
    	 
    }
    
   if (comanda.equals("Introducere / Stergere date")) {
   	
   		FrameAngajati aux=new FrameAngajati(this,"Introducere / Stergere date  ");
								aux.initializare();
								aux.setSize(450,300);
								aux.show();

   }

 }
		
	
	
	//{
		
	//}
	

	
}