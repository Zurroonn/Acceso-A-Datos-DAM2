package Propierties;

import java.util.Properties;

public class Propiedades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop= System.getProperties();
		System.out.println("Version java : "+prop.getProperty("java.version") );
		System.out.println("Version: "+prop.getProperty("os.name") );
		System.out.println("Version: "+prop.getProperty("user.home") );
	}

}
