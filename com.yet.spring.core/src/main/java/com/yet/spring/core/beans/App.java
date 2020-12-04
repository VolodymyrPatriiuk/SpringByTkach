package com.yet.spring.core.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	Client client;
	ConsoleEventLogger consoleEventLogger;	
	
	public App(Client client, ConsoleEventLogger consoleEventLogger) {
		this.client = client;
		this.consoleEventLogger = consoleEventLogger;
	}
	
	public static void main(String[] args) {

		// var. 1
//		App app = new App();
//		
//		Client client = new Client("1", "John Smitch");
//		ConsoleEventLogger consoleEventLogger = new ConsoleEventLogger();
//		
//		app.logEvent("Some event for user 1", client, consoleEventLogger);

		// var. 2
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app = (App) ctx.getBean("app");
		
		app.logEvent("Some event for 1");
		
	}

	private void logEvent(String msg) {
		final String message = msg.replaceAll(client.getId(), client.getFullName());
		consoleEventLogger.logEvent(message);
	}
	
}
