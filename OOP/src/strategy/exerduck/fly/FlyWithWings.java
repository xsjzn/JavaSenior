package strategy.exerduck.fly;

/**
 * @author xsj
 * @create 2020-10-19 10:28
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
