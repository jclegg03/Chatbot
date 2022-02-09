package chat.tests;

/**
 * Project imports
 */
import chat.controller.Controller;
import chat.view.ChatPanel;
import chat.view.ChatFrame;
import javax.swing.*;

import java.awt.Component;
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

class FrameTest
{
	private Controller testedController;
	private ChatFrame testedFrame;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
		this.testedFrame = new ChatFrame(testedController);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedFrame = null;
	}

	@Test
	void testChatFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "ChatFrame needs to extend JFrame");
		Method [] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(methods.length == 1, "You need 1 method in the ChatFrame");
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");
		assertTrue(testedFrame.getTitle().toLowerCase().contains("chat"), "Your title needs to have chat in it");
		assertTrue(testedFrame.getContentPane() instanceof ChatPanel, "Your ChatFrame needs to have a ChatPanel inside");
	}

}
