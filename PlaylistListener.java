package mp3;
import java.awt.*;
import java.awt.event.*;

public class PlaylistListener implements ActionListener
{
	private Interface f;
	private FenetrePlaylist fp;
	public PlaylistListener(){}
	public PlaylistListener(Interface newf)
	{
		this.f=newf;	
		
	}
	public void actionPerformed(ActionEvent e)
	{
		fp=new FenetrePlaylist(this.f);
	}
}

