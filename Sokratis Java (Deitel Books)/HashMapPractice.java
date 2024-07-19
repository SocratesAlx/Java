import java.util.HashMap;

public class HashMapPractice {

    public static void main(String[] args)

    {


    // HashMap implements the Map interface (need import)
    // HashMap is similar to ArrayList, but with key-value pairs
    // stores objects, need to use Wrapper Class
    // ex: (name,email), (username,userID), (country,capital)

    HashMap<String,String> countries = new HashMap<String,String>();    // The <String,String> after hashmap means we will be using string for countries/capital. Can change to different variables BUT it needs to be worded fully, for example (Interger or Double or Boolean etc...)

    // add a key and value
    countries.put("USA", "Washington DC");
    countries.put("India", "New Dehli");
    countries.put("Russia", "Moscow");
    countries.put("China", "Beijing");


    


    countries.remove("USA"); // Remove something from hashmap using key value. (USA)

    System.out.println(countries);

    System.out.println(countries.get("Russia")); // Print the capital (value) of Russia (key)

    System.out.println(countries.size()); // prints how many key & value pairs are contained in hashmap

    countries.replace("Russia", "Athens"); // replace the capital (value) of russia (key)

    System.out.println(countries);




    // countries.clear();    -   empties hashmap
  
     }

}
