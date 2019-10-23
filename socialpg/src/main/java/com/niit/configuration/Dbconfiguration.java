package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.model.BlogComment;
import com.niit.model.BlogPost;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.Notification;
import com.niit.model.ProfilePicture;
import com.niit.model.User;

@Configuration
@EnableTransactionManagement
public class Dbconfiguration {
public Dbconfiguration(){
 System.out.println("Dbconfiguraton class is instantiated");
}
@Bean(name="sessionFactory")
		public SessionFactory sessionFactory() {
	System.out.println("Entering sessionFactory creation method");
	LocalSessionFactoryBuilder Isf=new LocalSessionFactoryBuilder(getDataSource());
	Properties hibernateProperties=new Properties();
	hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	hibernateProperties.setProperty("hibernate.show_sql","true");
	Isf.addProperties(hibernateProperties);
	Class classes[]=new Class[]{User.class,Job.class,BlogPost.class,Notification.class,BlogComment.class,Friend.class,ProfilePicture.class};
    return Isf.addAnnotatedClasses(classes).buildSessionFactory();
}

@Bean(name="dataSource")
		public DataSource getDataSource() {
	System.out.println("Entering DataSource bean creation method");
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	dataSource.setUsername("sa");
	dataSource.setPassword("sa");
	System.out.println("DataSource bean"+dataSource);
	return dataSource;
}

@Bean
public HibernateTransactionManager hibTransManagement() {
	return new HibernateTransactionManager(sessionFactory());
	}

@Bean(name="userDao")
public UserDao getUserDao() {
	return new UserDaoImpl();
}

}
