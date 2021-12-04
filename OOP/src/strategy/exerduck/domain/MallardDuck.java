package strategy.exerduck.domain;

import strategy.exerduck.fly.FlyWithWings;
import strategy.exerduck.quack.RealQuack;

/**
 * @author xsj
 * @create 2020-10-19 10:46
 */
public class MallardDuck extends Duck{
    public MallardDuck() {
        quackBehavior = new RealQuack();
        flyBehavior = new FlyWithWings( );
    }

    @Override
    void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
