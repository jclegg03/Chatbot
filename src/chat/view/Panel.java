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
	
	private JPanel chatButtonPanel;
	private JPanel ioPanel;
	
	private JButton dateButton;
	private JButton timeButton;
	private JButton politeButton;
	private JButton politicalButton;
	private JButton questionButton;
	private JButton randomTopicButton;
	private JButton quitButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton chatButton;
	private JTextArea chatArea;
	private JTextField chatField;
	
	private SpringLayout layout;
	
	public Panel(Controller app)
	{
		super();
		this.app = app;
		this.dateButton = new JButton("Get the date");
		this.timeButton = new JButton("Get the time");
		this.politeButton = new JButton("Check for politeness");
		this.politicalButton = new JButton("Check for politics");
		this.questionButton = new JButton("Ask a question");
		this.randomTopicButton = new JButton("Get a random topic");
		this.quitButton = new JButton("Quit");
		this.saveButton = new JButton("Save");
		this.loadButton = new JButton("Load");
		this.chatButton = new JButton("Chat");
		this.chatArea = new JTextArea();
		this.chatField = new JTextField();
		
		this.layout = new SpringLayout();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}

	private void setupLayout()
	{
		
	}

	private void setupListeners()
	{
		dateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 0);
			}
		});
		
		timeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 1);
			}
		});
		
		politeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 2);
			}
		});
		
		questionButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 3);
			}
		});
		
		randomTopicButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.interactWithChatbot("", 4);
			}
		});
		
		quitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.quit();
			}
		});
	}

	private void setupPanel()
	{
		this.add(dateButton);
		this.add(timeButton);
		this.add(politeButton);
		this.add(politicalButton);
		this.add(questionButton);
		this.add(randomTopicButton);
		this.add(quitButton);
	}
}
