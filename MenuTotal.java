package mp3;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MenuTotal extends MenuBar
{
    private Menu menufichier=new Menu("Fichier");
    private MenuItem menulect=new MenuItem("Lecture d un seul fichier");
    private MenuItem menucharg=new MenuItem("Gestionnaire de playlist");
    private MenuItem menutimer=new MenuItem("Liste Planifier");
    private MenuItem menuquit=new MenuItem("Quitter");

    public Menu getmenufichier()
    {
        return menufichier;
    }
    public MenuItem getmenulect()
    {
        return menulect;
    }
    public MenuItem getmenucharg()
    {
        return menucharg;
    }
    public MenuItem getmenutimer()
    {
        return menutimer;
    }
    public MenuItem getmenuquit()
    {
        return menuquit;
    }

	public MenuTotal()
    {
         menufichier.add(menulect);
        menufichier.add(menucharg);
        menufichier.add(menutimer);
        menufichier.add(menuquit);
        this.add(menufichier);
    }

}