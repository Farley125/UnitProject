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

    public int exchange(String attacker, String victim) {
        //Method that'll compare the two given moves and determine the outcome of them.
        int baseDamage = (strength * 5) + 10;
        if (attacker.equals(""))
        {
            return 0;
        }
        if (attacker.equals("a")) {
            attackCounter++;
        } else {
            if (attackCounter > 0) {
                attackCounter--;
            }
        }
        if (attacker.equals("c")) {
            if (potion > 0) {
                consume();
            }
            else {
                return 0;
            }
        }
        if (attacker.equals("p") && victim.equals("a") == false) {
            isStun = true;
            return 0;
        } else if (attacker.equals("p") && victim.equals("a")) {
            return 0;
        }
        if (attacker.equals("a") && victim.equals("p")) {
            isStun = true;
            return 0;
        }
        if (attacker.equals("a") && victim.equals("d")) {
            double crit = Math.random();
            if (crit < critRate) {
                return (baseDamage / 3) * 2;
            }
            return baseDamage / 3;
        } else if (attacker.equals("d")) {
            return 0;
        }
        return baseDamage;
    }

    public void outcomeMessage(String attacker, String victim) {
        int baseDamage = (strength*5) + 25;
        if (attacker.equals("c")) {
            if (potion > 0) {
                System.out.println("You reach into your bag and pull out a potion! + 50 Health! \n[You have " + potion + " potion(s)]\n");
            }
            else {
                System.out.println("You reach into your bag and pull out nothing! [You have 0 potions]\n");
            }
        }
        else if (attacker.equals("p") && victim.equals("a") == false) {
            System.out.println("You ready yourself for an attack that never came, your posture was disrupted! \nYou've been stunned.\n");
        } else if (attacker.equals("p") && victim.equals("a")) {
            System.out.println("You parried their blow!");
        }
        else if (attacker.equals("a") && victim.equals("d")){
            double crit = Math.random();
            if (crit < critRate)
            {
               System.out.println("You strike a defending opponent, but it was a critical! (You deal " + (baseDamage/3)*2 + " damage)\n");
            }
            else System.out.println("You strike a defending opponent. (You deal " + (baseDamage/3) + " damage)\n");
        }
        else if (attacker.equals("a") && victim.equals("p")) {
            System.out.println("Your blow was parried, you were thrown off balance. \nYou've been stunned.\n");
        }
        else if (attacker.equals("d")) {
            System.out.println("You ready your shield.\n");
        } else if (attacker.equals(""))
        {
            System.out.println("You're unable to move.\n");
        }
        else System.out.println("You strike your opponent. (You deal " + (baseDamage) + " damage)\n");
    }

    public void setHealth(int newHealth) {
        //Method to set health of user.
        health = newHealth;
    }
    public int getHealth(){
        return health;
    }

    public void consume() {
        //method to consume potion and affect stat associated
        potion--;
        setHealth(health + 50);
    }

    public boolean isStun() {
        return isStun;
    }
    public void unStun() {
        isStun = false;
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
            strength += 3;
        } else if (artifact.equals("d")) {
            critRate += .10;
        } else if (artifact.equals("w")) {
            evadeChance += .15;
            speed += 3;
        } else if (artifact.equals("v")) {
            fortitude += 4;
        }
    }

    public void pointAlloc(int strength, int speed, int fortitude)
    {
        this.strength += strength;
        this.speed += speed;
        evadeChance += (.5 * speed);
        this.fortitude += fortitude;
        health += (10 * this.fortitude);
    }

    public void infoPrint2()
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

    public void infoPrint()
    {
        System.out.println ("user: " + userName);
        System.out.println ("health: " + health);
        System.out.println ("potions: " + potion);
        System.out.println ("attack counters: " + attackCounter);
        System.out.println ("");
    }
}
