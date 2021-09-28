package chatbot.model;

import java.time.LocalDateTime;

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
		String answer = "You said: ";
		answer += text + "\n";
		answer += getDate() + "\n";
		return answer;
	}
	
	public String sayGreeting()
	{
		String greeting = "";
		
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
		
		String day = currentDate.getDayOfMonth() + " of ";
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
