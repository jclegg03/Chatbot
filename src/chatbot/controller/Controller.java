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
		System.out.println("What do you want to talk about?");
		String response = input.nextLine();
		
		while (! response.contentEquals("quit"))
		{
			System.out.println(interactWithChatbot(response));
			System.out.println("Type quit to quit.");
			response = input.nextLine();
		}
	}

	public String interactWithChatbot(String received)
	{
		String message = "";
		message += myChatbot.processText(received);
		
		return message;
	}
}
