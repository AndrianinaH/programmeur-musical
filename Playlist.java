package mp3;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Playlist
{
    private Chanson[] tabchanson;
    public Chanson[] gettabchanson()
    {
        return this.tabchanson;
    }
    public void settabchanson(Chanson[] newtabchanson)
    {
        this.tabchanson=newtabchanson;
    }
    public Playlist(){}

    //stocker la playlist dans un fichier txt
    public void ecritureplaylist(String nom, String filename)
    {//écrire a la suite de du fichier txt
       try
       {
            FileWriter fw = new FileWriter(filename, true); 
            fw.write(nom);
            fw.close();
       } 
       catch(IOException e)
       {
            e.printStackTrace();
       }
    }
    public void ecritureplaylistfin(String nom, String filename)
    {//écrire a la suite de du fichier txt et permet le saut de ligne
        try
        {
            //écrire a la suite du fichier avec true
            FileWriter fw = new FileWriter(filename, true); 
            PrintWriter out = new PrintWriter(fw); 
            //pour permettre le saut de ligne a prochaine ecriture
            out.println(nom); 
            out.close();
        } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public int nbr_element(String filename)
    {//compte le nombre de ligne du fichier txt
        int compteur=0;
        String line="";
        try
        {
            BufferedReader bfr = new BufferedReader(new FileReader(filename));
            while((line=bfr.readLine())!= null)
            {
                compteur++;
            }
            bfr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return compteur;
    }
   //recupere le contenu du fichier txt
    public String[] lectureplaylist(String filename)
    {
        String[]listeFichiers=new String[nbr_element(filename)];
        try
        {
            BufferedReader bfr = new BufferedReader(new FileReader(filename));
            for(int i=0; i<nbr_element(filename); i++)
            {
                listeFichiers[i]=bfr.readLine();
                //System.out.println(listeFichiers[i]);
            }
            bfr.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return listeFichiers;
    }
    //recupere les infos sur une ligne du fichier txt
    public String[] getinfochanson(String donnee)
    {
        String[]ret=donnee.split("//");
        for(int i=0; i<ret.length;i++)
        {
            //System.out.println(ret[i]);
        }
        return ret;
    }
    //rempli les infos chanson par chanson
    public void completeinfochanson(Interface f)
    {   
        String[] listmp3=f.getpl().lectureplaylist("playlist.txt");
        tabchanson = new Chanson[listmp3.length];
        for(int i=0; i<listmp3.length;i++)
        {//boucle pour parcourir le tabchanson
        
            String[] infomp3=f.getpl().getinfochanson(listmp3[i]);
            tabchanson[i]=new Chanson();
            tabchanson[i].setchemin(infomp3[0]);
            tabchanson[i].setnom(infomp3[1]);
            tabchanson[i].setgenre(infomp3[2]);
            tabchanson[i].setnationalite(infomp3[3]);
            tabchanson[i].setnote(Integer.parseInt(infomp3[4]));   
        } 
    }
    public int nbrelement(Object[] l)
    {
        int ret=0;
        for (int i=0; i<l.length; i++)
        {
            if(l[i]!=null)
            {
                ret++;
            }
        }
        return ret;
    }
    public Chanson[]vectTotabchanson(Vector vect)
    {
        Object[] temp=vect.toArray();
        Chanson[] tab=new Chanson[temp.length];
        for(int i=0; i<temp.length; i++)
        {
            tab[i]=(Chanson)temp[i];
        }
        return tab;
    }
    public String[]vectTotabstring(Vector vect)
    {
        Object[] temp=vect.toArray();
        String[] tab=new String[temp.length];
        for(int i=0; i<temp.length; i++)
        {
            tab[i]=(String)temp[i];
        }
        return tab;
    }
    //recupere une nouvelle playlist a partir d un attribut commun
    public Chanson[] getplaylisttrier(Chanson[] lo, String met, String nom)
    {
        Vector temp=new Vector();
        try
        {
            Method lamethod=lo[0].getClass().getMethod(met);
            for(int i=0; i<nbrelement(lo);i++)
            {
                String a=(String)lamethod.invoke(lo[i]);
                if(a.equals(nom)==true)
                {
                    temp.add(lo[i]);
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        Chanson[] rep=vectTotabchanson(temp);
        return rep;
    }
    public String[] listnom(Chanson[] tabchanson)
    {
        Vector temp=new Vector();
        for(int i=0; i<tabchanson.length; i++)
        {
            temp.add(tabchanson[i].getnom());
        }
        String[] rep=vectTotabstring(temp);
        return rep;
    }
     public String[] listgenre(Chanson[] tabchanson)
    {
        Vector temp=new Vector();
        //supprimer les doublons
        temp.add(tabchanson[0].getgenre());
        for( int i=1; i<tabchanson.length; i++)
        {
            boolean exist = false;
            for(int j=0; j<temp.size(); j++)
            {
                if (tabchanson[i].getgenre().equalsIgnoreCase((String)temp.get(j))) 
                {
                    exist = true;
                    break;
                }
                if(exist==false)
                {
                    temp.add(tabchanson[i].getgenre());
                }
            }
        }
        String[] rep=vectTotabstring(temp);
        return rep;
    }
}