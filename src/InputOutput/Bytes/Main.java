package InputOutput.Bytes;

import java.io.IOException;
import java.io.InputStream;

/*
Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
Контрольная сумма данных вычисляется по следующему алгоритму:
Контрольная сумма представляет собой число типа int.
Контрольная сумма пустого набора данных равна нулю.
Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
С(n+1) = rotateLeft(C(n) xor b(n+1), где Cn - контрольная сумма первых n байт данных, rotateLeft - циклический сдвиг
бит числа на один бит влево, b(n) - n-ный бит данных.
Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
Выброшенное из методов InputStream исключение должно выбрасываться из метода.
 */
public class Main {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int checkSum = 0;

        int result = inputStream.read();
        while (result != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ result;
            result = inputStream.read();
        }

        return checkSum;
    }

}
