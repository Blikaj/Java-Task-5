import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorQueue {

    public static void main(String[] args){
        PriorityQueue<Guest> gq = new PriorityQueue<Guest>(10, new GueustComparator());
        Guest g1 = new Guest("Alpha", (float) 400.21);
        Guest g2 = new Guest("Bravo", (float) 34.45);
        Guest g3 = new Guest("Charlie", (float) 200.17);
        Guest g4 = new Guest("Delta", (float) 500.33);
        Guest g5 = new Guest("Eagle", (float) 700.22);
        gq.add(g1);
        gq.add(g2);
        gq.add(g3);
        gq.add(g4);
        gq.add(g5);
        Scanner in = new Scanner(System.in);
        /*while (!gq.isEmpty()) {
            Guest gg = gq.poll();
            System.out.println(gg.getName()+" "+gg.getDistance());
        }*/
        String ch = "-1";
        while (ch != "3") {
            System.out.println("\n");
            System.out.println(
                    """
                            ============Text Main Menu =============
                                                    
                            0- print guest list
                            1- serve guest
                            2- add new guest
                            3- exit
                            """);
            ch = in.next();
            switch (ch) {
                case "0" -> {
                    PriorityQueue<Guest> copy = new PriorityQueue<Guest>(gq);
                    if (!copy.isEmpty()) {
                        while (!copy.isEmpty()) {
                            Guest gg = copy.poll();
                            System.out.println(gg.getName() + " " + gg.getDistance());
                        }
                    } else {
                        System.out.println("No customers left! Queue is empty!");
                    }
                    break;
                }
                case "1" -> {
                    try {
                        Guest gg = gq.poll();
                        System.out.println("Serving customer");
                        System.out.println(gg.getName() + " " + gg.getDistance());
                    } catch (NullPointerException e) {
                        System.out.println("No customers left!");
                    }
                    break;
                }
                case "2" -> {
                    System.out.println("Enter name");
                    String name = in.next();
                    System.out.println("Enter distance");
                    Float distance = Float.parseFloat(in.next());
                    try {
                        gq.add(new Guest(name, distance));
                        System.out.println("Guest added");
                    } catch (Exception e) {
                        System.out.println("Adding failed");
                        e.printStackTrace();
                    }
                    break;
                }
                case "3" -> {
                    ch = "3";
                    break;
                }
                default -> {
                    ch = "-1";
                    System.out.print("Wrong choise, my friend!");
                    break;
                }
            }
        }
    }
}
