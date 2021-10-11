package chat.controller;
/**
 * Runs the chatbot project.
 * @author Jay Clegg
 *
 */
public class Runner
{
	/**
	 * Allows the project to run.
	 * @param args
	 */
	public static void main (String [] args)
	{
		Controller app = new Controller();
		app.start();
	}
}
