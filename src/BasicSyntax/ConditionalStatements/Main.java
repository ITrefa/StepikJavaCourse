package BasicSyntax.ConditionalStatements;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println(true);
    }

/*
Реализуйте метод, вычисляющий факториал заданного натурального числа.
Факториал N вычисляется как  1⋅2⋅...⋅N.
Поскольку это очень быстро растущая функция, то даже для небольших NN вместимости типов int и long очень скоро не хватит.
Поэтому будем использовать BigInteger.
 */
    public static BigInteger factorial(int value) {
        if (BigInteger.valueOf(value).equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }

    /*
Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив.
Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
     */

    public static int[] mergeArrays(int[] theFirstArray, int[] theSecondArray) {
        int[] resultArray = new int[theFirstArray.length + theSecondArray.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < resultArray.length; k++) {
            if (i > theFirstArray.length - 1) {
                resultArray[k] = theSecondArray[j];
                j++;

            } else if (j > theSecondArray.length - 1) {
                resultArray[k] = theFirstArray[i];
                i++;

            }
            else if (theFirstArray[i] < theSecondArray[j]) {
                resultArray[k] = theFirstArray[i];
                i++;
            }
            else {
                resultArray[k] = theSecondArray[j];
                j++;
            }
        }
        return resultArray;
    }


    /*
Вам дан список ролей и сценарий пьесы в виде массива строчек.
Каждая строчка сценария пьесы дана в следующем виде:
Роль: текст

Текст может содержать любые символы.
Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста (см. пример).
Каждая группа распечатывается в следующем виде:
Роль:
i) текст
j) текст2
...
==перевод строки==

i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в соответствии с порядком ролей.
Переводы строк между группами обязательны, переводы строк в конце текста не учитываются.

Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно,
неправильная сборка результирующей строчки может выйти за ограничение по времени.
 */

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        for (String role : roles) {
            result.append(role).append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    result.append(i + 1).append(")").append(textLines[i].substring(role.length() + 1)).append("\n");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
