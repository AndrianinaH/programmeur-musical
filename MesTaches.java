package mp3;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;
import java.io.*;
public class MesTaches extends Dialog
{
	private List liste = new List();
    private ScrollPane sp = new ScrollPane();
    private Label lb=new Label("Chaque Playlist se lance a la date qui lui est attribue");
    private Button button = new Button("Ok");

    public String[] getTaches(Interface f, String filename)
    {
        String[] ret=f.getpl().lectureplaylist(filename);
        return ret;
    }
    public MesTaches(Interface f)
    {
    	super(f);
    	this.setTitle("Vos Playlists planifier");
        String[] tab=this.getTaches(f,"save.txt");
        Vector<String> vect=new Vector<>();
        vect.addAll(Arrays.asList(tab));
        for(int i=0; i<vect.size();i++)
        {
            liste.add(vect.get(i));
        }


        //Tableau des playlist
    	sp.add(liste);
        sp.setSize(375,300);
        this.setModal(true);
        this.setSize(400,400);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(f);
        this.add(sp);
        this.add(lb);
        this.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent we) 
            {
                dispose();
            }
        });
        this.setVisible(true);
    }
}