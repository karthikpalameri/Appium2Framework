package learn.designpattern;

class SingletonEager {
    private static SingletonEager instance = new SingletonEager();//1.make instance static

    private SingletonEager() { //2.make constructor private so no once can initialize
    }

    public static SingletonEager getInstance() { //3.make the getter static
        return instance;
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonSyncronizedMethod {
    private SingletonSyncronizedMethod() {
    }

    private static SingletonSyncronizedMethod instance;

    public synchronized SingletonSyncronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSyncronizedMethod();
        }
        return instance;
    }
}

class SingletonSynchronized {
    private SingletonSynchronized() {
    }

    private static SingletonSynchronized instance;

    public static SingletonSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null)
                    instance = new SingletonSynchronized();
            }
        }
        return instance;
    }
}

public class SigletonDesignPatternExample {
    public static void main(String[] args) {
        SingletonEager instance = SingletonEager.getInstance(); //

        Singleton instance1 = Singleton.getInstance();
        System.out.println("instance1 = " + instance1);
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance2 = " + instance2);

        SingletonSynchronized instance3 = SingletonSynchronized.getInstance();
        System.out.println("instance3 = " + instance3);
        SingletonSynchronized instance4 = SingletonSynchronized.getInstance();
        System.out.println("instance4 = " + instance4);


    }

}
