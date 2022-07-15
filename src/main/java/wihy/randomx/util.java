package wihy.randomx;

import java.util.Random;

public class util {
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
