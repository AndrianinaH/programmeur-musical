package mp3;
import java.awt.*;
import java.awt.event.*;

public class PauseListener implements MouseListener
{
	private Interface f;
	private Thread t;
	private String chemin="icones/pause.png";
	private String newchemin="icones/pause1.png";
	public PauseListener(){}
	public PauseListener(Interface newf)
	{
		this.f=newf;	
	}
	public void mouseClicked(MouseEvent e)
	{	    		
		if(f.getvazo().isPlaying())
		{
			if(f.getvazo() != null)
			{
				f.getvazo().pause();
            }
		}		
	}
	public void mouseEntered(MouseEvent e)
	{
		f.getbtpause().setchemin(newchemin);
		f.getbtpause().repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		f.getbtpause().setchemin(chemin);
		f.getbtpause().repaint();
	}
	public void mouseReleased(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){}
}

