package chatbot.controller;

import java.util.Scanner;
import chatbot.model.Chatbot;

public class Controller
{
	private Scanner input;
	private Chatbot myChatbot;
	
	public Controller()
	{
		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot("Yaj");
	}
	
	public void start()
	{
		System.out.println(myChatbot);
	}
}
