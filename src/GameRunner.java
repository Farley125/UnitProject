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
        String artifact  = s.nextLine();
        System.out.print("Will you be playing with potions? (y or n): ");
        String hasPotions = s.nextLine();
        if (hasPotions.equals("y"))
        {
            player1 = new GameMethods(userName, artifact, .10, 200, 1, 1, 1, 1, 1);
        }
        else
        {
            player1 = new GameMethods(userName, .10, 200, 1, 1, 1, artifact, 1);
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
        player1.pointAlloc(Integer.parseInt(strAllocate), Integer.parseInt(spdAllocate), Integer.parseInt(fortAllocate));
        System.out.println("");
        System.out.print("Player 2, what would you like to be called? ");
        userName = s.nextLine();
        System.out.print("Choose an artifact. (a for (artifact name) (+1 strength), d for (artifact name) (+10% crit chance), w for (artifact name) (+1 speed), v for (artifact name) (+1 fortitude): ");
        artifact  = s.nextLine();
        if (hasPotions.equals("y"))
        {
            player2 = new GameMethods(userName, artifact, .10, 200, 1, 1, 1, 1, 2);
        }
        else
        {
            player2 = new GameMethods(userName, .10, 200, 1, 1, 1, artifact, 2);
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
        if (availStatPts1 < 0 || availStatPts2 < 0)
        {
            System.out.print("Dirty cheater.");
            System.exit(0);
        }
        player2.pointAlloc(Integer.parseInt(strAllocate), Integer.parseInt(spdAllocate), Integer.parseInt(fortAllocate));






        player1.infoPrint();
        player2.infoPrint();
    }
}
