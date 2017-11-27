import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream in = System.in;
        //byte[] arr = {48, 49, 50, 51};
        //ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        //System.setIn(inputStream);
        /*try {
            readSumOfDouble(in);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Locale loc = new Locale("ru");

        double a=0;
        try (Scanner s = new Scanner(in).useLocale(loc)) {
            while (s.hasNext()) {
                try {
                    a += Double.parseDouble(s.next());
                } catch (NumberFormatException e){}

            }

            System.out.format("%.6f",a);

        }

    }

    /*public static void readSumOfDouble(InputStream inputStream) throws IOException {
        String result;
        double a=0;
        try (Scanner s = new Scanner(inputStream)) {

            //.useDelimiter("\\A")
            /*for (; s.hasNext(); ) {
                //System.out.println(Double.parseDouble(s.toString()));
                System.out.println(s);
                a += a;
                System.out.println(a);
                s.nextLine();

            }*/

            /*while (s.hasNext()) {
                try {
                    //Double.parseDouble(s.nextLine());)
                    a = Double.parseDouble(s.next());
                    a = a+a;
                    //System.out.println(Double.parseDouble(s.next()));
                } catch (NumberFormatException e){}

                //s.nextLine();
            }
            //result = s.hasNext() ? s.next() : "";
           /*if (s.hasNextDouble()) {
                a = s.nextDouble();
                a = +a;
                System.out.println(a);

            }
            s.nextLine();
        }*/
           /* System.out.format("%.6f",a);
            //return a;

        }
    }*/
}