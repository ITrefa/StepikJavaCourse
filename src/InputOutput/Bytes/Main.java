package InputOutput.Bytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class Main {

   /*
По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле.
На Unix-системах конец строки обозначается символом с кодом 10 ('\n'), на Windows — двумя последовательными символами с кодами 13 и 10 ('\r' '\n').
Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix.
Данные в формате Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out.
На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы.
Требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'. Если на входе встречается одиночный символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.
Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' — байтом 13.
Поэтому программа может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.
Из-за буферизации данных в System.out в конце вашей программы надо явно вызвать System.out.flush(). Иначе часть выведенных вами данных не будет видна проверяющей системе.
     */


    public static void main(String[] args) {
        InputStream is = System.in;
        OutputStream os = System.out;

        try {
            int firstByte = is.read();
            if (firstByte == -1) return;
            int secondByte = is.read();
            if (secondByte == -1) {
                os.write(firstByte);
            }
            while (-1 != secondByte) {
                if (firstByte == 13 && secondByte == 10) {
                    os.write(secondByte);
                    secondByte = is.read();
                } else {
                    os.write(firstByte);
                }
                firstByte = secondByte;
                secondByte = is.read();
                if (-1 == secondByte) {
                    os.write(firstByte);
                }
            }
            os.flush();
        } catch (IOException ignored) {

        }
    }


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
