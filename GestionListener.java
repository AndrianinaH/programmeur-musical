package mp3;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class GestionListener implements ActionListener
{
	private FenetrePlaylist d;
	private Interface f;
	private String genre;
	public GestionListener(){}
	public GestionListener(FenetrePlaylist newd, Interface newf)
	{
		this.d=newd;
		this.f=newf;		
	}
	public void controlgenre(Chanson[] tab, String genre)throws Exception
	{
		String[] tabgenre =f.getpl().listgenre(tab);
		boolean test = false;
		for(int i=0; i<tabgenre.length; i++)
		{
			if(tabgenre[i].equalsIgnoreCase(genre))
			{
				test = true;
				break;
			}
		}
		if(test==false) 
		{	
			throw new Exception("Veillez entrer un genre existant");
		}
		
	}

	public void saveGenre(String genre)
	{
		try
        {
        	//écrire a la suite du fichier avec true
            FileWriter fw = new FileWriter("save.txt", true); 
           	fw.write("la playlist "+genre+" se lancera le ");
           	fw.close();
        } 
       catch(IOException e)
       {
            e.printStackTrace();
       }
	}
	public void actionPerformed(ActionEvent e)
	{
		f.getbtprevious().setVisible(true);
		f.getbtnext().setVisible(true);
		f.getpane_boutton().revalidate();
		f.getngenre().setVisible(true);
		f.getncountry().setVisible(true);
		f.getnappreciation().setVisible(true);
		f.getpane_info().revalidate();
		genre=d.getchoixgenre().getText();
		try
		{
			Chanson[] tabobj=f.getpl().gettabchanson();
			this.controlgenre(tabobj, genre);
			String met="getgenre";
			this.saveGenre(genre);
			Chanson[] playlist=f.getpl().getplaylisttrier(tabobj, met, genre);
			f.getpl().settabchanson(playlist);
			d.dispose();
			FenetrePlaylist2 fp2=new FenetrePlaylist2(f);
		}
		catch(Exception ex)
		{
			new InfoErreur(f,ex.getMessage());
		}
	}
}