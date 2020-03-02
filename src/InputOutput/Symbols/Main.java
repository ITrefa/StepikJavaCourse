package InputOutput.Symbols;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Scanner;


/*
Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте вещественных чисел
с точностью до шестого знака после запятой. Числом считается последовательность символов,
отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
*/

public class Main {

    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else scanner.next();
        }
        System.out.format("%.6f", sum);
    }


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
