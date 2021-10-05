package chat.controller;

import chat.model.Chatbot;
import chat.view.Popup;

public class Controller
{
//	private Scanner input;
	private Chatbot myChatbot;
	private Popup view;
	
	public Controller()
	{
//		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot("Yaj");
		this.view = new Popup();
	}
	
	public void start()
	{
//		System.out.println(myChatbot);
		view.displayMessage(myChatbot.toString());
		
//		System.out.println("What do you want to talk about?");
//		String response = input.nextLine();
		
		String response = view.displayQuestion("What do you want to talk about?");
		
		while (! response.contentEquals("quit"))
		{
//			System.out.println(interactWithChatbot(response));
			view.displayMessage(interactWithChatbot(response));
//			System.out.println("Type quit to quit.");
//			response = input.nextLine();
			response = view.displayQuestion("Type quit to quit.");
		}
	}

	public String interactWithChatbot(String received)
	{
		String message = "";
		message += myChatbot.processText(received);
		
		return message;
	}
}
