package strategy.exerduck.quack;

/**
 * @author xsj
 * @create 2020-10-19 10:31
 */
public class QuackWithTrumpet implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quack with trumpet");
    }
}
