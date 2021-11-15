import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        // if the list is under 5 and the ages are between 1 and 20 it will proceed
        if (petArray.size() < 5 && age > 0 && age <= 20) {
            petArray.add(new Pet(name, age));
            // Prints messages otherwise indicating why it failed
        } else {
            if (petArray.size() >= 5) {
                System.out.println("Database is full!");
            }
            if (age < 0 || age > 20) {
                System.out.println("That is not a valid age!");
            }
        }
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
        // Changes the age and name to the new input and prints new table
        if (id >= 0 && id < petArray.size() && age <= 20 && age > 0) {
            // Only used to print the message as shown in example
            String oldName = petArray.get(id).getName();
            int oldAge = petArray.get(id).getAge();
            petArray.get(id).setAge(age);
            petArray.get(id).setName(name);
            System.out.println(oldName + " " + oldAge + " changed to " + name + " " + age);
        } else {
            if (id < 0 || id >= petArray.size()) {
                System.out.println("ID does not exist!");
            }
            if (age < 1 || age > 20) {
                System.out.println("That is not a valid age!");
            }
        }
        viewPets();
    }

    // Remove pet method
    public void removePet(int id) {
        // Prints message before removing and shows new table
        // If id is within the contraints it will proceed
        if (id >= 0 && id < petArray.size()) {
            System.out
                    .println(id + " " + petArray.get(id).getName() + " " + petArray.get(id).getAge() + " is removed.");
            petArray.remove(id);
            // else it prints the message why it does not work
        } else {
            System.out.println("That is not a valid ID!");
        }
        viewPets();
    }

    public boolean save(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);// writes to the file
            String newString = "";// used to store the line to be written
            for (int i = 0; i < petArray.size(); i++) {// loops through entire array
                newString = petArray.get(i).getName() + "," + petArray.get(i).getAge();// combines age and name in one
                                                                                       // line separated by comma
                writer.write(newString + "\n");// writes to the new file
            }
            writer.close();
            System.out.println("Pet Data Saved");
            return true;
        } catch (IOException e) {// File Exception
            System.out.println("An error occured.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean load(String filename) {
        petArray = new ArrayList<Pet>();// creates a new array
        String[] splitLine;// used to separate the String objects
        Pet tempPet;
        try {
            File inputFile = new File(filename);// creates an instance of the file
            Scanner reader = new Scanner(inputFile);// reads the file
            while (reader.hasNextLine()) {
                splitLine = reader.nextLine().split(",");// splits the string on commas
                tempPet = new Pet(splitLine[0], Integer.valueOf(splitLine[1]));// instantiates a pet
                petArray.add(tempPet);// inserts new pet
            }
            System.out.println("Pet Data Loaded");
            reader.close();
            return true;
        } catch (FileNotFoundException e) {// File Error
            e.printStackTrace();
            return false;
        }
    }
}