package chat.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;

import javax.swing.JTextArea;
import javax.swing.JTextField;
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
		
	}

	private void setupListeners()
	{
		getDate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 0);
			}
		});
		
		getTime.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 1);
			}
		});
		
		isPolite.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 2);
			}
		});
		
		askQuestion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 3);
			}
		});
		
		getRandomTopic.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 4);
			}
		});
		
		quit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.quit();
			}
		});
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
