
/**
 * @author vostoc
 * @version 1.0
 * @since domingo, 2023-03-26 12:22
 */

public class User {

    private String firstName;
    private String lastName;
    private int age;


    public User(String firstName, String lastName, int age) {

        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.age = age;

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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
