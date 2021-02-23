package au.com.automation.helper;

import org.apache.log4j.PropertyConfigurator;
/**
 * 
 * @author Gursimran
 *
 */
public class Logger {

	private static boolean root=false;
	
	public static org.apache.log4j.Logger getLogger(Class cls){
		if(root){
			return org.apache.log4j.Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("log4j.properties");
		root = true;
		return org.apache.log4j.Logger.getLogger(cls);
	}
	
	public static void main(String[] args) {
		org.apache.log4j.Logger log = Logger.getLogger(Logger.class);
		log.info("I am test");
				
	}
}
