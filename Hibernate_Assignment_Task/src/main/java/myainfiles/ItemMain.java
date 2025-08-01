package myainfiles;

import java.util.List;
import java.util.Scanner;

import mydao.ItemDAO;
import mypojos.Item;

public class ItemMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemDAO dao = new ItemDAO();
        int choice;

        do {
            System.out.println("-------------------------------");
            System.out.println("Hibernate Item CRUD");
            System.out.println("-------------------------------");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    dao.addItem(name, price);
                    break;

                case 2:
                    List<Item> items = dao.getAllItems();
                    for (Item i : items) {
                        System.out.println(i);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    dao.updateItem(uid, newName, newPrice);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteItem(did);
                    break;

                case 5:
                    System.out.print("Enter ID to fetch: ");
                    int fid = sc.nextInt();
                    Item item = dao.getItemById(fid);
                    if (item != null)
                        System.out.println(item);
                    else
                        System.out.println("Item not found.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);

        sc.close();
    }
}


/*
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 1
Enter name: Laptop
Enter price: 84512
Hibernate: insert into items (name, price) values (?, ?)
Item added.
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 2
Hibernate: select item0_.id as id1_0_, item0_.name as name2_0_, item0_.price as price3_0_ from items item0_
Item [id=1, name=Laptop, price=84512.0]
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 1
Enter name: Mobile
Enter price: 27120
Hibernate: insert into items (name, price) values (?, ?)
Item added.
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 1
Enter name: Tv
Enter price: 45000
Hibernate: insert into items (name, price) values (?, ?)
Item added.
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 2
Hibernate: select item0_.id as id1_0_, item0_.name as name2_0_, item0_.price as price3_0_ from items item0_
Item [id=1, name=Laptop, price=84512.0]
Item [id=2, name=Mobile, price=27120.0]
Item [id=3, name=Tv, price=45000.0]
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 5
Enter ID to fetch: 2
Hibernate: select item0_.id as id1_0_0_, item0_.name as name2_0_0_, item0_.price as price3_0_0_ from items item0_ where item0_.id=?
Item [id=2, name=Mobile, price=27120.0]
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 1
Enter name: pouch
Enter price: 300
Hibernate: insert into items (name, price) values (?, ?)
Item added.
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 2
Hibernate: select item0_.id as id1_0_, item0_.name as name2_0_, item0_.price as price3_0_ from items item0_
Item [id=1, name=Laptop, price=84512.0]
Item [id=2, name=Mobile, price=27120.0]
Item [id=3, name=Tv, price=45000.0]
Item [id=4, name=pouch, price=300.0]
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 3
Enter ID to update: 3
Enter new name: RealmeTv
Enter new price: 52100
Hibernate: select item0_.id as id1_0_0_, item0_.name as name2_0_0_, item0_.price as price3_0_0_ from items item0_ where item0_.id=?
Hibernate: update items set name=?, price=? where id=?
Item updated.
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 2
Hibernate: select item0_.id as id1_0_, item0_.name as name2_0_, item0_.price as price3_0_ from items item0_
Item [id=1, name=Laptop, price=84512.0]
Item [id=2, name=Mobile, price=27120.0]
Item [id=3, name=RealmeTv, price=52100.0]
Item [id=4, name=pouch, price=300.0]
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 4
Enter ID to delete: 4
Hibernate: select item0_.id as id1_0_0_, item0_.name as name2_0_0_, item0_.price as price3_0_0_ from items item0_ where item0_.id=?
Hibernate: delete from items where id=?
Item deleted.
-------------------------------
Hibernate Item CRUD
-------------------------------
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 0
Exiting...
*/