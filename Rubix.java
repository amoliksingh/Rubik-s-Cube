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

public class Rubix extends Rubix2nd
{
  
  /*
   * public String revThis() { String temp = ""; for (int i =
   * moves.length()-1; i >= 0; i--) { String temp2; char c = moves.charAt(i);
   * if (c == 'u' || c == 'b' || c == 'r' || c == 'f' || c == 'l' || c == 'd')
   * { temp2 = c + ""; temp2 = temp2.toUpperCase(); temp = temp + temp2; }
   * else if (c == 'U' || c == 'B' || c == 'R' || c == 'F' || c == 'L' || c ==
   * 'D') { temp2 = c + ""; temp2 = temp2.toLowerCase(); temp = temp + temp2;
   * } else temp = temp + c; } return temp; }
   */
  
  public String invert()
  {
    String temp = "";
    
    int i = 0;
    while (i < moves.length())
    {
      char c = moves.charAt(i);
      // System.out.println(temp + "3");
      if (c == 'u')
        temp = temp + "d";
      else if (c == 'U')
        temp = temp + "D";
      else if (c == 'd')
        temp = temp + "u";
      else if (c == 'D')
        temp = temp + "U";
      else if (c == 'r')
        temp = temp + "l";
      else if (c == 'R')
        temp = temp + "L";
      else if (c == 'l')
        temp = temp + "r";
      else if (c == 'L')
        temp = temp + "R";
      else
        temp = temp + c;
      i++;
    }
    
    return temp;
  }
  
  public String fixThis()
  {
    
    String temp = "";
    int i = 0;
    while (i < moves.length() - 4)
    {
      // System.out.println(temp + "3");
      if (moves.substring(i, i + 4).equals("uuuu") && moves.charAt(i + 4) != '2')
      {
        temp = temp + "";
        i += 3;
      }
      else if (moves.substring(i, i + 3).equals("uuu") && moves.charAt(i + 3) != '2')
      {
        // System.out.println(moves.substring(i, i+3) + "4");
        temp = temp + "U";
        i += 2;
      }
      else if (moves.substring(i, i + 4).equals("uuu2"))
      {
        temp = temp + "";
        i += 3;
      }
      else if (moves.substring(i, i + 4).equals("u2uu"))
      {
        temp = temp + "";
        i += 3;
      }
      else if (moves.substring(i, i + 4).equals("uu2u"))
      {
        temp = temp + "";
        i += 3;
      }
      else if (moves.substring(i, i + 2).equals("uU") && moves.charAt(i + 2) != '2')
      {
        temp = temp + "";
        i++;
      }
      else if (moves.substring(i, i + 2).equals("Uu") && moves.charAt(i + 2) != '2')
      {
        temp = temp + "";
        i++;
      }
      else if (moves.substring(i, i + 3).equals("uU2"))
      {
        temp = temp + "U";
        i += 2;
      }
      else if (i == moves.length() - 5)
        temp = temp + moves.substring(i, moves.length());
      else
        temp = temp + moves.charAt(i);
      i++;
      // System.out.println(temp + "4");
    }
    
    return temp;
  }
  
  public Rubix(int a[][][], int b, int c, int d, int e, int f, int g)
  {
    super(a, b, c, d, e, f, g);
  }
  
  public void solve()
  {
    solveCross();
    moves = moves + "\n";
    solveBotCorners();
    moves = moves + "\n";
    solve2ndLayer();
    moves = moves + "\n";
    orientTopEdges();
    moves = moves + "\n";
    fixTopEdges();
    moves = moves + "\n";
    cornerShuffle();
    orient();
    // System.out.println(moves);
    // printCube();
    moves = fixThis();
    moves = invert();
  }
  
  public void solveTest()
  {
    solveCross();
    moves = moves + "\n";
    f2l();
    f2l();
    f2l();
    f2l();
    moves = moves + "\n";
  }
  
  public void orient()
  {
    Corner tLeft = new Corner(myCube[5][0][0], myCube[1][0][2], myCube[4][0][0], top, back, left);
    Corner tRight = new Corner(myCube[5][0][2], myCube[2][0][2], myCube[1][0][0], top, right, back);
    Corner bRight = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, front, right);
    Corner bLeft = new Corner(myCube[5][2][0], myCube[4][0][2], myCube[3][0][0], top, left, front);
    
    int count = 0;
    
    if (bRight.leftSide == 5)
      doOrient();
    else if (bRight.rightSide == 5)
      doRevOrient();
    
