package strategy.exerduck.domain;

import strategy.exerduck.fly.FlyNoWay;
import strategy.exerduck.quack.QuackWithTrumpet;

/**
 * @author xsj
 * @create 2020-10-19 10:46
 */
public class RobbuerDuck extends Duck{
    public RobbuerDuck() {
        quackBehavior = new QuackWithTrumpet();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("I'm a Robbuer duck");
    }
}
