package strategy.exerduck.fly;

/**
 * @author xsj
 * @create 2020-10-19 10:29
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
