package dao;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

public class SectionFactory {
	 
	public static Session getSession() { 
		AnnotationConfiguration configuration = new AnnotationConfiguration();
	    configuration.configure();
	    return configuration.buildSessionFactory().openSession();
    }
	
}
