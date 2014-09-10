package cs2114.vtchess;

import java.util.Arrays;
import android.widget.CheckBox;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.Menu;
import sofia.app.Screen;
import java.util.*;

// -------------------------------------------------------------------------
/**
 * Chess Application for android devices
 *
 * @authors Kent Hannigan (kent) and Wilson Rhodes (rush)
 * @version 2014.04.29
 */

public class HokieChess
    extends Screen
{
    private char                   mostRecentMode;
    private ImageView              cell00;
    private ImageView              cell01;
    private ImageView              cell02;
    private ImageView              cell03;
    private ImageView              cell04;
    private ImageView              cell05;
    private ImageView              cell06;
    private ImageView              cell07;

    private ImageView              cell10;
    private ImageView              cell11;
    private ImageView              cell12;
    private ImageView              cell13;
    private ImageView              cell14;
    private ImageView              cell15;
    private ImageView              cell16;
    private ImageView              cell17;

    private ImageView              cell20;
    private ImageView              cell21;
    private ImageView              cell22;
    private ImageView              cell23;
    private ImageView              cell24;
    private ImageView              cell25;
    private ImageView              cell26;
    private ImageView              cell27;

    private ImageView              cell30;
    private ImageView              cell31;
    private ImageView              cell32;
    private ImageView              cell33;
    private ImageView              cell34;
    private ImageView              cell35;
    private ImageView              cell36;
    private ImageView              cell37;

    private ImageView              cell40;
    private ImageView              cell41;
    private ImageView              cell42;
    private ImageView              cell43;
    private ImageView              cell44;
    private ImageView              cell45;
    private ImageView              cell46;
    private ImageView              cell47;

    private ImageView              cell50;
    private ImageView              cell51;
    private ImageView              cell52;
    private ImageView              cell53;
    private ImageView              cell54;
    private ImageView              cell55;
    private ImageView              cell56;
    private ImageView              cell57;

    private ImageView              cell60;
    private ImageView              cell61;
    private ImageView              cell62;
    private ImageView              cell63;
    private ImageView              cell64;
    private ImageView              cell65;
    private ImageView              cell66;
    private ImageView              cell67;

    private ImageView              cell70;
    private ImageView              cell71;
    private ImageView              cell72;
    private ImageView              cell73;
    private ImageView              cell74;
    private ImageView              cell75;
    private ImageView              cell76;
    private ImageView              cell77;

    private ChessPiece             selected;
    private ChessPiece             target;
    private ChessPiece[][]         board;
    private CheckBox               valid;
    private CheckBox               alwaysOn;
    private TextView               infoLabel;
    private boolean                blackTurn;
    private Map<ImageView, String> cells;
    private String                 moveMessage;
    private boolean                checkOrCMSituation;
    private boolean                gameOver;
    private boolean                showValid;
    private boolean                pieceHeld;         // set true after a piece
// has been selected for a move. Set false after its move has been carried out.

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hokie_chess);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hokie_chess, menu);
        return true;
    }


    public void initialize()
    {
        board = new ChessPiece[8][8];
        gameOver = false;
        blackTurn = false;
        showValid = false;
        checkOrCMSituation = false;
        moveMessage = "";
        infoLabel.setText("");

        selected = null;
        target = null;

        // Black pieces--------------------------------------
        board[0][0] = new ChessPiece("black", "rook", cell00);
        board[1][0] = new ChessPiece("black", "knight", cell01);
        board[2][0] = new ChessPiece("black", "bishop", cell02);
        board[3][0] = new ChessPiece("black", "queen", cell03);
        board[4][0] = new ChessPiece("black", "king", cell04);
        board[5][0] = new ChessPiece("black", "bishop", cell05);
        board[6][0] = new ChessPiece("black", "knight", cell06);
        board[7][0] = new ChessPiece("black", "rook", cell07);

        board[0][1] = new ChessPiece("black", "pawn", true, cell10);
        board[1][1] = new ChessPiece("black", "pawn", true, cell11);
        board[2][1] = new ChessPiece("black", "pawn", true, cell12);
        board[3][1] = new ChessPiece("black", "pawn", true, cell13);
        board[4][1] = new ChessPiece("black", "pawn", true, cell14);
        board[5][1] = new ChessPiece("black", "pawn", true, cell15);
        board[6][1] = new ChessPiece("black", "pawn", true, cell16);
        board[7][1] = new ChessPiece("black", "pawn", true, cell17);
        // ---------------------------------------------------

        // White pieces---------------------------------------
        board[0][7] = new ChessPiece("white", "rook", cell70);
        board[1][7] = new ChessPiece("white", "knight", cell71);
        board[2][7] = new ChessPiece("white", "bishop", cell72);
        board[3][7] = new ChessPiece("white", "queen", cell73);
        board[4][7] = new ChessPiece("white", "king", cell74);
        board[5][7] = new ChessPiece("white", "bishop", cell75);
        board[6][7] = new ChessPiece("white", "knight", cell76);
        board[7][7] = new ChessPiece("white", "rook", cell77);

        board[0][6] = new ChessPiece("white", "pawn", true, cell60);
        board[1][6] = new ChessPiece("white", "pawn", true, cell61);
        board[2][6] = new ChessPiece("white", "pawn", true, cell62);
        board[3][6] = new ChessPiece("white", "pawn", true, cell63);
        board[4][6] = new ChessPiece("white", "pawn", true, cell64);
        board[5][6] = new ChessPiece("white", "pawn", true, cell65);
        board[6][6] = new ChessPiece("white", "pawn", true, cell66);
        board[7][6] = new ChessPiece("white", "pawn", true, cell67);
        // ---------------------------------------------------

        // Empty Cells ---------------------------------------
        board[0][2] = new ChessPiece(cell20);
        board[0][3] = new ChessPiece(cell30);
        board[0][4] = new ChessPiece(cell40);
        board[0][5] = new ChessPiece(cell50);

        board[1][2] = new ChessPiece(cell21);
        board[1][3] = new ChessPiece(cell31);
        board[1][4] = new ChessPiece(cell41);
        board[1][5] = new ChessPiece(cell51);

        board[2][2] = new ChessPiece(cell22);
        board[2][3] = new ChessPiece(cell32);
        board[2][4] = new ChessPiece(cell42);
        board[2][5] = new ChessPiece(cell52);

        board[3][2] = new ChessPiece(cell23);
        board[3][3] = new ChessPiece(cell33);
        board[3][4] = new ChessPiece(cell43);
        board[3][5] = new ChessPiece(cell53);

        board[4][2] = new ChessPiece(cell24);
        board[4][3] = new ChessPiece(cell34);
        board[4][4] = new ChessPiece(cell44);
        board[4][5] = new ChessPiece(cell54);

        board[5][2] = new ChessPiece(cell25);
        board[5][3] = new ChessPiece(cell35);
        board[5][4] = new ChessPiece(cell45);
        board[5][5] = new ChessPiece(cell55);

        board[6][2] = new ChessPiece(cell26);
        board[6][3] = new ChessPiece(cell36);
        board[6][4] = new ChessPiece(cell46);
        board[6][5] = new ChessPiece(cell56);

        board[7][2] = new ChessPiece(cell27);
        board[7][3] = new ChessPiece(cell37);
        board[7][4] = new ChessPiece(cell47);
        board[7][5] = new ChessPiece(cell57);
        // ----------------------------------------------------

        // Initialize the map of imageView objects
        cells = new HashMap<ImageView, String>(64);

        cells.put(cell00, "cell00");
        cells.put(cell01, "cell01");
        cells.put(cell02, "cell02");
        cells.put(cell03, "cell03");
        cells.put(cell04, "cell04");
        cells.put(cell05, "cell05");
        cells.put(cell06, "cell06");
        cells.put(cell07, "cell07");

        cells.put(cell10, "cell10");
        cells.put(cell11, "cell11");
        cells.put(cell12, "cell12");
        cells.put(cell13, "cell13");
        cells.put(cell14, "cell14");
        cells.put(cell15, "cell15");
        cells.put(cell16, "cell16");
        cells.put(cell17, "cell17");

        cells.put(cell20, "cell20");
        cells.put(cell21, "cell21");
        cells.put(cell22, "cell22");
        cells.put(cell23, "cell23");
        cells.put(cell24, "cell24");
        cells.put(cell25, "cell25");
        cells.put(cell26, "cell26");
        cells.put(cell27, "cell27");

        cells.put(cell30, "cell30");
        cells.put(cell31, "cell31");
        cells.put(cell32, "cell32");
        cells.put(cell33, "cell33");
        cells.put(cell34, "cell34");
        cells.put(cell35, "cell35");
        cells.put(cell36, "cell36");
        cells.put(cell37, "cell37");

        cells.put(cell40, "cell40");
        cells.put(cell41, "cell41");
        cells.put(cell42, "cell42");
        cells.put(cell43, "cell43");
        cells.put(cell44, "cell44");
        cells.put(cell45, "cell45");
        cells.put(cell46, "cell46");
        cells.put(cell47, "cell47");

        cells.put(cell50, "cell50");
        cells.put(cell51, "cell51");
        cells.put(cell52, "cell52");
        cells.put(cell53, "cell53");
        cells.put(cell54, "cell54");
        cells.put(cell55, "cell55");
        cells.put(cell56, "cell56");
        cells.put(cell57, "cell57");

        cells.put(cell60, "cell60");
        cells.put(cell61, "cell61");
        cells.put(cell62, "cell62");
        cells.put(cell63, "cell63");
        cells.put(cell64, "cell64");
        cells.put(cell65, "cell65");
        cells.put(cell66, "cell66");
        cells.put(cell67, "cell67");

        cells.put(cell70, "cell70");
        cells.put(cell71, "cell71");
        cells.put(cell72, "cell72");
        cells.put(cell73, "cell73");
        cells.put(cell74, "cell74");
        cells.put(cell75, "cell75");
        cells.put(cell76, "cell76");
        cells.put(cell77, "cell77");

    }


    /**
     * when the user touches the screen
     *
     * @param event
     *            the motion event
     * @return always returns true
     */
    public boolean onTouchEvent(MotionEvent event)
    {
        processTouch(event.getX(), event.getY());
        return true;
    }


    /**
     * processes the users touch
     *
     * @param x
     *            the x location on the android screen
     * @param y
     *            the y location on the android screen
     */
    public void processTouch(float x, float y)
    {
        if (gameOver)
        {
            return;
        }

        if (valid.isChecked())
        {
            showValid = true;
        }

        if (alwaysOn.isChecked())
        {
            showValid = true;
        }

        int cellX = (int)((x - 25) / 54);
        int cellY = (int)((y - 135) / 54);

        // If beginning of new turn set every piece's validMoves[] array
        if (selected == null && target == null)
        {
            setAllValid('e');
        }

        // If the spot touched is within the board
        if (cellX < 8 && cellY < 8 && cellX >= 0 && cellY >= 0)
        {
            // If it's black's turn and he selects his own piece after having
            // previously done so.
            if (blackTurn && board[cellX][cellY].getColor().equals("black")
                && selected != null)
            {
                if (showValid)
                {
                    updateValidMovesDisplay('r');
                }

                setImage(selected, selected.abbreviate('i'));

                selected = board[cellX][cellY]; // selected is now the new cell
                pieceHeld = true;

                setImage(selected, selected.abbreviate('i') + 'o');

                if (showValid)
                {
                    updateValidMovesDisplay('s');
                }
            }

            // If it's white's turn and he selects his own piece after having
            // previously done so.
            else if (!blackTurn
                && board[cellX][cellY].getColor().equals("white")
                && selected != null)
            {
                if (showValid)
                {
                    updateValidMovesDisplay('r');
                }

                setImage(selected, selected.abbreviate('i'));

                selected = board[cellX][cellY]; // selected is now the new cell
                pieceHeld = true;

                setImage(selected, selected.abbreviate('i') + 'o');

                if (showValid)
                {
                    updateValidMovesDisplay('s');
                }
            }

            // If it's black's turn and he selects his own piece
            else if (blackTurn
                && board[cellX][cellY].getColor().equals("black")
                && selected == null)
            {
                selected = board[cellX][cellY]; // selected is now the new cell
                pieceHeld = true;

                setImage(selected, selected.abbreviate('i') + 'o');

                if (showValid)
                {
                    updateValidMovesDisplay('s');
                }
            }

            // If it's white's turn and he selects his own piece
            else if (!blackTurn
                && board[cellX][cellY].getColor().equals("white")
                && selected == null)
            {
                selected = board[cellX][cellY]; // selected is now the new cell
                pieceHeld = true;

                setImage(selected, selected.abbreviate('i') + 'o');

                if (showValid)
                {
                    updateValidMovesDisplay('s');
                }
            }

            // If it's black's turn and he selects a white target or empty cell
            else if ((blackTurn
                && board[cellX][cellY].getColor().equals("white") && pieceHeld && selected != null)
                || (blackTurn && !(board[cellX][cellY].getOccupied())
                    && pieceHeld && selected != null))
            {

                target = board[cellX][cellY];

                if (withinReach())
                {
                    blackTurn = false;
                    moveConfirmed(cellX, cellY);

                    // resets the invalid move message when a valid move is made
                    // and displays completed moves
                    if (!checkOrCMSituation)
                    {
                        infoLabel.setText(moveMessage);
                    }

                    selected = null;
                    target = null;

                }
                else
                {
                    if (showValid)
                    {
                        updateValidMovesDisplay('r');
                    }
                    infoLabel.setText("Invalid Move.");

                    setImage(selected, selected.abbreviate('i'));
                    target = null;
                    selected = null;
                }
            }

            // If it's white's turn and he selects a black target or empty cell
            else if ((!blackTurn
                && board[cellX][cellY].getColor().equals("black") && pieceHeld && selected != null)
                || (!blackTurn && !(board[cellX][cellY].getOccupied())
                    && pieceHeld && selected != null))
            {
                target = board[cellX][cellY];

                if (withinReach())
                {
                    blackTurn = true;
                    moveConfirmed(cellX, cellY);

                    // resets the invalid move message when a valid move is made
                    // and displays completed moves
                    if (!checkOrCMSituation)
                    {
                        infoLabel.setText(moveMessage);
                    }
                    selected = null;
                    target = null;
                    blackTurn = true;
                }
                else
                {
                    if (showValid)
                    {
                        updateValidMovesDisplay('r');
                    }
                    infoLabel.setText("Invalid Move.");

                    setImage(selected, selected.abbreviate('i'));
                    target = null;
                    selected = null;

                }
            }

        }

    }


    /**
     * When the move has been confirmed to be valid. Sets all of the necessary
     * variables for the end of a turn and moves the pieces.
     *
     * @param x
     *            the the desired x location on the board to move the piece to
     * @param y
     *            the the desired y location on the board to move the piece to
     */
    public void moveConfirmed(int x, int y)
    {
        if (showValid)
        {
            updateValidMovesDisplay('r');
            valid.setChecked(false);
            showValid = false;
        }

        setImage(selected, "transparent");

        ImageView oldLoc = selected.getLocation();
        selected.setLocation(target.getLocation());

        setImage(selected, selected.abbreviate('i'));

        board[getX(oldLoc)][getY(oldLoc)] = new ChessPiece(oldLoc);
        board[getX(target.getLocation())][getY(target.getLocation())] =
            selected;

        if (selected.getType().equals("pawn") && selected.getAtStartLoc())
        {
            selected.setAtStartLoc(false);
        }

        pieceHeld = false;

        // DEBUGGING------------------------------------------------------
// boardToStringPrint();
        // ---------------------------------------------------------------

        // Checks if either player is in check or checkmate and sets the label
        int checkSituation = inCheckOrCheckmate();
        if (checkSituation == 0)
        {
            infoLabel.setText("White has black in check.");
            checkOrCMSituation = true;
        }
        else if (checkSituation == 1 || target.getType().equals("king"))
        {
            infoLabel.setText("Checkmate! White wins!");
            gameOver = true;
            checkOrCMSituation = true;

        }
        else if (checkSituation == 2)
        {
            infoLabel.setText("Black has white in check.");
            checkOrCMSituation = true;

        }
        else if (checkSituation == 3 || target.getType().equals("king"))
        {
            infoLabel.setText("Checkmate! Black wins!");
            gameOver = true;
            checkOrCMSituation = true;

        }

        // converting numbers to letters for move
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String captured = "";
        char selectedXLetter = alphabet.charAt(getX(oldLoc));
        char targetXLetter = alphabet.charAt(getX(selected.getLocation()));

        if (target.getOccupied())
        {
            captured = "Capture!";
        }

        moveMessage =
            selected.getType()
                + " "
                + selectedXLetter
                + String.valueOf(getY(oldLoc))
                + "x"
                + targetXLetter
                + String
                    .valueOf(getY(selected.getLocation()) + "  " + captured);

        if (alwaysOn.isChecked())
        {
            valid.setChecked(true);
        }
    }


    /**
     * Sets the validMovesPiece array of every piece after checking their valid
     * moves with validMove().
     *
     * @param mode
     *            either 'a' for all or 'e' for enemy/empty. If the mode is 'a'
     *            valid moves includes friendly pieces. This is used for
     *            checkmate situations.
     */
    public void setAllValid(char mode)
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (board[x][y].getOccupied())
                {
                    board[x][y]
                        .setValidMovesPiece(validMove(board[x][y], mode));

                    if (board[x][y].getType().equals("pawn"))
                    {
                        board[x][y].setValidAttacks(validAttack(board[x][y]));
                    }
                }
            }
        }
    }


    /**
     * Checks if the target piece is within reach of the player's selected piece
     *
     * @return true if the move is valid and false otherwise
     */
    public boolean withinReach()
    {
        ChessPiece[] validMoves = selected.getValidMovesPiece();

        if (validMoves[0] != null)
        {
            for (int i = 0; i < validMoves.length; i++)
            {

                if (validMoves[i].equals(target))
                {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * determines if any piece on the board has the ability to attack the king
     *
     * @return -1 if not in check or checkmate, 0 if white has black in check, 1
     *         if white has black in checkmate, 2 if black has white in check,
     *         and 3 if black has white in checkmate.
     */
    public int inCheckOrCheckmate()
    {
        setAllValid('a');

        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (board[x][y].getOccupied())
                {

                    ChessPiece[] validMoves;
                    if (board[x][y].getType().equals("pawn"))
                    {
                        validMoves = board[x][y].getValidAttacks();
                    }
                    else
                    {
                        validMoves = board[x][y].getValidMovesPiece();
                    }

                    if (validMoves[0] != null)
                    {
                        for (int i = 0; i < validMoves.length; i++)
                        {
                            // If a white piece has the ability to attack
                            // black's king 0 is returned.
                            if (validMoves[i].getType().equals("king")
                                && validMoves[i].getColor().equals("black")
                                && board[x][y].getColor().equals("white"))
                            {
                                // Check or checkmate decision-----------------
                                ChessPiece[] kingsMoves =
                                    validMoves[i].getValidMovesPiece();
                                for (int j = 0; j < kingsMoves.length; j++)
                                {
                                    if (kingsMoves[j].getType() != "black"
                                        && kingEscape(
                                            kingsMoves[j],
                                            validMoves[i]))
                                    {
                                        return 0;
                                    }
                                }
                                // --------------------------------------------

                                // if no move in kingsMoves is outside of their
                                // opponent's reach, then checkmate.
                                return 1;
                            }

                            // If a black piece has the ability to attack
                            // white's king 2 is returned.
                            if (validMoves[i].getType().equals("king")
                                && validMoves[i].getColor().equals("white")
                                && board[x][y].getColor().equals("black"))
                            {
                                // Check or checkmate decision-----------------
                                ChessPiece[] kingsMoves =
                                    validMoves[i].getValidMovesPiece();
                                for (int j = 0; j < kingsMoves.length; j++)
                                {
                                    if (kingsMoves[j].getType() != "white"
                                        && kingEscape(
                                            kingsMoves[j],
                                            validMoves[i]))
                                    {
                                        return 2;
                                    }
                                }
                                // --------------------------------------------

                                // if no move in kingsMoves is outside of their
                                // opponent's reach, then checkmate.
                                return 3;
                            }

                        }
                    }
                }
            }
        }
        // not in check or checkmate, so -1 is returned
        return -1;
    }


    /**
     * determines if the king can escape from the opposing player by moving to
     * the given ChessPiece location.
     *
     * @param kingTargetMove
     *            where the king is trying to move
     * @param king
     *            the ChessPiece that reperesents the king trying to escape
     * @return true if the king can escape there and false otherwise
     */
    public boolean kingEscape(ChessPiece kingTargetMove, ChessPiece king)
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (board[x][y].getColor() != king.getColor())
                {
                    ChessPiece[] validMoves = board[x][y].getValidMovesPiece();

                    if (board[x][y].getOccupied()
                        && !(board[x][y].equals(king)))
                    {
                        if (board[x][y].getType().equals("pawn"))
                        {
                            ChessPiece[] validAttacks =
                                board[x][y].getValidAttacks();

                            if (validAttacks[0] != null)
                            {
                                for (int i = 0; i < validAttacks.length; i++)
                                {
                                    if (validAttacks[i].equals(kingTargetMove))
                                    {
                                        return false;
                                    }
                                }
                            }
                        }
                        else if (validMoves[0] != null)
                        {
                            for (int i = 0; i < validMoves.length; i++)
                            {

                                if (validMoves[i].equals(kingTargetMove))
                                {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    /**
     * creates the array of valid moves for the given piece
     *
     * @param piece
     *            the piece valid moves are being created for
     * @return an array of valid moves
     */
    /**
     * creates the array of valid moves for the given piece
     *
     * @param piece
     *            the piece valid moves are being created for
     * @param mode
     *            is the mode that the method is being run in 'a' for all pieces
     *            or 'e' for only enemies and empties
     * @return an array of valid moves
     */
    public ChessPiece[] validMove(ChessPiece piece, char mode)
    {
        mostRecentMode = mode;

        String type = piece.getType();
        ChessPiece[] validMoves = new ChessPiece[1];
        ChessPiece[] validMovesIncFriend = new ChessPiece[1];
        int validSpotsFound = 0;
        int validSpotsFoundIncFriend = 0;

        // if the piece is a pawn
        if (type.equals("pawn"))
        {
            // if black
            if (piece.getColor().equals("black"))
            {
                validMoves = new ChessPiece[4];
                validMovesIncFriend = new ChessPiece[4];
                if (piece.getAtStartLoc())
                {
                    // for forward one and two spaces
                    int x = getX(piece.getLocation());
                    int holdy = getY(piece.getLocation()) + 2;
                    for (int y = getY(piece.getLocation()) + 1; y <= holdy
                        && y < 8 && x < 8; y++)
                    {
                        if (!board[x][y].getOccupied())
                        {
                            validMoves[validSpotsFound] = board[x][y];
                            validSpotsFound++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else
                {
                    // for forward one space
                    int x = getX(piece.getLocation());
                    int holdy = getY(piece.getLocation()) + 1;
                    for (int y = getY(piece.getLocation()) + 1; y <= holdy
                        && y < 8 && x < 8; y++)
                    {
                        if (!board[x][y].getOccupied())
                        {
                            validMoves[validSpotsFound] = board[x][y];
                            validSpotsFound++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                // for attacking moves
                // for left diagonal

                int checkLeftDiagX = getX(piece.getLocation()) + 1;
                int checkLeftDiagY = getY(piece.getLocation()) + 1;
                if (checkLeftDiagX < 8 && checkLeftDiagY < 8)
                {
                    if (board[checkLeftDiagX][checkLeftDiagY].getOccupied())
                    {
                        if (!board[checkLeftDiagX][checkLeftDiagY].getColor()
                            .equals(piece.getColor()))
                        {
                            validMoves[validSpotsFound] =
                                board[checkLeftDiagX][checkLeftDiagY];
                            validSpotsFound++;
                        }
                        else if ((blackTurn && piece.getColor().equals("white"))
                            || (!blackTurn && piece.getColor().equals("black")))
                        {
                            validMovesIncFriend[validSpotsFoundIncFriend] =
                                board[checkLeftDiagX][checkLeftDiagY];
                            validSpotsFoundIncFriend++;
                        }

                    }
                }

                // for right diagonal
                int checkRightDiagX = getX(piece.getLocation()) - 1;
                int checkRightDiagY = getY(piece.getLocation()) + 1;
                if (checkRightDiagX > -1 && checkRightDiagY < 8)
                {
                    if (board[checkRightDiagX][checkRightDiagY].getOccupied())
                    {

                        if (!board[checkRightDiagX][checkRightDiagY].getColor()
                            .equals(piece.getColor()))
                        {
                            validMoves[validSpotsFound] =
                                board[checkRightDiagX][checkRightDiagY];
                            validSpotsFound++;
                        }
                        else if ((blackTurn && piece.getColor().equals("white"))
                            || (!blackTurn && piece.getColor().equals("black")))
                        {
                            validMovesIncFriend[validSpotsFoundIncFriend] =
                                board[checkRightDiagX][checkRightDiagY];
                            validSpotsFoundIncFriend++;
                        }
                    }
                }
            }
            // if white
            else if (piece.getColor().equals("white"))
            {
                validMoves = new ChessPiece[4];
                validMovesIncFriend = new ChessPiece[4];
                if (piece.getAtStartLoc())
                {
                    // for forward one and two spaces
                    int x = getX(piece.getLocation());
                    int holdy = getY(piece.getLocation()) - 2;
                    for (int y = getY(piece.getLocation()) - 1; y >= holdy
                        && y > -1 && x > -1; y--)
                    {
                        if (!board[x][y].getOccupied())
                        {
                            validMoves[validSpotsFound] = board[x][y];
                            validSpotsFound++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else
                {
                    // for forward one space
                    int x = getX(piece.getLocation());
                    int holdy = getY(piece.getLocation()) - 1;
                    for (int y = getY(piece.getLocation()) - 1; y >= holdy
                        && y > -1 && x > -1; y--)
                    {
                        if (!board[x][y].getOccupied())
                        {
                            validMoves[validSpotsFound] = board[x][y];
                            validSpotsFound++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }

                // for attacking moves
                // for left diagonal
                int checkLeftDiagX = getX(piece.getLocation()) - 1;
                int checkLeftDiagY = getY(piece.getLocation()) - 1;
                if (checkLeftDiagX > -1 && checkLeftDiagY > -1)
                {
                    if (board[checkLeftDiagX][checkLeftDiagY].getOccupied())
                    {
                        if (!board[checkLeftDiagX][checkLeftDiagY].getColor()
                            .equals(piece.getColor()))
                        {
                            validMoves[validSpotsFound] =
                                board[checkLeftDiagX][checkLeftDiagY];
                            validSpotsFound++;
                        }
                        else if ((blackTurn && piece.getColor().equals("white"))
                            || (!blackTurn && piece.getColor().equals("black")))
                        {
                            validMovesIncFriend[validSpotsFoundIncFriend] =
                                board[checkLeftDiagX][checkLeftDiagY];
                            validSpotsFoundIncFriend++;
                        }
                    }

                }
                // for right diagonal
                int checkRightDiagX = getX(piece.getLocation()) + 1;
                int checkRightDiagY = getY(piece.getLocation()) - 1;
                if (checkRightDiagX < 8 && checkRightDiagY > -1)
                {
                    if (board[checkRightDiagX][checkRightDiagY].getOccupied())
                    {

                        if (!board[checkRightDiagX][checkRightDiagY].getColor()
                            .equals(piece.getColor()))
                        {
                            validMoves[validSpotsFound] =
                                board[checkRightDiagX][checkRightDiagY];
                            validSpotsFound++;
                        }
                        else if ((blackTurn && piece.getColor().equals("white"))
                            || (!blackTurn && piece.getColor().equals("black")))
                        {
                            validMovesIncFriend[validSpotsFoundIncFriend] =
                                board[checkRightDiagX][checkRightDiagY];
                            validSpotsFoundIncFriend++;
                        }
                    }
                }
            }
        }
        // if the piece is a knight
        if (type.equals("knight"))
        {
            validMoves = new ChessPiece[8];
            validMovesIncFriend = new ChessPiece[8];
            int possMove1X = getX(piece.getLocation()) - 2;
            int possMove1Y = getY(piece.getLocation()) - 1;

            int possMove2X = getX(piece.getLocation()) - 1;
            int possMove2Y = getY(piece.getLocation()) - 2;

            int possMove3X = getX(piece.getLocation()) + 1;
            int possMove3Y = getY(piece.getLocation()) - 2;

            int possMove4X = getX(piece.getLocation()) + 2;
            int possMove4Y = getY(piece.getLocation()) - 1;

            int possMove5X = getX(piece.getLocation()) + 2;
            int possMove5Y = getY(piece.getLocation()) + 1;

            int possMove6X = getX(piece.getLocation()) + 1;
            int possMove6Y = getY(piece.getLocation()) + 2;

            int possMove7X = getX(piece.getLocation()) - 1;
            int possMove7Y = getY(piece.getLocation()) + 2;

            int possMove8X = getX(piece.getLocation()) - 2;
            int possMove8Y = getY(piece.getLocation()) + 1;

            if (possMove1X < 8 && possMove1X > -1 && possMove1Y < 8
                && possMove1Y > -1)
            {
                if (!board[possMove1X][possMove1Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove1X][possMove1Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove1X][possMove1Y];
                    validSpotsFoundIncFriend++;
                }
            }

            if (possMove2X < 8 && possMove2X > -1 && possMove2Y < 8
                && possMove2Y > -1)
            {
                if (!board[possMove2X][possMove2Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove2X][possMove2Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove2X][possMove2Y];
                    validSpotsFoundIncFriend++;
                }
            }

            if (possMove3X < 8 && possMove3X > -1 && possMove3Y < 8
                && possMove3Y > -1)
            {
                if (!board[possMove3X][possMove3Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove3X][possMove3Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove3X][possMove3Y];
                    validSpotsFoundIncFriend++;
                }
            }

            if (possMove4X < 8 && possMove4X > -1 && possMove4Y < 8
                && possMove4Y > -1)
            {
                if (!board[possMove4X][possMove4Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove4X][possMove4Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove4X][possMove4Y];
                    validSpotsFoundIncFriend++;
                }
            }

            if (possMove5X < 8 && possMove5X > -1 && possMove5Y < 8
                && possMove5Y > -1)
            {
                if (!board[possMove5X][possMove5Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove5X][possMove5Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove5X][possMove5Y];
                    validSpotsFoundIncFriend++;
                }
            }

            if (possMove6X < 8 && possMove6X > -1 && possMove6Y < 8
                && possMove6Y > -1)
            {
                if (!board[possMove6X][possMove6Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove6X][possMove6Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove6X][possMove6Y];
                    validSpotsFoundIncFriend++;
                }
            }

            if (possMove7X < 8 && possMove7X > -1 && possMove7Y < 8
                && possMove7Y > -1)
            {
                if (!board[possMove7X][possMove7Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove7X][possMove7Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove7X][possMove7Y];
                    validSpotsFoundIncFriend++;
                }
            }

            if (possMove8X < 8 && possMove8X > -1 && possMove8Y < 8
                && possMove8Y > -1)
            {
                if (!board[possMove8X][possMove8Y].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[possMove8X][possMove8Y];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[possMove8X][possMove8Y];
                    validSpotsFoundIncFriend++;
                }
            }

        }
        // if the piece is a rook
        if (type.equals("rook"))
        {
            validMoves = new ChessPiece[14];
            validMovesIncFriend = new ChessPiece[14];
            int rookX = getX(piece.getLocation());
            int rookY = getY(piece.getLocation());
            // check left direction
            for (int x = rookX - 1; x > -1; x--)
            {
                if (!board[x][rookY].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][rookY];
                    validSpotsFound++;
                }
                else if (!board[x][rookY].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][rookY];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[x][rookY];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check right direction
            for (int x = rookX + 1; x < 8; x++)
            {
                if (!board[x][rookY].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][rookY];
                    validSpotsFound++;
                }
                else if (!board[x][rookY].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][rookY];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[x][rookY];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check up direction
            for (int y = rookY - 1; y > -1; y--)
            {
                if (!board[rookX][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[rookX][y];
                    validSpotsFound++;
                }
                else if (!board[rookX][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[rookX][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[rookX][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check down direction
            for (int y = rookY + 1; y < 8; y++)
            {
                if (!board[rookX][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[rookX][y];
                    validSpotsFound++;
                }
                else if (!board[rookX][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[rookX][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[rookX][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }

        }
        // if the piece is a king
        if (type.equals("king"))
        {
            validMoves = new ChessPiece[8];
            validMovesIncFriend = new ChessPiece[8];
            int kingX = getX(piece.getLocation());
            int kingY = getY(piece.getLocation());

            // top left move
            if (kingX - 1 > -1 && kingY - 1 > -1)
            {
                if (!board[kingX - 1][kingY - 1].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX - 1][kingY - 1];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX - 1][kingY - 1];
                    validSpotsFoundIncFriend++;
                }
            }

            // straight up move
            if (kingX > -1 && kingY - 1 > -1)
            {
                if (!board[kingX][kingY - 1].getColor()
                    .equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX][kingY - 1];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX][kingY - 1];
                    validSpotsFoundIncFriend++;
                }
            }
            // top right move
            if (kingX + 1 < 8 && kingY - 1 > -1)
            {
                if (!board[kingX + 1][kingY - 1].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX + 1][kingY - 1];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX + 1][kingY - 1];
                    validSpotsFoundIncFriend++;
                }
            }
            // straight right move
            if (kingX + 1 < 8 && kingY > -1)
            {
                if (!board[kingX + 1][kingY].getColor()
                    .equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX + 1][kingY];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX + 1][kingY];
                    validSpotsFoundIncFriend++;
                }
            }
            // bottom right move
            if (kingX + 1 < 8 && kingY + 1 < 8)
            {
                if (!board[kingX + 1][kingY + 1].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX + 1][kingY + 1];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX + 1][kingY + 1];
                    validSpotsFoundIncFriend++;
                }
            }
            // straight down move
            if (kingX < 8 && kingY + 1 < 8)
            {
                if (!board[kingX][kingY + 1].getColor()
                    .equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX][kingY + 1];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX][kingY + 1];
                    validSpotsFoundIncFriend++;
                }
            }
            // bottom left move
            if (kingX - 1 > -1 && kingY + 1 < 8)
            {
                if (!board[kingX - 1][kingY + 1].getColor().equals(
                    piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX - 1][kingY + 1];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX - 1][kingY + 1];
                    validSpotsFoundIncFriend++;
                }
            }
            // straight left move
            if (kingX - 1 > -1 && kingY < 8)
            {
                if (!board[kingX - 1][kingY].getColor()
                    .equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[kingX - 1][kingY];
                    validSpotsFound++;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[kingX - 1][kingY];
                    validSpotsFoundIncFriend++;
                }
            }
        }
        // if the piece is a queen
        if (type.equals("queen"))
        {
            validMoves = new ChessPiece[27];
            validMovesIncFriend = new ChessPiece[27];
            int queenX = getX(piece.getLocation());
            int queenY = getY(piece.getLocation());

            // check left direction
            for (int x = queenX - 1; x > -1; x--)
            {
                if (!board[x][queenY].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][queenY];
                    validSpotsFound++;
                }
                else if (!board[x][queenY].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][queenY];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[x][queenY];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check right direction
            for (int x = queenX + 1; x < 8; x++)
            {
                if (!board[x][queenY].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][queenY];
                    validSpotsFound++;
                }
                else if (!board[x][queenY].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][queenY];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[x][queenY];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check up direction
            for (int y = queenY - 1; y > -1; y--)
            {
                if (!board[queenX][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[queenX][y];
                    validSpotsFound++;
                }
                else if (!board[queenX][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[queenX][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[queenX][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check down direction
            for (int y = queenY + 1; y < 8; y++)
            {
                if (!board[queenX][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[queenX][y];
                    validSpotsFound++;
                }
                else if (!board[queenX][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[queenX][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] =
                        board[queenX][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check top left diagonal
            for (int x = queenX - 1, y = queenY - 1; x > -1 && y > -1; x--, y--)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check top right diagonal
            for (int x = queenX + 1, y = queenY - 1; x < 8 && y > -1; x++, y--)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check bottom right diagonal
            for (int x = queenX + 1, y = queenY + 1; x < 8 && y < 8; x++, y++)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check bottom left diagonal
            for (int x = queenX - 1, y = queenY + 1; x > -1 && y < 8; x--, y++)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
        }
        // if the piece is a bishop
        if (type.equals("bishop"))
        {
            validMoves = new ChessPiece[13];
            validMovesIncFriend = new ChessPiece[13];
            int bishopX = getX(piece.getLocation());
            int bishopY = getY(piece.getLocation());

            // check top left diagonal
            for (int x = bishopX - 1, y = bishopY - 1; x > -1 && y > -1; x--, y--)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check top right diagonal
            for (int x = bishopX + 1, y = bishopY - 1; x < 8 && y > -1; x++, y--)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check bottom right diagonal
            for (int x = bishopX + 1, y = bishopY + 1; x < 8 && y < 8; x++, y++)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
            // check bottom left diagonal
            for (int x = bishopX - 1, y = bishopY + 1; x > -1 && y < 8; x--, y++)
            {
                if (!board[x][y].getOccupied())
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                }
                else if (!board[x][y].getColor().equals(piece.getColor()))
                {
                    validMoves[validSpotsFound] = board[x][y];
                    validSpotsFound++;
                    break;
                }
                else if ((blackTurn && piece.getColor().equals("white"))
                    || (!blackTurn && piece.getColor().equals("black")))
                {
                    validMovesIncFriend[validSpotsFoundIncFriend] = board[x][y];
                    validSpotsFoundIncFriend++;
                    break;
                }
                else
                {
                    break;
                }
            }
        }
        if (mode == 'e')
        {
            if (validSpotsFound != 0)
            {
                ChessPiece[] fixedValid =
                    Arrays.copyOf(validMoves, validSpotsFound);
                return fixedValid;
            }
            else
            {
                validMoves = new ChessPiece[1];
                validMoves[0] = null;
                return validMoves;
            }
        }
        else if (mode == 'a')
        {
            if (validSpotsFound != 0 && validSpotsFoundIncFriend != 0)
            {
                ChessPiece[] fixedValid =
                    Arrays.copyOf(validMoves, validSpotsFound);
                ChessPiece[] fixedValidIncFriends =
                    Arrays
                        .copyOf(validMovesIncFriend, validSpotsFoundIncFriend);
                ChessPiece[] combinedMoves =
                    new ChessPiece[fixedValid.length
                        + fixedValidIncFriends.length];
                System.arraycopy(
                    fixedValid,
                    0,
                    combinedMoves,
                    0,
                    fixedValid.length);
                System.arraycopy(
                    fixedValidIncFriends,
                    0,
                    combinedMoves,
                    fixedValid.length,
                    fixedValidIncFriends.length);
                return combinedMoves;
            }
            else if (validSpotsFound == 0 && validSpotsFoundIncFriend != 0)
            {
                ChessPiece[] fixedValidIncFriends =
                    Arrays
                        .copyOf(validMovesIncFriend, validSpotsFoundIncFriend);
                return fixedValidIncFriends;
            }
            else if (validSpotsFound != 0 && validSpotsFoundIncFriend == 0)
            {
                ChessPiece[] fixedValid =
                    Arrays.copyOf(validMoves, validSpotsFound);
                return fixedValid;
            }
            else
            {
                validMoves = new ChessPiece[1];
                validMoves[0] = null;
                return validMoves;
            }
        }
        else
        {
            validMoves = new ChessPiece[1];
            validMoves[0] = null;
            return validMoves;
        }

    }


    /**
     * checks if show valid is enabled. If so, the valid moves for the selected
     * piece are shown, via green cells
     *
     * @param mode
     *            set to 's' for show and 'r' for remove
     */
    public void updateValidMovesDisplay(char mode)
    {
        ImageView[] myViews =
            { cell00, cell01, cell02, cell03, cell04, cell05, cell06, cell07,
                cell10, cell11, cell12, cell13, cell14, cell15, cell16, cell17,
                cell20, cell21, cell22, cell23, cell24, cell25, cell26, cell27,
                cell30, cell31, cell32, cell33, cell34, cell35, cell36, cell37,
                cell40, cell41, cell42, cell43, cell44, cell45, cell46, cell47,
                cell50, cell51, cell52, cell53, cell54, cell55, cell56, cell57,
                cell60, cell61, cell62, cell63, cell64, cell65, cell66, cell67,
                cell70, cell71, cell72, cell73, cell74, cell75, cell76, cell77 };

        // show valid moves
        if (mode == 's' && selected != null)
        {
            ChessPiece[] valMoves = selected.getValidMovesPiece();

            if (valMoves[0] != null)
            {
                for (int i = 0; i < valMoves.length; i++)
                {
                    int n =
                        (getY(valMoves[i].getLocation()) * 8)
                            + getX(valMoves[i].getLocation());
                    myViews[n].setBackgroundColor(Color.GREEN);

                    if (valMoves[i].getColor() != selected.getColor()
                        && valMoves[i].getColor() != "none")
                    {
                        myViews[n].setColorFilter(Color.RED);
                    }
                }
            }
        }

        // remove valid moves
        else if (mode == 'r' && selected != null)
        {
            ChessPiece[] valMoves = selected.getValidMovesPiece();
            if (valMoves[0] != null)
            {
                for (int i = 0; i < valMoves.length; i++)
                {
                    int n =
                        (getY(valMoves[i].getLocation()) * 8)
                            + getX(valMoves[i].getLocation());
                    // orange cells
                    if (getY(valMoves[i].getLocation()) % 2 == 0
                        && getX(valMoves[i].getLocation()) % 2 == 0)
                    {
                        myViews[n].setBackgroundColor(Color.rgb(232, 117, 17));
                    }
                    else if (getY(valMoves[i].getLocation()) % 2 != 0
                        && getX(valMoves[i].getLocation()) % 2 != 0)
                    {
                        myViews[n].setBackgroundColor(Color.rgb(232, 117, 17));
                    }

                    // maroon cells
                    else if (getY(valMoves[i].getLocation()) % 2 == 0
                        && getX(valMoves[i].getLocation()) % 2 != 0)
                    {
                        myViews[n].setBackgroundColor(Color.rgb(142, 35, 68));
                    }
                    else if (getY(valMoves[i].getLocation()) % 2 != 0
                        && getX(valMoves[i].getLocation()) % 2 == 0)
                    {
                        myViews[n].setBackgroundColor(Color.rgb(142, 35, 68));
                    }

                    // color filter
                    if (valMoves[i].getColor() != selected.getColor()
                        && valMoves[i].getColor() != "none")
                    {
                        myViews[n].setColorFilter(null);
                    }

                }
            }
        }
    }


    /**
     * When the valid checkbox is clicked, the valid moves are either displayed
     * or removed, depending on their previous state.
     */
    public void validClicked()
    {
        if (!alwaysOn.isChecked())
        {
            if (showValid)
            {
                alwaysOn.setClickable(true);
                if (selected != null)
                {
                    updateValidMovesDisplay('r');
                }
                showValid = false;
            }
            else if (pieceHeld)
            {
                updateValidMovesDisplay('s');
                showValid = true;
            }
        }
    }


    /**
     * When the always on checkbox is clicked, the valid moves are either
     * displayed or removed, depending on their previous state and the valid
     * checkbox is either checked or unchecked.
     */
    public void alwaysOnClicked()
    {
        if (!alwaysOn.isChecked())
        {
            valid.setChecked(false);
            valid.setClickable(true);
            showValid = false;
            if (selected != null)
            {
                updateValidMovesDisplay('r');
            }
        }
        else
        {
            valid.setChecked(true);
            valid.setClickable(false);
            if (pieceHeld)
            {
                updateValidMovesDisplay('s');
            }
            showValid = true;
        }

    }


    /**
     * gets the valid attacks for each piece
     *
     * @param piece
     *            is the piece to find the attacks for
     * @return returns the pieces that the current piece can attack
     */
    public ChessPiece[] validAttack(ChessPiece piece)
    {
        ChessPiece[] validAttacks = new ChessPiece[1];
        int validAttacksFound = 0;
        if (piece.getColor().equals("black"))
        {
            validAttacks = new ChessPiece[2];
            // for attacking moves
            // for left diagonal
            int checkLeftDiagX = getX(piece.getLocation()) + 1;
            int checkLeftDiagY = getY(piece.getLocation()) + 1;
            if (checkLeftDiagX < 8 && checkLeftDiagY < 8)
            {
                if (board[checkLeftDiagX][checkLeftDiagY].getOccupied()
                    && !board[checkLeftDiagX][checkLeftDiagY].getColor()
                        .equals(piece.getColor()))
                {
                    validAttacks[validAttacksFound] =
                        board[checkLeftDiagX][checkLeftDiagY];
                    validAttacksFound++;
                }
            }
            // for right diagonal
            int checkRightDiagX = getX(piece.getLocation()) - 1;
            int checkRightDiagY = getY(piece.getLocation()) + 1;
            if (checkRightDiagX > -1 && checkRightDiagY < 8)
            {
                if (board[checkRightDiagX][checkRightDiagY].getOccupied()
                    && !board[checkRightDiagX][checkRightDiagY].getColor()
                        .equals(piece.getColor()))
                {
                    validAttacks[validAttacksFound] =
                        board[checkRightDiagX][checkRightDiagY];
                    validAttacksFound++;
                }
            }
        }
        else if (piece.getColor().equals("white"))
        {
            validAttacks = new ChessPiece[2];
            // for attacking moves
            // for left diagonal
            int checkLeftDiagX = getX(piece.getLocation()) - 1;
            int checkLeftDiagY = getY(piece.getLocation()) - 1;
            if (checkLeftDiagX > -1 && checkLeftDiagY > -1)
            {
                if (board[checkLeftDiagX][checkLeftDiagY].getOccupied()
                    && !board[checkLeftDiagX][checkLeftDiagY].getColor()
                        .equals(piece.getColor()))
                {
                    validAttacks[validAttacksFound] =
                        board[checkLeftDiagX][checkLeftDiagY];
                    validAttacksFound++;
                }
            }
            // for right diagonal
            int checkRightDiagX = getX(piece.getLocation()) + 1;
            int checkRightDiagY = getY(piece.getLocation()) - 1;
            if (checkRightDiagX < 8 && checkRightDiagY > -1)
            {
                if (board[checkRightDiagX][checkRightDiagY].getOccupied()
                    && !board[checkRightDiagX][checkRightDiagY].getColor()
                        .equals(piece.getColor()))
                {
                    validAttacks[validAttacksFound] =
                        board[checkRightDiagX][checkRightDiagY];
                    validAttacksFound++;
                }
            }
        }

        if (validAttacksFound != 0)
        {
            ChessPiece[] fixedValid =
                Arrays.copyOf(validAttacks, validAttacksFound);
            return fixedValid;
        }
        else
        {
            validAttacks = new ChessPiece[1];
            validAttacks[0] = null;
            return validAttacks;
        }
    }


    /**
     * resets the board when the reset button is clicked
     */
    public void resetClicked()
    {
        if (showValid)
        {
            updateValidMovesDisplay('r');
            valid.setChecked(false);
            alwaysOn.setChecked(false);
        }

        initialize();

        // Black
        cell00.setImageResource(R.drawable.br);
        cell01.setImageResource(R.drawable.bn);
        cell02.setImageResource(R.drawable.bb);
        cell03.setImageResource(R.drawable.bq);
        cell04.setImageResource(R.drawable.bk);
        cell05.setImageResource(R.drawable.bb);
        cell06.setImageResource(R.drawable.bn);
        cell07.setImageResource(R.drawable.br);

        cell10.setImageResource(R.drawable.bp);
        cell11.setImageResource(R.drawable.bp);
        cell12.setImageResource(R.drawable.bp);
        cell13.setImageResource(R.drawable.bp);
        cell14.setImageResource(R.drawable.bp);
        cell15.setImageResource(R.drawable.bp);
        cell16.setImageResource(R.drawable.bp);
        cell17.setImageResource(R.drawable.bp);

        // White
        cell60.setImageResource(R.drawable.wp);
        cell61.setImageResource(R.drawable.wp);
        cell62.setImageResource(R.drawable.wp);
        cell63.setImageResource(R.drawable.wp);
        cell64.setImageResource(R.drawable.wp);
        cell65.setImageResource(R.drawable.wp);
        cell66.setImageResource(R.drawable.wp);
        cell67.setImageResource(R.drawable.wp);

        cell70.setImageResource(R.drawable.wr);
        cell71.setImageResource(R.drawable.wn);
        cell72.setImageResource(R.drawable.wb);
        cell73.setImageResource(R.drawable.wq);
        cell74.setImageResource(R.drawable.wk);
        cell75.setImageResource(R.drawable.wb);
        cell76.setImageResource(R.drawable.wn);
        cell77.setImageResource(R.drawable.wr);

        // Empty
        cell20.setImageResource(android.R.color.transparent);
        cell21.setImageResource(android.R.color.transparent);
        cell22.setImageResource(android.R.color.transparent);
        cell23.setImageResource(android.R.color.transparent);
        cell24.setImageResource(android.R.color.transparent);
        cell25.setImageResource(android.R.color.transparent);
        cell26.setImageResource(android.R.color.transparent);
        cell27.setImageResource(android.R.color.transparent);

        cell30.setImageResource(android.R.color.transparent);
        cell31.setImageResource(android.R.color.transparent);
        cell32.setImageResource(android.R.color.transparent);
        cell33.setImageResource(android.R.color.transparent);
        cell34.setImageResource(android.R.color.transparent);
        cell35.setImageResource(android.R.color.transparent);
        cell36.setImageResource(android.R.color.transparent);
        cell37.setImageResource(android.R.color.transparent);

        cell40.setImageResource(android.R.color.transparent);
        cell41.setImageResource(android.R.color.transparent);
        cell42.setImageResource(android.R.color.transparent);
        cell43.setImageResource(android.R.color.transparent);
        cell44.setImageResource(android.R.color.transparent);
        cell45.setImageResource(android.R.color.transparent);
        cell46.setImageResource(android.R.color.transparent);
        cell47.setImageResource(android.R.color.transparent);

        cell50.setImageResource(android.R.color.transparent);
        cell51.setImageResource(android.R.color.transparent);
        cell52.setImageResource(android.R.color.transparent);
        cell53.setImageResource(android.R.color.transparent);
        cell54.setImageResource(android.R.color.transparent);
        cell55.setImageResource(android.R.color.transparent);
        cell56.setImageResource(android.R.color.transparent);
        cell57.setImageResource(android.R.color.transparent);

        // DEBUGGING----------------------------------------------
// textToBoard("[bk][bn][bb][wn][bk][bb][bn][br]"
// + "[bp][bp][bp][bp][bp][bp][wr][bp]"
// + "[  ][  ][  ][  ][  ][  ][  ][  ]"
// + "[wr][  ][  ][wn][  ][  ][bk][  ]"
// + "[  ][  ][  ][  ][  ][  ][  ][  ]"
// + "[  ][  ][  ][  ][  ][wp][  ][  ]"
// + "[wp][wp][wp][wp][wp][wp][wp][wp]"
// + "[wr][wn][br][wq][wk][wb][wn][wr]");
        // ------------------------------------------------------
    }


// ----------------------------------------------------------------------------

// Debugging Methods ----------------------------------------------------------

    /**
     * converts the users string input into a board of pieces based upon two
     * letter abbreviations for each piece.
     *
     * @param input
     *            the user's input
     */
    public void textToBoard(String input)
    {
        ImageView[] myViews =
            { cell00, cell01, cell02, cell03, cell04, cell05, cell06, cell07,
                cell10, cell11, cell12, cell13, cell14, cell15, cell16, cell17,
                cell20, cell21, cell22, cell23, cell24, cell25, cell26, cell27,
                cell30, cell31, cell32, cell33, cell34, cell35, cell36, cell37,
                cell40, cell41, cell42, cell43, cell44, cell45, cell46, cell47,
                cell50, cell51, cell52, cell53, cell54, cell55, cell56, cell57,
                cell60, cell61, cell62, cell63, cell64, cell65, cell66, cell67,
                cell70, cell71, cell72, cell73, cell74, cell75, cell76, cell77 };

        String color = "";
        String type = "";
        Boolean startLoc = false;

        int stringStart = 1;

        for (int i = 0; i < 64; i++)
        {
            ImageView loc = myViews[i];

            if (input.substring(stringStart, stringStart + 2).equals("  "))
            {
                myViews[i].setImageResource(android.R.color.transparent);
                board[getX(myViews[i])][getY(myViews[i])] = new ChessPiece(loc);
            }
            else
            {
                myViews[i].setImageResource(getResources().getIdentifier(
                    input.substring(stringStart, stringStart + 2),
                    "drawable",
                    getPackageName()));

                String oneSpot = input.substring(stringStart, stringStart + 2);
                if (oneSpot.charAt(0) == 'w')
                {
                    color = "white";
                }
                if (oneSpot.charAt(0) == 'b')
                {
                    color = "black";
                }
                if (oneSpot.charAt(1) == 'r')
                {
                    type = "rook";
                }
                if (oneSpot.charAt(1) == 'n')
                {
                    type = "knight";
                }
                if (oneSpot.charAt(1) == 'b')
                {
                    type = "bishop";
                }
                if (oneSpot.charAt(1) == 'q')
                {
                    type = "queen";
                }
                if (oneSpot.charAt(1) == 'k')
                {
                    type = "king";
                }
                if (oneSpot.charAt(1) == 'p')
                {
                    type = "pawn";
                    if (color.equals("white") && getY(myViews[i]) == 1)
                    {
                        startLoc = true;
                    }
                    if (color.equals("black") && getY(myViews[i]) == 6)
                    {
                        startLoc = true;
                    }
                }
                board[getX(myViews[i])][getY(myViews[i])] =
                    new ChessPiece(color, type, startLoc, loc);
            }
            stringStart += 4;
        }
    }


    /**
     * sets the imageview's resource based upon the imgage name
     *
     * @param piece
     *            the piece to set the image of
     * @param imgName
     *            the name of the image
     */
    public void setImage(ChessPiece piece, String imgName)
    {

        ImageView[] myViews =
            { cell00, cell01, cell02, cell03, cell04, cell05, cell06, cell07,
                cell10, cell11, cell12, cell13, cell14, cell15, cell16, cell17,
                cell20, cell21, cell22, cell23, cell24, cell25, cell26, cell27,
                cell30, cell31, cell32, cell33, cell34, cell35, cell36, cell37,
                cell40, cell41, cell42, cell43, cell44, cell45, cell46, cell47,
                cell50, cell51, cell52, cell53, cell54, cell55, cell56, cell57,
                cell60, cell61, cell62, cell63, cell64, cell65, cell66, cell67,
                cell70, cell71, cell72, cell73, cell74, cell75, cell76, cell77 };

        int i = (getY(piece.getLocation()) * 8) + getX(piece.getLocation());

        myViews[i].setImageResource(getResources().getIdentifier(
            imgName,
            "drawable",
            getPackageName()));

    }


    /**
     * turns the board into a string representation. For example, if run on the
     * board at the beginning of the game it would return
     * "[br][bn][bb][bq][bk][bb][bn][br][bp][bp][bp][bp][bp][bp][bp][bp][ ][ ][
     * ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][
     * ][ ][ ][ ][ ][ ][wp][wp][wp][wp][wp][wp][wp][wp][wr][wn][wb][wq][wk][wb]
     * [wn][wr]" The characters are read by row, left to right, starting with
     * the top row and printed continuously. [bn] = black knight [wn] = white
     * knight (The k was taken by king)
     *
     * @return the string representation of the board
     */
    public String boardToString()
    {
        String result = "";
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                result = result + board[x][y].abbreviate('t');
            }
        }
        return result;

    }


    /**
     * Prints the board as a textual representation This is for use in debugging
     * as the string is printed into LogCat At the beginning of the game this
     * would print [br][bn][bb][bq][bk][bb][bn][br]
     * [bp][bp][bp][bp][bp][bp][bp][bp] [ ][ ][ ][ ][ ][ ][ ][ ] [ ][ ][ ][ ][
     * ][ ][ ][ ] [ ][ ][ ][ ][ ][ ][ ][ ] [ ][ ][ ][ ][ ][ ][ ][ ]
     * [wp][wp][wp][wp][wp][wp][wp][wp] [wr][wn][wb][wq][wk][wb][wn][wr] [bn] =
     * black knight [wn] = white knight (The k was taken by king)
     */
    public void boardToStringPrint()
    {
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                System.out.print(board[x][y].abbreviate('t'));
            }
            System.out.println();
        }

    }


    /**
     * gets the cell's x-coordinate
     *
     * @param loc
     *            the location to check
     * @return the x-coordinate
     */
    public int getX(ImageView loc)
    {
        return cells.get(loc).charAt(5) - '0';
    }


    /**
     * gets the cell's y-coordinate
     *
     * @param loc
     *            the location to check
     * @return the y-coordinate
     */
    public int getY(ImageView loc)
    {
        return cells.get(loc).charAt(4) - '0';
    }


    /**
     * gets the specific ChessPiece at the given location
     *
     * @param x
     *            the x-coordinate
     * @param y
     *            the y-coordinate
     * @return the piece
     */
    public ChessPiece getSpecificPiece(int x, int y)
    {
        return board[x][y];
    }
}
