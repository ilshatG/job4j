package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class MapExploring {


    public static void main(String... args) {
        withHashCode();
    }

    static void withHashCode() {
        User dostoevskiy = new User("Федор");
        User shalyapin = new User("Федор Ш");

        HashTableArray<User, String> celebrities = new HashTableArray<>();

        celebrities.insert(dostoevskiy, "Федор Достоевский");
        celebrities.insert(shalyapin, "Федор Шаляпин");

        System.out.println(celebrities);

        System.out.println("dostoevskiy hashCode " + String.format("0x%08X", dostoevskiy.hashCode()));
        System.out.println("shalyapin hashCode " + String.format("0x%08X", shalyapin.hashCode()));

        System.out.println("Equality dostoevskiy is " + dostoevskiy.equals(shalyapin));
        System.out.println("Equality shalyapin is " + shalyapin.equals(dostoevskiy));

        System.out.println(celebrities.get(shalyapin));
        System.out.println(celebrities.get(dostoevskiy));
    }
}
/*        System.out.println("dostoevskiy IdentityHashCode " + String.format("0x%08X", System.identityHashCode(dostoevskiy)));
        System.out.println("shalyapin IdentityHashCode " + String.format("0x%08X", System.identityHashCode(shalyapin)));
*/