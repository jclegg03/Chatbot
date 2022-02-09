package chat.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.SpringLayout;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import chat.controller.Controller;

public class ChatPanel extends JPanel
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
	private JScrollPane chatPane;
	
	private SpringLayout layout;
	
	public ChatPanel(Controller app)
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
		this.chatPane = new JScrollPane();
		
		setupChatPane();
		setupPanel();
		setupListeners();
		setupLayout();
	}

	private void setupLayout()
	{
		//code generated from the wonders of window builder
		layout.putConstraint(SpringLayout.SOUTH, chatPane, -175, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatField);
		layout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatField);
		layout.putConstraint(SpringLayout.NORTH, ioPanel, 10, SpringLayout.SOUTH, chatButtonPanel);
		layout.putConstraint(SpringLayout.WEST, ioPanel, 0, SpringLayout.WEST, chatButtonPanel);
		layout.putConstraint(SpringLayout.EAST, ioPanel, 0, SpringLayout.EAST, chatButtonPanel);
		layout.putConstraint(SpringLayout.NORTH, chatField, 10, SpringLayout.SOUTH, chatPane);
		layout.putConstraint(SpringLayout.WEST, chatField, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, chatField, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, chatButtonPanel, 10, SpringLayout.SOUTH, chatButton);
		layout.putConstraint(SpringLayout.WEST, chatButtonPanel, 0, SpringLayout.WEST, chatButton);
		layout.putConstraint(SpringLayout.EAST, chatButtonPanel, 0, SpringLayout.EAST, chatButton);
		layout.putConstraint(SpringLayout.NORTH, chatButton, 10, SpringLayout.SOUTH, chatField);
		layout.putConstraint(SpringLayout.NORTH, chatPane, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, chatPane, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, chatPane, -10, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		dateButton.addActionListener(click -> chatArea.append(chatField.getText() + app.interactWithChatbot(chatField.getText(), 0) + "\n"));
		
		timeButton.addActionListener(click -> chatArea.append(chatField.getText() + app.interactWithChatbot(chatField.getText(), 1) + "\n"));
		
		politeButton.addActionListener(click -> chatArea.append(chatField.getText() + app.interactWithChatbot(chatField.getText(), 2) + "\n"));
		
		politicalButton.addActionListener(click -> chatArea.append(chatField.getText() + app.interactWithChatbot(chatField.getText(), 3) + "\n"));
		
		questionButton.addActionListener(click -> chatArea.append(chatField.getText() + app.interactWithChatbot(chatField.getText(), 4) + "\n"));
		
		randomTopicButton.addActionListener(click -> chatArea.append(chatField.getText() + app.interactWithChatbot(chatField.getText(), 5) + "\n"));
		
		quitButton.addActionListener(click -> app.quit());
		
		saveButton.addActionListener(click -> app.save());
		
		loadButton.addActionListener(click -> chatArea.setText(app.load()));
		
		chatButton.addActionListener(click -> chatArea.append(chatField.getText() + app.interactWithChatbot(chatField.getText()) + "\n"));
	}

	private void setupChatPane()
	{
		chatArea.setEditable(false);
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.MAGENTA);
		this.setPreferredSize(new Dimension(800, 600));
		
		this.add(chatPane);
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
