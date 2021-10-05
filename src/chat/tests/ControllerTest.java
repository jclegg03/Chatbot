package chat.tests;

/**
 * Project imports
 */
import chat.controller.Controller;
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

class ControllerTest
{
	private Controller testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
	}

	@Test
	void testStructure()
	{
		Field [] fields = testedController.getClass().getDeclaredFields();
		assertTrue(fields.length > 2, "You need at least 3 data members in your Controller");
		Method [] methods = testedController.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 2, "You need at least two methods in the controller");
		boolean hasStart = false;
		boolean hasInteract = false;
//		boolean hasHandle = false;
		
		for (Method method : methods)
		{
//			if (method.getName().equals("handleError"))
//			{
//				hasHandle = true;
//				Type[] types = method.getGenericParameterTypes();
//				assertTrue(types[0].getTypeName().equals("java.lang.Exception"), "The parameter type needs to be: Exception");
//			}
			if (method.getName().equals("start"))
			{
				hasStart = true;
			}
			else if (method.getName().equals("interactWithChatbot"))
			{
				hasInteract = true;
				Type[] types = method.getGenericParameterTypes();
				assertTrue(types[0].getTypeName().equals("java.lang.String"), "The parameter type needs to be: String");
				
			}
		}
//		assertTrue(hasHandle, "You need a method named handleError");
		assertTrue(hasInteract, "You need a method named interactWithChatbot");
		assertTrue(hasStart, "You need a method named start");
	}

}
