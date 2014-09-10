package cs2114.vtchess;

import android.widget.ImageView;

// -------------------------------------------------------------------------
/**
 * This class represents a ChessPiece as part of an android chess application.
 *
 * @authors Kent Hannigan (kent) and Wilson Rhodes (rush)
 * @version 2014.04.29
 */
public class ChessPiece
{
// Fields----------------------------------------------------------------------
    private String       type;           // determines moves allowed
    private String       color;          // = "white" or "black"
    private boolean      occupied;       // is space empty or occupied?
    private boolean      atStartLoc;     // if pawn set to false after it has
// moved from its starting location
    private ImageView    location;       // the location of the piece
    private ChessPiece[] validMovesPiece;
    private ChessPiece[] validAttacks;


// Constructors----------------------------------------------------------------

    /**
     * constructor when only an ImageView is provided
     *
     * @param loc
     *            the imageView to set as the piece's location
     */
    public ChessPiece(ImageView loc)
    {
        type = "none";
        color = "none";
        location = loc;
        occupied = false;
        atStartLoc = false;
        validMovesPiece = new ChessPiece[1];
        validMovesPiece[0] = null;

    }


    /**
     * constructor used for all pieces except pawns and empty cells
     *
     * @param col
     *            is the color to set the new piece to
     * @param typ
     *            is the type to set the new piece to
     * @param loc
     *            the imageView to set as the piece's location
     */
    public ChessPiece(String col, String typ, ImageView loc)
    {
        type = typ;
        color = col;
        location = loc;
        occupied = true;
        atStartLoc = false; // assuming constructor is only used beyond setup
        validMovesPiece = new ChessPiece[1];
        validMovesPiece[0] = null;
    }


    /**
     * constructor used for pawns. includes the extra variable start.
     *
     * @param col
     *            is the color to set the new piece to
     * @param typ
     *            is the type to set the new piece to
     * @param start
     *            tells if the piece is to be considered at its starting
     *            location or not
     * @param loc
     *            the imageView to set as the piece's location
     */
    public ChessPiece(String col, String typ, boolean start, ImageView loc)
    {
        type = typ;
        color = col;
        location = loc;
        occupied = true;
        atStartLoc = start;
        validMovesPiece = new ChessPiece[1];
        validMovesPiece[0] = null;
    }


// Accessors-------------------------------------------------------------------
    /**
     * gets the type of the piece
     *
     * @return the type as a string, where options are "king", "queen", "pawn",
     *         "knight", "bishop", "rook"
     */
    public String getType()
    {
        return type;
    }


    /**
     * gets the color of the piece
     *
     * @return either "white" or "black"
     */
    public String getColor()
    {
        return color;
    }


    /**
     * gets where or not the piece is at its start location
     *
     * @return true if it is at the start location and false otherwise
     */
    public boolean getAtStartLoc()
    {
        return atStartLoc;
    }


    /**
     * gets whether or not the cell is occupied by a piece
     *
     * @return true if it is occupied and false otherwise
     */
    public boolean getOccupied()
    {
        return occupied;
    }


    /**
     * gets the location
     *
     * @return the ImageView associated with the piece
     */
    public ImageView getLocation()
    {
        return location;
    }


    /**
     * gets the valid moves of the piece
     *
     * @return an array of the pieces this piece can move to
     */
    public ChessPiece[] getValidMovesPiece()
    {
        return validMovesPiece;
    }


    /**
     * gets the valid attacks of a pawn
     *
     * @return an array of its valid attacks
     */
    public ChessPiece[] getValidAttacks()
    {
        return validAttacks;
    }


// Modifiers-------------------------------------------------------------------
    /**
     * sets the type of the piece
     *
     * @param newType
     *            the type to set the piece to
     */
    public void setType(String newType)
    {
        type = newType;
    }


    /**
     * sets the color of the piece
     *
     * @param newColor
     *            = the color to set the piece to
     */
    public void setColor(String newColor)
    {
        color = newColor;
    }


    /**
     * sets whether or not the piece is at its start location. Only used for
     * pawn.
     *
     * @param val
     *            either true or false
     */
    public void setAtStartLoc(boolean val)
    {
        atStartLoc = val;
    }


    /**
     * sets whether or not the cell is occupied
     *
     * @param val
     *            either true or false
     */
    public void setOccupied(boolean val)
    {
        occupied = val;
    }


    /**
     * sets the ImageView location of the piece
     *
     * @param loc
     *            the ImageView to set the piece's location to
     */
    public void setLocation(ImageView loc)
    {
        location = loc;
    }


    /**
     * sets the valid moves of the piece
     *
     * @param moves
     *            the array of valid moves
     */
    public void setValidMovesPiece(ChessPiece[] moves)
    {
        validMovesPiece = moves;
    }


    /**
     * sets the valid attacks of a pawn
     *
     * @param valAttacks
     */
    public void setValidAttacks(ChessPiece[] valAttacks)
    {
        validAttacks = valAttacks;
    }


    /**
     * prints the string representation of the piece
     *
     * @return the string
     */
    public String toString()
    {
        return "Color: " + color + "  Type: " + type + "  Occupied: "
            + occupied;
    }


    /**
     * abbreviates the piece as two characters with or without brackets
     * depending on the mode 't' = text mode 'i' = image mode One is used for
     * testing and the other is used for setting the imageview to a resource
     *
     * @param mode
     *            the mode to use abbreviate in. Either 'i' or 't'
     * @return the abbreviation
     */
    public String abbreviate(char mode)
    {
        String firstLetter = null;
        String secondLetter = null;

        if (color == "white")
            firstLetter = "w";
        else if (color == "black")
            firstLetter = "b";

        if (type == "knight")
            secondLetter = "n";
        else if (type == "rook")
            secondLetter = "r";
        else if (type == "king")
            secondLetter = "k";
        else if (type == "queen")
            secondLetter = "q";
        else if (type == "bishop")
            secondLetter = "b";
        else if (type == "pawn")
            secondLetter = "p";

        if (firstLetter == null && secondLetter == null)
            return "[  ]";
        else if (mode == 'i')
        {
            return firstLetter + secondLetter;
        }
        // mode is 't'
        else
        {
            return "[" + firstLetter + secondLetter + "]";
        }

    }

}
