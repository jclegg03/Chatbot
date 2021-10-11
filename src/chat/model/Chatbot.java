package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This a crude chatbot. It takes user response and responds with what the user says. It can respond to some questions.
 * @author Jay Clegg
 *
 */

public class Chatbot
{	
	//data members
	private String name;
	private int quiet;
//	private int farewellCount;
//	private int greetingCount;
	
	/**
	 * Constructs a chatbot with the name given by the constructor call. Also initializes the quiet variable used to determine if the user hasn't responded multiple times.
	 * @param name
	 */
	public Chatbot(String name)
	{
		this.name = name;
		this.quiet = 0;
//		this.farewellCount = 0;
//		this.greetingCount = 0;
	}
	
	/**
	 * How the chatbot builds its response to send to the controller. Calls various internal methods.
	 * @param text The text given by the user.
	 * @return The response built by the chatbot.
	 */
	public String processText(String text)
	{
		String answer = sayGreeting();
		answer += "\nYou said: " + text + "\n";
		if(isPolite(text))
		{
			answer += sayKindPhrase();
		}
		if(isPolitical(text))
		{
			answer += "How political of you!\n";
		}
		
		if (text.toLowerCase().indexOf("date") >= 0)
		{
			answer += getDate();
		}
		
		if (text.toUpperCase().indexOf("TIME") >= 0)
		{
			answer += getTime();
		}
		
		if (containsQuestion(text))
		{
			answer += answerQuestion(text);
		}
		else if(containsQuestion(text))
		{
			answer += getRandomTopic();
		}
		
		if (text.contentEquals(""))
		{
			answer += quiet();
		}
		
		answer += sayFarewell() + "\n";
		
		return answer;
	}

	
	/**
	 * Checks if the user hasn't responded multiple times. If they haven't, it asks them to talk. Called by processText().
	 * @return Nothing if the user sends a message, or a message requesting the user to talk to the chatbot if they haven't.
	 */
	private String quiet()
	{
		String result = "";
		quiet += 1;
		if (quiet >= 5)
		{
			result += "Please talk to me!\n";
		}
		
		return result;
	}
	

	/**
	 * Generates a random topic from a list to talk about. Called by processText() and answerQuestion();
	 * @return The random topic that was generated.
	 */
	private String getRandomTopic()
	{
		String topic = "";
		
		ArrayList <String> topics = new ArrayList <String>();
		topics.add("What is your favoirte movie?");
		topics.add("What is the capital of Assyria?");
		topics.add("What is your favorite color?");
		topics.add("What is the air speed velocity of an unladen swallow?");
		topics.add("What is your quest?");
		topics.add("What is your name?");
		topics.add("Is Monty Python funny?");
		topics.add("How is school going?");
		topics.add("Are cat videos funny?");
		topics.add("What is your Star Wars movie?");
		
		int random = (int)(Math.random() * topics.size());
		topic = topics.get(random);
		topic += "\n";
		
		return topic;
	}

	/**
	 * Generates a compliment from a list. Called by processText();
	 * @return The generated compliment.
	 */
	private String sayKindPhrase()
	{
		String kindPhrase = "";
		ArrayList <String> kindPhrases = new ArrayList <String>();
		kindPhrases.add("Thank you for your kind words.");
		kindPhrases.add("You have exceptional manners.");
		kindPhrases.add("You are very nice.");
		
		int random = (int) (Math.random() * kindPhrases.size());
		kindPhrase = kindPhrases.get(random);
		
		kindPhrase += "\n";
		return kindPhrase;
	}

	/**
	 * Checks if the user used a political phrase. Called by processText().
	 * @param text The user input.
	 * @return true if the user was political or false if not.
	 */
	private boolean isPolitical(String text)
	{
		boolean political = false;
		String analyze = text.toLowerCase();
		
		if (analyze.contains("politics") || analyze.contains("republican") || analyze.contains("democrat") || analyze.contains("election")
				|| analyze.contains("biden"))
		{
			political = true;
		}
		
		return political;
	}
	
	/**
	 * Checks if the user used a polite phrase. Called by processText();
	 * @param text The user input.
	 * @return true if the user was polite or false if not.
	 */
	public boolean isPolite(String text)
	{
		boolean polite = false;
		String check = text.toLowerCase();
		if(check.contains("please") || check.contains("thank you"))
		{
			polite = true;
		}
		
		return polite;
	}
	
	/**
	 * Generates a random goodbye message from a list. Called by processText();
	 * @return The random goodbye message.
	 */
	public String sayFarewell()
	{
		String farewell = "";
		ArrayList <String> farewells = new ArrayList <String>();
		farewells.add("Goodbye!");
		farewells.add("Have a good day!");
		farewells.add("See you later!");
		farewells.add("I'll see ya in another life, brother!");
		farewells.add("Until we meet again.");
	
		
		int farewellCount = (int)(Math.random() * farewells.size());
		farewell = farewells.get(farewellCount);
//		farewellCount++;
//		if(farewellCount == farewells.size())
//		{
//			farewellCount = 0;
//		}
		
		return farewell;
	}
	
