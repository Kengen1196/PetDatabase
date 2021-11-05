import java.util.ArrayList;

public class PetDatabase {
    private ArrayList<Pet> petArray;

    public PetDatabase() {
        petArray = new ArrayList<Pet>();
    }

    public void viewPets() {
        System.out.println("+------------------+");
        System.out.println("|ID |NAME      |AGE|");
        System.out.println("+------------------+");
        for (int i = 0; i < petArray.size(); i++) {
            System.out.println("|" + String.format("%-3d", petArray.get(i).getID()) + "|"
                    + String.format("%-10s", petArray.get(i).getName()) + "|"
                    + String.format("%-4d", petArray.get(i).getAge()) + "|");
        }
        System.out.println("+------------------+");
        System.out.println(petArray.size() + " rows in set.");
    }

    public void addPets(String name, int age) {
        petArray.add(new Pet(petArray.size(), name, age));
    }
}
