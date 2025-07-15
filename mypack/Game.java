package mypack;

import java.util.*;

public class Game {
 
    // set default list of tribute names
    static String[] tribute_names = {"Tribute0","Tribute1","Tribute2","Tribute3","Tribute4","Tribute5","Tribute6","Tribute7"};
    static List<String> living_tributes = new ArrayList<>();
    static List<String> tributes_to_move = new ArrayList<>();

    public void run() {

         //initial text
        System.out.println("This is the list of current tributes:");
        for (int i = 0; i < 8; i++) {
            System.out.println(tribute_names[i]);
        } System.out.println("If you want to change them, input your list of 8 comma-separated names. If not, input 'y'");

        // some variable declarations
        Scanner s = new Scanner(System.in);
        String user_in;

        //analysing and validating user input
        boolean a = false;
        while (!(a));
            user_in = s.nextLine();
            if (user_in == "y") {
                a = true;
            } else {
                try {
                tribute_names = user_in.split(",");
                if (tribute_names.length == 8) {a = true;}
            } catch(Exception e) {
                System.out.println("Not a valid input. Try again:");
            } } 

        System.out.println("This is the list of current tributes:");
        for (int i = 0; i < 8; i++) {
           System.out.println(tribute_names[i]); }

        // creating a HashMap of tributes
        Map<String, Tribute> tributes = new HashMap<>();
        tributes.put("Trib_0", new Tribute(tribute_names[0], 2, 3 ));
        tributes.put("Trib_1", new Tribute(tribute_names[1], 2, 2 ));
        tributes.put("Trib_2", new Tribute(tribute_names[2], 3, 2 ));
        tributes.put("Trib_3", new Tribute(tribute_names[3], 4, 2 ));
        tributes.put("Trib_4", new Tribute(tribute_names[4], 4, 3 ));
        tributes.put("Trib_5", new Tribute(tribute_names[5], 4, 4 ));
        tributes.put("Trib_6", new Tribute(tribute_names[6], 3, 4 ));
        tributes.put("Trib_7", new Tribute(tribute_names[7], 2, 4 ));

        // adding the names of each tribute to the living_tributes and tributes_to_move list
        for (String key : tributes.keySet()) {
            if (tributes.get(key).alive == true) {living_tributes.add(tributes.get(key).name);}
            tributes_to_move.add(key);




        }



        Arena arena = new Arena();

        








        s.close();
        }

    

    public static void main(String[] args) { } 
}
