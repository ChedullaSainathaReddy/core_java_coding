package com.vcube.SpringTask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 AnnotationConfigApplicationContext context =
                 new AnnotationConfigApplicationContext(AppConfig.class);

         PersonDAO dao = context.getBean(PersonDAO.class);

         System.out.println("List of person is:");
         dao.getAll().forEach(System.out::println);

//         System.out.println("Get person with ID 2:");
//         System.out.println(dao.getById(2));
         System.out.println("Get person with ID 2:");
         Person person2 = dao.getById(2);
         if (person2 != null) {
             System.out.println(person2);
         } else {
             System.out.println("No person found with ID 2");
         }


         System.out.println("Creating person:");
         dao.create(new Person(0, 36, "Sergey", "Emets"));

         System.out.println("List of person is:");
         dao.getAll().forEach(System.out::println);

         System.out.println("Deleting person with ID 2");
         dao.delete(2);

//         System.out.println("Updating person with ID 4");
//         Person p = dao.getById(4);
//         p.setLastName("CHANGED");
//         dao.update(p);
         System.out.println("Updating person with ID 4");
         Person p = dao.getById(4);
         if (p != null) {
             p.setLastName("CHANGED");
             dao.update(p);
             System.out.println("Updated person with ID 4");
         } else {
             System.out.println("No person found with ID 4");
         }

         System.out.println("List of person is:");
         dao.getAll().forEach(System.out::println);

         context.close();
     }
    }

