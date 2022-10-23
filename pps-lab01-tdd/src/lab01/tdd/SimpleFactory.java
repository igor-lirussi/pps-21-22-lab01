package lab01.tdd;

public class SimpleFactory implements SelectFactory {
    @Override
    public SelectStrategy createEvenStrategy() {
        return element -> element % 2 == 0;
        // instead of  return new EvenStrategy();
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int number) {
        return element -> element % number == 0;
        // instead of  return new MultipleOfStrategy(number);
    }

    @Override
    public SelectStrategy createEqualsStrategy(int number) {
        return element -> element == number;
        // instead of  return new EqualsStrategy(number);
    }
}
