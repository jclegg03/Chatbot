package chat.view;

import javax.swing.JFrame;

import chat.controller.Controller;

public class Frame extends JFrame
{
	private Controller app;
	private Panel panel;
	
	public Frame(Controller app)
	{
		super();
		this.app = app;
		this.panel = new Panel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(700, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
		
		this.setVisible(true);
	}
}
