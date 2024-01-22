package learn.java.basics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("now = " + now);
        System.out.println("now.toString() = " + now.toString());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm::ss a zzz");
        String formatted = simpleDateFormat.format(now);
        System.out.println("formatted = " + formatted);


        String formatted1 = String.format("Current Date Time : %tc", now);
        System.out.println("formatted1 = " + formatted1);

        String formatted2 = String.format("%1$s %2$tB %2$td %2$tY", "DDate is :", now);
        System.out.println("formatted2 = " + formatted2);
    }
}
