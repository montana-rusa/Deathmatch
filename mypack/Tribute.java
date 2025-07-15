package mypack;

public class Tribute {

    // the tribute is always initially alive
    public boolean alive = true;

    // the name, x_position, and y_position are set when an instance is created
    public String name;
    public int x_position;
    public int y_position;
    
    // constructor method
    Tribute(String name, int x_position, int y_position) {
    this.name = name;
    this.x_position = x_position;
    this.y_position = y_position; 
    }

    // updates the tribute's position in the arena
    public void update_position(int new_x, int new_y) {
        this.x_position = new_x;
        this.y_position = new_y;
    } } 
