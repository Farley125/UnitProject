import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) {
        int potions = 0;
        int availStatPts1 = 5;
        int availStatPts2 = 5;
        GameMethods player1 = new GameMethods();
        GameMethods player2 = new GameMethods();
        Scanner s = new Scanner(System.in);
        System.out.print("Player 1, what would you like to be called? ");
        String userName = s.nextLine();
        System.out.print("Choose an artifact. (a for (artifact name) (+1 strength), d for (artifact name) (+15% crit chance), w for (artifact name) (+1 speed), v for (artifact name) (+1 fortitude): ");
        String artifact = s.nextLine();
        System.out.print("Will you be playing with potions? (y or n): ");
        String hasPotions = s.nextLine();
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
        if (availStatPts1 < 0 || Integer.parseInt(strAllocate) < 0 || Integer.parseInt(spdAllocate) < 0 || Integer.parseInt(fortAllocate) < 0) {
            System.out.println("");
            System.out.print("Nice try pal.");
            System.exit(0);
        }
        player1.pointAlloc(Integer.parseInt(strAllocate), Integer.parseInt(spdAllocate), Integer.parseInt(fortAllocate));

        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }

        System.out.print("Player 2, what would you like to be called? ");
        userName = s.nextLine();
        System.out.print("Choose an artifact. (a for (artifact name) (+1 strength), d for (artifact name) (+10% crit chance), w for (artifact name) (+1 speed), v for (artifact name) (+1 fortitude): ");
        artifact = s.nextLine();
        if (hasPotions.equals("y")) {
            player2 = new GameMethods(userName, artifact, .10, 200, 1, 1, 1, 1);
        } else {
            player2 = new GameMethods(userName, .10, 200, 1, 1, 1, artifact);
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
        if (availStatPts2 < 0 || Integer.parseInt(strAllocate) < 0 || Integer.parseInt(spdAllocate) < 0 || Integer.parseInt(fortAllocate) < 0) {
            System.out.println("");
            System.out.print("Nice try pal.");
            System.exit(0);
        }
        player2.pointAlloc(Integer.parseInt(strAllocate), Integer.parseInt(spdAllocate), Integer.parseInt(fortAllocate));

        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }

        int baseDamage1 = player1.getDamage();
        int baseDamage2 = player2.getDamage();
        String input1;
        String input2;
        while (player1.gameOver() == false && player2.gameOver() == false) {

            boolean successfulInput = false;
            while (successfulInput != true) {
                System.out.println("Player 1, make your move. (a to attack, d to defend, p to parry, and c to consume your health potion");
                input1 = s.nextLine();
                if (input1.equals("a") || input1.equals("d") || input1.equals("p") || input1.equals("c")) {
                    successfulInput = true;
                } else
                    System.out.println("There was a misinput!!! Type a to attack, d to defend, p to parry, and c to consume your health potion");
            }
            successfulInput = false;
            while (successfulInput != true) {
                System.out.println("Player 2, make your move. (a to attack, d to defend, p to parry, and c to consume your health potion");
                input2 = s.nextLine();
                if (input2.equals("a") || input2.equals("d") || input2.equals("p") || input2.equals("c")) {
                    successfulInput = true;
                } else
                    System.out.println("There was a misinput!!! Type a to attack, d to defend, p to parry, and c to consume your health potion");
            }
            successfulInput = false;
        }
        player1.infoPrint();
        player2.infoPrint();
    }
}
