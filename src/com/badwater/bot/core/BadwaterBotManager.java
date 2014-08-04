package com.badwater.bot.core;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by irinix on 8/3/14.
 */
public class BadwaterBotManager extends BadwaterBotCore {
	private static ArrayList<BadwaterBot> ManagedBots = new ArrayList<BadwaterBot> ();

	public BadwaterBotManager(String name,
	                          String login,
	                          String server,
	                          String channel,
	                          Listener listener,
	                          boolean autoNickChange,
	                          boolean capEnabled) throws IOException, IrcException {

		this.config = new Configuration.Builder ().setName ( name )
		                                          .setLogin ( login )
		                                          .setAutoNickChange ( autoNickChange )
		                                          .setCapEnabled ( capEnabled )
		                                          .setServerHostname ( server )
		                                          .addAutoJoinChannel ( channel )
		                                          .addListener ( listener )
		                                          .buildConfiguration ();

		this.bot = new PircBotX ( config );


	}

	public void run() throws IOException, IrcException {
		bot.startBot ();
	}

	public void addManagedBot(BadwaterBot bot) throws IOException, IrcException {
		if ( ManagedBots.isEmpty () ) {
			//just add the new bot
			ManagedBots.add ( bot );
		}
		else {
			for ( BadwaterBot b : ManagedBots ) {
				if ( !b.bot.equals ( bot ) ) {
					ManagedBots.add ( b );
				}
				else {

					return;
				}
			}
		}
	}
	/*
	public void startManagedBot(String name) throws IOException, IrcException {
		if ( !ManagedBots.isEmpty () ) {
			for ( BadwaterBot b : ManagedBots ) {
				if ( b.getName ().equalsIgnoreCase ( name ) ) {
					b.run ();
				}
			}
		}
	}

	public void removeManagedBot(String name) throws Throwable {
		for ( BadwaterBot b : ManagedBots ) {
			if ( b.getName ().equalsIgnoreCase ( name ) ) {

				ManagedBots.remove ( b );
			}
		}
	}
	*/

}
