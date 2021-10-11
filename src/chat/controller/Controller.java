package chat.controller;

//import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.Popup;
/**
 * Handles all aspects of the project. Takes inputs and outputs from the user, chatbot, and view and sends them to the view so the user can see the response and questions.
 * @author Jay Clegg
 *
 */
public class Controller
{
//	private Scanner input;
	private Chatbot myChatbot;
	private Popup view;
	
	/**
	 * Builds the controller used by the runner. Builds a chatbot to be used and builds a popup to be used for output and input.
	 */
	public Controller()
	{
//		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot("Yaj");
		this.view = new Popup();
	}
	
	/**
	 * Method called by the runner to get the chatbot to interact with the user.
	 */
	public void start()
	{
//		System.out.println(myChatbot);
		view.displayMessage(myChatbot.toString());
		
//		System.out.println("What do you want to talk about?");
//		String response = input.nextLine();
		
		String response = view.askQuestion("What do you want to talk about?");
		
		while (! response.contentEquals("quit"))
		{
//			System.out.println(interactWithChatbot(response));
			view.displayMessage(interactWithChatbot(response));
//			System.out.println("Type quit to quit.");
//			response = input.nextLine();
			response = view.askQuestion("Type quit to quit.");
		}
	}

	/**
	 * Used to allow the user's message to be sent to the chatbot.
	 * @param received The answer given by the user.
	 * @return The message built by the chatbot.
	 */
	public String interactWithChatbot(String received)
	{
		String message = "";
		message += myChatbot.processText(received);
		
		return message;
	}
}
