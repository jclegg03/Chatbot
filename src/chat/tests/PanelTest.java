package chat.tests;


/**
 * Project imports
 */
import chat.controller.Controller;
import chat.view.ChatPanel;
import javax.swing.*;

import java.awt.*;
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

class PanelTest
{
	private Controller testedController;
	private ChatPanel testedPanel;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
		this.testedPanel = new ChatPanel(testedController);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedPanel = null;
	}

	@Test
	void testPanelMethods()
	{
		Method [] methods = testedPanel.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 4, "You need at least 4 methods in the controller");
		boolean hasSetupPane = false;
		boolean hasSetupPanel = false;
		boolean hasSetupListeners = false;
		boolean hasSetupLayout = false;
		
		for (Method method : methods)
		{
			if (method.getName().equals("setupChatPane") || method.getName().equals("setupScrollPane"))
			{
				hasSetupPane = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupChatPane method must be private");
			}
			else if (method.getName().equals("setupPanel"))
			{
				hasSetupPanel = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupPanel method must be private");
			}
			else if (method.getName().equals("setupListeners"))
			{
				hasSetupListeners = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupListeners method must be private");
			}
			else if (method.getName().equals("setupLayout"))
			{
				hasSetupLayout = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupLayout method must be private");
			}
		}
		assertTrue(hasSetupPane, "You need a method named setupChatPane or setupScrollPane");
		assertTrue(hasSetupPanel, "You need a method named setupPanel");
		assertTrue(hasSetupListeners, "You need a method named setupListeners");
		assertTrue(hasSetupLayout, "You need a method named setupLayout");
	}
	
	@Test
	void testPanelComponents()
	{
		Field [] fields = testedPanel.getClass().getDeclaredFields();
		assertTrue(fields.length > 8, "You need at least 8 data members in your ChatPanel");
		
		int buttonCount = 0;
		int panelCount = 0;
		boolean hasCorrectLayout = false;
		boolean hasField = false;
		boolean hasScrollPane = false;
		
		if(testedPanel.getLayout() instanceof SpringLayout)
		{
			hasCorrectLayout = true;
		}
		
		Component [] components = testedPanel.getComponents();
		
		
		for(Component component : components)
		{
			if (component instanceof JButton)
			{
				buttonCount++;
				JButton tested = (JButton)component;
				assertTrue(tested.getActionListeners().length == 1, "Each button needs a listener");
			}
			else if(component instanceof JPanel)
			{
				panelCount++;
				JPanel panel = (JPanel) component;
				Component [] panelContents = panel.getComponents();
				for(Component innerComponent : panelContents)
				{
					if (innerComponent instanceof JButton)
					{
						buttonCount++;
						JButton tested = (JButton)innerComponent;
						assertTrue(tested.getActionListeners().length == 1, "Each button needs a listener");
					}
					
				}
				
			}
			else if(component instanceof JTextField)
			{
				hasField = true;
			}
			else if(component instanceof JScrollPane)
			{
				hasScrollPane = true;
				JScrollPane tested = (JScrollPane) component;
				assertTrue(tested.getViewport().getView() instanceof JTextArea, "Your Scrollpane needs the JTextArea as a view");
				assertTrue(tested.getVerticalScrollBarPolicy() == JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, "The vertical Scroll should be as needed");
				assertTrue(tested.getHorizontalScrollBarPolicy() == JScrollPane.HORIZONTAL_SCROLLBAR_NEVER, "The horizontal Scroll should be never");
			}
			
			
		}
		assertTrue(panelCount == 2, "ChatPanel needs two JPanel data members you have " + panelCount);
		assertTrue(buttonCount >= 7, "ChatPanel needs at least 7 JButton data members you have" + buttonCount );
		assertTrue(hasCorrectLayout, "The layout needs to be a SpringLayout");
		assertTrue(hasField, "The ChatPanel needs a JTextField");
		assertTrue(hasScrollPane, "The ChatPanel needs a JScrollPane");

	}

}
