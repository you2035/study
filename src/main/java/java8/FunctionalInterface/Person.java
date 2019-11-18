package java8.FunctionalInterface;

public class Person {
    private String firstName;
    private String lastName;
    Person() {}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person p = personFactory.createPerson("Peter", "Parker");

        System.out.println(p.getFirstName()+" "+p.getLastName());

    }
}
