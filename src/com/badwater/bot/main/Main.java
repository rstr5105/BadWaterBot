package com.badwater.bot.main;

import com.badwater.bot.core.BadwaterBot;
import com.badwater.bot.core.LearnerListener;
import com.badwater.bot.core.Listener;
import org.pircbotx.Configuration;
import org.pircbotx.exception.IrcException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by irinix on 8/3/14.
 */
public class Main {
	//bot shit. stuff will be added here.
	private static BadwaterBot bot;

	public static void main(String args[]) throws SQLException, IOException, IrcException, ClassNotFoundException {
		Configuration c = new Configuration.Builder().setName("BadWater_Bill")
			   .setServerHostname("chat.freenode.net")
			   .setNickservPassword("givem3thecookie")
			   .setCapEnabled(false)
			   .setLogin("BW_Bill")
			   .addListener(new Listener())
			   .addListener(new LearnerListener())
				      //.addListener(new GameDevBotListener())
			   .addAutoJoinChannel("#badwater")
				      //.addAutoJoinChannel("#reddit-gamedev")
			   .buildConfiguration();
		bot = new BadwaterBot(c);
		bot.startBot();
	}


}

