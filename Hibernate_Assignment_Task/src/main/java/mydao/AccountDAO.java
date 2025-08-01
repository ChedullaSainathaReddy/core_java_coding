package mydao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mypojos.Account;

//one to many bidirectionalrelationship
public class AccountDAO {

	private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addAccount(String holderName) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Account acc = new Account();
        acc.setHolderName(holderName);
        session.save(acc);
        tx.commit();
        session.close();
        System.out.println("Account added.");
    }

    public Account getAccount(int id) {
        Session session = factory.openSession();
        Account acc = session.get(Account.class, id);
        session.close();
        return acc;
    }

    public void deleteAccount(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Account acc = session.get(Account.class, id);
        if (acc != null) {
            session.delete(acc);
            tx.commit();
            System.out.println("Account deleted.");
        } else {
            System.out.println("Account not found.");
        }
        session.close();
    }
}

