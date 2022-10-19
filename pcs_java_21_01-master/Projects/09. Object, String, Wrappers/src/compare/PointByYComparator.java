package compare;

import java.util.Comparator;

/**
 * 07.09.2021
 * 09. Object, String, Wrappers
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PointByYComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return o1.getY() - o2.getY();
    }
}
