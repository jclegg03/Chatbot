package chatbot.view;

import javax.swing.JOptionPane;

public class Popup
{
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String displayQuestion(String question)
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