	/**
	 * Gives the name of the chatbot. Called by toString();
	 * @return The chatbot's name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Generates a random greeting from a list. Called by processText() and toString().
	 * @return The random greeting.
	 */
	public String sayGreeting()
	{
		String greeting = "";
		ArrayList <String> greetings = new ArrayList <String>();
		greetings.add("Hello there!");
		greetings.add("Good day!");
		greetings.add("Greetings!");
		greetings.add("Felicitations!");
		greetings.add("Salutations!");
		greetings.add("What an unexpected supprise!");
		
		int greetingCount = (int)(Math.random() * greetings.size());
		greeting = greetings.get(greetingCount);
//		greetingCount++;
//		if(greetingCount == greetings.size())
//		{
//			greetingCount = 0;
//		}
		
		return greeting;
	}
	
	/**
	 * Gives the current time in the American h:mm AM/PM format. Called by processText().
	 * @return The formated time.
	 */
	public String getTime()
	{
		String time = "The time is ";
		String ampm = " AM";
		
		LocalDateTime currentTime = LocalDateTime.now();
		int hour = currentTime.getHour();
		if (hour>12 && hour != 24)
		{
			hour -= 12;
			ampm = " PM";
		}
		if (hour == 12)
		{
			ampm = " PM";
		}
		if (hour == 24)
		{
			hour -= 12;
		}
		
		int minute = currentTime.getMinute();
		if(minute <= 9)
		{
			time += hour + ":0" + minute + ampm + ".\n";
		}
		else
		{
			time += hour + ":" + minute + ampm + ".\n";
		}
		
		return time;
	}
	
	/**
	 * Gives the current date in the format day month year like 1st of August 2052. Called by processText().
	 * @return The formated date.
	 */
	public String getDate()
	{
		String date = "The date is ";
		
		LocalDateTime currentDate = LocalDateTime.now();
		String dayOfWeek = currentDate.getDayOfWeek().toString();
		char dayCharOne = dayOfWeek.charAt(0);
		dayOfWeek = dayOfWeek.substring(1, dayOfWeek.length()).toLowerCase();
		dayOfWeek = dayCharOne + dayOfWeek + ", the ";
		
		int dayOfMonth = currentDate.getDayOfMonth();
		String day = "";
		if (dayOfMonth == 1 || dayOfMonth == 21 || dayOfMonth == 31)
		{
			day = dayOfMonth + "st";
		}
		else if (dayOfMonth == 2 || dayOfMonth == 22)
		{
			day = dayOfMonth + "nd";
		}
		else if (dayOfMonth == 3 || dayOfMonth == 23)
		{
			day = dayOfMonth + "rd";
		}
		else
		{
			day = dayOfMonth + "th";
		}
		day += " of ";
		String month = currentDate.getMonth().toString();
		char monthCharOne = month.charAt(0);
		month = month.substring(1, month.length()).toLowerCase();
		month = monthCharOne + month;
		
		date += dayOfWeek + day + month + ".\n";
		
		return date;
	}

	/**
	 * Determines if the user asked a question. Called by processText().
	 * @param text The user response.
	 * @return true if the user asked a question or false if the user didn't.
	 */
	public boolean containsQuestion(String text)
	{
		boolean inqusitive = false;
		
		if(text.contains("?") || text.toUpperCase().contains("CAN YOU") || text.toUpperCase().contains("WILL YOU"))
		{
			inqusitive = true;
		}
		
		return inqusitive;
	}
	
	/**
	 * Responds to the user's question. Called by processText().
	 * @param text The user response.
	 * @return The response generated by the method.
	 */
	private String answerQuestion(String text)
	{
		String answer = "";
		
		int mePosition = text.toUpperCase().indexOf("ME");
		int youPosition = text.toUpperCase().indexOf("YOU");
		int iPosition = text.indexOf(" I ");
		boolean iStart = text.indexOf("I ") == 0;
		boolean iEnd = (text.indexOf(" I") == text.length() - 2 || text.indexOf( "I") == text.length() - 1) && text.length() > 3;
		int symbolIndex = text.indexOf("?");
		
		answer += "You asked me ";
		
		if (mePosition == -1 && youPosition == -1 && iPosition == -1 && ! iStart && ! iEnd)
		{
			answer += "a question Jay is too lazy to answer.\nOh no I've used the name of the maker!\nI meant I, Yaj, am too lazy to answer your question.\n";
		}
		else if  (mePosition >=0 && youPosition == -1)
		{
			String segment = text.substring(0, mePosition);
			segment += "you";
			segment += text.substring(mePosition + 2);
			
			answer += segment;
			answer += "\n";
		}
		else if (youPosition >=0 && mePosition == -1)
		{
			String segment = text.substring(0, youPosition);
			segment += "I";
			segment += text.substring(youPosition + 3);
			answer += segment;
			answer += "\n";
		}
		
		answer = answer.substring(0, answer.length() - 2) + ".\n";
		
		answer += getRandomTopic();
		
		return answer;
	}
	
	/**
	 * Sends a description about the chatbot.
	 */
	@Override
	public String toString()
	{
		String response = sayGreeting() + " I am a chatbot. ";
		response += this.getName();
		response += " is my name.";
		return response;
	}
}
