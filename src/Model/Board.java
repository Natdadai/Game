package Model;

public class Board {
    private static int SQUARE_AMOUNT = 40;

    Square[] squares;

    public Board() {
        squares = new Square[SQUARE_AMOUNT];
        for (int i = 0 ; i < squares.length ; i++) {
            squares[i] = new Square("#" + i);
        }
    }

    public Square getSquare(Square oldLoc, int fvTot) {
        return squares[addFvTot(findSquareIndex(oldLoc), fvTot)];
    }

    public Square getStartingSquare() {
        return squares[0];
    }

    private int findSquareIndex(Square square){
        for (int i = 0 ; i < squares.length ; ++i) {
            if (squares[i] == square) {
                return i;
            }
        }
        return -1;
    }

    private int addFvTot(int squareIndex, int fvTot) {
        return (squareIndex + fvTot) % squares.length;
    }
}
