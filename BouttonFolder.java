package mp3;
import java.awt.*;

public class BouttonFolder extends Canvas
{
    private Toolkit image=Toolkit.getDefaultToolkit();
    private String chemin="icones/folder.png";
    public void setchemin(String newchemin)
    {
        this.chemin=newchemin;
    }
	public BouttonFolder()
    {
        super. setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

	public void paint(Graphics g)
	{
		Image img=image.getImage(chemin);
     	g.drawImage(img,0,0,this);
    } 
    public Dimension getPreferredSize() 
    {
        return new Dimension(40,40);
    }  	
}