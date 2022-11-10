public class GameMethods {
    private String userName;
    private String artifact;
    private double critRate;
    private double evadeChance;
    private int health;
    private int speed;
    private int strength;
    private int fortitude;
    private int potion;
    private int attackCounter;
    private int playerNumber;
    private int allocatableStat;
private boolean havePotion;
    public GameMethods (String name, String artifact, double critRate, int health, int speed, int strength, int fortitude, int potion, int playerNumber) {
        //A constructor with name, stats, and the potion that they may or may not have.
        this.userName = name;
        this.artifact = artifact;
        this.critRate = critRate;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.fortitude = fortitude;
        this.potion = potion;
        this.playerNumber = playerNumber;
        attackCounter = 0;
        allocatableStat = 5;
        evadeChance = .05;
        havePotion = true;
    }

    public GameMethods (String name, double critRate, int health, int speed, int strength, int fortitude, String artifact, int playerNumber) {
       // Overloaded constructor without the potion (incase they want it disabled)
        userName = name;
        this.critRate = critRate;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.fortitude = fortitude;
        this.artifact = artifact;
        attackCounter = 0;
        evadeChance = .05;
        allocatableStat = 5;
        havePotion = false;
    }

    public GameMethods (){
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
        return "my nuts";
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
return true;
    }

    public void statAdjust() {
        if (artifact.equals("a")) {
            strength++;
        } else if (artifact.equals("d")) {
            critRate += .10;
        } else if (artifact.equals("w")) {
            evadeChance += .10;
            speed ++;
        } else if (artifact.equals("v")) {
            fortitude++;
            health += 20;
        }
    }

    public void pointAlloc(int strength, int speed, int fortitude)
    {
        this.strength += strength;
        this.speed += speed;
        evadeChance += (.5 * speed);
        this.fortitude += fortitude;
        health += (20 * (this.fortitude-1));
    }

    public void infoPrint()
    {
        System.out.println ("user: " + userName);
        System.out.println ("critRate: " + critRate);
        System.out.println ("health: " + health);
        System.out.println ("speed: " + speed);
        System.out.println ("strength: " + strength);
        System.out.println ("fortitude: " + fortitude);
        System.out.println ("potions: " + potion);
        System.out.println ("playerNumber: " + playerNumber);
        System.out.println ("");
    }
}
