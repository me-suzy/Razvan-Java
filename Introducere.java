import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Introducere extends Dialog implements ActionListener{
	
	


	
	private TextField user;
	private TextField pass;
	private TextField masina;
	private TextField bede;
	private Button ok;
	private Button cancel;
	
	private Label us;
	private Label pa;
	private Label ma;
	private Label be;
	
	private Panel p1;
	private Panel p2;
	private Panel p3;
	private Panel p4;
	//private Panel p5;
	
	Rezultat rez;
	
	 
	private Conectare cn;
	private String server;
	private String db;
	private String usr;
	private String passw;
	
	public Introducere (Primul f){
		super(f,"Date conectare ",true);
		
	
		this.addWindowListener (new WindowAdapter () 
				{
					public void windowClosing(WindowEvent e){
				
						dispose();
						}
			
		 
		}); 
		
	}
	
	
	public void initializare(){
		
		setLayout (new GridLayout(1,2));
		
		setBackground(Color.lightGray);
		
		setResizable(false);
		
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		p4=new Panel();
		p1.setLayout(new GridLayout(5,1));
		;
		p2.setLayout(new GridLayout(5,1));
		
		p3.setLayout(new FlowLayout());
		
		p4.setLayout(new FlowLayout());
		us=new Label("User :");
		us.setAlignment(Label.CENTER);
		p1.add(us);
		
		user =new TextField("scott",50);
	
		p2.add(user);
	
		
		pa = new Label("Password :");
		pa.setAlignment(Label.CENTER);
		p1.add(pa);
		
		pass=new TextField("tiger",50);
		pass.setEchoChar('*');
		p2.add(pass);
	
		
		ma = new Label("Server :");
		ma.setAlignment(Label.CENTER);
		p1.add(ma);
		
		masina=new TextField("ws21",50);
		p2.add(masina);
		
		
		be= new Label ("Baza de date :");
		be.setAlignment(Label.CENTER);
		p1.add(be);
		
		bede=new TextField("Boracle",50);
		p2.add(bede);
	
		
		ok=new Button("OK");
		ok.setSize(100,30);
		ok.addActionListener(this);
		p3.add(ok);
		
		cancel=new Button("Cancel");
		cancel.addActionListener(this);
		p4.add(cancel);
		
		p1.add(p3);
		p2.add(p4);
		add(p1);
		add(p2);
		
		
		pack();
		
	}
	
	public void GetTxt()
	{
		server=masina.getText();
		db=bede.getText();
		usr=user.getText();
		passw=pass.getText();
	}
	
	public String Connecting()
	{
		cn=new Conectare(server,db,usr,passw);
		return cn.Connect();
	}
	public void actionPerformed(ActionEvent e){
		String tmp=e.getActionCommand();
		String tmps;
		if(tmp=="OK")   {
						 GetTxt();
						 rez=new Rezultat(this,Connecting());
						 rez.setSize(300,200);
						 rez.show();
						 tmps=Connecting();
						 if(tmps=="Succes")
						  { Global.c=cn.getC();
						    dispose();
						    } 
						    }
		if(tmp=="Cancel")  dispose();
		
		

	}	
}