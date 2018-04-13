package mp3;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;
import java.io.*;
public class FenetrePlaylist extends Dialog
{
    private Panel pan=new Panel();
    private Panel pan2=new Panel();
	private List liste = new List();
    private ScrollPane sp = new ScrollPane();
    private Label lb=new Label("Choisissez un genre afin de trier cette playlist");
    private TextField choixgenre=new TextField(15);
    private Button button = new Button("charger la nouvelle playlist");
    public TextField getchoixgenre()
    {
        return this.choixgenre;
    }
    public FenetrePlaylist(Interface f)
    {
    	super(f);
    	this.setTitle("Votre Playlist Global");
        //recupere la playlist total
    	f.getpl().completeinfochanson(f);
    	Chanson[] tabobj=f.getpl().gettabchanson();
    	String[] tabobjNom=f.getpl().listnom(tabobj);
    	//transformer un tableau en vector
    	Vector<String> vect=new Vector<>();
    	vect.addAll(Arrays.asList(tabobjNom));
    	for(int i=0; i<vect.size();i++)
    	{
    		liste.add(vect.get(i));
    	}

    	button.addActionListener(new GestionListener(this, f));
    	sp.add(liste);
        sp.setSize(375,300);

        pan2.setLayout(null);
        lb.setBounds(65,0,375,40);
        choixgenre.setBounds(100,40,175,25);
        button.setBounds(100,75,175,25);

        this.setModal(true);
        this.setSize(400,460);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(f);
        pan.add(sp);
        pan2.add(lb);
        pan2.add(choixgenre);
        pan2.add(button);
        this.add(pan, BorderLayout.NORTH);
        this.add(pan2, BorderLayout.CENTER);
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