import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FrameAngajati extends Dialog implements ActionListener,ItemListener
{

	Panel p1,p2,p3,p4,p5;
	Choice nr_ord;
	TextField nume,prenume,cnp,nr;
	Button adauga,sterge,cancel;
	
public FrameAngajati(Frame parinte,String s){
		super(parinte,s,true);
		this.addWindowListener (new WindowAdapter () 
				{
					public void windowClosing(WindowEvent e){
						dispose();
						}
		}); 
	}
public void initializare(){
	setLayout(new GridLayout(5,1) );
	setResizable(true);
	p1=new Panel();
	p1.add(new Label("Numar ordine : "));
	nr_ord=new Choice();
	nr_ord.addItemListener(this);
	p1.add(nr_ord);
	nr_ord.addItem("-NOU");
	nr=new TextField(5);
	nr.setVisible(true);
	p1.add(nr);
	add(p1);
	
	try {
					Statement stmt = Global.c.createStatement();
					ResultSet rs = stmt.executeQuery("select nr_ord from ANGAJATI");
					while(rs.next())
							{
						nr_ord.add(rs.getString(1));
						}
			}
			catch(Exception exc){
						Rezultat rez=new Rezultat(this,exc.toString());
						rez.setTitle("Eroare ");
						rez.setSize(200,100);
						rez.show();
			}

	
	
	p2=new Panel();
	p2.add(new Label("Nume :") );
	nume=new TextField(16);
	p2.add(nume);
	add(p2);
	
	p3=new Panel();
	p3.add(new Label("Prenume :") );
	prenume=new TextField(21);
	p3.add(prenume);
	add(p3);
	
	p4=new Panel();
	p4.add(new Label("CNP :") );
	cnp=new TextField(13);
	p4.add(cnp);
	add(p4);
	
	p5=new Panel();
	adauga=new Button("Adauga");
	adauga.addActionListener(this);
	p5.add(adauga);
	
	sterge=new Button("Sterge");
	sterge.addActionListener(this);
	p5.add(sterge);
	
	cancel=new Button("Cancel");
	cancel.addActionListener(this);
	p5.add(cancel);
	add(p5);

	
	
}

public void actionPerformed(ActionEvent e){
	String comanda=new String(e.getActionCommand());
		if(comanda.equals("Cancel") ) { dispose(); }
		
		if (comanda.equals("Sterge") && !nr_ord.getSelectedItem().equals("-NOU")){
			try {
					PreparedStatement stmt = Global.c.prepareStatement
					("delete from  ANGAJATI where NR_ORD=?");
					//stmt.setInt(1,Int.parseInt(s));
					stmt.setString(1,nr_ord.getSelectedItem());
					stmt.execute();
					}
						
					catch(Exception exc){
					Rezultat rez=new Rezultat(this,exc.toString());
					rez.setTitle("Eroare ");
					rez.setSize(400,100);
					rez.show();
					}
			dispose();
			}

		if (comanda.equals("Adauga") && nr_ord.getSelectedItem().equals("-NOU") ){
			try {
				//Long op=0;
				PreparedStatement stmt = Global.c.prepareStatement ("insert into angajati(NR_ORD,NUME,PRENUME,CNP) values (?,?,?,?)");
				//op=Long.parseLong(nr.getText());
				stmt.setString(1,nr.getText());
				stmt.setString (2,nume.getText());
				stmt.setString (3,prenume.getText());
				stmt.setString (4,cnp.getText());
				
				stmt.execute();
				}
			catch (Exception ex) {
						Rezultat rez=new Rezultat(this,ex.toString());
						rez.setTitle("Eroare ");
						rez.setSize(400,100);
						rez.show();
						}
			dispose();
		}
}


public void itemStateChanged (ItemEvent e){
	String s=e.getItem().toString();
		
			if (!s.equals("-NOU")) {
					nr.setVisible(false);
					try {
					PreparedStatement stmt = Global.c.prepareStatement
					("select NUME,PRENUME,CNP from ANGAJATI where NR_ORD=?");
					//stmt.setInt(1,Int.parseInt(s));
					stmt.setString(1,s);
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						nume.setText(rs.getString(1));
						prenume.setText(rs.getString(2));
						cnp.setText(rs.getString(3));
										}			
					}
						
					catch(Exception exc){
					Rezultat rez=new Rezultat(this,exc.toString());
					rez.setTitle("Eroare ");
					rez.setSize(400,100);
					rez.show();
					}
			}
			else 	{
					nr.setVisible(true);
					nume.setText("");
					prenume.setText("");
					cnp.setText("");
					}

}

}
	
