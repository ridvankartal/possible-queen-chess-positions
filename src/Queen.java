import java.util.Objects;
import java.util.Set;

class Queen extends Piece {

    // Return the number of possible position for a Queen.
    static int findPossiblePositionCount(int boardSize, Queen queen, Set<Piece> obstacles) {

        // 1 -> Start position.
        // N -> Board size.

        int positionX = queen.getPositionX();
        int positionY = queen.getPositionY();

        // Distances on diagonal directions.
        int diagonalDistanceOn1and1Direction = Math.min(positionX - 1, positionY - 1);
        int diagonalDistanceOn1andNDirection = Math.min(boardSize - positionX, boardSize - positionY);
        int diagonalDistanceOnNand1Direction = Math.min(boardSize - positionX, positionY - 1);
        int diagonalDistanceOnNandNDirection = Math.min(positionX - 1, boardSize - positionY);

        // Distances on Y axis.
        int verticalDistanceOnDirection1 = positionY - 1;
        int verticalDistanceOnDirectionN = boardSize - positionY;

        // Distances on X axis.
        int horizontalDistanceOnDirection1 = positionX - 1;
        int horizontalDistanceOnDirectionN = boardSize - positionX;

        // Find the minimum obstacle distances and subtract.
        if (Objects.nonNull(obstacles)) {
            for (Piece obstacle : obstacles) {

                if (positionX > obstacle.getPositionX() &&
                        positionY > obstacle.getPositionY() &&
                        Objects.equals((positionX - obstacle.getPositionX()), (positionY - obstacle.getPositionY())))
                    diagonalDistanceOn1and1Direction = Math.min(diagonalDistanceOn1and1Direction, positionX - obstacle.getPositionX() - 1);

                if (obstacle.getPositionX() > positionX &&
                        obstacle.getPositionY() > positionY &&
                        Objects.equals((obstacle.getPositionX() - positionX), obstacle.getPositionY() - positionY))
                    diagonalDistanceOn1andNDirection = Math.min(diagonalDistanceOn1andNDirection, obstacle.getPositionX() - positionX - 1);

                if (obstacle.getPositionX() > positionX &&
                        positionY > obstacle.getPositionY() &&
                        Objects.equals((obstacle.getPositionX() - positionX), (positionY - obstacle.getPositionY())))
                    diagonalDistanceOnNand1Direction = Math.min(diagonalDistanceOnNand1Direction, obstacle.getPositionX() - positionX - 1);

                if (positionX > obstacle.getPositionX() &&
                        obstacle.getPositionY() > positionY &&
                        Objects.equals((positionX - obstacle.getPositionX()), (obstacle.getPositionY() - positionY)))
                    diagonalDistanceOnNandNDirection = Math.min(diagonalDistanceOnNandNDirection, positionX - obstacle.getPositionX() - 1);

                if (Objects.equals(positionX, obstacle.getPositionX()) && obstacle.getPositionY() < positionY)
                    verticalDistanceOnDirection1 = Math.min(verticalDistanceOnDirection1, positionY - obstacle.getPositionY() - 1);

                if (Objects.equals(positionX, obstacle.getPositionX()) && obstacle.getPositionY() > positionY)
                    verticalDistanceOnDirectionN = Math.min(verticalDistanceOnDirectionN, obstacle.getPositionY() - positionY - 1);

                if (Objects.equals(positionY, obstacle.getPositionY()) && obstacle.getPositionX() < positionX)
                    horizontalDistanceOnDirection1 = Math.min(horizontalDistanceOnDirection1, positionX - obstacle.getPositionX() - 1);

                if (Objects.equals(positionY, obstacle.getPositionY()) && obstacle.getPositionX() > positionX)
                    horizontalDistanceOnDirectionN = Math.min(horizontalDistanceOnDirectionN, obstacle.getPositionX() - positionX - 1);

            }
        }
        return diagonalDistanceOn1and1Direction +
                diagonalDistanceOn1andNDirection +
                diagonalDistanceOnNand1Direction +
                diagonalDistanceOnNandNDirection +
                verticalDistanceOnDirection1 +
                verticalDistanceOnDirectionN +
                horizontalDistanceOnDirection1 +
                horizontalDistanceOnDirectionN;
    }

}
