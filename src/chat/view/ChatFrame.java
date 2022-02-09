package chat.view;

import javax.swing.JFrame;

import chat.controller.Controller;

public class ChatFrame extends JFrame
{
	private Controller app;
	private ChatPanel panel;
	
	public ChatFrame(Controller app)
	{
		super();
		this.app = app;
		this.panel = new ChatPanel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(700, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setTitle("Chatbot V2.1.0");
		
		this.setVisible(true);
	}
}
