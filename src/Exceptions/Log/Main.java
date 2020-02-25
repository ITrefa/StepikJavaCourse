package Exceptions.Log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.print(true);
    }
/*
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования.
Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:

Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения печатались в
консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".

Не упомянутые здесь настройки изменяться не должны.
 */
    private static void configureLogging() {
        Logger logger = Logger.getLogger("org.stepic.java");

        logger.setLevel(Level.ALL);

        ConsoleHandler handler = new ConsoleHandler();
        XMLFormatter formatter = new XMLFormatter();

        handler.setLevel(Level.ALL);
        handler.setFormatter(formatter);

        logger.addHandler(handler);
        logger.setUseParentHandlers(false);

        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);
    }


}
