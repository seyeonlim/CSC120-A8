/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim, Jordan Crouser
 * @version April 10, 2023
 *          Description: An interface where the methods that must be included in HarryPotter class is listed.
 */
public interface Contract {

    /**
     * Make Harry grab an item and either save it to inventory or throw it away
     */
    void grab(String item);
    
    /**
     * Make Harry remove an item from inventory
     * Throw an exception when the item is not in inventory
     */
    String drop(String item);

    /**
     * Make Harry examine an item in inventory
     * Throw an exception when the item is used or doesn't exist in inventory
     */
    void examine(String item);

    /**
     * Make Harry use an item in inventory
     * Throw an exception when the item is already used or doesn't exist in inventory
     */
    void use(String item);

    /**
     * Make Harry walk to a certain direction
     * Throw an exception when harry is already walking or is flying
     */
    boolean walk(String direction);

    /**
     * Make Harry fly to a certain position
     * Throw an exception when Harry is already flying or walking
     */
    boolean fly(int x, int y);

    /**
     * Make Harry shrink by 20 cm
     * Print a warning message when Harry is less than 20 cm tall to prevent Harry from having a negative height
     */
    Number shrink();

    /**
     * Make Harry grow by 20 cm
     */
    Number grow();

    /**
     * Make Harry stop walking
     * Throw an exception when Harry is not walking
     */
    void rest();

    /**
     * Make Harry stop walking or flying
     * Throw an exception when Harry is not walking or flying
     */
    void undo();

}