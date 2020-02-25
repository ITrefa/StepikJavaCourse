package GenericsCollectionsStreams.Collections;

import java.util.*;

public class Main {
/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.
Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
 */
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNext()) {
                String line =scanner.nextLine();
                String[] result = line.split(" ");
                for (String s : result) {
                    list.add(Integer.parseInt(s));

                }
                for (int i = 1; i < list.size() - 1; i++) {
                    list.remove(i + 1);
                }
                list.remove(0);
                Collections.reverse(list);
            }
            for (Integer integer : list) {
                System.out.println(integer);
            }
        } catch (NumberFormatException e) {

        }

    }

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.

Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
 */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> symmetricDiff = new HashSet<T>(set1);
        symmetricDiff.addAll(set2);
        Set<T> tmp = new HashSet<T>(set1);
        tmp.retainAll(set2);
        symmetricDiff.removeAll(tmp);
        return symmetricDiff;
    }


}
