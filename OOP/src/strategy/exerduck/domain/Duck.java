package strategy.exerduck.domain;

import strategy.exerduck.fly.FlyBehavior;
import strategy.exerduck.quack.QuackBehavior;

/**
 * @author xsj
 * @create 2020-10-19 10:25
 */
public abstract class Duck {
     FlyBehavior flyBehavior;
     QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    abstract void display();
    // Duck对象不再直接飞了，而是将这种行为委托（delegate）给相关行为对象，
// 由后者负责处理
    public void performFly( ) {
        flyBehavior.fly( );
    }

    // Duck对象不再直接嘎嘎叫了，而是将这种行为委托（delegate）给相关行为
// 对象，由后者负责处理
    public void performQuack( ) {
        quackBehavior.quack( );
    }

    public void swim( ) {
        System.out.println("All ducks float, even decoys!");
    }
}


