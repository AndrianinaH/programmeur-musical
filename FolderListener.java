package mp3;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Pattern;

public class FolderListener implements MouseListener
{
	private Interface f;
	private Thread t;
	private String chemin="icones/folder.png";
	private String newchemin="icones/folder1.png";
	private boolean fichierOuvert=false;
    public boolean fichierOuvert() 
    {
        return fichierOuvert;
    }
	public FolderListener(){}
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
		FileDialog fd=new FileDialog(f,"Ajouter une chanson a la playlist global");
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
	        String dir=fd.getDirectory();
	        //transforme les \ en /
	        String result =changeAntiSlash(dir);
    		ret=result+"/"+nom;
    		//System.out.println(ret);
    		fichierOuvert=true;
    	}
    	return ret;
	}

	public FolderListener(Interface newf)
	{
		this.f=newf;
	}
	public void mouseClicked(MouseEvent e)
	{
		try
		{
			f.getpl().ecritureplaylist(getfilelocation(), "playlist.txt");
			if(fichierOuvert()==true)
			{
				new Completeinfo(f);
			}
		}
		catch(Exception ex)
		{	
			new InfoErreur(f,ex.getMessage());
		}
	

	}
	public void mouseEntered(MouseEvent e)
	{
		f.getbtfolder().setchemin(newchemin);
		f.getbtfolder().repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		f.getbtfolder().setchemin(chemin);
		f.getbtfolder().repaint();
	}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
}

