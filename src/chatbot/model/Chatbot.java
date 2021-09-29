package chatbot.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private int greetingCount;
	private int farewellCount;
	
	public Chatbot(String name)
	{
		this.name = name;
		this.greetingCount = 0;
		this.farewellCount = 4;
	}
	
	public String processText(String text)
	{
		String answer = sayGreeting() + "\nYou said: ";
		answer += text + "\n";
		answer += sayFarewell() + "\n";
		answer += getDate() + "\n";
		return answer;
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
		farewell = farewells.get(farewellCount);
		farewellCount--;
		if (farewellCount == -1)
		{
			farewellCount = 4;
		}
		
		
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
		
		greeting = greetings.get(greetingCount);
		greetingCount++;
		if (greetingCount == 5)
		{
			greetingCount = 0;
		}
		
		return greeting;
	}
	public String getTime()
	{
		String time = "The time is ";
		
		LocalDateTime currentTime = LocalDateTime.now();
		int hour = currentTime.getHour();
		int minute = currentTime.getMinute();
		if(minute == 0)
		{
			time += hour + ":00";
		}
		else
		{
			time += hour + ":" + minute;
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
		
		date += dayOfWeek + day + month + ".";
		
		return date;
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
