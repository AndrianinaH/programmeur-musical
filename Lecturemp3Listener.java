package mp3;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Pattern;

public class Lecturemp3Listener implements ActionListener
{
	private Interface f;
	private Thread t; 
	public Lecturemp3Listener(){}
	public int nbr_element(String donnee)
	{//compter le nombre de mot par rapport au nombre de separateur
		int ret=0;
		for(int i=0; i<donnee.length(); i++)
		{
			if(donnee.charAt(i)=='\\')
			{
				ret++;
			}
		}
		return ret;
	}
	//change \ en /
	public String changeAntiSlash(String directory)
	{
		String ret="";
		String []global=directory.split(Pattern.quote("\\"));
		for(int i=0; i<nbr_element(directory); i++)
		{	
			ret=ret+global[i]+"/";
		}
		return ret;
	}
	public String getfilelocation()throws Exception
	{
		FileDialog fd=new FileDialog(f,"Lire un fichier mp3");
		fd.setVisible(true);
		String nom=fd.getFile();
		String ret="";
        if (nom!=null) 
        {
        	//verifier si le fichier selectionner est un mp3
        	String[] tabvalidation=nom.split(Pattern.quote("."));
        	//System.out.println(tabvalidation[1]);
        	if(tabvalidation[1].compareToIgnoreCase("mp3")!=0)
        	{
        		throw new Exception("Le fichier selectionner n est pas un mp3");
        	}
    		//stop la chanson actuel avant de lire une nouvelle
    		f.getvazo().stop();
    		f.gettxt().setText(nom);
			f.getpane_playlist().revalidate();
	        String dir=fd.getDirectory();
	        //transforme les \ en /
	        String result =changeAntiSlash(dir);
    		ret=result+nom;
    		//System.out.println(ret);
    	}
    	return ret;
	}
	public Lecturemp3Listener(Interface newf)
	{
		this.f=newf;
	}
	public void actionPerformed(ActionEvent e)
	{
		
		t=new Thread()
		{
			public void run()
			{
				try
				{
					f.getvazo().play(getfilelocation());
				}
				catch(Exception ex)
				{	
					new InfoErreur(f,ex.getMessage());
				}
			}
		};t.start();
	}
}

