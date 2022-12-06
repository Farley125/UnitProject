public class GameMethods {
    private String userName;
    private String artifact;
    private double critRate;
    private double evadeChance;
    private double evadeRoll;
    private double critRoll;
    private int health;
    private int speed;
    private int strength;
    private int fortitude;
    private int potion;
    private int attackCounter;
    private int damageDone;
    private boolean isStun;


    public static final String TEXT_RESET  = "\u001B[0m";

    public static final String TEXT_BLACK  = "\u001B[30m";
    public static final String TEXT_RED    = "\u001B[31m";
    public static final String TEXT_GREEN  = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE   = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN   = "\u001B[36m";
    public static final String TEXT_WHITE  = "\u001B[37m";
    public static final String TEXT_BG_BLACK  = "\u001B[40m";

    public GameMethods (String name, String artifact, double critRate, int health, int speed
            , int strength, int fortitude, int potion) {
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
        evadeChance = .05;
    }

    public GameMethods (String name, double critRate, int health, int speed, int strength,
                        int fortitude, String artifact) {
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
    }

    public GameMethods (){
    }

    /**
     * Will handle two user inputs and will output the damage result based off of the interaction between the two inputs.
     * @param attacker One of the user's inputs.
     * @param victim The other user input.
     * @return returns the damage that should be dealt.
    **/

    public int exchange(String attacker, String victim) {
        int baseDamage = (strength * 5) + 10;
        int damageMulti = 1;
        critRoll = Math.random();
        evadeRoll = Math.random();
        if (evadeRoll < evadeChance) {
            damageDone = 0;
            return 0;
        }
        if (critRoll < critRate) {
            damageMulti = 2;
        }
        if (attacker.equals("")) {
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
            } else {
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
            damageDone = (baseDamage / 3) * damageMulti;
            return (baseDamage / 3) * damageMulti;
        } else if (attacker.equals("d")) {
            return 0;
        }
        damageDone = baseDamage * damageMulti;
        return baseDamage * damageMulti;
    }

    /**
     * Will handle two user inputs and will output the resulting string based off of the interaction between the two inputs.
     * @param attacker One of the user's inputs.
     * @param victim The other user input.
     * @return returns the string that will be outputted to the users.
     **/
    public String outcomeMessage(String attacker, String victim) {
        if (evadeRoll < evadeChance && attacker.equals("a")) {
            return (TEXT_BLUE + "Your opponent dodged your attack!" + TEXT_RESET);
        }
        if (attacker.equals("c")) {
            if (potion > 0) {
                potion--;
                return (TEXT_RED + "You reach into your bag and pull out a potion! + 50 Health! \n[You have " + potion + " potion(s)]\n" + TEXT_RESET);
            }
            else {
                return ("You reach into your bag and pull out nothing! [You have 0 potions]\n");
            }
        } 
        else if (attacker.equals("p") && victim.equals("a") == false) {
            return (TEXT_YELLOW + "You ready yourself for an attack that never came, your posture was disrupted! \nYou've been stunned.\n" + TEXT_RESET);
        } else if (attacker.equals("p") && victim.equals("a")) {
            return (TEXT_CYAN + "You parried their blow!\n" + TEXT_RESET);
        }
        else if (attacker.equals("a") && victim.equals("d")){
            if (critRoll < critRate)
            {
               return(TEXT_PURPLE + "You strike a defending opponent, and it was a critical hit! (You deal " + damageDone + " damage)\n" + TEXT_RESET);
            }
            else return (TEXT_PURPLE + "You strike a defending opponent. (You deal " + damageDone + " damage)\n" + TEXT_RESET);
        }
        else if (attacker.equals("a") && victim.equals("p")) {
            return (TEXT_YELLOW + "Your blow was parried, you were thrown off balance. \nYou've been stunned.\n" + TEXT_RESET);
        }
        else if (attacker.equals("d")) {
            return (TEXT_GREEN + "You ready your shield.\n" + TEXT_RESET);
        } else if (attacker.equals(""))
        {
            return (TEXT_YELLOW + "You're unable to move.\n" + TEXT_RESET);
        }
        else if (critRoll < critRate)
        {
            return(TEXT_BG_BLACK + TEXT_WHITE + "You strike your opponent, and it was a critical hit! (You deal " + damageDone + " damage)\n" + TEXT_RESET);
        }
        return (TEXT_RED + "You strike your opponent. (You deal " + damageDone + " damage)\n" + TEXT_RESET);
    }
    /**
     * bro this is a setter method
     * @param newHealth Will set the instance variable "health" to this parameter.
     **/
    public void setHealth(int newHealth) {
        //Method to set health of user.
        health = newHealth;
    }

    /**
     * bro this is a getter method
     * @return Will return the amount of attack counters of the object used to call in this method.
     **/
    public int getAttackCounter() {return attackCounter;}

    /**
     * bro this is a getter method
     * @return Will return the health of the object used to call in this method.
     **/
    public int getHealth(){
        return health;
    }

    /**
     * bro this is a getter method
     * @return Will return the username of the object used to call in this method.
     **/
    public String getUserName() {
        return userName;
    }

    /**
     * Will increase the value of the instance variable "health" by 50 of the object used to call in this method.
     **/
    public void consume() {
        //method to consume potion and affect stat associated
        setHealth(health + 50);
    }

    /**
     * bro this is a getter method
     * @return Will return whether the instance variable "isStun" is true or false.
     **/
    public boolean isStun() {
        return isStun;
    }
    /**
     * Will set the instance variable "isStun" to false.
     **/
    public void unStun() {
        isStun = false;
    }

    /**
     * @return Will return true if the instance variable "health" is less than or equal to 0. Used to detect when the program should end.
     **/
    public boolean gameOver() {
        //will check health of users.
        if (health <= 0)
        {
            return true;
        }
        else return false;
    }

    /**
     * bro this is a getter method
     * @return Will return the product of the instance variable "speed" and the value .05.
     **/
    public double returnEvadeChance() {
        return speed * .05;
    }
    /**
     * bro this is a setter method
     * @param evadeChance Will set the instance variable "evadeChance" to this parameter.
     **/
    public void setEvadeChance(double evadeChance) {
        this.evadeChance = evadeChance;
    }

    /**
     * Will adjust the stats (various instance variables) based off of the instance variable "artifact" which is inputted by the user.
     **/
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

    /**
     * This method is used to take in the values inputted by the user and change the various instance variables associated with these values.
     * @param strength Will set the instance variable "strength" to this parameter.
     * @param speed Will set the instance variable "speed" to this parameter. Will also increase the instance variable "evadeChance."
     * @param fortitude Will set the instance variable "fortitude" to this parameter. Will also increase the instance variable "health."
     **/
    public void pointAlloc(int strength, int speed, int fortitude)
    {
        this.strength += strength;
        this.speed += speed;
        evadeChance += (.5 * speed);
        this.fortitude += fortitude;
        health += (10 * this.fortitude);
    }

    public String toString()
    {
        return ("user: " + userName + TEXT_RED + "\nhealth: " + TEXT_RESET + health + TEXT_BLUE + "\nattack counters: " + TEXT_RESET + attackCounter + "\n");
    }
}
