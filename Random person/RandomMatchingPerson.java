import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class RandomMatchingPerson {
    private String name;
    
    public RandomMatchingPerson(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static RandomMatchingPerson generaRandomPerson(ArrayList<RandomMatchingPerson> person) {
        Random random = new Random();
        if (person.isEmpty()) {
            return null; // Return null if the person array is empty
        }
        int randomIndex = random.nextInt(person.size());
        RandomMatchingPerson randomPerson = person.get(randomIndex);
        person.remove(randomIndex);
        return randomPerson;
    }

    public boolean hasSameName(RandomMatchingPerson otherPerson) {
        return this.name.equals(otherPerson.getName());
    }
    
    public static void main(String[] args) {
        RandomMatchingPerson[] person = new RandomMatchingPerson[10];
        String[] names = {"Jinny", "Best", "Praew", "Fong", "Bobby", "Nice", "Nana" ,"Au", "Aom", "Mark"};
            for (int i = 0; i < names.length; i++) {
                person[i] = new RandomMatchingPerson(names[i]);
            }
        ArrayList<RandomMatchingPerson> randomPerson = new ArrayList<>(Arrays.asList(
            new RandomMatchingPerson("Jinny"), new RandomMatchingPerson("Best"), new RandomMatchingPerson("Praew"),
            new RandomMatchingPerson("Fong"), new RandomMatchingPerson("Bobby"), new RandomMatchingPerson("Nice"),
            new RandomMatchingPerson("Mark"), new RandomMatchingPerson("Nana"), new RandomMatchingPerson("Aom"),
            new RandomMatchingPerson("Au")
    ));
        for(int i = 0 ; i < person.length ; i++){
            RandomMatchingPerson person1 = person[i];
            RandomMatchingPerson person2 = generaRandomPerson(randomPerson);
        
            if(person1 != null && person1.hasSameName(person2)){
            person2 = generaRandomPerson(randomPerson);
            } else if(person1.getName() == "Nana" && person2.getName() == "Fong"){
            person2 = generaRandomPerson(randomPerson);
            }


        System.out.println(person1.getName() + " is matching with " + person2.getName());
        }
    }
}