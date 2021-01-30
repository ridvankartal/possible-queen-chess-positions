import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int boardSize = 8;

        // Set queen's current position.
        Queen queen = new Queen();
        queen.setPositionX(4);
        queen.setPositionY(5);

        // Set obstacles' positions.
        Set<Piece> obstacles = new HashSet<>();

        Piece obstaclePosition1 = new Piece();
        obstaclePosition1.setPositionX(3);
        obstaclePosition1.setPositionY(6);
        obstacles.add(obstaclePosition1);

        int possibleQueenPositionCount = Queen

                .findPossiblePositionCount(boardSize, queen, obstacles);

        System.out.println("Possible Queen Position Count: " + possibleQueenPositionCount);

    }

}
