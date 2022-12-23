package Lev_10_lec_7_3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/

public class Solution implements Serializable {



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        File f = new File("111.big");
        Solution s1 = new Solution(5);

        FileOutputStream fOS = new FileOutputStream(f);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(s1);

        FileInputStream fIS = new FileInputStream(f);
        ObjectInputStream oIS = new ObjectInputStream(fIS);
        Solution s1Clone = (Solution) oIS.readObject();

        System.out.println(s1.hashcode(s1Clone));
        System.out.println(s1.equals(s1Clone));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    public boolean hashcode(Solution s) {
        return this.string.hashCode() * 3 == s.string.hashCode() * 3;
    }

    public boolean equals(Solution s) {
        return this.string.equals(s.string);
    }
}
