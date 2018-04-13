package mp3;
import java.awt.*;
import java.awt.event.*;

public class TimerListener implements ActionListener
{
	private Interface f;
	private FenetrePlaylist fp;
	public TimerListener(){}
	public TimerListener(Interface newf)
	{
		this.f=newf;	
		
	}
	public void actionPerformed(ActionEvent e)
	{
		MesTaches mt=new MesTaches(f);
	}
}

