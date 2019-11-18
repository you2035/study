package java8.FunctionalInterface;

public interface PersonFactory<P extends Person> {
    P createPerson(String firstName, String lastName);
}
