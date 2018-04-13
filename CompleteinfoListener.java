package mp3;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class CompleteinfoListener implements ActionListener
{
	private Completeinfo d;
	private Interface f;
	public CompleteinfoListener(){}
	public CompleteinfoListener(Completeinfo newd, Interface newf)
	{
		this.d=newd;
		this.f=newf;		
	}
	public boolean isnumeric(String donnee)
	{
		double test=0;
		try
		{
			test=Double.valueOf(donnee);
		}
		catch(NumberFormatException exept)
		{
			return false;
		}
		return true;

	}
	public String controlgenre()throws Exception
	{
		String temp=d.getgenre().getText();
		if(temp.isEmpty())
		{
			throw new Exception("Veillez remplir tout les champs");	
		}
		return temp;
	}
	public String controlnationnalite()throws Exception
	{
		String temp=d.getcountry().getText();
		if(d.getgenre().getText().isEmpty())
		{
			throw new Exception("Veillez remplir tout les champs");
		}
		return temp;
	}
	public String controlnote()throws Exception
	{
		String temp=d.getnote().getText();
		if(d.getgenre().getText().isEmpty() || d.getcountry().getText().isEmpty() || d.getnote().getText().isEmpty())
		{
			throw new Exception("Veillez remplir tout les champs");
		}
		if(!temp.isEmpty())
		{
			if(isnumeric(temp)==false)
			{
				throw new Exception("Veillez entrer un nombre entre 0 et 5");
			}
		}
		return temp;	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			String genre="//"+controlgenre()+"//";
			String country=controlnationnalite()+"//";
			String note=controlnote();
			f.getpl().ecritureplaylist(genre, "playlist.txt");
			f.getpl().ecritureplaylist(country, "playlist.txt");
			f.getpl().ecritureplaylistfin(note, "playlist.txt");
			d.dispose();
		}
		catch(Exception ex)
		{
			new InfoErreur(f,ex.getMessage());
		}
	}
}