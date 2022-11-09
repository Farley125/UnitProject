public class GameMethods {
    private String userName;
    private double critRate;
    private int health;
    private int speed;
    private int strength;
    private int fortitude;
    private int potion;
    private int attackCounter;
    private int playerNumber;
private boolean havePotion;
    public GameMethods (String name, double critRate, int health, int speed, int strength, int fortitude, int potion, int playerNumber) {
        //A constructor with name, stats, and the potion that they may or may not have.
        this.userName = name;
        this.critRate = critRate;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.fortitude = fortitude;
        this.potion = potion;
        this.playerNumber = playerNumber;
        attackCounter = 0;
        havePotion = true;
    }

    public GameMethods (String name, int critRate, int health, int speed, int strength, int fortitude) {
       // Overloaded constructor without the potion (incase they want it disabled)
        userName = name;
        this.critRate = critRate;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.fortitude = fortitude;
        attackCounter = 0;
        havePotion = false;
    }

    public String exchange(String user1, String user2) {
        //Method that'll compare the two given moves and determine the outcome of them.
        if (user1.equals(user2))
        {
            if (user1.equals("a"))
            {

            }
            else
            {

            }
        }
        else if (user1.equals("a") || user2.equals("a"))
        {

        }
    }

    public void setHealth(int newHealth) {
        //Method to set health of user.
        health = newHealth;
    }

    public void consume() {
        //method to consume potion and affect stat associated
        havePotion = false;
        setHealth(health + 50);
    }

    public int damageDone(String attacker, String victim) {
        //will calculate the damage done taking into account victim's defense and attackers strength and crit rate.
        int damage = 30;
        if (victim.equals("d"))
        {
            damage *= .5;
        }
        return damage;
    }

    public boolean gameOver() {
        //will check health of users.

    }
}
