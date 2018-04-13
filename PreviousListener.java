package mp3;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class PreviousListener extends Frame implements MouseListener
{
	private Interface f;
	private Thread t;
	private String chemin="icones/precedant.png";
	private String newchemin="icones/precedant1.png";
	public PreviousListener(){}
	public PreviousListener(Interface newf)
	{
		this.f=newf;
	}
	public void testcompteur()throws Exception
	{
		
		if(Interface.compteur==0)
		{
			throw new Exception("Vous etes au debut vous ne pouvez pas reculer");
		}
	}
	
	public void mouseClicked(MouseEvent e)
	{	
		try
		{
			//tester si le compteur est egal a 0, si oui 
			this.testcompteur();
			t=new Thread()
	       	{
	            public void run()
	        	{
					Interface.compteur--;
	        	   	f.getvazo().stop();
	        	   	//rafraichir les panels
	        	   	f.getpane_playlist().revalidate();
	    	   		f.getpane_info().revalidate();
	    	   		//affiche le nom de la chanson dans un label
					f.gettxt().setText(f.getpl().gettabchanson()[Interface.compteur].getnom());
					f.getpane_playlist().revalidate();
					//affiche les infos de la chanson dans des Labels
					f.getxtgenre().setText(f.getpl().gettabchanson()[Interface.compteur].getgenre());
					f.gettxtnationalite().setText(f.getpl().gettabchanson()[Interface.compteur].getnationalite());
					f.gettxtnote().setText((String.valueOf(f.getpl().gettabchanson()[Interface.compteur].getnote()))+" sur 5");
					f.getpane_info().revalidate();
					String lachanson=f.getpl().gettabchanson()[Interface.compteur].getnom();
					f.getvazo().play(f.getpl().gettabchanson()[Interface.compteur].getchemin()+"/"+lachanson);
					System.out.println("compteur lors de l appuie de previous="+Interface.compteur);			
	       		}
	       	};t.start();
		}
		catch(Exception ex)
		{
			new InfoErreur(f,ex.getMessage());
		}
		
	}
	public void mouseEntered(MouseEvent e)
	{
		f.getbtprevious().setchemin(newchemin);
		f.getbtprevious().repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		f.getbtprevious().setchemin(chemin);
		f.getbtprevious().repaint();
	}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
}

