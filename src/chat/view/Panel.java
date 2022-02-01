package chat.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import chat.controller.Controller;

public class Panel extends JPanel
{
	private Controller app;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton quit;
	
	public Panel(Controller app)
	{
		super();
		this.app = app;
		this.button0 = new JButton("");
		this.button1 = new JButton("");
		this.button2 = new JButton("");
		this.button3 = new JButton("");
		this.button4 = new JButton("");
		this.button5 = new JButton("");
		this.quit = new JButton("Quit");
		
		setupPanel();
		setupListeners();
		setupLayout();
	}

	private void setupLayout()
	{
		// TODO Auto-generated method stub
		
	}

	private void setupListeners()
	{
		// TODO Auto-generated method stub
		
	}

	private void setupPanel()
	{
		// TODO Auto-generated method stub
		
	}
}
