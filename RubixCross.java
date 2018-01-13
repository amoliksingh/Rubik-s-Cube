/*
 * Name: Amolik Singh
 * Date: Jan. 12, 2017
 * Class: Rubix.java
 * Desc: This class is an object named Rubix and has various parameters,
 * such as a 3d array to store the values of the sides of the cube as numbers
 * and has variables to determine which integers represent which sides
 * 0 - bottom, 1 - back, 2 - right, 3 - front, 4 - left, 5 - top
 * Lower case letters are clockwise moves, Upper case are counter
 */

public class RubixCross extends RubixBase
{

 public RubixCross(int a[][][], int b, int c, int d, int e, int f, int g)
 {
  super (a, b, c, d, e, f, g);
 }

 public void solveCross()
 {
  boolean isTopBadT = myCube[5][0][1] == bottom;
  boolean isLeftBadT = myCube[5][1][0] == bottom;
  boolean isRightBadT = (myCube[5][1][2] == bottom);
  boolean isBottomBadT = myCube[5][2][1] == bottom;

  int tTop = myCube[5][0][1];
  int tLeft = myCube[5][1][0];
  int tRight = myCube[5][1][2];
  int tBottom = myCube[5][2][1];
  int bTop = myCube[1][0][1];
  int rTop = myCube[2][0][1];
  int fTop = myCube[3][0][1];
  int lTop = myCube[4][0][1];
  int pair1 = myCube[1][2][1];
  int pair2 = myCube[2][2][1];
  int pair3 = myCube[3][2][1];
  int pair4 = myCube[4][2][1];
  /*int bBack = myCube[0][2][1];
  int bRight = myCube[0][1][2];
  int bFront = myCube[0][0][1];
  int bLeft = myCube[0][1][0];*/

  boolean badBottom = (myCube[0][2][1] == bottom && pair1 != back)
    || (myCube[0][1][2] == bottom && pair2 != right);
  badBottom = (badBottom) || (myCube[0][0][1] == bottom && pair3 != front)
    || (myCube[0][1][0] == bottom && pair4 != left);

  for (int i = 0; i < 100; i++)
  // while(bBack != bottom || bRight != bottom || bFront != bottom ||
  // bLeft != bottom)
  {
   if (myCube[3][1][0] == bottom && myCube[4][1][2] == left)
   {
    moves = moves + "l";
    l();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (myCube[1][1][2] == bottom && myCube[4][1][0] == left)
   {
    moves = moves + "L";
    lPrime();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (myCube[3][1][2] == bottom && myCube[2][1][0] == right)
   {
    moves = moves + "R";
    rPrime();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (myCube[1][1][0] == bottom && myCube[2][1][2] == right)
   {
    moves = moves + "r";
    r();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (myCube[2][1][0] == bottom && myCube[3][1][2] == front)
   {
    moves = moves + "f";
    f();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (myCube[4][1][2] == bottom && myCube[3][1][0] == front)
   {
    moves = moves + "F";
    fPrime();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (myCube[2][1][2] == bottom && myCube[1][1][0] == back)
   {
    moves = moves + "B";
    bPrime();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (myCube[4][1][0] == bottom && myCube[1][1][2] == back)
   {
    moves = moves + "b";
    b();
   }
   
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];

   // System.out.println((isRightBadT) + " " + (myCube[5][2][1]) + " "
   // + bottom);
   
   if (tTop == bottom)
   {
    if (bTop == left)
     doRevValue(top);
    else if (bTop == right)
     doValue(top);
    else if (bTop == front)
     doValue2(top);
   }
   else if (rTop == bottom)
   {
    if (rTop == back)
     doRevValue(top);
    else if (rTop == front)
     doValue(top);
    else if (rTop == left)
     doValue2(top);
   }
   else if (fTop == bottom)
   {
    if (fTop == right)
     doRevValue(top);
    else if (fTop == left)
     doValue(top);
    else if (fTop == back)
     doValue2(top);
   }
   else if (lTop == bottom)
   {
    if (lTop == front)
     doRevValue(top);
    else if (lTop == back)
     doValue(top);
    else if (lTop == right)
     doValue2(top);
   }
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = (myCube[5][1][2] == bottom);
   isBottomBadT = myCube[5][2][1] == bottom;

   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
   
   if (isTopBadT || isLeftBadT || isRightBadT || isBottomBadT)
   {
    if (tTop == bottom)
    {
     moveToBottom(1, back, right, front, left);
     // printCube();
    }
    else if (tRight == bottom)
    {
     moveToBottom(2, right, front, left, back);
    }
    else if (tBottom == bottom)
    {
     moveToBottom(3, front, left, back, right);
    }
    else if (tLeft == bottom)
    {
     moveToBottom(4, left, back, right, front);
    }
    else
     u();
   }
   else if (badBottom)
   {
    //System.out.println("here");
    fixBottom();
   }
   else if (bTop == bottom)
   {
    outwardsSolveTop(right, left, back);
   }
   else if (rTop == bottom)
   {
    // System.out.println("here");
    outwardsSolveTop(front, back, right);
   }
   else if (fTop == bottom)
   {
    // System.out.println("here");
    outwardsSolveTop(left, right, front);
   }
   else if (lTop == bottom)
   {
    //System.out.println("here");
    outwardsSolveTop(back, front, left);
   }
   else if (pair1 == bottom || pair2 == bottom || pair3 == bottom || pair4 == bottom)
   {
    outwardsSolveBot(pair1, pair2, pair3, pair4);
   }
   else
   {
    finalCross();
   }
   isTopBadT = myCube[5][0][1] == bottom;
   isLeftBadT = myCube[5][1][0] == bottom;
   isRightBadT = myCube[5][1][2] == bottom;
   isBottomBadT = myCube[5][2][1] == bottom;
   tTop = myCube[5][0][1];
   tLeft = myCube[5][1][0];
   tRight = myCube[5][1][2];
   tBottom = myCube[5][2][1];
   bTop = myCube[1][0][1];
   rTop = myCube[2][0][1];
   fTop = myCube[3][0][1];
   lTop = myCube[4][0][1];
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];

   /*bBack = myCube[0][2][1];
   bRight = myCube[0][1][2];
   bFront = myCube[0][0][1];
   bLeft = myCube[0][1][0];*/

   badBottom = (myCube[0][2][1] == bottom && pair1 != back) || (myCube[0][1][2] == bottom && pair2 != right);
   badBottom = (badBottom) || (myCube[0][0][1] == bottom && pair3 != front)
     || (myCube[0][1][0] == bottom && pair4 != left);

   // if (i <= 4)
   // printCube();
  }
  for (int i = 0; i < 100; i++)
  // while (pair1 != back || pair2 != right || pair3 != front || pair4 !=
  // left)
  {
   if (pair1 != back && pair2 != right && pair3 != front && pair4 != left)
   {
    moves = moves + "d";
    d();
   }
   else if (pair1 == back && pair2 == right && pair3 == front && pair4 == left)
   {
    break;
   }
   else
   {
    if (pair1 != back)
    {
     if (pair1 == right)
     {
      moves = moves + "bdBDb";
      dDAlg('b');
     }
     else if (pair1 == left)
     {
      moves = moves + "bDBdb";
      DdAlg('b');
     }
     else if (pair1 == front)
     {
      moves = moves + "bd2Bd2b";
      d2Alg('b');
     }
    }
    if (pair2 != right)
    {
     if (pair2 == front)
     {
      moves = moves + "rdRDr";
      dDAlg('r');
     }
     else if (pair2 == back)
     {
      moves = moves + "rDRdr";
      DdAlg('r');
     }
     else if (pair2 == left)
     {
      moves = moves + "rd2Rd2r";
      d2Alg('r');
     }
    }
    if (pair3 != front)
    {
     if (pair3 == left)
     {
      moves = moves + "fdFDf";
      dDAlg('f');
     }
     else if (pair3 == right)
     {
      moves = moves + "fDFdf";
      DdAlg('f');
     }
     else if (pair3 == back)
     {
      moves = moves + "fd2Fd2f";
      d2Alg('f');
     }
    }
    if (pair4 != left)
    {
     if (pair4 == back)
     {
      moves = moves + "rdRDr";
      dDAlg('r');
     }
     else if (pair4 == front)
     {
      moves = moves + "rDRdr";
      DdAlg('r');
     }
     else if (pair4 == right)
     {
      moves = moves + "rd2Rd2r";
      d2Alg('r');
     }
    }
   }
   pair1 = myCube[1][2][1];
   pair2 = myCube[2][2][1];
   pair3 = myCube[3][2][1];
   pair4 = myCube[4][2][1];
  }

 }

 public void outwardsSolveTop(int clockwise, int cc, int move)
 {
  int tTop = myCube[5][0][1];
  int tLeft = myCube[5][1][0];
  int tRight = myCube[5][1][2];
  int tBottom = myCube[5][2][1];
  int top;
  if (move == back)
   top = tTop;
  else if (move == right)
   top = tRight;
  else if (move == front)
   top = tBottom;
  else
   top = tLeft;

  if (top == clockwise)
  {
   doRevValue(move);
   doValue(clockwise);
   doValue(move);
  }
  else if (top == cc)
  {
   doValue(move);
   doRevValue(cc);
   doRevValue(move);
  }
  else
  {
   moves = moves + "u";
   u();
  }
 }

 public void outwardsSolveBot(int pair1, int pair2, int pair3, int pair4)
 {
  // System.out.println("here");
  if (pair1 == bottom)
  {
   if (myCube[0][2][1] == left)
   {
    moves = moves + "BL";
    bPrime();
    lPrime();
   }
   else if (myCube[0][2][1] == right)
   {
    moves = moves + "br";
    b();
    r();
   }
   else
   {
    moves = moves + "b2";
    b2();
   }
  }
  else if (pair2 == bottom)
  {
   if (myCube[0][1][1] == back)
   {
    moves = moves + "RB";
    rPrime();
    bPrime();
   }
   else if (myCube[0][1][2] == front)
   {
    moves = moves + "rf";
    r();
    f();
   }
   else
   {
    moves = moves + "f2";
    f2();
   }
  }
  else if (pair3 == bottom)
  {
   if (myCube[0][0][1] == right)
   {
    moves = moves + "FR";
    fPrime();
    rPrime();
   }
   else if (myCube[0][0][1] == left)
   {
    moves = moves + "fl";
    f();
    l();
   }
   else
   {
    moves = moves + "f2";
    f2();
   }
  }
  else if (pair4 == bottom)
  {
   if (myCube[0][1][0] == front)
   {
    moves = moves + "LF";
    lPrime();
    fPrime();
   }
   else if (myCube[0][1][0] == back)
   {
    moves = moves + "lb";
    l();
    b();
   }
   else
   {
    moves = moves + "l2";
    l2();
   }
  }
 }

 public void fixBottom()
 {
  int pair1 = myCube[1][2][1];
  int pair2 = myCube[2][2][1];
  int pair3 = myCube[3][2][1];
  int pair4 = myCube[4][2][1];
  if (myCube[0][2][1] == bottom && pair1 != back)
  {
   if (pair1 == front)
   {
    moves = moves + "bd2Bd2b";
    d2Alg('b');
   }
   else if (pair1 == right)
   {
    moves = moves + "bdBDb";
    dDAlg('b');
   }
   else if (pair1 == left)
   {
    moves = moves + "bDBdb";
    DdAlg('b');
   }
  }
  pair1 = myCube[1][2][1];
  pair2 = myCube[2][2][1];
  pair3 = myCube[3][2][1];
  pair4 = myCube[4][2][1];
  if (myCube[0][1][2] == bottom && pair2 != right)
  {
   if (pair2 == left)
   {
    moves = moves + "rd2Rd2r";
    d2Alg('r');
   }
   else if (pair2 == front)
   {
    moves = moves + "rdRDr";
    dDAlg('r');
   }
   else if (pair2 == back)
   {
    // System.out.println(pair2 + "here");
    moves = moves + "rDRdr";
    DdAlg('r');
   }
  }
  pair1 = myCube[1][2][1];
  pair2 = myCube[2][2][1];
  pair3 = myCube[3][2][1];
  pair4 = myCube[4][2][1];
  if (myCube[0][0][1] == bottom && pair3 != front)
  {
   if (pair3 == back)
   {
    moves = moves + "fd2Fd2f";
    d2Alg('f');
   }
   else if (pair3 == left)
   {
    moves = moves + "fdFDf";
    dDAlg('f');
   }
   else if (pair3 == right)
   {
    moves = moves + "fDFdf";
    DdAlg('f');
   }
  }
  pair1 = myCube[1][2][1];
  pair2 = myCube[2][2][1];
  pair3 = myCube[3][2][1];
  pair4 = myCube[4][2][1];
  if (myCube[0][1][0] == bottom && pair4 != left)
  {
   if (pair4 == right)
   {
    moves = moves + "ld2Ld2l";
    d2Alg('l');
   }
   else if (pair4 == back)
   {
    moves = moves + "ldLDl";
    dDAlg('l');
   }
   else if (pair4 == front)
   {
    moves = moves + "lDLdl";
    DdAlg('l');
   }
  }
 }

 public void d2Alg(char move)
 {
  doMove(move);
  d2();
  doRevMove(move);
  d2();
  doMove(move);
 }

 public void dDAlg(char move)
 {
  doMove(move);
  d();
  doRevMove(move);
  dPrime();
  doMove(move);
 }

 public void DdAlg(char move)
 {
  doMove(move);
  dPrime();
  doRevMove(move);
  d();
  doMove(move);
 }

 public void moveToBottom(int whichSide, int side1, int side2, int side3, int side4)
 {
  int pair;
  pair = myCube[whichSide][0][1];
  String add;
  // printCube();
  // System.out.println(pair + " " + whichSide);

  if (pair == back)
   add = "b2";
  else if (pair == right)
   add = "r2";
  else if (pair == front)
   add = "f2";
  else
   add = "l2";

  if (pair == side1)
  {
   moves = moves + add;
  }
  else if (pair == side2)
  {
   moves = moves + "u" + add;
   u();
  }
  else if (pair == side3)
  {
   moves = moves + "u2" + add;
   u();
   u();
  }
  else if (pair == side4)
  {
   moves = moves + "U" + add;
   // uPrime();
   u();
   u();
   u();
  }
  if (pair == back)
  {
   b2();
  }
  else if (pair == right)
   r2();
  else if (pair == front)
   f2();
  else
  {
   l2();
  }
 }

 public void finalCross()
 {
  // int bBack = myCube[0][2][1];
  // int bRight = myCube[0][1][2];
  // int bFront = myCube[0][0][1];
  // int bLeft = myCube[0][1][0];

  // these left and right are basically if they are on the left side or
  // the right side when facing that side not as in green and blue
  int backLeft = myCube[1][1][0];
  int backRight = myCube[1][1][2];
  int rightLeft = myCube[2][1][0];
  int rightRight = myCube[2][1][2];
  int frontLeft = myCube[3][1][0];
  int frontRight = myCube[3][1][2];
  int leftLeft = myCube[4][1][0];
  int leftRight = myCube[4][1][2];

  if (backLeft == bottom)
  {
   // sidePiece, whichSide the edge piece is not white, clockwise side,
   // cc side, opp side
   fixSidePiece(rightRight, right, front, back);
  }
  else if (rightLeft == bottom)
   fixSidePiece(frontRight, front, left, right);
  else if (frontLeft == bottom)
   fixSidePiece(leftRight, left, back, front);
  else if (leftLeft == bottom)
   fixSidePiece(backRight, back, right, left);
  else if (backRight == bottom)
   fixSidePiece2(leftLeft, left, back, front);
  else if (leftRight == bottom)
   fixSidePiece2(frontLeft, front, left, right);
  else if (frontRight == bottom)
   fixSidePiece2(rightLeft, right, front, back);
  else if (rightRight == bottom)
   fixSidePiece2(backLeft, back, right, left);

  // bBack = myCube[0][2][1];
  // bRight = myCube[0][1][2];
  // bFront = myCube[0][0][1];
  // bLeft = myCube[0][1][0];
 }

 // for side pieces on the right
 public void fixSidePiece(int theRight, int whichSide, int clockwise, int cc)
 {
  // printCube();
  if (theRight == whichSide)
  {
   doValue(whichSide);
  }
  else if (theRight == cc)
  {
   doRevValue(0);
   doValue(whichSide);
   doValue(0);
  }
  else if (theRight == clockwise)
  {
   doValue(0);
   doValue(whichSide);
   doRevValue(0);
  }
  else
  {
   doValue(0);
   doValue(0);
   doValue(whichSide);
   doValue(0);
   doValue(0);
  }
 }

 // fix this for the general case ****
 // for side pieces on the left
 public void fixSidePiece2(int theLeft, int whichSide, int clockwise, int cc)
 {
  if (theLeft == whichSide)
  {
   doRevValue(whichSide);
  }
  else if (theLeft == cc)
  {
   doRevValue(0);
   doRevValue(whichSide);
   doValue(0);
  }
  else if (theLeft == clockwise)
  {
   doValue(0);
   doRevValue(whichSide);
   doRevValue(0);
  }
  else
  {
   doValue(0);
   doValue(0);
   doRevValue(whichSide);
   doValue(0);
   doValue(0);
  }
 }

}