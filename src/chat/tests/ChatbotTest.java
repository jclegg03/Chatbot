package chat.tests;

/**
 * Project imports
 */
import chat.model.Chatbot;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Reflection imports
 */
import java.lang.reflect.*;
/**
 * Testing imports
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChatbotTest
{

	private Chatbot testedBot;
	
	@BeforeEach
	public void setUp() throws Exception
	{
		testedBot = new Chatbot("Testing");
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		testedBot = null;
	}
	
	@Test
	public void testMethods()
	{
		Method [] methods = testedBot.getClass().getDeclaredMethods();
		assertTrue(methods.length > 8, "");
		String [] requiredMethodNames = {""};
	}
	
	@Test
	public void testChatbot()
	{
		assertNotNull(testedBot.getName(), "Your default constructor must initialize the name data member.");
		Constructor [] constructors = testedBot.getClass().getDeclaredConstructors();
		assertTrue(constructors.length == 1, "There should be only one written constructor");
		Type[] types = constructors[0].getGenericParameterTypes();
		assertTrue(types[0].getTypeName().equals("java.lang.String"), "The first and only parameter should be a String");
		
	}

	@Test
	public void testGreetings()
	{
		int uniqueCount = 0;
		ArrayList<String> previous = new ArrayList<String>();
		for (int index = 0; index < 5; index++)
		{
			String currentGreeting = testedBot.sayGreeting();
			
			assertNotNull(currentGreeting, "The method should never return null");
			if (currentGreeting != null && previous.indexOf(currentGreeting) < 0 && currentGreeting.length() >= 2)
			{
				previous.add(currentGreeting);
				uniqueCount++;
			}
		}
		assertTrue(uniqueCount == 5, "You need at least 5 unique greetings");
	}
	
	@Test
	public void testFarewells()
	{
		int uniqueCount = 0;
		ArrayList<String> previous = new ArrayList<String>();
		for (int index = 0; index < 5; index++)
		{
			String currentFarewell = testedBot.sayFarewell();
			
			assertNotNull(currentFarewell, "The method should never return null");
			if (currentFarewell != null && previous.indexOf(currentFarewell) < 0 && currentFarewell.length() >= 2)
			{
				previous.add(currentFarewell);
				uniqueCount++;
			}
		}
		assertTrue(uniqueCount == 5, "You need at least 5 unique farewells");
	}
	
	@Test
	public void testToString()
	{
		Method [] methods = testedBot.getClass().getDeclaredMethods();
		for (Method currentMethod : methods)
		{
			if (currentMethod.getName().equals("toString"))
			{
				String toStringResult = testedBot.toString();
				assertFalse(toStringResult.indexOf("chat.model") >= 0, "The fully qualified name should not be part of the toString");
				assertFalse(toStringResult.indexOf("@") >= 0, "The fully qualified name should not be part of the toString");
			}
		}
	}
	
	@Test
	public void testName()
	{
		assertNotNull(testedBot.getName(), "Your default constructor must initialize the name data member.");
		assertTrue(testedBot.getName().indexOf("My name is") >= 0, "The getName method needs to include the phrase \"My name is\"");
		
	}

	@Test
	public void testIsPolitical()
	{
		String [] topics = {"politics", "republican", "democrat", "election", "biden"};
		for (String current : topics)
		{
			assertTrue(testedBot.isPolitical(current), "The word " + current + " needs to be recognized as political");
		}
	}
	
	@Test
	public void testIsPolite()
	{
		boolean isPolite = false;
		isPolite = testedBot.isPolite("");
		assertFalse(isPolite, "An empty string is not polite");
		isPolite = testedBot.isPolite("  please   ");
		assertTrue(isPolite, "If the word please is in the text it should be polite");
		isPolite = testedBot.isPolite("  thank you   ");
		assertTrue(isPolite, "If the phrase thank you is in the text it should be considered polite");
		isPolite = testedBot.isPolite("Thank you");
		assertTrue(isPolite, "If the phrase Thank you is in the text it should be considered polite");
		
	}
	
	@Test
	public void testDate()
	{
		LocalDateTime testedDate = LocalDateTime.now();
		String weekday = testedDate.getDayOfWeek().toString();
		String month = testedDate.getMonth().toString();
		String day = testedDate.getDayOfMonth() + ""; 
		String year = testedDate.getYear() + "";
		
		assertTrue(testedBot.getDate().indexOf(weekday) >= 0, "Your getDate method must include the weekday");
		assertTrue(testedBot.getDate().indexOf(month) >= 0, "Your getDate method must include the month");
		assertTrue(testedBot.getDate().indexOf(day) >= 0, "Your getDate method must include the day");
		assertTrue(testedBot.getDate().indexOf(year) >= 0, "Your getDate method must include the year");
		
	}
	
	@Test
	public void testTime()
	{
		LocalDateTime testedTime = LocalDateTime.now();
		int hour = testedTime.getHour();
		int minutes = testedTime.getMinute();
		int phrasePlacement = testedBot.getTime().indexOf("The time is ");
		int hourPlacement = testedBot.getTime().indexOf("" + hour);
		int minutePlacement = testedBot.getTime().indexOf("" + minutes);
		int colonPlacement = testedBot.getTime().indexOf(":", hourPlacement);
		
		assertTrue(hourPlacement > 0, "The getTime method must include the hour");
		assertTrue(minutePlacement > 0, "The getTime method must include the minutes");
		assertTrue(hourPlacement < colonPlacement && colonPlacement < minutePlacement, "The colon must be placed between the hour and minute values");
		assertTrue(phrasePlacement >= 0 && phrasePlacement < hourPlacement, "The getTime method must include the phrase: \"The time is \"followed by the time");
	}
	
	@Test
	public void testRandomTopics()
	{
		String firstTopic = testedBot.getRandomTopic();
		int matching = 0;
		ArrayList<String> topics = new ArrayList<String>();
		
		for (int index = 0; index < 1000; index++)
		{
			String nextTopic = testedBot.getRandomTopic();
			topics.add(nextTopic);		
		}
		
		
		for (int index = 0; index < topics.size(); index++)
		{
			if (topics.get(index).equals(firstTopic))
			{
				matching++;
			}
		}
		
		assertTrue(matching >= 80 && matching < 500, "Random topic choice should match at least 8% of the time but less than half");
		
	}
}
