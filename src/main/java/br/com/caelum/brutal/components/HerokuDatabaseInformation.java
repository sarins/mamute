package br.com.caelum.brutal.components;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HerokuDatabaseInformation {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HerokuDatabaseInformation.class);

	private final URI database;

	public HerokuDatabaseInformation(String databaseUrl) {
		try {
			this.database = new URI(databaseUrl);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public void exportToSystem() {
		logger.info("Using " + url());
		System.setProperty("heroku_database", url());

		String[] userInfo = userInfo();
		logger.info("Using " + user(userInfo));
		logger.info("Using " + password(userInfo));
		System.setProperty("heroku_database_user", user(userInfo));
		System.setProperty("heroku_database_password", password(userInfo));
	}

	private String[] userInfo() {
		return database.getUserInfo().split(":");
	}

	private String password(String[] userInfo) {
		return userInfo[1];
	}

	private String user(String[] userInfo) {
		return userInfo[0];
	}

	private String url() {
		return "jdbc:postgresql://" + database.getHost() + ":" + database.getPort() + database.getPath();
	}

	public Map<String, String> exportToProperties() {
		Map<String, String> p = new HashMap<>();
		logger.info("Using " + url());
		p.put("connection.url", url());

		String[] userInfo = userInfo();
		logger.info("Using " + user(userInfo));
		logger.info("Using " + password(userInfo));
		p.put("connection.username", user(userInfo));
		p.put("connection.password", password(userInfo));
		return p;
	}

}
