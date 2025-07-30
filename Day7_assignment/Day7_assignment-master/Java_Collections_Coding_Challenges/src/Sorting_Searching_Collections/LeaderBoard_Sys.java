package Sorting_Searching_Collections;
import java.util.*;
class Player {
    String name;
    int score;
    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return name + " - " + score;
    }
}
public class LeaderBoard_Sys {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Arun", 100));
        players.add(new Player("Vijay", 200));
        players.add(new Player("Ravi", 150));
        players.add(new Player("Amit", 250));
        players.sort((a, b) -> b.score - a.score); 
        System.out.println("Leaderboard:");
        int rank = 1;
        for (Player p : players) {
            System.out.println(rank + ". " + p);
            rank++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter player name to find rank: ");
        String searchName = sc.nextLine();
        rank = 1;
        boolean found = false;
        for (Player p : players) {
            if (p.name.equalsIgnoreCase(searchName)) {
                System.out.println(p.name + "'s rank: " + rank);
                found = true;
                break;
            }
            rank++;
        }
        if (!found) {
            System.out.println("Player not found.");
        }
        sc.close();
    }
}