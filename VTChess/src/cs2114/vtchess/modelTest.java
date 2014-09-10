package cs2114.vtchess;

//package com.example.vtchess;
//
//import android.widget.ImageView;
//import java.util.HashMap;
//
//public class modelTest
//    extends student.TestCase
//{
//    HokieChess        test;
//
//    private ImageView cell00;
//    private ImageView cell01;
//    private ImageView cell02;
//    private ImageView cell03;
//    private ImageView cell04;
//    private ImageView cell05;
//    private ImageView cell06;
//    private ImageView cell07;
//
//    private ImageView cell10;
//    private ImageView cell11;
//    private ImageView cell12;
//    private ImageView cell13;
//    private ImageView cell14;
//    private ImageView cell15;
//    private ImageView cell16;
//    private ImageView cell17;
//
//    private ImageView cell20;
//    private ImageView cell21;
//    private ImageView cell22;
//    private ImageView cell23;
//    private ImageView cell24;
//    private ImageView cell25;
//    private ImageView cell26;
//    private ImageView cell27;
//
//    private ImageView cell30;
//    private ImageView cell31;
//    private ImageView cell32;
//    private ImageView cell33;
//    private ImageView cell34;
//    private ImageView cell35;
//    private ImageView cell36;
//    private ImageView cell37;
//
//    private ImageView cell40;
//    private ImageView cell41;
//    private ImageView cell42;
//    private ImageView cell43;
//    private ImageView cell44;
//    private ImageView cell45;
//    private ImageView cell46;
//    private ImageView cell47;
//
//    private ImageView cell50;
//    private ImageView cell51;
//    private ImageView cell52;
//    private ImageView cell53;
//    private ImageView cell54;
//    private ImageView cell55;
//    private ImageView cell56;
//    private ImageView cell57;
//
//    private ImageView cell60;
//    private ImageView cell61;
//    private ImageView cell62;
//    private ImageView cell63;
//    private ImageView cell64;
//    private ImageView cell65;
//    private ImageView cell66;
//    private ImageView cell67;
//
//    private ImageView cell70;
//    private ImageView cell71;
//    private ImageView cell72;
//    private ImageView cell73;
//    private ImageView cell74;
//    private ImageView cell75;
//    private ImageView cell76;
//    private ImageView cell77;
//
//
//    public void setUp()
//    {
//        test = new HokieChess();
//        test.textToBoard("[bk][bn][bb][wn][bk][bb][bn][br]"
//            + "[bp][bp][bp][bp][bp][bp][wr][bp]"
//            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
//            + "[wr][  ][  ][wn][  ][  ][bk][  ]"
//            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
//            + "[  ][  ][  ][  ][  ][wp][  ][  ]"
//            + "[wp][wp][wp][wp][wp][wp][wp][wp]"
//            + "[wr][wn][br][wq][wk][wb][wn][wr]");
//    }
//
//
//    public void testBoardToString()
//    {
//        HashMap<ImageView, String> cells = new HashMap<ImageView, String>(64);
//
//        cells.put(cell00, "cell00");
//        cells.put(cell01, "cell01");
//        cells.put(cell02, "cell02");
//        cells.put(cell03, "cell03");
//        cells.put(cell04, "cell04");
//        cells.put(cell05, "cell05");
//        cells.put(cell06, "cell06");
//        cells.put(cell07, "cell07");
//
//        cells.put(cell10, "cell10");
//        cells.put(cell11, "cell11");
//        cells.put(cell12, "cell12");
//        cells.put(cell13, "cell13");
//        cells.put(cell14, "cell14");
//        cells.put(cell15, "cell15");
//        cells.put(cell16, "cell16");
//        cells.put(cell17, "cell17");
//
//        cells.put(cell20, "cell20");
//        cells.put(cell21, "cell21");
//        cells.put(cell22, "cell22");
//        cells.put(cell23, "cell23");
//        cells.put(cell24, "cell24");
//        cells.put(cell25, "cell25");
//        cells.put(cell26, "cell26");
//        cells.put(cell27, "cell27");
//
//        cells.put(cell30, "cell30");
//        cells.put(cell31, "cell31");
//        cells.put(cell32, "cell32");
//        cells.put(cell33, "cell33");
//        cells.put(cell34, "cell34");
//        cells.put(cell35, "cell35");
//        cells.put(cell36, "cell36");
//        cells.put(cell37, "cell37");
//
//        cells.put(cell40, "cell40");
//        cells.put(cell41, "cell41");
//        cells.put(cell42, "cell42");
//        cells.put(cell43, "cell43");
//        cells.put(cell44, "cell44");
//        cells.put(cell45, "cell45");
//        cells.put(cell46, "cell46");
//        cells.put(cell47, "cell47");
//
//        cells.put(cell50, "cell50");
//        cells.put(cell51, "cell51");
//        cells.put(cell52, "cell52");
//        cells.put(cell53, "cell53");
//        cells.put(cell54, "cell54");
//        cells.put(cell55, "cell55");
//        cells.put(cell56, "cell56");
//        cells.put(cell57, "cell57");
//
//        cells.put(cell60, "cell60");
//        cells.put(cell61, "cell61");
//        cells.put(cell62, "cell62");
//        cells.put(cell63, "cell63");
//        cells.put(cell64, "cell64");
//        cells.put(cell65, "cell65");
//        cells.put(cell66, "cell66");
//        cells.put(cell67, "cell67");
//
//        cells.put(cell70, "cell70");
//        cells.put(cell71, "cell71");
//        cells.put(cell72, "cell72");
//        cells.put(cell73, "cell73");
//        cells.put(cell74, "cell74");
//        cells.put(cell75, "cell75");
//        cells.put(cell76, "cell76");
//        cells.put(cell77, "cell77");
//
//        assertEquals("[bk][bn][bb][wn][bk][bb][bn][br]"
//            + "[bp][bp][bp][bp][bp][bp][wr][bp]"
//            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
//            + "[wr][  ][  ][wn][  ][  ][bk][  ]"
//            + "[  ][  ][  ][  ][  ][  ][  ][  ]"
//            + "[  ][  ][  ][  ][  ][wp][  ][  ]"
//            + "[wp][wp][wp][wp][wp][wp][wp][wp]"
//            + "[wr][wn][br][wq][wk][wb][wn][wr]", test.boardToString());
//    }
//}

