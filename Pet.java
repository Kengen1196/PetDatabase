//Pet class that stores the name and age
public class Pet {
    // Class Variables
    private String name;
    private int age;

    // Required Constructor
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Setters and Getter methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}