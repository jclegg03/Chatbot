package chat.tests;

/**
 * Project imports
 */
import chat.view.Popup;

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

class PopupTest
{
	private Popup testedPopup;

	@BeforeEach
	public void setUp() throws Exception
	{
		this.testedPopup = new Popup();
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		this.testedPopup = null;
	}

	@Test
	public void testStructure()
	{
		Method [] methods = testedPopup.getClass().getDeclaredMethods();
		assertTrue(methods.length == 2, "You should have two methods in your popup class");
		int voidCount = 0;
		int stringCount = 0;
		for (Method method : methods)
		{
			if (method.getReturnType().equals(String.class))
			{
				stringCount++;
				if (method.getParameterCount() == 1)
				{
					Type[] types = methods[0].getGenericParameterTypes();
					assertTrue(types[0].getTypeName().equals("java.lang.String"), "The parameter type needs to be: String");
				}
				assertTrue(method.getName().equals("askQuestion"), "This method should be named askQuestion");
			}
			else if (method.getReturnType().getName().equals("void"))
			{
				voidCount++;
				if (method.getParameterCount() == 1 && method.getParameters()[0].equals(String.class))
				{
					if (method.getParameterCount() == 1)
					{
						Type[] types = methods[0].getGenericParameterTypes();
						assertTrue(types[0].getTypeName().equals("java.lang.String"), "The parameter type needs to be: String");
					}
				}
				assertTrue(method.getName().equals("displayMessage"), "This method should be named displayMessage");
			}
		}
		assertTrue(voidCount == 1, "You should have exactly 1 void method");
		assertTrue(stringCount == 1, "You should have exactly 1 String method");
	}

}
