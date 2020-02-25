package BasicSyntax.PrimitiveTypes;


public class Main {
    public static void main(String[] args) {
        System.out.println(true);
    }


    /*
Реализуйте метод, возвращающий true,если среди четырех его аргументов ровно два истинны (любые).
Во всех остальных случаях метод должен возвращать false.
Воспользуйтесь шаблоном кода, который предлагает система. Ввод-вывод будет сделан за вас. Вам надо только проанализировать переданные в метод booleanExpression значения (a, b, c, d) и вернуть результат.
Попробуйте составить формулу с использованием булевых операторов.

*/
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        if ((a && b && c) || (d && b && c) || (a && d && c))
            return false;

        if ((!a && !b && !c) || (!d && !b && !c) || (!a && !d && !c))
            return false;

        return !c || a || b || d;
    }

/*
В Григорианском календаре год является високосным в двух случаях: либо он кратен 4, но при этом не кратен 100, либо кратен 400.
Реализуйте метод, вычисляющий количество високосных лет с начала нашей эры (первого года) до заданного года включительно. На самом деле Григорианский календарь
был введен значительно позже, но здесь для упрощения мы распространяем его действие на всю нашу эру.

 */

    public static int leapYearCount(int year) {
        return year / 4 + (year / 400 - year / 100);
    }

    /*
    Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
Допустимая погрешность – 0.0001 (1E-4)
     */

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }

/*
Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
Данная задача актуальна, например, при работе с битовыми полями.
Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).
 */
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));
    }


}
