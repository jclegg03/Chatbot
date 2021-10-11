package chat.view;

import javax.swing.JOptionPane;
/**
 * Allows the chatbot to use popup windows.
 * @author Jay Clegg
 *
 */
public class Popup
{
	/**
	 * Displays a message sent from the controller on a popup window.
	 * @param message The message the popup will display.
	 */
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	/**
	 * Allows the user to ask questions.
	 * @param question The question the user asks sent from the controller.
	 * @return Sends the user's response back to the controller.
	 */
	public String askQuestion(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question);
		if (response == null)
		{
			response = "";
		}

		return response;
	}
}
