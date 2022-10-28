import java.util.Comparator;

class GueustComparator implements Comparator<Guest> {

    public int compare(Guest g1, Guest g2) {
        if (g1.getDistance() < g2.getDistance())
            return 1;
        else if (g1.getDistance() > g2.getDistance())
            return -1;
                        return 0;
    }
}