import java.util.ArrayList;

public class PetDatabase {
    // ArrayList for simplifying arrays
    private ArrayList<Pet> petArray;

    // Default constructor
    public PetDatabase() {
        petArray = new ArrayList<Pet>();
    }

    // Show entire list of pets
    public void viewPets() {
        // Header
        System.out.println("+-------------------+");
        System.out.println("|ID |NAME      |AGE |");
        System.out.println("+-------------------+");
        // Loops through entire array formatting what was assigned
        for (int i = 0; i < petArray.size(); i++) {
            System.out.println("|" + String.format("%-3d", i) + "|" + String.format("%-10s", petArray.get(i).getName())
                    + "|" + String.format("%-4d", petArray.get(i).getAge()) + "|");
        }
        // Bottom of the table
        System.out.println("+-------------------+");
        System.out.println(petArray.size() + " rows in set.");
    }

    // Adds pet to array and prints the new table
    public void addPets(String name, int age) {
        petArray.add(new Pet(name, age));
        viewPets();
    }

    // Used to find age or name of pet
    public void findPets(int method, String key) {
        // Chose to use a counter rather than a new Arraylist to simplify loops
        int counter = 0;
        // Used only for age as method takes in a String.
        int numKey;
        // Header
        System.out.println("+-------------------+");
        System.out.println("|ID |NAME      |AGE |");
        System.out.println("+-------------------+");
        // Loops through array regardless of sort method
        for (int i = 0; i < petArray.size(); i++) {
            // First sort method is by name
            if (method == 0) {
                // Similar to the previous view loop, but if name matches then it prints
                if (petArray.get(i).getName().toLowerCase().equals(key)) {
                    System.out.println(
                            "|" + String.format("%-3d", i) + "|" + String.format("%-10s", petArray.get(i).getName())
                                    + "|" + String.format("%-4d", petArray.get(i).getAge()) + "|");
                    counter++;
                }
            }
            // Second sort method is by age
            if (method == 1) {
                numKey = Integer.valueOf(key);
                // Similar to the previous view loop, but if age matches then it prints
                if (petArray.get(i).getAge() == numKey) {
                    System.out.println(
                            "|" + String.format("%-3d", i) + "|" + String.format("%-10s", petArray.get(i).getName())
                                    + "|" + String.format("%-4d", petArray.get(i).getAge()) + "|");
                    counter++;
                }
            }
        }
        // Bottom of table
        System.out.println("+------------------+");
        System.out.println(counter + " rows in set.");
    }

    // Update pet method
    public void updatePet(int id, String name, int age) {
        // Only used to print the message as shown in example
        String oldName = petArray.get(id).getName();
        int oldAge = petArray.get(id).getAge();
        // Changes the age and name to the new input and prints new table
        petArray.get(id).setAge(age);
        petArray.get(id).setName(name);
        System.out.println(oldName + " " + oldAge + " changed to " + name + " " + age);
        viewPets();
    }

    // Remove pet method
    public void removePet(int id) {
        // Prints message before removing and shows new table
        System.out.println(id + " " + petArray.get(id).getName() + " " + petArray.get(id).getAge() + " is removed.");
        petArray.remove(id);
        viewPets();
    }
}