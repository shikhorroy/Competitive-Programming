package utils.algo.dirarray;

public class DirectionalArray {

    public enum Direction {
        FOUR,   //-> index: 0
        EIGHT,  //-> index: 1
        KNIGHT  //-> index: 2
    }

    private static final Integer dirArray[][][] = {
            {{1, 0, -1, 0}, {0, 1, 0, -1}}, // 4 - directions
            {{1, 1, 0, -1, -1, -1, 0, 1}, {0, 1, 1, 1, 0, -1, -1, -1}}, // 8 - directions
            {{2, 1, -1, -2, -2, -1, 1, 2}, {1, 2, 2, 1, -1, -2, -2, -1}} // Knight - directions
    };

    public static Integer[][] getDirectinalArray(Direction dir) {
        return dirArray[dir.ordinal()];
    }
}
