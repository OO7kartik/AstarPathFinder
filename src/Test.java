import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

class Temp {
    public int val;

    public Temp(int val) {
        this.val = val;
    }
}

public class Test extends JPanel {
    public static void addTemp(int x, ArrayList<Temp> arr) {
        Temp temp = new Temp(x);
        arr.add(temp);
    }

    public static void main(String[] args) {

        int[] dir = new int[]{-1, 0, 1};

        for (int x : dir) {
            for (int j : dir) {
                System.out.println(x + " " + j);
            }
        }

        ArrayList<Temp> arr = new ArrayList<>();
        arr.add(new Temp(1));
        arr.add(new Temp(2));

        addTemp(3, arr);

        for (var x : arr) {
            System.out.println(x.val);
        }
    }
}

