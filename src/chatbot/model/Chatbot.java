package chatbot.model;

public class Chatbot
{
	private String name;
	
	public Chatbot(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	public String processText(String text)
	{
		String answer = "you said: ";
		answer += text + "\n";
		return answer;
	}
	
	@Override
	public String toString()
	{
		String response = "Hi, I am a chatbot. ";
		response += this.getName();
		response += " is my name.";
		return response;
	}
}
