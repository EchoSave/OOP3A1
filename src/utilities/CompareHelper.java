package utilities;

public class CompareHelper {

    public static int compare(Shape s1, Shape s2, String type) {
        switch (type) {
            case "h":
                return s1.compareTo(s2);

            case "a":
                return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());

            case "v":
                return Double.compare(s1.calcVolume(), s2.calcVolume());
        }
        return 0;
    }

}
