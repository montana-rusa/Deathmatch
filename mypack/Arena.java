package mypack;

public class Arena {

    // initializes the arena_display and tribute_positions variable
    public char[][] arena_display;
    public int[][] tribute_positions = {{2,3},{2,2},{3,2},{4,2},{4,3},{4,4},{3,4},{2,4}};

    //constructor method
    public Arena() {
        arena_display = new char[7][7]; }
        
    public void display_reset() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arena_display[i][j] = '-';
            } } }

    public void set_tribute_positions(int[][] new_places) {
        for (int i = 0; i < 8; i++) {
        tribute_positions[i] = new_places[i]; } }

    public void update_display() {
        for (int i = 0; i < 8; i++) {
            int temp_y = tribute_positions[i][0];
            int temp_x = tribute_positions[i][1];
            arena_display[temp_y][temp_x] = (char) (i + '0');
        } }

    public void display_arena() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(arena_display[i][j]);
            } System.out.print("\n");
        } } } 
