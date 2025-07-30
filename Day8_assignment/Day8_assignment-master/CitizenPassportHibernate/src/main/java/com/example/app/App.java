package com.example.app;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Citizen;
import com.example.entity.Passport;
import com.example.util.HibernateUtil;
public class App {
    public static void main(String[] args) {
        Citizen citizen = new Citizen();
        citizen.setName("Viswath");
        Passport passport = new Passport();
        passport.setPassportNumber("IN123456");
        citizen.setPassport(passport);
        passport.setCitizen(citizen);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(citizen);
        tx.commit();
        session.close();
        System.out.println("Citizen and Passport saved successfully.");
    }
}