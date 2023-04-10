import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HarryPotter implements Contract {

    /**
     * isWalking a boolean that tells if Harry is walking or not
     * isFlying a boolean that tells if Harry is flying or not
     * inventory Hashtable that saves the item name and its availability
     * exp integer that shows Harry's exp
     * xPosition Harry's x position
     * yPosition Harry's y position
     */
    private boolean isWalking;
    private boolean isFlying;
    private Hashtable<String, Boolean> inventory;
    private int exp = 0;
    private double height;
    private int xPosition;
    private int yPosition;

    /**
     * A constructor for making Harry that takes Harry's height and initial x and y position as its parameters
     * @param height Harry's height
     * @param xPosition Harry's initial x position
     * @param yPosition Harry's initial y position
     */
    public HarryPotter(double height, int xPosition, int yPosition) {
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.inventory = new Hashtable<String, Boolean>();
    }

    /**
     * A method that makes Harry walk
     * @param direction the direction that Harry will be walking towards
     * @return isWalking = true 
     * @throws RuntimeException when the method is called while Harry is already walking
     * @throws RuntimeException when the method is called while Harry is flying
     */
    public boolean walk(String direction) {
        if (isFlying == false) {
            System.out.println("Harry is walking towards the " + direction);
            return isWalking = true;
        } if (isWalking == true) {
            throw new RuntimeException("Harry is already walking.");
        } else {
            throw new RuntimeException("Harry can't walk while flying. Must land before walking.");
        }

    }

    /**
     * A method that makes Harry land and increases exp by 20
     * @return isFlying = false
     * @throws RuntimeException when the method is called while Harry is not flying
     */
    public boolean land() {
        if (isFlying == true) {
            System.out.println(
                    "Harry successfully landed on the ground. EXP increased by 20. (enhanced broom flight talent)");
            exp = exp + 20;
            return isFlying = false;
        } else {
            throw new RuntimeException("Harry is not flying.");
        }
    }

    /**
     * A method that makes Harry fly 
     * @param int x Harry's new x position
     * @param int y Harry's new y position
     * @return isFlying = true
     * @throws RuntimeException when the method is called while Harry is already flying
     * @throws RuntimeException when the method is called while Harry is walking
     */
    public boolean fly(int x, int y) {
        if (isWalking == false && isFlying == false) {
            this.xPosition = xPosition + x;
            this.yPosition = yPosition + y;
            System.out.println("Harry is flying. Harry's current position is\nx: " + this.xPosition + "\ny: " + this.yPosition);
            return isFlying = true;
        }
        if (isFlying == true) {
            throw new RuntimeException("Harry is already flying.");
        }
        
        else {
            throw new RuntimeException("Harry can't fly while walking. Must stop walking before flying.");
        }

    }

    /**
     * A method that returns and prints out Harry's current exp
     * @return exp Harry's exp
     */
    public int getEXP() {
        System.out.println("Harry's current EXP is " + exp + ".");
        return exp;
    }

    /**
     * A method that makes Harry grab an item and either save it to inventory or throw it away. Increases exp by 10
     * @param item the item that Harry will grab
     */
    public void grab(String item) {
        System.out.println("Harry grabbed " + item + ". Add to inventory?\nYes/No");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        if (userInput.equals("Yes")) {
            this.inventory.put(item, true);
            System.out.println(item + " has been added to Harry's inventory. EXP increased by 10.");
            exp = exp + 10;
        }
        if (userInput.equals("No")) {
            System.out.println("Harry threw away " + item + ".");
        } else {
            System.out.println("Response must be either Yes or No. Try grabbing the item again.");
        }
    }

    /**
     * A method that allows Harry to drop an item
     * @param item item that Harry will drop
     * @return item that Harry will drop
     * @throws RuntimeException when the item is not in Harry's inventory
     */
    public String drop(String item) {
        if (!this.inventory.containsKey(item)) {
            throw new RuntimeException(item + " is not in Harry's inventory.");
        }
        this.inventory.remove(item);
        System.out.println(item + " removed from Harry's inventory.");
        return item;
    }

    /**
     * A method that allows Harry to examine an item in inventory and increases exp by 10
     * @param item item that Harry will examine
     * @throws RuntimeException when the item is not in inventory
     * @throws RuntimeException when the item is used and currently unavailable
     */
    public void examine(String item) {
        if (this.inventory.isEmpty()) {
            System.out.println("Harry's inventory is empty. There is nothing to examine.");
        }
        if (!this.inventory.containsKey(item)) {
            throw new RuntimeException(item + " is not in Harry's inventory.");
        } else if (this.inventory.get(item) == false) {
            throw new RuntimeException(item + " is used. Consider dropping this item for more inventory space.");
        }
        System.out.println("Harry examined " + item + ". EXP increased by 10. (Gained knowledge)");
        exp = exp + 10;
    }

    /**
     * A method that prints out Harry's inventory
     */
    public void printInventory() {
        System.out.println("=====Inventory=====");
        for (Map.Entry<String, Boolean> inventory : this.inventory.entrySet()) {
            System.out.println("Name: " + inventory.getKey() + "\nAvailability: " + inventory.getValue());
        }
        System.out.println("====================");
    }

    /**
     * A method that makes Harry use an item in inventory
     * @param item item that Harry will use
     * @throws RuntimeException when the item is not in inventory
     * @throws RuntimeException when the item is already used
     */
    public void use(String item) {
        if (!this.inventory.containsKey(item)) {
            throw new RuntimeException(item + " is not in Harry's inventory.");
        } else if (this.inventory.get(item) == false) {
            throw new RuntimeException(item + " is already used. Drop this item for more inventory space.");
        }
        this.inventory.replace(item, true, false);
        System.out.println("Harry used " + item + ".");
    }

    /**
     * A method that makes Harry shrink by 20 cm. Prints out a warning message when Harry is already less than 20 cm.
     * @return Harry's height
     */
    public Number shrink() {
        if (height < 20) {
            System.out.println("Harry is already less than 20 cm. Let's not make Harry disappear!");
            return height;
        } else {
            height = height - 20.0;
            System.out.println("Harry shrank. He is now " + height + "cm tall.");
            return height;
        }

    }

    /**
     * A method that makes Harry grow by 20 cm. 
     * @return Harry's height
     */
    public Number grow() {
        height = height + 20.0;
        System.out.println("Harry grew. He is now " + height + "cm tall.");
        return height;
    }

    /**
     * A method that makes Harry stop walking
     * @throws RuntimeException when the method is called while Harry is not walking
     */
    public void rest() {
        if (isWalking == true) {
            System.out.println("Harry stopped walking.");
            isWalking = false;
        } else {
            throw new RuntimeException("Harry is not walking.");
        }
    }

    /**
     * A method that can either undo Harry walking or flying and increases exp by 20
     * @throws RuntimeException when Harry is not walking 
     * @throws RuntimeException when Harry is not flying 
     */
    public void undo() {
        System.out.println("What would you like to undo? Options: walking/flying");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("walking")) {
            if (isWalking == true) {
                System.out.println("Harry stopped walking.");
                isFlying = false;
            } else {
                throw new RuntimeException("Harry is not walking.");
            }
        }
        if (input.equals("flying")) {
            if (isFlying == true) {
                System.out.println(
                        "Harry successfully landed on the ground. EXP increased by 20. (enhanced broom flight talent)");
                exp = exp + 20;
                isFlying = false;
            } else {
                throw new RuntimeException("Harry is not flying.");
            }
        }

    }


    /**
     * A demonstration of constructing Harry and the use of methods walk(...), rest(), 
     * fly(...), land(), grab(...), use(...), drop(...), examine(...), printInventory(), grow(), shrink(), and getEXP().
     * @param args
     */
    public static void main(String[] args) {
        HarryPotter harry = new HarryPotter(180.0, 0, 0);
        harry.walk("North");
        harry.rest();
        harry.fly(12, 40);
        //harry.fly(0, 0);
        harry.land();
        harry.grab("Bug");
        harry.grab("Pig");
        harry.use("Bug");
        //harry.use("Cat");
        harry.printInventory();
        //harry.drop("Pig");
        harry.examine("Pig");
        //harry.examine("Bug");
        harry.printInventory();
        harry.grow();
        harry.shrink();
        harry.getEXP();

    }
}
