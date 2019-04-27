package pl.umcs;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        PersonIdentifier personIdentifier = PersonIdentifier.builder()
                .firstName("Tomek")
                .surName("Kowalski")
                .pesel("93052412342")
                .build();

        System.out.println(personIdentifier);
    }
}
