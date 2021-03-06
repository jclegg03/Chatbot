package chat.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.Popup;

/**
 * Handles all aspects of the project. Takes inputs and outputs from the user, chatbot, and view and sends them to the view so the user can see the response and questions.
 * @author Jay Clegg
 *
 */
public class Controller
{
	private Chatbot myChatbot;
	private Popup view;
	private ChatFrame frame;
	
	/**
	 * Builds the controller used by the runner. Builds a chatbot to be used and builds a popup to be used for output and input.
	 */
	public Controller()
	{
		this.myChatbot = new Chatbot("Yaj");
		this.view = new Popup();
		this.frame = new ChatFrame(this);
	}
	
	/**
	 * Method called by the runner to get the chatbot to interact with the user.
	 */
	public void start()
	{
		//Old code
//		view.displayMessage(myChatbot.sayGreeting());
//		view.displayMessage("Loading saved data...");
//		
//		myChatbot.setUserInputs(loadTextToList("user input.txt"));
//		myChatbot.setChatbotResponses(loadTextToList("chatbot answers.txt"));
//		
//		String response = view.askQuestion("What do you want to talk about?");
//		
//		while (! response.contentEquals("quit"))
//		{
//			view.displayMessage(interactWithChatbot(response));
//			response = view.askQuestion("Type quit to quit.");
//		}
//		
//		view.displayMessage(myChatbot.sayFarewell());
//		
//		view.displayMessage(myChatbot.getMostCommonWord(myChatbot.getUserInputs()));
//		
//		saveListAsText(myChatbot.getUserInputs(), "user input.txt");
//		saveListAsText(myChatbot.getChatbotResponses(), "chatbot answers.txt");
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
	 * Used to send the user's message from the view to the model.
	 * @param text The text given by the user.
	 * @param button The button clicked by the user.
	 * @return The chatbot's response.
	 */
	public String interactWithChatbot(String text, int button)
	{
		String response = "";
		
		response += myChatbot.processText(text, button);
		
		return response;
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

	/**
	 * Saves an arrayList of text to a file named filename.
	 * @param responses The arrayList of text.
	 * @param filename The name of the file where the data is saved.
	 */
	private void saveListAsText(ArrayList <String> responses, String filename)
	{
		File saveFile = new File(filename);
		
		try(PrintWriter saveText = new PrintWriter(saveFile))
		{
			for(String content : responses)
			{
				saveText.println(content);
			}
		}
		catch(IOException errorFromIO)
		{
			handleError(errorFromIO);
		}
		catch(Exception genericError)
		{
			handleError(genericError);
		}
	}
	
	private ArrayList <String> loadTextToList(String filename)
	{
		ArrayList <String> fileContents = new ArrayList <String>();
		
		File source = new File(filename);
		
		try(Scanner fileScanner = new Scanner(source))
		{
			while(fileScanner.hasNextLine())
			{
				fileContents.add(fileScanner.nextLine());
			}
		}
		catch(IOException fileError)
		{
			handleError(fileError);
		}
		catch(Exception error)
		{
			handleError(error);
		}
		
		return fileContents;
	}
	
	public void quit()
	{
		save();
		
	}
	
	public void save()
	{
		saveListAsText(myChatbot.getUserInputs(), "user input.txt");
		saveListAsText(myChatbot.getChatbotResponses(), "chatbot answers.txt");
	}
	
	public String load()
	{
		String data = "";
		
		ArrayList <String> userInputs = loadTextToList("user input.txt");
		ArrayList <String> chatbotResponses = loadTextToList("chatbot answers.txt");
		myChatbot.setUserInputs(userInputs);
		myChatbot.setChatbotResponses(chatbotResponses);
		
		for(int index = 0; index < userInputs.size() && index < chatbotResponses.size(); index++)
		{
			data += userInputs.get(index);
			data += chatbotResponses.get(index);
		}
		
		return data;
	}
}