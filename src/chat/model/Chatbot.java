package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Chatbot
{	
	//data members
	private String name;
	private int quiet;
//	private int farewellCount;
//	private int greetingCount;
	
	//constructor
	public Chatbot(String name)
	{
		this.name = name;
		this.quiet = 0;
//		this.farewellCount = 0;
//		this.greetingCount = 0;
	}
	
	//returns an actual answer. Used by outside code.
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

	
	//if the user doesn't respond, asks them to talk.
	public String quiet()
	{
		String result = "";
		quiet += 1;
		if (quiet >= 5)
		{
			result += "Please talk to me!\n";
		}
		
		return result;
	}
	

	//gives a random topic. Used every time for now.
	public String getRandomTopic()
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

	//says something nice. Used if the user is polite.
	public String sayKindPhrase()
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

	//checks if certain political aspects are in the string.
	public boolean isPolitical(String text)
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
	
	//checks if the user is somewhat polite
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
	
	//sends a random farewell. Used every time user interacts.
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
	
	//Sends the phrase "My name is " and the name of the chatbot. Used in the toString method.
	public String getName()
	{
		return "My name is " + this.name;
	}
	
	//sends a random greeting. Used each time the user interacts with the chatbot. Also used in the toString override
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
	
	//gets the current time and formats it American way. Used if the user says time.
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
	
	//gets the current date and formats it dayth of month year. used if the user says date.
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

	//determines if a question is asked. used every time user responds
	public boolean containsQuestion(String text)
	{
		boolean inqusitive = false;
		
		if(text.contains("?") || text.toUpperCase().contains("CAN YOU") || text.toUpperCase().contains("WILL YOU"))
		{
			inqusitive = true;
		}
		
		return inqusitive;
	}
	
	//answers a user's question. used if the user asked a question
	public String answerQuestion(String text)
	{
		String answer = "";
		
		int mePosition = text.toUpperCase().indexOf("ME");
		int youPosition = text.toUpperCase().indexOf("YOU");
		int iPosition = text.indexOf(" I ");
		boolean iStart = text.indexOf("I ") == 0;
		boolean iEnd = (text.indexOf(" I") == text.length() - 2 || text.indexOf( "I") == text.length() - 1) && text.length() > 3;
		
		answer += "You asked ";
		
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
		
		
		
		answer += getRandomTopic();
		
		return answer;
	}
	
	//Uses greeting then sends the name of the chatbot. Used in the controller once.
	@Override
	public String toString()
	{
		String response = sayGreeting() + " I am a chatbot. ";
		response += this.getName();
		response += ".";
		return response;
	}
}
