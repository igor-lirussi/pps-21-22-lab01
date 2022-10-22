package lab01.tdd;

public class EqualsStrategy implements SelectStrategy {
    int num = 0;

    public EqualsStrategy(int num){
        this.num = num;
    }

    @Override
    public boolean apply(int element) {
        return element==this.num;
    }
}
