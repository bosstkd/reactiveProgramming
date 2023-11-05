package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        var numbers = ReactiveSources.intNumbersFlux()
                .log()
                .toStream()
                .toList();
        System.out.println("List is : " + numbers);
        System.out.println("List size : " + numbers.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
