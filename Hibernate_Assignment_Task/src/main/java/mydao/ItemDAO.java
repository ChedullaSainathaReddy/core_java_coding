package mydao;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import mypojos.Item;

public class ItemDAO {


	private SessionFactory factory;

    public ItemDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void addItem(String name, double price) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(new Item(name, price));
        tx.commit();
        session.close();
        System.out.println("Item added.");
    }

    public List<Item> getAllItems() {
        Session session = factory.openSession();
        List<Item> items = session.createQuery("from Item", Item.class).list();
        session.close();
        return items;
    }

    public void updateItem(int id, String name, double price) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Item item = session.get(Item.class, id);
        if (item != null) {
            item.setName(name);
            item.setPrice(price);
            session.update(item);
            tx.commit();
            System.out.println("Item updated.");
        } else {
            System.out.println("Item not found.");
        }
        session.close();
    }

    public void deleteItem(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Item item = session.get(Item.class, id);
        if (item != null) {
            session.delete(item);
            tx.commit();
            System.out.println("Item deleted.");
        } else {
            System.out.println("Item not found.");
        }
        session.close();
    }

    public Item getItemById(int id) {
        Session session = factory.openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
    }
}