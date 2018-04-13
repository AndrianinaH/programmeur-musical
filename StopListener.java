package mp3;
import java.awt.*;
import java.awt.event.*;

public class StopListener implements MouseListener
{
	private Interface f;
	private Thread t;
	private String chemin="icones/stop.png";
	private String newchemin="icones/stop1.png";
	public StopListener(){}
	public StopListener(Interface newf)
	{
		this.f=newf;	
	}
	public void mouseClicked(MouseEvent e)
	{
		if(f.getvazo().isPlaying())
		{
			if(f.getvazo() != null)
			{
               	f.getvazo().stop();	
            }
		}	
	}
	public void mouseEntered(MouseEvent e)
	{
		f.getbtstop().setchemin(newchemin);
		f.getbtstop().repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		f.getbtstop().setchemin(chemin);
		f.getbtstop().repaint();
	}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
}

