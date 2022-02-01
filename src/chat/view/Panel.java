package chat.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import chat.controller.Controller;

public class Panel extends JPanel
{
	private Controller app;
	private JButton getDate;
	private JButton getTime;
	private JButton isPolite;
	private JButton isPolitical;
	private JButton askQuestion;
	private JButton getRandomTopic;
	private JButton quit;
	
	public Panel(Controller app)
	{
		super();
		this.app = app;
		this.getDate = new JButton("Get the date");
		this.getTime = new JButton("Get the time");
		this.isPolite = new JButton("Check for politeness");
		this.isPolitical = new JButton("Check for politics");
		this.askQuestion = new JButton("Ask a question");
		this.getRandomTopic = new JButton("Get a random topic");
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
		this.add(getDate);
		this.add(getTime);
		this.add(isPolite);
		this.add(isPolitical);
		this.add(askQuestion);
		this.add(getRandomTopic);
		this.add(quit);
	}
}
