package GenericsCollectionsStreams.Generics;

import java.util.Objects;

/*
   Реализуйте generic-класс Pair, похожий на Optional,
   но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
   Реализуйте методы getFirst(), getSecond(), equals() и hashCode(),
   а также статический фабричный метод of(). Конструктор должен быть закрытым (private).

   С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
   Pair<Integer, String> pair = Pair.of(1, "hello");
   Integer i = pair.getFirst(); // 1
   String s = pair.getSecond(); // "hello"

   Pair<Integer, String> pair2 = Pair.of(1, "hello");
   boolean mustBeTrue = pair.equals(pair2); // true!
   boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

 */

 class Pair<F, S> {
    private F fValue;
    private S sValue;

    private Pair(F fNewValue, S sNewValue) {
        this.fValue = fNewValue;
        this.sValue = sNewValue;
    }

    public F getFirst() {
        return fValue;
    }

    public S getSecond() {
        return sValue;
    }

    @Override
    public int hashCode() {
        int hash = 10;
        hash = 13 * hash + Objects.hashCode(this.fValue);
        hash = 13 * hash + Objects.hashCode(this.sValue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Pair<?, ?> other = (Pair<?, ?>) obj;

        if (!Objects.equals(this.fValue, other.fValue)) {
            return false;
        }
        return Objects.equals(this.sValue, other.sValue);
    }

    public static <F, S> Pair<F, S> of(F fV, S sV) {
        return new Pair<>(fV, sV);
    }

}
