/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 * Subclase de Piece, Fai referencia a Peza en forma de barra
 *
 * @author Jorge Val Gil e Adrían Fernández Pérez
 */
public class BarPiece extends Piece {

    private int position = 0;

    /**
     * Constructor
     *
     * @param game parámetro da clase game
     */
    public BarPiece(Game game) {

        this.game = game;

        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.YELLOW, game);
        squares[1] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                Color.YELLOW, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * 2, Color.YELLOW, game);

        squares[3] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * 3, Color.YELLOW, game);
    }

    /**
     * Método da clase Piece, redefinido. Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    @Override
    public boolean rotate() {
        boolean rotatepiece = false;
        switch (position) {
            case 0:
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE) && (game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE))
                        && (game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE * 2, squares[3].getY() - 2 * Game.SQUARE_SIDE))) {

                    squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                    squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                    squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                    squares[3].setX(squares[3].getX() + Game.SQUARE_SIDE * 2);
                    squares[3].setY(squares[3].getY() - 2 * Game.SQUARE_SIDE);

                    position = 1;
                    rotatepiece = true;
                } else {
                    rotatepiece = false;
                }
                break;

            case 1:
                if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE) && (game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE))
                        && (game.isValidPosition(squares[3].getX() - 2 * Game.SQUARE_SIDE, squares[3].getY() + 2 * Game.SQUARE_SIDE))) {

                    squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                    squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                    squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                    squares[3].setX(squares[3].getX() - 2 * Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY() + 2 * Game.SQUARE_SIDE);

                    position = 0;
                    rotatepiece = true;
                } else {
                    rotatepiece = false;
                }
                break;
        }
        return rotatepiece;
    }

}
