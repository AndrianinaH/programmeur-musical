package mp3;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class MonTimerTask extends TimerTask
{
	private Interface f;
	private String genre;
	Chanson[] tab;
	public MonTimerTask(Interface newfs, Chanson[] newtab)
	{
		this.f=newfs;
		this.tab=newtab;
	}
	public void run()
	{
		f.getvazo().stop();
		String met="getgenre";
		//L utilisateur choisi le genre de musique avant de lire la playlist
		Interface.chansonLength=tab.length;
		f.getpl().settabchanson(tab);
		for(int i=0; i<tab.length; i++)
		{
			System.out.println(tab[i].getnom());
		}

		Interface.compteur= 0;
		for(Interface.compteur=0; Interface.compteur<Interface.chansonLength; Interface.compteur++)
		{
			//affiche le nom de la chanson dans un label
			f.gettxt().setText(f.getpl().gettabchanson()[Interface.compteur].getnom());
			f.getpane_playlist().revalidate();
			//affiche les infos de la chanson dans des Labels
			f.getxtgenre().setText(f.getpl().gettabchanson()[Interface.compteur].getgenre());
			f.gettxtnationalite().setText(f.getpl().gettabchanson()[Interface.compteur].getnationalite());
			f.gettxtnote().setText((String.valueOf(f.getpl().gettabchanson()[Interface.compteur].getnote()))+" sur 5");
			f.getpane_info().revalidate();
			//play la chanson
			String lachanson=f.getpl().gettabchanson()[Interface.compteur].getnom();
			f.getvazo().play(f.getpl().gettabchanson()[Interface.compteur].getchemin()+"/"+lachanson);
			while(f.getvazo().getplayer().isComplete()==false)
			{
				while(f.getvazo().isPlaying()==false)
				{
					System.out.println("isnotplaying");
				}	
			}
		}	
	}
}