import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        //byte[] arr = {13,10};
        //ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        //System.setIn(in);
        dos2unix(in);
    }

    public static void dos2unix(InputStream inputStream) throws IOException {
        int n, i;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((n = inputStream.read())!=-1){
            baos.write(n);
            baos.flush();
            baos.close();
        }
        byte[] array = baos.toByteArray();
        for (i = 0; i < array.length; i++){
            if (((i+1) < array.length) ) {
                if ((array[i] == 13) & (array[i + 1] == 10)) {
                    i++;
                }
            }
            System.out.write(array[i]);
            System.out.flush();
        }

    }
}

/*
public class Main {
    public static void main(String... args) throws IOException {
        int prev = System.in.read();
        while (prev != -1) {
            int next = System.in.read();
            if (prev != 13 || next != 10) {
                System.out.write(prev);
            }
            prev = next;
        }
        System.out.flush();
    }
}
 */