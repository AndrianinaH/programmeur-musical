package mp3;
import java.awt.*;
import java.awt.event.*;
public class Interface extends Frame
{
	private BouttonPlay btplay=new BouttonPlay();
	private BouttonStop btstop=new BouttonStop();
	private BouttonPause btpause=new BouttonPause();
	private BouttonFolder btfolder=new BouttonFolder();
	private BouttonNext btnext=new BouttonNext();
	private BouttonPrevious btprevious=new BouttonPrevious();
	private Panel pane_boutton=new Panel();
	private Panel pane_playlist=new Panel();
	private Panel pane_info=new Panel();
	private Label txt=new Label("");
	private Label ngenre=new Label("Genre :");
	private Label ncountry=new Label("Nationalite :");
	private Label nappreciation=new Label("Note :");
	private Label txtgenre=new Label("");
	private Label txtnationalite=new Label("");
	private Label txtnote=new Label("");
	private Sound vazo=new Sound();  
	private MenuTotal menutotal=new MenuTotal();
	private Playlist pl=new Playlist();
	private Toolkit image=Toolkit.getDefaultToolkit();
	private Image img=image.getImage("icones/lecteurIcone.png");
	private PreviousListener plistener=new PreviousListener(this);
	private NextListener nlistener=new NextListener(this);
	public static int compteur=0;
	public static int chansonLength=0;
	public BouttonPlay getbtplay()
	{
		return this.btplay;
	}
	public BouttonStop getbtstop()
	{
		return this.btstop;
	}
	public BouttonPause getbtpause()
	{
		return this.btpause;
	}
	public BouttonFolder getbtfolder()
	{
		return this.btfolder;
	}
	public BouttonPrevious getbtprevious()
	{
		return this.btprevious;
	}
	public BouttonNext getbtnext()
	{
		return this.btnext;
	}
	public Panel getpane_boutton()
	{
		return this.pane_boutton;
	}
	public Panel getpane_playlist()
	{
		return this.pane_playlist;
	}
	public Panel getpane_info()
	{
		return this.pane_info;
	}
	public Sound getvazo()
	{
		return this.vazo;
	}
	public Label gettxt()
	{
		return this.txt;
	}
	
	public Label getxtgenre()
	{
		return this.txtgenre;
	}
	public Label gettxtnationalite()
	{
		return this.txtnationalite;
	}
	public Label gettxtnote()
	{
		return this.txtnote;
	}

	public Label getngenre()
	{
		return this.ngenre;
	}
	public Label getncountry()
	{
		return this.ncountry;
	}
	public Label getnappreciation()
	{
		return this.nappreciation;
	}
	public Playlist getpl()
	{
		return this.pl;
	}
	public MenuTotal getmenutotal()
	{
		return this.menutotal;
	}
	public Interface()
	{
		//Frame principal
		this.setTitle("Lecteur mp3");
		//this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setIconImage(img);
		this.setSize(600,200);
		this.setLocationRelativeTo(this);
		this.setMenuBar(menutotal);

		//Les Listeners
		btplay.addMouseListener(new PlayListener(this));
		btstop.addMouseListener(new StopListener(this));
		btpause.addMouseListener(new PauseListener(this));
		btfolder.addMouseListener(new FolderListener(this));
		btnext.addMouseListener(nlistener);
		btprevious.addMouseListener(plistener);
		//Listener des menus
		menutotal.getmenulect().addActionListener(new Lecturemp3Listener(this));
		menutotal.getmenucharg().addActionListener(new PlaylistListener(this));
		menutotal.getmenutimer().addActionListener(new TimerListener(this));
		menutotal.getmenuquit().addActionListener(new QuitListener(this));

		//ajoute les bouttons au panel
		pane_playlist.add(txt);
		pane_info.add(ngenre);
		pane_info.add(txtgenre);
		pane_info.add(ncountry);
		pane_info.add(txtnationalite);
		pane_info.add(nappreciation);
		pane_info.add(txtnote);
		pane_boutton.add(btstop);
		pane_boutton.add(btprevious);
		pane_boutton.add(btplay);
		pane_boutton.add(btnext);
		pane_boutton.add(btpause);
		pane_boutton.add(btfolder);

		//modifier apparence des labels
		txt.setFont(new Font("MV Boli",Font.BOLD,15));
		ngenre.setFont(new Font("MV Boli",Font.BOLD,12));
		ncountry.setFont(new Font("MV Boli",Font.BOLD,12));
		nappreciation.setFont(new Font("MV Boli",Font.BOLD,12));
		txtgenre.setFont(new Font("MV Boli",Font.ITALIC,12));
		txtnationalite.setFont(new Font("MV Boli",Font.ITALIC,12));
		txtnote.setFont(new Font("MV Boli",Font.ITALIC,12));

		//cacher les bouttons les Labels genre/nation/note
		ngenre.setVisible(false);
		ncountry.setVisible(false);
		nappreciation.setVisible(false);

		//pane_boutton.setBackground(new Color(0,128,255));
		pane_boutton.setBackground(Color.white);
		this.add(pane_playlist, BorderLayout.NORTH);
		this.add(pane_info, BorderLayout.CENTER);
		this.add(pane_boutton, BorderLayout.SOUTH);

		//fermeture de la fenetre en appuyant sur la croix rouge
		this.addWindowListener(new FermetureListener(this));
		this.setVisible(true);
	}
}