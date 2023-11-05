package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        printExerciceNumber(1);
        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream()
                .forEach(System.out::println);

        printExerciceNumber(2);
        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(n -> n < 5)
                .forEach(System.out::println);

        printExerciceNumber(3);
        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .limit(3)
                .skip(1)
                .forEach(System.out::println);

        printExerciceNumber(4);
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println(StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .findFirst()
                .orElse(-1));

        printExerciceNumber(5);
        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        printExerciceNumber(6);
        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().toList().contains(user.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);

    }

    private static void printExerciceNumber(int nb) {
        System.out.println(" ");
        System.out.println("********** " + nb + " **********");
    }

}
