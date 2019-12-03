package Chapter1Beginning;

/*
* 1 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。
* 2 针对接口编程，而不是针对实现编程
* 3 多用组合，少用继承
*
* */

public class DuckGame {
    public static void main(String[] args) {
        Duck duck = new MallarDuck();
        duck.fly.fly();
        duck.iQuack.quack();
    }
}


class Duck{
    IFly fly;
    IQuack iQuack;
    Duck(){

    }

}

class MallarDuck extends Duck{
    MallarDuck(){
        fly = new FlyWithSwing();
        iQuack = new MuteQuack();
    }
}


interface IFly{
    void fly();
}

interface IQuack{
    void quack();
}

class FlyNoWay implements IFly{
    @Override
    public void fly() {
        System.out.println("I cann't fly!");
    }
}

class FlyWithSwing implements IFly{
    @Override
    public void fly() {
        System.out.println("I can fly with my Swing!");
    }
}

class Quack implements IQuack{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

class MuteQuack implements IQuack{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}