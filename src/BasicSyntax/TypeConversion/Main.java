package BasicSyntax.TypeConversion;

public class Main {
    public static void main(String[] args) {
        System.out.println(true);
    }

    /*
    Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
     */

    public static char charExpression(int a) {
        char charValue = '\\';
        int result = charValue + a;
        return (char) result;
    }


/*
Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
 */

    public static boolean isPowerOfTwo(int value) {
        if (Integer.bitCount(Math.abs(value)) == 1)
            return true;
        else return false;
    }

}
