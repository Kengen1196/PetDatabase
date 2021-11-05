public class Pet {
    private int id;
    private String name;
    private int age;

    public Pet(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}