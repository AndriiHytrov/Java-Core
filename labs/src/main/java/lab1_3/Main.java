package lab1_3;


import lab1_3.reflection.Reflection;

public class Main {

    public static void main(String[] args) {

        Reflection reflection = new Reflection();
        reflection.getHeirClass();
        try {
            reflection.Analyze();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
