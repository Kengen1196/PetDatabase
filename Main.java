import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables used throughout the program
        Scanner input = new Scanner(System.in);
        PetDatabase database = new PetDatabase();
        int choice;
        boolean loop = true;
        String key;
        String[] line;
        String name;
        int age;
        int id;
        // Opening message
        System.out.println("Pet Database Program");
        // Loops until it is changed
        while (loop) {
            // Menu options
            System.out.println(
                    "What would you like to do?\n1) View all pets\n2) Add more pets\n3)Update an exitsing pet\n4) Remove an existing pet\n5) Search pets by name\n6) Search pets by age\n7) Exit program");
            // Allows user to easily see their input
            System.out.print("Your Choice: ");
            // Used in the switch
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
            // Views entire array
            case 1:
                database.viewPets();
                break;
            // Adds pet to array
            case 2:
                System.out.print("Add pet ie. name age: ");
                // split input line by space as it is assumed both are given
                line = input.nextLine().split(" ");
                name = line[0];
                age = Integer.valueOf(line[1]);
                database.addPets(name, age);
                break;
            // Updates pet in array
            case 3:
                System.out.print("Enter the pet ID you want to update: ");
                id = input.nextInt();
                input.nextLine();
                System.out.print("Enter new name and new age: ");
                // split input line by space as it is assumed both are given
                line = input.nextLine().split(" ");
                name = line[0];
                age = Integer.valueOf(line[1]);
                database.updatePet(id, name, age);
                break;
            // Removes pet in array
            case 4:
                System.out.print("Enter the pet ID you want to remove: ");
                id = input.nextInt();
                input.nextLine();
                database.removePet(id);
                // Search pet by name
            case 5:
                System.out.print("Enter a name to search: ");
                key = input.nextLine().toLowerCase();
                database.findPets(0, key);
                break;
            // Search pet by age
            case 6:
                System.out.print("Enter an age to search: ");
                key = input.nextLine();
                database.findPets(1, key);
                break;
            // Exits program
            case 7:
                loop = false;
            }
        }
        input.close();
    }
}