package br.com.mybank.appium.helper;

import com.github.lgigek.scenario.Scenario;

public class PropertiesReaderBuilder {

    //configuration of the properties reader, with differentiation of environments
	public static PropertiesReader build() {
        PropertiesReader filter;
        
        String ambiente = Scenario.getInfoValue("ambiente").toString();
        if (ambiente.equals("PROD"))
            filter = new PropertiesReader("filter-prod");
        else if (ambiente.equals("HOM"))
            filter = new PropertiesReader("filter-hom");
        else
            filter = null;
        
        return filter;
    }
    
	private static PropertiesReader propUsers = new PropertiesReader("filter-hom");

	public static String getEmailUser(String profile) {
		return propUsers.read(Scenario.getInfoValue("ambiente").toLowerCase() + "-" + profile + "-email");
	}

	public static String getPasswordUser(String profile) {
		return propUsers.read(Scenario.getInfoValue("ambiente").toLowerCase() + "-" + profile + "-password");
	}
}
	

