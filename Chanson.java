package mp3;
import java.io.*;
public class Chanson
{
    private String chemin;
    private String nom;
    private String genre;
    private String nationalite;
    private int note;
    public String getnom()
    {
        return this.nom;
    }
    public String getgenre()
    {
        return this.genre;
    }
     public String getnationalite()
    {
        return this.nationalite;
    }
    public int getnote()
    {
        return this.note;
    }
    public String getchemin()
    {
        return this.chemin;
    }
    public void setnom(String newnom)
    {
        this.nom=newnom;
    }
     public void setgenre(String newgenre)
    {
        this.genre=newgenre;
    }
     public void setnationalite(String newnationalite)
    {
        this.nationalite=newnationalite;
    }
    public void setnote(int newnote)
    {
        if(newnote>5)
        {
            this.note=5;  
        }
        if(newnote<0)
        {
            this.note=0;
        }
        this.note=newnote;
    }
    public void setchemin(String newchemin)
    {
        this.chemin=newchemin;
    }
    public Chanson(){} 
}
