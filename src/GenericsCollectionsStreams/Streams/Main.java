package GenericsCollectionsStreams.Streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    /*
    Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
    и в конце выводящую 10 наиболее часто встречающихся слов. Словом будем считать любую непрерывную последовательность символов,
    состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
    Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.
    Если в тексте меньше 10 уникальных слов, то выводите сколько есть. Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
    Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
*/
    public static void main(String[] args) {
        HashMap<String, Integer> result = new HashMap<>();
        (new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)))
                .lines()
                .flatMap(l -> Stream.of(l.split("[^a-zA-Zа-яА-Я0-9]+")))
                .map(String::toLowerCase)
                .forEach(w -> {
                    if(result.containsKey(w)) result.put(w, result.get(w) + 1);
                    else result.put(w, 1);
                });

        result.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if(e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                    else return e2.getValue().compareTo(e1.getValue());})
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }

    /*
    Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
    Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
    Первый элемент последовательности устанавливается равным этому числу.
    Следующие элементы вычисляются по рекуррентной формуле R{n+1}=mid(R_{n}^2), где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа.
    */
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10 % 1000));
    }
 /*
    Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
    Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
        minMaxConsumer.accept(min, max);
    Если стрим не содержит элементов, то вызовите
        minMaxConsumer.accept(null, null);
    */

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T sMin = null;
        T sMax = null;
        T[] streamArray;

        List<T> list = new ArrayList<>();
        list = stream.sorted(order).collect(Collectors.toList());

        if (list.size() == 1) {
            sMin = list.get(0);
            sMax = list.get(0);
            minMaxConsumer.accept(sMin, sMax);
        } else if (list.size() > 1) {
            sMin = list.get(0);
            sMax = list.get(list.size() - 1);
            minMaxConsumer.accept(sMin, sMax);
        } else
            minMaxConsumer.accept(null, null);
    }


}
