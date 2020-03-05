package Objects.Abstract;

/*
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт.
По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:
реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */
public class AsciiCharSequence implements CharSequence {
    private byte[] content;

    public AsciiCharSequence(byte[] content) {
        this.content = content;
    }

    @Override
    public char charAt(int index) {
        return (char) content[index];
    }

    @Override
    public int length() {
        return content.length;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] result = new byte[end - start];
        if (end - start >= 0) System.arraycopy(content, start, result, 0, end - start);
        return new AsciiCharSequence(result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(content.length);
        for (byte b : content) {
            result.append((char) b);
        }
        return result.toString();
    }
}
