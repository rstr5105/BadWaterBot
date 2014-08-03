package com.badwater.bot.core;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;

/**
 * Created by irinix on 8/2/14.
 */
public class BadwaterBot extends BadwaterBotCore {

	public BadwaterBot(String name,
	                   String login,
	                   String server,
	                   String channel,
	                   boolean autoNickChange,
	                   boolean capEnabled) throws IOException, IrcException {
		this.config  = new Configuration.Builder ().setName ( name )
		                                            .setLogin ( login )
		                                            .setAutoNickChange ( autoNickChange )
		                                            .setCapEnabled ( capEnabled )
		                                            .setServerHostname ( server )
		                                            .addAutoJoinChannel ( channel )
		                                            .buildConfiguration ();

		this.bot = new PircBotX ( config );


	}



}

