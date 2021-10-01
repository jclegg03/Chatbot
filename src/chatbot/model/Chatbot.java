package chatbot.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Chatbot
{	
	private String name;
	private int quiet;
	
	public Chatbot(String name)
	{
		this.name = name;
		this.quiet = 0;
	}
	
	public String processText(String text)
	{
		String answer = sayGreeting() + "\nYou said: ";
		answer += text + "\n";
		if(isPolite(text))
		{
			answer += sayKindPhrase();
		}
		if(isPolitical(text))
		{
			answer += "How political of you!\n";
		}
		answer += sayFarewell() + "\n";
		if (text.toLowerCase().indexOf("date") >= 0)
		{
			answer += getDate();
		}
		
		if (text.toUpperCase().indexOf("TIME") >= 0)
		{
			answer += getTime();
		}
		
		answer += getRandomTopic();
		
		if (text.contentEquals(""))
		{
			answer += quiet();
		}
		
		return answer;
	}

	public String quiet()
	{
		String result = "";
		quiet += 1;
		if (quiet >= 5)
		{
			result += "Please talk to me!";
		}
		result += "\n";
		
		return result;
	}
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
		
		return farewell;
	}
	public String getName()
	{
		return this.name;
	}
	public String sayGreeting()
	{
		String greeting = "";
		ArrayList <String> greetings = new ArrayList <String>();
		greetings.add("Hello there!");
		greetings.add("Good day!");
		greetings.add("Greetings!");
		greetings.add("Felicitations!");
		greetings.add("Salutations!");
		
		int greetingCount = (int)(Math.random() * greetings.size());
		greeting = greetings.get(greetingCount);
		
		return greeting;
	}
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

	@Override
	public String toString()
	{
		String response = sayGreeting() + " I am a chatbot. ";
		response += this.getName();
		response += " is my name.";
		return response;
	}
}
