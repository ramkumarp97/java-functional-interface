package main.java.optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional.ofNullable(null)
                .ifPresentOrElse(e-> System.out.println("value present "+e), ()-> System.out.println("Value null"));
    }
}

