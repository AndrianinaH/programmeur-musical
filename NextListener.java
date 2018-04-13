package mp3;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class NextListener extends Frame implements MouseListener
{
	private Interface f;
	private Thread t;
	private String chemin="icones/suivant.png";
	private String newchemin="icones/suivant1.png";
	public NextListener(){}
	public void testchansonLenght()throws Exception
	{
		if(Interface.compteur==Interface.chansonLength-1)
		{
			throw new Exception("Vous etes a la fin vous ne pouvez plus avancer");
		}
	}
	
	public NextListener(Interface newf)
	{
		this.f=newf;
	}
	public void mouseClicked(MouseEvent e)
	{
		try
		{
			//tester si on atteint la fin de la liste, si oui 
			this.testchansonLenght();
			t=new Thread()
	       	{
	            public void run()
	        	{
					Interface.compteur++;	

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
					System.out.println("compteur lors de l appuie de next="+Interface.compteur);		
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
		f.getbtnext().setchemin(newchemin);
		f.getbtnext().repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		f.getbtnext().setchemin(chemin);
		f.getbtnext().repaint();
	}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
}

