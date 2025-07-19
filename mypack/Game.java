package mypack;

import java.util.*;

public class Game {

    // setting default list of tributes and all other variables
    String[] tribute_names = {"Tribute0","Tribute1","Tribute2","Tribute3","Tribute4","Tribute5","Tribute6","Tribute7"};
    List<String> living_tributes  = new ArrayList<>(), tributes_to_move = new ArrayList<>();
    Map<String, Tribute> tributes = new HashMap<>();
    Random rand = new Random();
    Tribute current_tribute, winner;
    int current_index, movement_index, not_meet = 0;
    Arena arena = new Arena();
    String current_key;
    char current_char;
    int[][] positions = new int[8][2];
    Tribute[] collision_list = new Tribute[2];
    boolean encounter;
    boolean[] l = new boolean[8];
    

    //a contains functions for the position arrays
    public boolean array_checker(int[][] a, int[]item) {
        for (int i = 0; i < a.length; i++) {
            if (Arrays.equals(a[i], item)) {
                return true;
            } } return false; }

    public void show_arena() {

        for (int i = 0; i < 8; i++) {
            if (tributes.get("Trib_" + Integer.toString(i)).alive == true) {
                l[i] = true;
            } else {
                l[i] = false; } }

        arena.display_reset();
        arena.update_display(l);
        arena.display_arena();
    }

    // ensuring the positions in the Game and Arena classes match up
    public void positions_sync() {
        for (int i = 0; i < 8; i++) {
            positions[i] = new int[] {tributes.get("Trib_" + Integer.toString(i)).y_position, tributes.get("Trib_" + Integer.toString(i)).x_position};
        } arena.set_tribute_positions(positions); }

    public void collision(Tribute t) {

        int[] tile = {t.y_position, t.x_position};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (Arrays.equals(positions[i], tile)) {
                collision_list[count] = tributes.get("Trib_" + Integer.toString(i));
                count += 1; } }

        int who_dies = rand.nextInt(2);
        if (who_dies == 1) {
            System.out.println(collision_list[0].name + " encounters and kills " + collision_list[1].name);
            collision_list[1].alive = false;
            collision_list[1].x_position = 10;
            collision_list[1].y_position = not_meet;
            not_meet += 1;
            positions_sync();

        } else {
            System.out.println(collision_list[1].name + " encounters and kills " + collision_list[0].name);
            collision_list[0].alive = false;
            collision_list[0].x_position = 10;
            collision_list[0].y_position = not_meet;
            not_meet += 1;
            positions_sync();
        }
    }

    // moving all the tributes and printing the messages
    public void day_cycle() {

        while (tributes_to_move.size() > 0) {

            current_index = rand.nextInt(tributes_to_move.size());
            current_key = tributes_to_move.get(current_index);
            current_tribute = tributes.get(current_key);

            if (current_tribute.alive) {

                if (tributes_to_move.size() == 1) {movement_index = 4;}
                else {movement_index = rand.nextInt(4);}
                encounter = false;

                if ((movement_index == 0) && (current_tribute.y_position != 0)) {
                     current_tribute.y_position -= 1;

                    if (array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))) {
                        encounter = true; }

                    positions_sync();
                    System.out.println(current_tribute.name + " heads north");
                    tributes_to_move.remove(current_index);

                } else if ((movement_index == 1) && (current_tribute.x_position != 6)) { 
                    current_tribute.x_position += 1;

                    if (array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))) {
                        encounter = true; }

                    positions_sync(); 
                    System.out.println(current_tribute.name + " heads east");
                    tributes_to_move.remove(current_index);

                } else if ((movement_index == 2) && (current_tribute.y_position != 6)) { 
                    current_tribute.y_position += 1;

                    if (array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))) {
                        encounter = true; }

                    positions_sync();
                    System.out.println(current_tribute.name + " heads south");
                    tributes_to_move.remove(current_index);

                } else if ((movement_index == 3) && (current_tribute.x_position != 0)) { 
                    current_tribute.x_position -= 1;

                    if (array_checker(arena.tribute_positions, (new int[] {current_tribute.y_position,current_tribute.x_position}))) {
                        encounter = true; }

                    positions_sync();
                    System.out.println(current_tribute.name + " heads west");
                    tributes_to_move.remove(current_index);

                } else {
                    System.out.println(current_tribute.name + " stays put.");
                    tributes_to_move.remove(current_index); } 

                if (encounter) {collision(current_tribute);} }
            else {tributes_to_move.remove(current_index); }
        } }

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
        System.out.println("enter y to start the games:");
        boolean proceed = false;
        user_in = s.nextLine();

        while (!(proceed)) {
            if (user_in.trim().equals("y")) {
                proceed = true;
            } else {
                System.out.println("Not a valid input. Try again:");
                user_in = s.nextLine(); }
        }

        while (living_tributes.size() > 1) {
        living_tributes.clear();
        tributes_to_move.clear();

        for (String key : tributes.keySet()) {
            if (tributes.get(key).alive == true)  {
                living_tributes.add(tributes.get(key).name);
                tributes_to_move.add(key); } }

        System.out.println("This is the list of living tributes:");
        for (int i = 0; i < living_tributes.size(); i++) {
           System.out.println(living_tributes.get(i)); }

        day_cycle();
        System.out.println("\nThis is the arena:");
        show_arena();

        System.out.println("enter y to continue:");
        proceed = false;
        user_in = s.nextLine();

        while (!(proceed)) {
            if (user_in.trim().equals("y")) {
                proceed = true;
            } else {
                System.out.println("Not a valid input. Try again:");
                user_in = s.nextLine(); }
        } }

        s.close();

        }

    public static void main(String[] args) { } 
}
