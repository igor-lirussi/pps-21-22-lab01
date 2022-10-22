package lab01.tdd;

public class MultipleOfStrategy implements SelectStrategy {

    int num = 0;

    public MultipleOfStrategy(int num){
        this.num = num;
    }

    @Override
    public boolean apply(int element) {
        return element%this.num==0;
    }
}
