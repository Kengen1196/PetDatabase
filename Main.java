import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pet Database Program");
        Scanner input = new Scanner(System.in);
        PetDatabase database = new PetDatabase();
        int choice;
        boolean loop = true;
        while (loop) {
            System.out.println("What would you like to do?\n1) View all pets\n2) Add more pets\n7)Exit program");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
            case 1:
                database.viewPets();
                break;
            case 2:
                String[] line;
                String name;
                int age;
                System.out.println("add pet (name, age)");
                line = input.nextLine().split(" ");
                name = line[0];
                age = Integer.valueOf(line[1]);
                database.addPets(name, age);
                break;
            case 7:
                loop = false;
                break;
            }
        }
        input.close();
    }
}
