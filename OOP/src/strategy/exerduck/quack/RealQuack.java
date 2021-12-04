package strategy.exerduck.quack;

/**
 * @author xsj
 * @create 2020-10-19 10:30
 */
public class RealQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("I am a real duck");
    }
}
