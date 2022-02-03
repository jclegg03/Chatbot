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
		
		this.layout = new SpringLayout();
		
		this.chatArea = new JTextArea(20, 40);
		this.chatField = new JTextField(40);
		
		this.chatButtonPanel = new JPanel(new GridLayout(1, 0));
		this.ioPanel = new JPanel(new GridLayout(1, 0));
		
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
		this.setLayout(layout);
		this.setBackground(Color.MAGENTA);
		
		this.add(chatArea);
		this.add(chatField);
		this.add(chatButton);
		this.add(chatButtonPanel);
		this.add(ioPanel);
		
		chatButtonPanel.add(dateButton);
		chatButtonPanel.add(timeButton);
		chatButtonPanel.add(politeButton);
		chatButtonPanel.add(politicalButton);
		chatButtonPanel.add(questionButton);
		chatButtonPanel.add(randomTopicButton);
		
		ioPanel.add(saveButton);
		ioPanel.add(loadButton);
		ioPanel.add(quitButton);
	}
}
