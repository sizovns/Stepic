import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream stream;
        int result;
        stream = getStream( new byte[] { 0x33, 0x45, 0x01});

        result = checkSumOfStream(stream);
        System.out.print(result);
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream (data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {

        int x=0,n;
        while ((n=inputStream.read())!=-1){
            x = Integer.rotateLeft(x,1) ^ n;
        }
        return x;
    }


}