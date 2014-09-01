package com.projectName.testutils.testdatareader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentPropertiesReader {
	private String accTransusername;
	private String accMgrusername;
	private String password;
	private String TransactionUrl;
	private String merchantUrl;
	private String browser;
	private String dbURL;
	private String dbUsername;
	private String dbpassword;
	private String dbDriver;
	private static Properties property = new Properties();
	private String filePath = "/src/test/resources/env.properties";
	private String jenkinsPath = "/src/test/resources/jenkinsconfig";
	
	public EnvironmentPropertiesReader() {
		try {
			property.load(new FileInputStream(new java.io.File(".").getCanonicalPath() + filePath));
			this.setTransMgrUsername(property.getProperty("transmgrusername"));
			this.setAccMgrUsername(property.getProperty("accountmgrusername"));
			this.setPassword(property.getProperty("password"));
			this.setBrowser(property.getProperty("browser"));
			this.setURLMerchant(property.getProperty("URLMerchant"));
			this.setTransUrl(property.getProperty("URLTransaction"));
			this.setDBurl(property.getProperty("DBurl"));
			this.setDBpassword(property.getProperty("DBpassword"));
			this.setDBusername(property.getProperty("DBusername"));
			this.setDbDriver(property.getProperty("DBdriver"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public EnvironmentPropertiesReader(String fileName) {
		try {
			property.load(new FileInputStream(new java.io.File(".").getCanonicalPath() + jenkinsPath
					+ File.separatorChar + fileName));
			this.setTransMgrUsername(property.getProperty("transmgrusername"));
			this.setAccMgrUsername(property.getProperty("accountmgrusername"));
			this.setPassword(property.getProperty("password"));
			this.setBrowser(property.getProperty("browser"));
			this.setTransUrl(property.getProperty("URLTransaction"));
			this.setURLMerchant(property.getProperty("URLMerchant"));
			this.setDBurl(property.getProperty("DBurl"));
			this.setDBpassword(property.getProperty("DBpassword"));
			this.setDBusername(property.getProperty("DBusername"));
			this.setDbDriver(property.getProperty("DBdriver"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set user name
	 * 
	 * @param username
	 */
	public void setTransMgrUsername(String accTransusername) {
		this.accTransusername = accTransusername;
	}

	/**
	 * Get user name
	 * 
	 * @return userName
	 */
	public String getTransMgrUsername() {
		return accTransusername;
	}
	
	/**
	 * Set user name
	 * 
	 * @param username
	 */
	public void setAccMgrUsername(String accMgrusername) {
		this.accMgrusername = accMgrusername;
	}

	/**
	 * Get user name
	 * 
	 * @return userName
	 */
	public String getAccMgrUsername() {
		return accMgrusername;
	}
	
	/**
	 * set Password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set URL
	 * 
	 * @param url
	 */
	public void setTransUrl(String TransactionUrl) {
		this.TransactionUrl = TransactionUrl;
	}
	
	/**
	 * set URL1
	 * 
	 * @param url
	 */
	public void setURLMerchant(String merchantUrl) {
		this.merchantUrl = merchantUrl;
	}

	/**
	 * Get URL1
	 * 
	 * @return url
	 */
	public String getTransUrl() {
		return TransactionUrl;
	}
	
	/**
	 * Get URL
	 * 
	 * @return url
	 */
	public String getURLMerchant() {
		return merchantUrl;
	}

	/**
	 * set browser
	 * 
	 * @param browser
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * get browser
	 * 
	 * @return browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * set DBusername
	 * 
	 * @param dBusername
	 */
	public void setDBusername(String dBusername) {
		dbUsername = dBusername;
	}

	/**
	 * get DBusername
	 * 
	 * @return dBusername
	 */
	public String getDBusername() {
		return dbUsername;
	}

	/**
	 * set dBpassword
	 * 
	 * @param dBpassword
	 */
	public void setDBpassword(String dBpassword) {
		dbpassword = dBpassword;
	}

	/**
	 * get dBpassword
	 * 
	 * @return dBpassword
	 */
	public String getDBpassword() {
		return dbpassword;
	}

	/**
	 * set dbURL
	 * 
	 * @param dbURL
	 */
	public void setDBurl(String dBurl) {
		dbURL = dBurl;
	}

	/**
	 * get dbURL
	 * 
	 * @return dbURL
	 */
	public String getDBurl() {
		return dbURL;
	}

	/**
	 * set dbDriver
	 * 
	 * @param dbDriver
	 */
	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	/**
	 * get dbDriver
	 * 
	 * @return dbDriver
	 */
	public String getDbDriver() {
		return dbDriver;
	}
}
