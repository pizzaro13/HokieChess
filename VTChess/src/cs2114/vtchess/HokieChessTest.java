package cs2114.vtchess;

import sofia.app.Screen;
import sofia.graphics.ShapeView;
import android.content.res.Resources;
import android.widget.CheckBox;
import java.util.Map;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.net.Uri;
import android.content.Intent;
import sofia.widget.ImageView;

// -------------------------------------------------------------------------
/**
 * Tests for the HokieChess class
 *
 * @author Kent Hannigan (kent) && Wilson Rhodes (rush)
 * @version (2014.04.15)
 */
public class HokieChessTest
    extends student.AndroidTestCase<HokieChess>
{
    // ~ Fields ................................................................

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
    private boolean                pieceHeld;
    private Button                 reset;
    private HokieChess             test;


    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public HokieChessTest()
    {
        super(HokieChess.class);
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Initializes the text fixtures.
     */
    public void setUp()
    {
        this.test = getScreen();
    }


    /**
     * tests the reset
     */
    public void testResetClicked()
    {
        Resources cellPiece = cell04.getResources();
        click(reset);
        assertEquals(cellPiece, cell00.getResources());
    }

    public void testInitialPosition()
    {
        assertEquals("[br][bn][bb][bq][bk][bb][bn][br]"
            + "[bp][bp][bp][bp][bp][bp][bp][bp]"
            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
            + "[wp][wp][wp][wp][wp][wp][wp][wp]"
            + "[wr][wn][wb][wq][wk][wb][wn][wr]", test.boardToString());
    }

    public void testPawnMove1()
    {
        //from board start touch down cell (0,6)
        //touchdownCell(0, 6);
        //touch down cell (0,5)
        //touchdownCell(0, 5);
        //assert that the pawns location updated
        //assertEquals("pawn", getScreen().getSpecificPiece(0, 5).getType());
    }

    public void testPawnMove2()
    {
        //from board start touch down cell (0,6)
        //touch down cell (0,4)
        //assert that the pawns location updated
    }

    public void testPawnMove3()
    {
        //set the board state to have a pawn not at start location ex(0,4)
        //touch down cell (0,4)
        //touch down cell (0,3)
        //assert that the pawns location updated
    }

    public void testKnightMove1()
    {
        //set the board state to have only a few pieces, one of them being a
        //knight at (3,4)
        //touch down cell(3,4)
        //touch down cell (1,3)
        //assert the knights location updated
    }

    public void testKnightMove2()
    {
        //set the board state to have only a few pieces, one of them being a
        //knight at (3,4)
        //touch down cell(3,4)
        //touch down cell (2,2)
        //assert the knights location updated
    }

    public void testKnightMove3()
    {
        //set the board state to have only a few pieces, one of them being a
        //knight at (3,4)
        //touch down cell(3,4)
        //touch down cell (2,2)
        //assert the knights location updated
    }


}
