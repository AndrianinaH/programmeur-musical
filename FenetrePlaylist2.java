package mp3;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;
import java.io.*;
public class FenetrePlaylist2 extends Dialog
{
    private Panel pan=new Panel();
    private Panel pan2=new Panel();
	private List liste = new List();
    private ScrollPane sp = new ScrollPane();
    private Label lb=new Label("Entrer une date pour planifier la lecture de cette nouvelle playlist");
    private Label lb2=new Label("La date doit etre du format : dd/MM/yyyy hh:mm");
    private TextField choixheure=new TextField(15);
    private Button button = new Button("Lancer");
    public TextField getchoixheure()
    {
        return this.choixheure;
    }
    public FenetrePlaylist2(Interface f)
    {
    	super(f);
    	this.setTitle("Votre Playlist trier");
    	Chanson[] tabobj=f.getpl().gettabchanson();
    	String[] tabobjNom=f.getpl().listnom(tabobj);
    	//transformer un tableau en vector
    	Vector<String> vect=new Vector<>();
    	vect.addAll(Arrays.asList(tabobjNom));
    	for(int i=0; i<vect.size();i++)
    	{
    		liste.add(vect.get(i));
    	}
    	button.addActionListener(new GestionListener2(this, f));
    	sp.add(liste);
        sp.setSize(375,225);

        pan2.setLayout(null);
        lb.setBounds(15,0,375,40);
        choixheure.setBounds(100,40,175,25);
        lb2.setBounds(65,60,375,40);
        button.setBounds(100,100,175,25);

        this.setModal(true);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(f);
       
        pan.add(sp);
        pan2.add(lb);
        pan2.add(choixheure);
        pan2.add(lb2);
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