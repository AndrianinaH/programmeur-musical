package mp3;
import java.awt.*;
import java.awt.event.*;

public class InfoErreur extends Dialog
{
	public InfoErreur(Interface f, String texte)
	{
		super(f);
		this.setTitle("Information");
		Panel pan= new Panel();
		IcoErreur ico=new IcoErreur();
		Label label=new Label();
		Button button=new Button("OK");
		ico.setBounds(25,15,50,50);
		label.setBounds(100,10,350,40);
		button.setBounds(165,50,50,30);
		//afficher le message d erreur
		label.setText(texte);
		label.revalidate();

		//propriete de la fenetre
		this.setModal(true);
		this.setSize(400,125);
		pan.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		pan.add(ico);
		pan.add(label);
		pan.add(button);
		this.add(pan);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		this.setVisible(true);

	}
}