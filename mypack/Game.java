package mypack;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    static String[] tribute_names = {"Tribute0","Tribute1","Tribute2","Tribute3","Tribute4","Tribute5","Tribute6","Tribute7"};

    public static void main(String[] args) {
    
        //initial text
        System.out.println("This is the list of current tributes:");
        for (int i = 0; i < 8; i++) {
            System.out.println(tribute_names[i]);
        } System.out.println("If you want to change them, input your list of 8 comma-separated names. If not, input 'y'");

        Scanner user_input = new Scanner(System.in);
        

    }
    
}
