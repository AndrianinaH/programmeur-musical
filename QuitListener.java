package mp3;
import java.awt.*;
import java.awt.event.*;

public class QuitListener implements ActionListener
{
	private Interface f;
	public QuitListener(){}
	public QuitListener(Interface newf)
	{
		this.f=newf;	
	}
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
