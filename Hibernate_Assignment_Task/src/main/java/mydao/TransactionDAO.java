package mydao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mypojos.Account;
import mypojos.Transactions;

public class TransactionDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addTransaction(int accountId, String type, double amount) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Account acc = session.get(Account.class, accountId);
        if (acc == null) {
            System.out.println("Account not found.");
            session.close();
            return;
        }

        Transactions trans = new Transactions();
        trans.setType(type);
        trans.setAmount(amount);
        trans.setAccount(acc);

        session.save(trans);
        tx.commit();
        session.close();
        System.out.println("Transaction added.");
    }

    public List<Transactions> getTransactionsByAccount(int accountId) {
        Session session = factory.openSession();
        List<Transactions> list = session.createQuery("FROM Transactions WHERE account.id = :id", Transactions.class)
                .setParameter("id", accountId)
                .list();
        session.close();
        return list;
    }
}