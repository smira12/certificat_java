import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyBox {
    private List<Toy> toys = new ArrayList<>();
    private Random random = new Random();

    public void putToy(Toy toy) {
        toys.add(toy);
    }

    public int getToy() {
        int totalProbability = toys.stream().mapToInt(toy -> toy.getProbability()).sum();
        int value = random.nextInt(totalProbability);
        for (Toy toy : toys) {
            value -= toy.getProbability();
            if (value < 0) {
                return toy.getId();
            }
        }
        return -1;
    }
}
