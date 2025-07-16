package mypack;

import java.util.*;

public class Game {

    // setting default list of tributes and all other variables
    String[] tribute_names = {"Tribute0","Tribute1","Tribute2","Tribute3","Tribute4","Tribute5","Tribute6","Tribute7"};
    List<String> living_tributes  = new ArrayList<>(), tributes_to_move = new ArrayList<>();
    Map<String, Tribute> tributes = new HashMap<>();
    Random rand = new Random();
    Tribute current_tribute;
    int current_index, movement_index;
    Arena arena = new Arena();
    String current_key;
    char current_char;
    public int[][] positions;

    //a contains functions for the position arrays
    public boolean array_checker(int[][] a, int[]item) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == item) {
                return true;
            } } return false; }

    public void show_arena() {
        arena.display_reset();
        arena.update_display();
        arena.display_arena();
    }

    // ensuring the positions in the Game and Arena classes match up
    public void positions_sync() {
        positions = new int[8][2];
        for (int i = 0; i < 8; i++) {
            positions[i] = new int[] {tributes.get("Trib_" + Integer.toString(i)).y_position, tributes.get("Trib_" + Integer.toString(i)).x_position};
        } arena.set_tribute_positions(positions); }

    // moving all the tributes and printing the messages
    public void day_cycle() {

        while (tributes_to_move.size() > 0) {
            current_index = rand.nextInt(tributes_to_move.size());
            current_key = tributes_to_move.get(current_index);
            current_tribute = tributes.get(current_key);
            movement_index = rand.nextInt(4);

            if ((movement_index == 0) && (current_tribute.y_position != 0) && (!(array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))))) {
                current_tribute.y_position -= 1;
                positions_sync();
                System.out.println(current_tribute.name + " Heads north");
                tributes_to_move.remove(current_index);

            } else if ((movement_index == 1) && (current_tribute.x_position != 6) && (!(array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))))) { 
                current_tribute.x_position += 1;
                positions_sync(); 
                System.out.println(current_tribute.name + " Heads east");
                tributes_to_move.remove(current_index);

            } else if ((movement_index == 2) && (current_tribute.y_position != 6) && (!(array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))))) { 
                current_tribute.y_position += 1;
                positions_sync();
                System.out.println(current_tribute.name + " Heads south");
                tributes_to_move.remove(current_index);

            } else if ((movement_index == 3) && (current_tribute.x_position != 0) && (!(array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))))) { 
                current_tribute.x_position -= 1;
                positions_sync();
                System.out.println(current_tribute.name + " Heads west");
                tributes_to_move.remove(current_index);

            } else {
                System.out.println(current_tribute.name + " Stays put.");
                tributes_to_move.remove(current_index);
            } } }

    //the actual running
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
        while (!(a)) {
            user_in = s.nextLine();
            if (user_in.trim().equals("y")) {
                a = true;
            } else {
                try {
                tribute_names = user_in.split(",");
                if (tribute_names.length == 8) {a = true;}
            } catch(Exception e) {
                System.out.println("Not a valid input. Try again:");
            } } }

        System.out.println("This is the list of current tributes:");
        for (int i = 0; i < 8; i++) {
           System.out.println(tribute_names[i]); }

        // creating a HashMap of tributes
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
            if (tributes.get(key).alive == true)  {
                living_tributes.add(tributes.get(key).name);
                tributes_to_move.add(key); } }
 
        System.out.println("\nThis is the arena:");
        show_arena();
        day_cycle();
        show_arena();

        s.close();
        }

    public static void main(String[] args) { } 
}
