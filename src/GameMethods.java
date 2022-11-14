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
    private int allocatableStat;
    private boolean isStun;
    public GameMethods (String name, String artifact, double critRate, int health, int speed, int strength, int fortitude, int potion) {
        //A constructor with name, stats, and the potion that they may or may not have.
        this.userName = name;
        this.artifact = artifact;
        this.critRate = critRate;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.fortitude = fortitude;
        this.potion = potion;
        isStun = false;
        attackCounter = 0;
        allocatableStat = 5;
        evadeChance = .05;
    }

    public GameMethods (String name, double critRate, int health, int speed, int strength, int fortitude, String artifact) {
       // Overloaded constructor without the potion (incase they want it disabled)
        userName = name;
        this.critRate = critRate;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.fortitude = fortitude;
        this.artifact = artifact;
        isStun = false;
        attackCounter = 0;
        evadeChance = .05;
        allocatableStat = 5;
    }

    public GameMethods (){
    }

    public int exchange(String attacker, int baseDamage, String victim) {
        //Method that'll compare the two given moves and determine the outcome of them.
        if (attacker.equals("c")) {
            if (potion > 0) {
                consume();
                System.out.println("You reach into your bag and pull out a potion! + 50 Health! \n [You have " + potion + " potion(s)]");
            }
            else {
                System.out.println("You reach into your bag and pull out nothing! [You have 0 potions]");
                return 0;
            }
        }
        if (attacker.equals("p") && victim.equals("a") == false) {
            isStun = true;
                System.out.println("You ready yourself for an attack that never came, your rhythm was broken! \n You've been stunned.");
                return 0;
        }
        if (attacker.equals("a") && victim.equals("d")){
            return (int) (Math.ceil((double)baseDamage/5));
        }
        return 0;
    }

    public void setHealth(int newHealth) {
        //Method to set health of user.
        health = newHealth;
    }
    public int getDamage(){
        return strength * 5;
    }

    public void consume() {
        //method to consume potion and affect stat associated
        potion--;
        setHealth(health + 50);
    }

    public boolean gameOver() {
        //will check health of users.
        if (health <= 0)
        {
            return true;
        }
        else return false;
    }

    public void statAdjust() {
        if (artifact.equals("a")) {
            strength += 2;
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
        health += (40 * this.fortitude);
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
        System.out.println ("");
    }
}
