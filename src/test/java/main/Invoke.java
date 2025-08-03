package main;

import java.util.List;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Invoke 
{   
	public void checkAgent() 
	{   
    		try {
    		TestNG testng = new TestNG();
    		List<String> suites = Lists.newArrayList();
    		String workingDir = System.getProperty("user.dir");
    		System.out.println("user.dir "+ workingDir);
    		suites.add(workingDir + "/testng.xml");
    		
    		testng.setTestSuites(suites);
    		testng.run();
		} 
    		catch (Exception e) {	 	  	  		 	     	     	      	 	
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    Invoke iv=new Invoke();
	    iv.checkAgent();
	}
}