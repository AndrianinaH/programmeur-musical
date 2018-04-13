package mp3;
import java.awt.*;
import java.awt.event.*;

public class PlayListener implements MouseListener
{
	private Interface f;
	private Thread t;
	private String chemin="icones/play.png";
	private String newchemin="icones/play1.png";
	public PlayListener(){}
	public PlayListener(Interface newf)
	{
		this.f=newf;	
	}
	public void mouseClicked(MouseEvent e)
	{
		t=new Thread()
       	{
            public void run()
        	{
        		if(!f.getvazo().isPlaying())
				{
					f.getvazo().resume();
				}	    					
       		}
       	};t.start();
	}
	public void mouseEntered(MouseEvent e)
	{
		f.getbtplay().setchemin(newchemin);
		f.getbtplay().repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		f.getbtplay().setchemin(chemin);
		f.getbtplay().repaint();
	}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
}

