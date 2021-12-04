package strategy.exerduck.domain;

/**
 * @author xsj
 * @create 2020-10-19 10:48
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        RobbuerDuck robbuerDuck = new RobbuerDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.display();
        System.out.println("-------------");
        robbuerDuck.performQuack();
        robbuerDuck.performFly();
        robbuerDuck.display();
    }
}
