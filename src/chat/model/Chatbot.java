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
	private ArrayList <String> userInputs;
	private ArrayList <String> chatbotResponses;
	
	/**
	 * Constructs a chatbot with the name given by the constructor call. Also initializes the quiet variable used to determine if the user hasn't responded multiple times.
	 * @param name The name of the chatbot
	 */
	public Chatbot(String name)
	{
		this.name = name;
		this.quiet = 0;
		this.userInputs = new ArrayList <String>();
		this.chatbotResponses = new ArrayList <String>();
	}
	
	/**
	 * How the chatbot builds its response to send to the controller. Calls various internal methods.
	 * @param text The text given by the user.
	 * @return The response built by the chatbot.
	 */
	public String processText(String text)
	{
		userInputs.add(text);
		
		String answer = "";
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
		
		chatbotResponses.add(answer);
		
		return answer;
	}
	
	/**
	 * How the chatbot builds its response to send to the controller. Calls various internal methods.
	 * @param text The text supplied by the user.
	 * @param choice The choice made by the user.
	 * @return The response built by the chatbot.
	 */
	public String processText(String text, int choice)
	{
		String answer = "";
		
		if(choice == 0)
		{
			answer += getDate();
		}
		else if(choice == 1)
		{
			answer += getTime();
		}
		else if(choice == 2)
		{
			if(isPolite(text))
			{
				answer += sayKindPhrase();
			}
			else
			{
				answer += "\nHow wude!";	
			}
		}
		else if(choice == 3)
		{
			if(isPolitical(text))
			{
				answer += "You are very politically enlightened.";
			}
			else
			{
				answer += "No politics detected.";
			}
		}
		else if(choice == 4)
		{
			if(containsQuestion(text))
			{
				answer += answerQuestion(text);
			}
			else
			{
				answer += "That is not a question fool, ya fool!";
			}
		}
		else if(choice == 5)
		{
			answer += getRandomTopic();
		}
		
		if(text.contentEquals(""))
		{
			answer += quiet();
		}
		
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
		
		String[] topics =
		{
			"What is your favoirte movie?",
			"What is the capital of Assyria?",
			"What is your favorite color?",
			"What is the air speed velocity of an unladen swallow?",
			"What is your quest?",
			"What is your name?",
			"Is Monty Python funny?",
			"How is school going?",
			"Are cat videos funny?",
			"What is your Star Wars movie?"
		};
		
		int random = (int)(Math.random() * topics.length);
		topic = topics[random];
		topic += "\n";
		
		return topic;
	}

	/**
	 * Generates a compliment from a list.
	 * @return The generated compliment.
	 */
	private String sayKindPhrase()
	{
		String kindPhrase = "";
		String[] kindPhrases = new String[3];
		kindPhrases[0] = "Thank you for your kind words.";
		kindPhrases[1] = "You have exceptional manners.";
		kindPhrases[2] = "You are very nice.";
		
		int random = (int) (Math.random() * kindPhrases.length);
		kindPhrase = kindPhrases[random];
		
		kindPhrase += "\n";
		return kindPhrase;
	}

	/**
	 * Checks if the user used a political phrase.
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
	 * Checks if the user used a polite phrase.
	 * @param text The user input.
	 * @return true if the user was polite or false if not.
	 */
	private boolean isPolite(String text)
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
	 * Generates a random goodbye message from a list.
	 * @return The random goodbye message.
	 */
	public String sayFarewell()
	{
		String farewell = "";
		String[] farewells = 
			{
				"Goodbye!",
				"Have a good day!",
				"See you later!",
				"I'll see ya in another life, brother!",
				"Until we meet again."
			};
		
		int farewellCount = (int)(Math.random() * farewells.length);
		farewell = farewells[farewellCount];

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
		String[] greetings = 
		{
			"Hello there!",
			"Good day!",
			"Greetings!",
			"Felicitations!",
			"Salutations!",
			"What an unexpected supprise!"
		};
		int greetingCount = (int)(Math.random() * greetings.length);
		greeting = greetings[greetingCount];

		return greeting;
	}
	
	/**
	 * Gives the current time in the American h:mm AM/PM format. Called by processText().
	 * @return The formated time.
	 */
	private String getTime()
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
	private String getDate()
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
	private boolean containsQuestion(String text)
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

	public String getMostCommonWord(ArrayList<String> source)
	{
		String mostCommon = "";
		ArrayList <String> words = new ArrayList <String>();
		
		for(String sentence : source)
		{
			String[] tempWords = sentence.split(" ");
			for(String word : tempWords)
			{
				words.add(word);
			}
		}
		
		int most = 0;
		
		for(int index = 0; index < words.size(); index++)
		{
			String current = words.get(index);
			int count = 1;
			
			for(int inner = index + 1; inner < words.size(); inner++)
			{
				if(words.get(inner).equalsIgnoreCase(current) && ! current.contentEquals(""))
				{
					count++;
				}
			}
			if(count > most)
			{
				most = count;
				mostCommon = current;
			}
		}
		
		mostCommon = "The most common word was: " + mostCommon + " with " + most + " apppearences.";
		
		return mostCommon;
	}
	
	public ArrayList <String> getUserInputs()
	{
		return this.userInputs;
	}
	
	public ArrayList <String> getChatbotResponses()
	{
		return this.chatbotResponses;
	}
	
	public void setUserInputs(ArrayList <String> inputs)
	{
		this.userInputs = inputs;
	}
	
	public void setChatbotResponses(ArrayList <String> responses)
	{
		this.chatbotResponses = responses;
	}
}