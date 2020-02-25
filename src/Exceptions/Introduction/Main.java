package Exceptions.Introduction;

public class Main {
/*
Реализуйте метод sqrt(), вычисляющий квадратный корень числа. В отличие от Math.sqrt(),
это метод при передаче отрицательного параметра должен бросать исключение java.lang.IllegalArgumentException
с сообщением "Expected non-negative number, got ?", где вместо вопросика будет подставлено фактически
переданное в метод число.
 */

    public static double sqrt(double x) {
        if (x < 0)
            throw new IllegalArgumentException ("Expected non-negative number, got " + x);
        else
            return Math.sqrt(x);
    }
/*
Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод,
вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"),
если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
 */
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        if (stackTraceElements.length < 3 ) {
            return null;
        } else {
            return stackTraceElements[2].getClassName()+"#"+stackTraceElements[2].getMethodName();
        }
    }
}
