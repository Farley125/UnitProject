import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to \"Run Ye' Belongings!\" This is a two player turn-based combat game. There are 4 different types of moves" +
                "\nDefending - Reduces damage done." +
                "\nParrying - If the user is attacked while parrying the attacking user will be stunned, however if the user isn't attacked the parrying user will be stunned" +
                "\nConsume - Will consume a health potion (if the user has one) and regenerate 50 health.");
        int availStatPts1 = 5;
        int availStatPts2 = 5;
        GameMethods player1 = new GameMethods();
        GameMethods player2 = new GameMethods();
        Scanner s = new Scanner(System.in);
        System.out.print("Will you be playing with potions? (y or n): ");
        String hasPotions = s.nextLine();
        System.out.print("Player 1, what would you like to be called? ");
        String userName = s.nextLine();
        System.out.print("Choose an artifact. (a for (artifact name) (+3 strength), d for (artifact name) (+10% crit chance), w for (artifact name) (+3 speed), v for (artifact name) (+4 fortitude): ");
        String artifact = s.nextLine();

        if (hasPotions.equals("y")) {
            player1 = new GameMethods(userName, artifact, .10, 200, 1, 1, 1, 1);
        } else {
            player1 = new GameMethods(userName, .10, 200, 1, 1, 1, artifact);
        }
        player1.statAdjust();
        System.out.print("Player 1, how many points would you like to put into strength? (" + availStatPts1 + " points left): ");
        String strAllocate = s.nextLine();
        availStatPts1 -= Integer.parseInt(strAllocate);
        System.out.print("Player 1, how many points would you like to put into speed? (" + availStatPts1 + " points left): ");
        String spdAllocate = s.nextLine();
        availStatPts1 -= Integer.parseInt(spdAllocate);
        System.out.print("Player 1, how many points would you like to put into fortitude? (" + availStatPts1 + " points left): ");
        String fortAllocate = s.nextLine();
        availStatPts1 -= Integer.parseInt(fortAllocate);

        /*
        To determine if the values inputted by the user are within the expected scope.
         */
        if (availStatPts1 < 0 || Integer.parseInt(strAllocate) < 0 || Integer.parseInt(spdAllocate) < 0 || Integer.parseInt(fortAllocate) < 0) {
            System.out.println("");
            System.out.print("Nice try pal.");
            System.exit(0);
        }
        player1.pointAlloc(Integer.parseInt(strAllocate), Integer.parseInt(spdAllocate), Integer.parseInt(fortAllocate));

        /*
        Creates space to obscure inputs.
         */
        for (int i = 0; i < 100; i++) {
            System.out.println("");
            if (i == 50) {
                System.out.print("It isn't too late to turn back.");
            }
        }

        System.out.print("Player 2, what would you like to be called? ");
        userName = s.nextLine();
        System.out.print("Choose an artifact. (a for (artifact name) (+3 strength), d for (artifact name) (+10% crit chance), w for (artifact name) (+3 speed), v for (artifact name) (+4 fortitude): ");
        artifact = s.nextLine();
        if (hasPotions.equals("y")) {
            player2 = new GameMethods(userName, artifact, .10, 200, 1, 2, 1, 1);
        } else {
            player2 = new GameMethods(userName, .10, 200, 1, 2, 1, artifact);
        }
        player2.statAdjust();
        System.out.print("Player 2, how many points would you like to put into strength? (" + availStatPts2 + " points left): ");
        strAllocate = s.nextLine();
        availStatPts2 -= Integer.parseInt(strAllocate);
        System.out.print("Player 2, how many points would you like to put into speed? (" + availStatPts2 + " points left): ");
        spdAllocate = s.nextLine();
        availStatPts2 -= Integer.parseInt(spdAllocate);
        System.out.print("Player 2, how many points would you like to put into fortitude? (" + availStatPts2 + " points left): ");
        fortAllocate = s.nextLine();
        availStatPts2 -= Integer.parseInt(fortAllocate);
        if (availStatPts2 < 0 || Integer.parseInt(strAllocate) < 0 || Integer.parseInt(spdAllocate) < 0
                || Integer.parseInt(fortAllocate) < 0) {
            System.out.println("");
            System.out.print("Nice try pal.");
            System.exit(0);
        }
        player2.pointAlloc(Integer.parseInt(strAllocate), Integer.parseInt(spdAllocate), Integer.parseInt(fortAllocate));

        for (int i = 0; i < 100; i++) {
            System.out.println("");
            if (i == 50) {
                System.out.print("It isn't too late to turn back.");
            }
        }

        /*
        Calls in methods to calculate and set the evadeChance variable.
         */
        player1.setEvadeChance(player2.returnEvadeChance());
        player2.setEvadeChance(player1.returnEvadeChance());
        String input1 = "";
        String input2 = "";
        while (player1.gameOver() == false && player2.gameOver() == false) {
            boolean successfulInput = false;
            if (player1.isStun() == false) {
                while (successfulInput != true) {
                    System.out.println(player1.getUserName() + ", make your move. (a to attack, d to defend, p to parry, and c to consume your health potion)");
                    input1 = s.nextLine();
                    System.out.println(input1);
                    if (input1.equals("a") || input1.equals("d") || input1.equals("p") || input1.equals("c")) {
                        successfulInput = true;
                        for (int i = 0; i < 100; i++) {
                            System.out.println("");
                            if (i == 50) {
                                System.out.print("It isn't too late to turn back.");
                            }
                        }
                    } else
                        System.out.println("There was a misinput!!! Type a to attack, d to defend, p to parry, and c to consume your health potion)");

                }
            } else {
                for (int i = 0; i < 50; i++) {
                    System.out.println("");
                }
                System.out.println(player1.getUserName() + " is stunned, they are unable to move.");
                input1 = "";
                player1.unStun();
            }
            successfulInput = false;


            if (player2.isStun() == false) {
                while (successfulInput != true) {
                    System.out.println(player1);
                    System.out.println(player2);
                    System.out.println(player2.getUserName() + ", make your move. (a to attack, d to defend, p to parry, and c to consume your health potion)");
                    input2 = s.nextLine();
                    System.out.println(input2);
                    if (input2.equals("a") || input2.equals("d") || input2.equals("p") || input2.equals("c")) {
                        successfulInput = true;
                        for (int i = 0; i < 100; i++) {
                            System.out.println("");
                            if (i == 50) {
                                System.out.print("It isn't too late to turn back.");
                            }
                        }
                    } else
                        System.out.println("There was a misinput!!! Type a to attack, d to defend, p to parry, and c to consume your health potion)");
                }
            } else {
                System.out.println(player2.getUserName() + " is stunned, they are unable to move.");
                player2.unStun();
                input2 = "";
            }

            player1.setHealth(player1.getHealth() - player2.exchange(input2, input1));
            System.out.println(player1.outcomeMessage(input1, input2));
            player2.setHealth(player2.getHealth() - player1.exchange(input1, input2));
            System.out.println(player2.outcomeMessage(input2, input1));

            System.out.println(player1);
            System.out.println(player2);
        }
        if (player1.gameOver() == true && player2.gameOver() == true) {
            System.out.println("Both players were killed in battle.");
        } else if (player1.gameOver() == true) {
            System.out.println(player2.getUserName() + " has won the battle!");
        } else if (player2.gameOver() == true) {
            System.out.println(player1.getUserName() + " has won the battle!");
        }
    }
}
