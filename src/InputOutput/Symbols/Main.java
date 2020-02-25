package InputOutput.Symbols;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Main {

    /*
    Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
     */

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(String.valueOf(charset));

    }

}
