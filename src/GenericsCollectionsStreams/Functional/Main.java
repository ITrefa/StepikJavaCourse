package GenericsCollectionsStreams.Functional;

import java.util.function.Function;
import java.util.function.Predicate;

/*
Давайте научимся комбинировать функции в более сложные функции.
Для примера построим следующую комбинацию. Дан предикат condition и две функции ifTrue и ifFalse.
Напишите метод ternaryOperator, который из них построит новую функцию, возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
 */

public class Main {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return T -> condition.test(T) ? ifTrue.apply(T) : ifFalse.apply(T);



    }
}
