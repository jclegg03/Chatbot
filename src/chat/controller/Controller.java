package chat.controller;

//import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.Popup;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all aspects of the project. Takes inputs and outputs from the user, chatbot, and view and sends them to the view so the user can see the response and questions.
 * @author Jay Clegg
 *
 */
public class Controller
{
	private Chatbot myChatbot;
	private Popup view;
	
	/**
	 * Builds the controller used by the runner. Builds a chatbot to be used and builds a popup to be used for output and input.
	 */
	public Controller()
	{
		this.myChatbot = new Chatbot("Yaj");
		this.view = new Popup();
	}
	
	/**
	 * Method called by the runner to get the chatbot to interact with the user.
	 */
	public void start()
	{
		view.displayMessage(myChatbot.sayGreeting());
		
		String response = view.askQuestion("What do you want to talk about?");
		
		while (! response.contentEquals("quit"))
		{
			view.displayMessage(interactWithChatbot(response));
			response = view.askQuestion("Type quit to quit.");
		}
		
		view.displayMessage(myChatbot.sayFarewell());
		
		view.displayMessage(myChatbot.getMostCommonWord(myChatbot.getUserInputs()));
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

	/**
	 * Displays an error message.
	 * @param error The error thrown.
	 */
	public void handleError(Exception error)
	{
		String details = "Your error is: " + error.getMessage();
		view.displayMessage(details);
	}

	
}