//public void testPawnMove1()
//{
//    //from board start touch down cell (0,6)
//    touchdownCell(0, 6);
//    //touch down cell (0,5)
//    touchdownCell(0, 5);
//    //assert that the pawns location updated
//    assertEquals("pawn", getScreen().getSpecificPiece(0, 5).getType());
//}
//
//public void testPawnMove2()
//{
//    //from board start touch down cell (0,6)
//    //touch down cell (0,4)
//    //assert that the pawns location updated
//}
//
//public void testPawnMove3()
//{
//    //set the board state to have a pawn not at start location ex(0,4)
//    //touch down cell (0,4)
//    //touch down cell (0,3)
//    //assert that the pawns location updated
//}
//
//public void testKnightMove1()
//{
//    //set the board state to have only a few pieces, one of them being a
//    //knight at (3,4)
//    //touch down cell(3,4)
//    //touch down cell (1,3)
//    //assert the knights location updated
//}
//
//public void testKnightMove2()
//{
//    //set the board state to have only a few pieces, one of them being a
//    //knight at (3,4)
//    //touch down cell(3,4)
//    //touch down cell (2,2)
//    //assert the knights location updated
//}
//
//public void testKnightMove3()
//{
//    //set the board state to have only a few pieces, one of them being a
//    //knight at (3,4)
//    //touch down cell(3,4)
//    //touch down cell (2,2)
//    //assert the knights location updated
//}
//
////HelperMethods----------------------------------------------------------------
//
//private void touchdownCell(int x, int y)
//{
//    float rawX = x*54 + 25;
//    float rawY = y*54 + 135;
//    int cellX = (int)((x - 25) / 54);
//    int cellY = (int)((y - 135) / 54);
//    test.processTouch(rawX, rawY);
//    //touchDown(view,rawX, rawY);
//}
//
//
//public void testProcessTouch()
//{
//
//}
