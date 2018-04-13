package mp3;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class GestionListener2 implements ActionListener
{
	private FenetrePlaylist2 d;
	private Interface f;
	private String heure;
	private SimpleDateFormat df;
	private Date date;
	private MonTimerTask timt;
	private Timer timer=new Timer();
	public GestionListener2(){}
	public GestionListener2(FenetrePlaylist2 newd, Interface newf)
	{
		this.d=newd;
		this.f=newf;		
	}
	public Date isValid() throws Exception
	{
		heure=d.getchoixheure().getText();		
		df=new SimpleDateFormat("dd/MM/yy hh:mm");
		Date dt=df.parse(heure);
		return dt;
	}
	public void saveHeure(String heure)
	{
		try
        {
        	//écrire a la suite du fichier avec true
            FileWriter fw = new FileWriter("save.txt", true); 
            PrintWriter out = new PrintWriter(fw); 
            //pour permettre le saut de ligne a prochaine ecriture
            out.println(heure); 
        	out.close();
        } 
       catch(IOException e)
       {
            e.printStackTrace();
       }
	}
	public void actionPerformed(ActionEvent e)
	{
		f.getngenre().setVisible(true);
		f.getncountry().setVisible(true);
		f.getnappreciation().setVisible(true);
		f.getpane_info().revalidate();

		
		Chanson[] tabobj=f.getpl().gettabchanson();
		d.revalidate();
		MonTimerTask timt=new MonTimerTask(f,tabobj);
		//creation des timer et lancement de ce timer
		timer=new Timer();
		try
		{
			date=this.isValid();
			String heurevalid=df.format(date);
			this.saveHeure(heurevalid);
			timer.schedule(timt,date);
			d.dispose();
		}
		catch(Exception ex)
		{
			new InfoErreur(f, "format de date invalide");
		}

	}
}