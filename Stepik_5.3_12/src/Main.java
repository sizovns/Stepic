import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Charset charset = Charset.forName("US-ASCII");
        byte[] arr = {48, 49, 50, 51};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);
        try {
            System.out.println(readAsString(inputStream, charset));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        /*String result;
        try(Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            result = s.hasNext() ? s.next() : "";
        }

        return result;*/

        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try (Reader in = new InputStreamReader(inputStream, charset)) {
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }

        return out.toString();
        }

    }
}
