package Criacionais.Singleton.Exemplo;

class Singleton {
    private static Singleton instance;
    private int value;

    private Singleton() {
        this.value = 0;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void increment() {
        value += 1;
        System.out.println("Value: " + value);
    }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);

        s1.increment();
        s2.increment();
    }
}