    doValue(top);
    count++;
    tRight = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, right, back);
    
    if (tRight.leftSide == 5)
      doOrient();
    else if (tRight.rightSide == 5)
      doRevOrient();
    
    doValue(top);
    count++;
    tLeft = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, back, left);
    
    if (tLeft.leftSide == 5)
      doOrient();
    else if (tLeft.rightSide == 5)
      doRevOrient();
    
    doValue(top);
    count++;
    bLeft = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, left, front);
    
    if (bLeft.leftSide == 5)
      doOrient();
    else if (bLeft.rightSide == 5)
      doRevOrient();
    
    doValue(top);
    count++;
    
    if (count == 3)
      doValue(top);
    else if (count == 2)
      doValue2(top);
    else if (count == 1)
      doRevValue(top);
  }
  
  public void doOrient()
  {
    for (int i = 0; i < 2; i++)
    {
      doRevValue(right);
      doValue(bottom);
      doValue(right);
      doRevValue(bottom);
    }
  }
  
  public void doRevOrient()
  {
    for (int i = 0; i < 2; i++)
    {
      doValue(bottom);
      doRevValue(right);
      doRevValue(bottom);
      doValue(right);
    }
  }
  
  public void cornerShuffle()
  {
    Corner tLeft = new Corner(myCube[5][0][0], myCube[1][0][2], myCube[4][0][0], top, back, left);
    Corner tRight = new Corner(myCube[5][0][2], myCube[2][0][2], myCube[1][0][0], top, right, back);
    Corner bRight = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, front, right);
    Corner bLeft = new Corner(myCube[5][2][0], myCube[4][0][2], myCube[3][0][0], top, left, front);
    
    for (int i = 0; i < 10; i++)
      // while (!(tLeft.inPosition() && tRight.inPosition() &&
      // bRight.inPosition() && bLeft.inPosition()))
    {
      // System.out.println(bLeft);
      if (bRight.inPosition() && !bLeft.inPosition())
        do3CornerShuffle(right, left);
      else if (bLeft.inPosition() && !tLeft.inPosition())
        do3CornerShuffle(front, back);
      else if (tLeft.inPosition() && !tRight.inPosition())
        do3CornerShuffle(left, right);
      else if (tRight.inPosition() && !bRight.inPosition())
        do3CornerShuffle(back, front);
      else if (tLeft.inPosition() && tRight.inPosition() && bRight.inPosition() && bLeft.inPosition())
        break;
      else
      {
        do3CornerShuffle(right, left);
      }
      tLeft = new Corner(myCube[5][0][0], myCube[1][0][2], myCube[4][0][0], top, back, left);
      tRight = new Corner(myCube[5][0][2], myCube[2][0][2], myCube[1][0][0], top, right, back);
      bRight = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, front, right);
      bLeft = new Corner(myCube[5][2][0], myCube[4][0][2], myCube[3][0][0], top, left, front);
    }
  }
  
  public void do3CornerShuffle(int whichSide, int opp)
  {
    doValue(top);
    doValue(whichSide);
    doRevValue(top);
    doRevValue(opp);
    doValue(top);
    doRevValue(whichSide);
    doRevValue(top);
    doValue(opp);
  }
  
  public void fixTopEdges()
  {
    int bTop = myCube[1][0][1];
    int rTop = myCube[2][0][1];
    int fTop = myCube[3][0][1];
    int lTop = myCube[4][0][1];
    
    for (int i = 0; i < 100; i++)
    {
      if (!(bTop == back && rTop == right && fTop == front && lTop == left))
      {
        if (bTop == back && rTop == right)
          doAlg2(right);
        else if (rTop == right && fTop == front)
          doAlg2(front);
        else if (fTop == front && lTop == left)
          doAlg2(left);
        else if (lTop == left && bTop == back)
          doAlg2(back);
        else if (lTop == left && rTop == right)
          doAlg2(right);
        else if (bTop == back && fTop == front)
          doAlg2(right);
        else
          doValue(top);
      }
      bTop = myCube[1][0][1];
      rTop = myCube[2][0][1];
      fTop = myCube[3][0][1];
      lTop = myCube[4][0][1];
    }
  }
  
  public void orientTopEdges()
  {
    int tTop = myCube[5][0][1];
    int tLeft = myCube[5][1][0];
    int tRight = myCube[5][1][2];
    int tBottom = myCube[5][2][1];
    
    for (int i = 0; i < 1; i++)
    {
      if (tLeft == top && tRight == top && tTop == top && tBottom == top)
      {
        break;
      }
      else if (tTop == top && tLeft == top)
        doAlg();
      else if (tTop == top && tRight == top)
      {
        moves = moves + "U";
        uPrime();
        doAlg();
      }
      else if (tLeft == top && tBottom == top)
      {
        moves = moves + "u";
        u();
        doAlg();
      }
      else if (tRight == top && tBottom == top)
      {
        moves = moves + "u2";
        u2();
        doAlg();
      }
      else if (tTop == top && tBottom == top)
      {
        moves = moves + "u";
        u();
        doRevAlg();
      }
      else if (tLeft == top && tRight == top)
        doRevAlg();
      else
      {
        doAlg();
        moves = moves + "u";
        u();
        doRevAlg();
      }
    }
  }
  
  public void doAlg()
  {
    moves = moves + "furURF";
    f();
    u();
    r();
    uPrime();
    rPrime();
    fPrime();
  }
  
  public void doRevAlg()
  {
    moves = moves + "fruRUF";
    f();
    r();
    u();
    rPrime();
    uPrime();
    fPrime();
  }
  
  public void doAlg2(int whichSide)
  {
    // ruRuru2R
    doValue(whichSide);
    doValue(top);
    doRevValue(whichSide);
    doValue(top);
    doValue(whichSide);
    doValue2(top);
    doRevValue(whichSide);
    doValue(top);
  }
}