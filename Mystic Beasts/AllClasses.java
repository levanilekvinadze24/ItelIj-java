package fop.w8mystic;

/*
 * Animal could also be defined as interface of which Flyable and FireBreathable
 * inherit.
 * By that, Flyable would be restricted to animals and could not be used for modeling,
 * e.g., aeroplanes; the best choice thus depends on the application.
 */
public abstract class Animal {
    public abstract String getClassName();

    public void eat() {
        System.out.println(getClassName() + " eats.");
    }
}

package fop.w8mystic;

public class Dragon extends Animal implements Flyable, FireBreathable {
    @Override
    public String getClassName() {
        return "Dragon";
    }
}

package fop.w8mystic;

public interface FireBreathable {
    public String getClassName();
    
    public default void breathFire() {
        System.out.println(getClassName() + " breathes fire.");
    }
}

package fop.w8mystic;

public interface Flyable {
    public String getClassName();
    
    public default void fly() {
        System.out.println(getClassName() + " flies.");
    }
}

package fop.w8mystic;

public class Monster extends Animal implements FireBreathable {
    @Override
    public String getClassName() {
        return "Monster";
    }
}

package fop.w8mystic;

public class Penguin extends Animal {
    @Override
    public String getClassName() {
        return "Penguin";
    }
}

package fop.w8mystic;

public class Pigeon extends Animal implements Flyable {
    @Override
    public String getClassName() {
        return "Pigeon";
    }

}

package fop.w8mystic;

public abstract class SimpleAnimal {
    public abstract void eat();
}

package fop.w8mystic;

public class SimpleDragon extends SimpleAnimal implements SimpleFlyable, SimpleFireBreathable {
    @Override
    public void breathFire() {
        System.out.println("Dragon breathes fire.");
    }

    @Override
    public void fly() {
        System.out.println("Dragon flies.");
    }

    @Override
    public void eat() {
        System.out.println("Dragon eats.");
    }

}

package fop.w8mystic;

public interface SimpleFireBreathable {
    public void breathFire();
}

package fop.w8mystic;

public interface SimpleFlyable {
    public void fly();
}

package fop.w8mystic;

public interface SimpleFlyable {
    public void fly();
}

package fop.w8mystic;

public class SimplePenguin extends SimpleAnimal {
    @Override
    public void eat() {
        System.out.println("Penguin eats.");
    }
}

package fop.w8mystic;

public class SimplePigeon extends SimpleAnimal implements SimpleFlyable {
    @Override
    public void fly() {
        System.out.println("Pigeon flies.");
    }

    @Override
    public void eat() {
        System.out.println("Pigeon eats.");
    }

}