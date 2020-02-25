package Objects.Declaration;

/*
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y — снизу вверх.
В начальный момент робот находится в некоторой позиции на поле.
Также известно, куда робот смотрит: вверх, вниз, направо или налево.
Ваша задача — привести робота в заданную точку игрового поля.
Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(true);
    }


    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();

        if (x >= toX && y >= toY) {

            while (!(robot.getDirection() == Direction.LEFT)) {
                robot.turnRight();
            }

            while (!(robot.getX() == toX)) {
                robot.stepForward();
            }


            while (!(robot.getDirection() == Direction.DOWN)) {
                robot.turnRight();
            }

            while (!(robot.getY() == toY)) {
                robot.stepForward();
            }

        } else if (x >= toX) {


            while (!(robot.getDirection() == Direction.LEFT)) {
                robot.turnRight();
            }

            while (!(robot.getX() == toX)) {
                robot.stepForward();
            }


            while (!(robot.getDirection() == Direction.UP)) {
                robot.turnRight();
            }

            while (!(robot.getY() == toY)) {
                robot.stepForward();
            }
        } else if (y <= toY) {


            while (!(robot.getDirection() == Direction.RIGHT)) {
                robot.turnRight();
            }

            while (!(robot.getX() == toX)) {
                robot.stepForward();
            }


            while (!(robot.getDirection() == Direction.UP)) {
                robot.turnRight();
            }

            while (!(robot.getY() == toY)) {
                robot.stepForward();
            }
        } else {


            while (!(robot.getDirection() == Direction.RIGHT)) {
                robot.turnRight();
            }

            while (!(robot.getX() == toX)) {
                robot.stepForward();
            }


            while (!(robot.getDirection() == Direction.DOWN)) {
                robot.turnRight();
            }

            while (!(robot.getY() == toY)) {
                robot.stepForward();
            }
        }


    }

}
