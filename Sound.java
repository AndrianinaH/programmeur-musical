package mp3;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import java.io.*;

// MP3, WMA, MPEG, WAV compatible

public class Sound 
{
    private boolean isPlaying = false;
    private boolean isFinished = false;
    private Player player = null;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private long pauseLocation;//position de la pause
    private long lengthTotal;//taille total
    private String filelocation;
    public Player getplayer()
    {
        return this.player;
    }
    public Sound()
    {
    }
    
    public void play(String path)
    {
        try
        {
            fis=new FileInputStream(new File(path));
            bis= new BufferedInputStream(fis);
            player = new Player(bis);  
            lengthTotal=fis.available();
            filelocation=path;  
        } 
        catch(FileNotFoundException | JavaLayerException e)
        {
            e.printStackTrace();
        }
         catch(IOException e)
        {
            e.printStackTrace();
        }
       
        isPlaying = true;
        isFinished = false;
        try
        {
            player.play();
        }
        catch(JavaLayerException e)
        {
            e.printStackTrace();
        }  
    }
    public void resume()
    {
        try
        {
            fis=new FileInputStream(new File(filelocation));
            bis= new BufferedInputStream(fis);
            player = new Player(bis);
            if(isFinished==false)
            {
                fis.skip(lengthTotal-pauseLocation); 
            }
             if(isFinished==true)
            {
                lengthTotal=fis.available();
            }
            
        } 
        catch(FileNotFoundException | JavaLayerException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
      
        isPlaying = true;
        isFinished = false;
        try
        {
            player.play();
        }
        catch(JavaLayerException e)
        {
            e.printStackTrace();
        } 
    }
    public void stop()
    {
        if (player != null)
        {
            isPlaying = false;
            isFinished = true;
            player.close();
            //reinitialisation
            pauseLocation=0;
            lengthTotal=0;
        }
    }
    public void pause()
    {
        if (player != null) 
        {
            isPlaying = false;
            isFinished = false;
            try
            {
                pauseLocation=fis.available();
                player.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
           
        }
    } 
    public boolean isPlaying() 
    {
        return isPlaying;
    }
    public boolean isFinished()
    {
        return isFinished;
    }
   
}

