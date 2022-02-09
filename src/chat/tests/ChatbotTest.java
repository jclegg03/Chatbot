package chat.tests;

/**
 * Project imports
 */
import chat.model.Chatbot;
import java.util.ArrayList;
import java.util.Arrays;
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
		this.testedBot = new Chatbot("");
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		this.testedBot = null;
	}
	
	@Test
	public void testUpdatedStructure()
	{
		Method [] methods = testedBot.getClass().getDeclaredMethods();
		String [] names = {"getRandomTopic","isPolite","isPolitical","getDate","getTime","containsQuestion","processText","sayGreeting", "sayFarewell"};
		ArrayList<String> requiredMethods = new ArrayList<String>( Arrays.asList(names));
		for (Method method : methods)
		{
			int index = requiredMethods.indexOf(method.getName()); 
			if (index >= 0)
			{
				requiredMethods.remove(index);
			}
			
		}
		assertTrue(requiredMethods.size() == 0, "You do not have all the required methods." + requiredMethods.size() + " is/are missing");
		names = new String [] {"getRandomTopic","isPolite","isPolitical","getDate","getTime","containsQuestion", "answerQuestion"};
		requiredMethods = new ArrayList<String>( Arrays.asList(names));
		for (Method method : methods)
		{
			int index = requiredMethods.indexOf(method.getName());
			if (index >= 0)
			{
				int returnType = method.getModifiers();
				assertTrue(Modifier.isPrivate(returnType), "This method: " + method.getName() + " must be private!");
			}
			
		}
		
	}
	
	@Test
	void testRefactor()
	{
		Method [] methods = testedBot.getClass().getDeclaredMethods();
		boolean hasSingleParameter = false;
		boolean hasDoubleParameter = false;
		
		for (Method method : methods)
		{
			if (method.getName().equals("processText"))
			{
				if (method.getParameterCount() == 1)
				{
					Type[] types = method.getGenericParameterTypes();
					assertTrue(types[0].getTypeName().equals("java.lang.String"), "The parameter type needs to be: String");
					hasSingleParameter = true;
				}
				else if (method.getParameterCount() == 2)
				{
					hasDoubleParameter = true;
				}
			}
		}

		assertTrue(hasSingleParameter, "You need a single parameter method named interactWithChatbot");
		assertTrue(hasDoubleParameter, "You need a double parameter method named interactWithChatbot");
	}
	
//	
//	@Test
//	public void testContainsQuestion()
//	{
//		boolean isQuestion = false;
//		isQuestion = testedBot.containsQuestion("");
//		assertFalse(isQuestion, "An empty String is not a question");
//		isQuestion = testedBot.containsQuestion("?");
//		assertTrue(isQuestion, "A single question mark is enough to be a question");
//		isQuestion = testedBot.containsQuestion("can you");
//		assertTrue(isQuestion, "If the text contains can you it is a question");
//		isQuestion = testedBot.containsQuestion("Will you");
//		assertTrue(isQuestion, "If the text contains Will you it is a question");
//	}


	

}
