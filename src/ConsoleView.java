import java.util.Scanner;

public class ConsoleView implements View{
    Scanner in = new Scanner(System.in);

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getToyName() {
        System.out.printf("Имя игрушки: ");
        return in.nextLine();
    }

    @Override
    public int getToyProbability() {
        int probability = -1;
        while (probability > 100 || probability < 0) {
            System.out.printf("Вероятность выбора игрушки от 0 до 100: ");
            if (!in.hasNextLine()) {
                System.out.println("Ошибка: поток ввода закрыт");
                return -1;
            }
            try {
                probability = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 0 до 100");
            }
        }
        return probability;
    }

    @Override
    public void setToyName() {

    }

    @Override
    public void setToyProbability() {

    }

    @Override
    public void setToyName(String value) {
        System.out.printf("Игрушка: %s\n", value);

    }

    @Override
    public void setToyProbability(int value) {
        System.out.printf("Вероятность выбора: %d\n", value);

    }
}
