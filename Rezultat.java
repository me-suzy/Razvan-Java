import java.awt.event.*;
import java.awt.*;

class Rezultat extends Dialog implements ActionListener{
	private Button ok;
	private Label succ;
	//private String str;
	
	Rezultat(Dialog f,String s)
	{
		super(f,"Result window",true);
		succ=new Label(s);
		succ.setAlignment(Label.CENTER);
		setBackground(Color.lightGray);
		Button ok=new Button("OK");
		//setSize(s.length()+10,100);
		setLayout(new GridLayout(2,1));
		add(succ);
		ok.addActionListener(this);
		add(ok);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
	
	
	
}