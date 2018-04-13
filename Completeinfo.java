package mp3;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;
import java.io.*;
public class Completeinfo extends Dialog
{
    private Label lb=new Label("Veillez entrer les informations sur la chanson");
    private Label txtgenre=new Label("genre");
    private TextField genre=new TextField(15);
    private Label txtnationnalite=new Label("nationnalite");
    private TextField country=new TextField(15);
    private Label txtnote=new Label("Appreciation (une note sur 5)");
    private TextField note=new TextField(15);
    private Button button = new Button("Ok");

    public TextField getgenre()
    {
        return this.genre;
    }
    public TextField getcountry()
    {
        return this.country;
    }
    public TextField getnote()
    {
        return this.note;
    }
    public Completeinfo(Interface f)
    {
    	super(f);
    	this.setTitle("Information sur la chanson");
      
        this.setModal(true);
        this.setSize(400,400);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(f);

        lb.setBounds(65,40,375,40);
        txtgenre.setBounds(100,80,175,40);
        genre.setBounds(100,120,175,25);
        txtnationnalite.setBounds(100,160,175,40);
        country.setBounds(100,200,175,25);
        txtnote.setBounds(100,240,175,40);
        note.setBounds(100,280,175,25);
        button.setBounds(100,320,175,25);

        this.add(lb);
        this.add(txtgenre);
        this.add(genre);
        this.add(txtnationnalite);
        this.add(country);
        this.add(txtnote);
        this.add(note);
        this.add(button);
        button.addActionListener(new CompleteinfoListener(this, f));
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