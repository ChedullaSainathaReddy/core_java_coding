package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory
			= new Configuration().configure().buildSessionFactory();
		
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

//private static final SessionFactory sessionFactory
//
//private: Only accessible within this class.
//static: Shared across all instances of the class; gets initialized only once when the class is loaded.
//final: Value cannot be changed once initialized.
//SessionFactory: The core Hibernate object used to open sessions for database interaction.
// = new Configuration().configure().buildSessionFactory();
//
//new Configuration()
//→ Creates a new Configuration object which holds all Hibernate settings.
//.configure()
//→ Reads the hibernate.cfg.xml file from the classpath. This file contains DB connection info, dialect, entity mapping, etc.
//.buildSessionFactory()
//→ Builds the SessionFactory using the configuration settings.
