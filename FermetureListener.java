package mp3;
import java.awt.*;
import java.awt.event.*;

public class FermetureListener extends WindowAdapter
{
	private Interface f;
	public FermetureListener(){}
	public FermetureListener(Interface newf)
	{
		this.f=newf;	
	}
	//public void windowDeactivated(WindowEvent e){}
	public void windowClosing (WindowEvent e)
	{
		System.exit(0);
	}
}
