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

public class Rubix2nd extends RubixCross
{
  
  public Corner bBL = new Corner(myCube[0][2][0], myCube[4][2][0], myCube[1][2][2], bottom, left, back);
  public Corner bBR = new Corner(myCube[0][2][2], myCube[1][2][0], myCube[2][2][2], bottom, back, right);
  public Corner bFR = new Corner(myCube[0][0][2], myCube[2][2][0], myCube[3][2][2], bottom, right, front);
  public Corner bFL = new Corner(myCube[0][0][0], myCube[3][2][0], myCube[4][2][2], bottom, front, left);
  public Corner tBL = new Corner(myCube[5][0][0], myCube[1][0][2], myCube[4][0][0], top, back, left);
  public Corner tBR = new Corner(myCube[5][0][2], myCube[2][0][2], myCube[1][0][0], top, right, back);
  public Corner tFR = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, front, right);
  public Corner tFL = new Corner(myCube[5][2][0], myCube[4][0][2], myCube[3][0][0], top, left, front);
  
  public Edge bTop = new Edge(myCube[1][0][1], myCube[5][0][1]);
  public Edge rTop = new Edge(myCube[2][0][1], myCube[5][1][2]);
  public Edge fTop = new Edge(myCube[3][0][1], myCube[5][2][1]);
  public Edge lTop = new Edge(myCube[4][0][1], myCube[5][1][0]);
  
  public Edge rb = new Edge(myCube[2][1][2], myCube[1][1][0], false, false);
  public Edge fr = new Edge(myCube[3][1][2], myCube[2][1][0], false, false);
  public Edge lf = new Edge(myCube[4][1][2], myCube[3][1][0], false, false);
  public Edge bl = new Edge(myCube[1][1][2], myCube[4][1][0], false, false);
  
  public Rubix2nd(int a[][][], int b, int c, int d, int e, int f, int g)
  {
    super(a, b, c, d, e, f, g);
  }
  
  public void update()
  {
    bBL = new Corner(myCube[0][2][0], myCube[4][2][0], myCube[1][2][2], bottom, left, back);
    bBR = new Corner(myCube[0][2][2], myCube[1][2][0], myCube[2][2][2], bottom, back, right);
    bFR = new Corner(myCube[0][0][2], myCube[2][2][0], myCube[3][2][2], bottom, right, front);
    bFL = new Corner(myCube[0][0][0], myCube[3][2][0], myCube[4][2][2], bottom, front, left);
    tBL = new Corner(myCube[5][0][0], myCube[1][0][2], myCube[4][0][0], top, back, left);
    tBR = new Corner(myCube[5][0][2], myCube[2][0][2], myCube[1][0][0], top, right, back);
    tFR = new Corner(myCube[5][2][2], myCube[3][0][2], myCube[2][0][0], top, front, right);
    tFL = new Corner(myCube[5][2][0], myCube[4][0][2], myCube[3][0][0], top, left, front);
    
    bTop = new Edge(myCube[1][0][1], myCube[5][0][1]);
    rTop = new Edge(myCube[2][0][1], myCube[5][1][2]);
    fTop = new Edge(myCube[3][0][1], myCube[5][2][1]);
    lTop = new Edge(myCube[4][0][1], myCube[5][1][0]);
    
    rb = new Edge(myCube[2][1][2], myCube[1][1][0], false, false);
    fr = new Edge(myCube[3][1][2], myCube[2][1][0], false, false);
    lf = new Edge(myCube[4][1][2], myCube[3][1][0], false, false);
    bl = new Edge(myCube[1][1][2], myCube[4][1][0], false, false);
  }
  
  public void f2l()
  {
    // bottom back left, rest follow the pattern
    update();
    
    if (tBR.leftSide == bottom || tFR.leftSide == bottom || tFL.leftSide == bottom || tBL.leftSide == bottom)
    {
      if (tBL.leftSide == bottom)
      {
        y();
        y();
      }
      else if (tBR.leftSide == bottom)
        y();
      else if (tFL.leftSide == bottom)
        yPrime();
      update();
      int rig = tFR.rightSide;
      if (rig == back)
        wideDPrime();
      else if (rig == front)
        wideD();
      else if (rig == left)
      {
        wideD();
        wideD();
      }
      update();
      
      moves = moves + " ";
      if (tFR.rightSide == rTop.leftSide && tFR.topSide == rTop.rightSide)
        rightInsert();
      else if (tFR.rightSide == lTop.rightSide && tFR.topSide == lTop.leftSide)
        righty();
      else if (fr.leftSide == front && fr.rightSide == right)
      {
        rightBaseCase4();
        rightInsert();
      }
      else if (fr.leftSide == right && fr.rightSide == front)
      {
        rightBaseCase1();
        righty();
      }
      else if (tFR.rightSide == bTop.leftSide && tFR.topSide == bTop.rightSide)
      {
        rightBaseCase1();
        rightInsert();
      }
      else if (tFR.rightSide == lTop.leftSide && tFR.topSide == lTop.rightSide)
      {
        rightBaseCase2();
        rightInsert();
      }
      else if (tFR.rightSide == fTop.leftSide && tFR.topSide == fTop.rightSide)
      {
        rightBaseCase3();
        rightBaseCase2();
        rightInsert();
      }
      else if (tFR.rightSide == bTop.rightSide && tFR.topSide == bTop.leftSide)
      {
        rightBaseCase4();
        righty();
      }
      else if (tFR.rightSide == lTop.rightSide && tFR.topSide == lTop.leftSide)
      {
        rightBaseCase2();
        righty();
      }
      else if (tFR.rightSide == fTop.rightSide && tFR.topSide == fTop.leftSide)
      {
        rightBaseCase3();
        righty();
      }
      else
      {
        wideD();
        update();
        if (fr.leftSide == tFR.topSide && fr.rightSide == tFR.rightSide)
        {
          System.out.println("here");
          rightBaseCase4();
          wideDPrime();
          rightInsert();
        }
        else if (fr.leftSide == tFR.rightSide && fr.rightSide == tFR.topSide)
        {
          rightBaseCase1();
          wideDPrime();
          righty();
        }
        else
        {
          wideD();
          update();
          if (fr.leftSide == tFR.topSide && fr.rightSide == tFR.rightSide)
          {
            rightBaseCase4();
            wideD();
            wideD();
            rightInsert();
          }
          else if (fr.leftSide == tFR.rightSide && fr.rightSide == tFR.topSide)
          {
            rightBaseCase1();
            wideD();
            wideD();
            righty();
          }
          else
          {
            wideD();
            update();
            if (fr.leftSide == tFR.topSide && fr.rightSide == tFR.rightSide)
            {
              rightBaseCase4();
              wideD();
              rightInsert();
            }
            else if (fr.leftSide == tFR.rightSide && fr.rightSide == tFR.topSide)
            {
              rightBaseCase1();
              wideD();
              righty();
            }
          }
        }
      }
      update();
    }
    else if (tBR.rightSide == bottom || tFR.rightSide == bottom || tFL.rightSide == bottom || tBL.rightSide == bottom)
    {
      if (tBR.rightSide == bottom)
      {
        y();
        y();
      }
      else if (tFR.rightSide == bottom)
        y();
      else if (tBL.rightSide == bottom)
        yPrime();
      update();
      int lef = tFL.leftSide;
      if (lef == front)
        wideDPrime();
      else if (lef == back)
        wideD();
      else if (lef == right)
      {
        wideD();
        wideD();
      }
      update();
      if (tFL.leftSide == lTop.leftSide && tFL.topSide == lTop.rightSide)
        leftInsert();
      else if (tFL.leftSide == rTop.rightSide && tFL.topSide == rTop.leftSide)
        lefty();
      else if (lf.leftSide == left && lf.rightSide == front)
      {
        leftBaseCase4(); // surprsingly the same
        leftInsert();
      }
      else if (lf.leftSide == front && lf.rightSide == left)
      {
        leftBaseCase1(); // surprsingly the same
        lefty();
      }
      else if (tFL.leftSide == bTop.leftSide && tFL.topSide == bTop.rightSide)
      {
        leftBaseCase1();
        leftInsert();
      }
      else if (tFL.leftSide == rTop.leftSide && tFL.topSide == rTop.rightSide)
      {
        leftBaseCase2();
        leftInsert();
      }
      else if (tFL.leftSide == fTop.leftSide && tFL.topSide == fTop.rightSide)
      {
        leftBaseCase3();
        leftBaseCase2();
        leftInsert();
      }
      else if (tFL.leftSide == bTop.rightSide && tFL.topSide == bTop.leftSide)
      {
        leftBaseCase4();
        lefty();
      }
      else if (tFL.leftSide == lTop.rightSide && tFL.topSide == lTop.leftSide)
      {
        leftBaseCase2();
        lefty();
      }
      else if (tFL.leftSide == fTop.rightSide && tFL.topSide == fTop.leftSide)
      {
        leftBaseCase3();
        lefty();
      }
      update();
    }
    else if (tBR.topSide == bottom || tFR.topSide == bottom || tFL.topSide == bottom || tBL.topSide == bottom)
    {
      // code this today boi, itz 911 pm lelz
    }
  }
  
  public void leftBaseCase1()
  {
    u();
    lPrime();
    uPrime();
    l();
    uPrime();
    moves = moves + "uLUlU";
  }
  
  public void leftBaseCase2()
  {
    u();
    lPrime();
    u2();
    l();
    uPrime();
    moves = moves + "uLu2lU";
  }
  
  public void leftBaseCase3() // split front left
  {
    uPrime();
    f();
    uPrime();
    fPrime();
    u();
    moves = moves + "UfUFu";
  }
  
  public void leftBaseCase4() // split back left
  {
    u();
    lPrime();
    u();
    l();
    uPrime();
    moves = moves + "uLulU";
  }
  
  public void rightBaseCase1()
  {
    uPrime();
    r();
    u();
    rPrime();
    u();
    moves = moves + "UruRu";
  }
  
  public void rightBaseCase2()
  {
    uPrime();
    r();
    u2();
    rPrime();
    u();
    moves = moves + "Uru2Ru";
  }
  
  public void rightBaseCase3() // split front right
  {
    u();
    fPrime();
    u();
    f();
    uPrime();
    moves = moves + "uFufU";
  }
  
  public void rightBaseCase4() // split back right
  {
    uPrime();
    r();
    uPrime();
    rPrime();
    u();
    moves = moves + "UrURu";
  }
  
  public void lefty()
  {
    f();
    u();
    fPrime();
    moves = moves + "fuF";
  }
  
  public void righty()
  {
    fPrime();
    uPrime();
    f();
    moves = moves + "FUf";
  }
  
  public void leftInsert()
  {
    uPrime();
    lPrime();
    u();
    l();
    moves = moves + "ULul";
  }
  
  public void rightInsert()
  {
    u();
    r();
    uPrime();
    rPrime();
    moves = moves + "urUR";
  }
  
  public void solve2ndLayer()
  {
    // rb is right back, fr is front right, lf is left front, bl is back
    // left
    update();
    boolean isAnyMessed = (rb.isMessedNotYellow() || fr.isMessedNotYellow());
    isAnyMessed = (isAnyMessed || lf.isMessedNotYellow() || bl.isMessedNotYellow());
    boolean quit = false;
    boolean trueQuit = false;
    int count = 0;
    
    for (int i = 0; i < 100; i++)
    {
      for (int j = 0; j < 4; j++)
      {
        count = 0;
        if (rb.leftSide != right || rb.rightSide != back)
        {
          //System.out.println("hereee");
          if (rb.leftSide == front && rb.rightSide == right)
          {
            // dbuBD, fix RightCorner(right)
            fixLeftEdge(back, right);
            
          }
          else if (rb.leftSide == back && rb.rightSide == left)
          {
            // DbuBduu, fix RightCorner(left)
            fixRightEdge(back, left);
          }
          else if (rb.leftSide == left && rb.rightSide == front)
          {
            // ddbuuBdd, fix RightCorner(front)
            fixOppEdge(back, front);
          }
          else
          {
            if (rb.leftSide == top || rb.rightSide == top)
              rb.isYellow = true;
            rb.isMessed = true;
            count++;
          }
        }
        
        rb = new Edge(myCube[2][1][2], myCube[1][1][0], rb.isMessed(), rb.isYellow());
        fr = new Edge(myCube[3][1][2], myCube[2][1][0], fr.isMessed(), fr.isYellow());
        lf = new Edge(myCube[4][1][2], myCube[3][1][0], lf.isMessed(), lf.isYellow());
        bl = new Edge(myCube[1][1][2], myCube[4][1][0], bl.isMessed(), bl.isYellow());
        
        /*System.out.println(rb);
         System.out.println(fr);
         System.out.println(lf);
         System.out.println(bl);
         System.out.println("");*/
        
        if (rb.leftSide == right && rb.rightSide == back)
          rb.isMessed = false;
        if (fr.leftSide == front && fr.rightSide == right)
          fr.isMessed = false;
        if (lf.leftSide == left && lf.rightSide == front)
          lf.isMessed = false;
        if (bl.leftSide == back && bl.rightSide == left)
          bl.isMessed = false;
        
        if (fr.leftSide != front || fr.rightSide != right)
        {
          // System.out.println("hereee");
          if (fr.leftSide == left && fr.rightSide == front)
          {
            // druRD, fix RightCorner(front)
            fixLeftEdge(right, front);
          }
          else if (fr.leftSide == right && fr.rightSide == back)
          {
            // DruRduu, fix RightCorner(back)
            fixRightEdge(right, back);
          }
          else if (fr.leftSide == back && fr.rightSide == left)
          {
            // ddruuRdd, fix RightCorner(left)
            fixOppEdge(right, left);
          }
          else
          {
            if (fr.leftSide == top || fr.rightSide == top)
              fr.isYellow = true;
            fr.isMessed = true;
            count++;
            // System.out.println("here3333");
          }
        }
        
        rb = new Edge(myCube[2][1][2], myCube[1][1][0], rb.isMessed(), rb.isYellow());
        fr = new Edge(myCube[3][1][2], myCube[2][1][0], fr.isMessed(), fr.isYellow());
        lf = new Edge(myCube[4][1][2], myCube[3][1][0], lf.isMessed(), lf.isYellow());
        bl = new Edge(myCube[1][1][2], myCube[4][1][0], bl.isMessed(), bl.isYellow());
        
        if (rb.leftSide == right && rb.rightSide == back)
          rb.isMessed = false;
        if (fr.leftSide == front && fr.rightSide == right)
          fr.isMessed = false;
        if (lf.leftSide == left && lf.rightSide == front)
          lf.isMessed = false;
        if (bl.leftSide == back && bl.rightSide == left)
          bl.isMessed = false;
        
        if (lf.leftSide != left || lf.rightSide != front)
        {
          // System.out.println("hereee" + moves + i);
          if (lf.leftSide == back && lf.rightSide == left)
          {
            // dbuBD, fix RightCorner(right)
            // System.out.println("here " + moves);
            fixLeftEdge(front, left);
            // System.out.println("heree " + moves);
          }
          else if (lf.leftSide == front && lf.rightSide == right)
          {
            // DbuBduu, fix RightCorner(left)
            fixRightEdge(front, right);
          }
          else if (lf.leftSide == right && lf.rightSide == back)
          {
            // ddbuuBdd, fix RightCorner(front)
            fixOppEdge(front, back);
          }
          else
          {
            if (lf.leftSide == top || lf.rightSide == top)
              lf.isYellow = true;
            lf.isMessed = true;
            count++;
            // System.out.println("here222");
          }
        }
        
        rb = new Edge(myCube[2][1][2], myCube[1][1][0], rb.isMessed(), rb.isYellow());
        fr = new Edge(myCube[3][1][2], myCube[2][1][0], fr.isMessed(), fr.isYellow());
        lf = new Edge(myCube[4][1][2], myCube[3][1][0], lf.isMessed(), lf.isYellow());
        bl = new Edge(myCube[1][1][2], myCube[4][1][0], bl.isMessed(), bl.isYellow());
        
        if (rb.leftSide == right && rb.rightSide == back)
          rb.isMessed = false;
        if (fr.leftSide == front && fr.rightSide == right)
          fr.isMessed = false;
        if (lf.leftSide == left && lf.rightSide == front)
          lf.isMessed = false;
        if (bl.leftSide == back && bl.rightSide == left)
          bl.isMessed = false;
        
        if (bl.leftSide != back || bl.rightSide != left)
        {
          // System.out.println("hereee" + i);
          if (bl.leftSide == left && bl.rightSide == front)
          {
            // System.out.println("hereee");
            // druRD, fix RightCorner(front)
            fixLeftEdge2(left, front);
          }
          else if (bl.leftSide == right && bl.rightSide == back)
          {
            // System.out.println("hereee");
            // DruRduu, fix RightCorner(back)
            fixRightEdge2(left, back);
          }
          else if (bl.leftSide == front && bl.rightSide == right)
          {
            // System.out.println("hereee");
            // ddruuRdd, fix RightCorner(left)
            fixOppEdge(left, right);
          }
          else
          {
            // System.out.println("hereee" + moves);
            if (bl.leftSide == top || bl.rightSide == top)
              bl.isYellow = true;
            bl.isMessed = true;
            count++;
          }
        }
        
        rb = new Edge(myCube[2][1][2], myCube[1][1][0], rb.isMessed(), rb.isYellow());
        fr = new Edge(myCube[3][1][2], myCube[2][1][0], fr.isMessed(), fr.isYellow());
        lf = new Edge(myCube[4][1][2], myCube[3][1][0], lf.isMessed(), lf.isYellow());
        bl = new Edge(myCube[1][1][2], myCube[4][1][0], bl.isMessed(), bl.isYellow());
        
        if (rb.leftSide == right && rb.rightSide == back)
          rb.isMessed = false;
        if (fr.leftSide == front && fr.rightSide == right)
          fr.isMessed = false;
        if (lf.leftSide == left && lf.rightSide == front)
          lf.isMessed = false;
        if (bl.leftSide == back && bl.rightSide == left)
          bl.isMessed = false;
        
        rb.determineYellow();
        fr.determineYellow();
        lf.determineYellow();
        bl.determineYellow();
        
        //System.out.println(fr);
        //System.out.println(bl);
      }
      boolean isRB = !rb.isMessed || rb.isYellow;
      boolean isFR = !fr.isMessed || fr.isYellow;
      boolean isLF = !lf.isMessed || lf.isYellow;
      boolean isBL = !bl.isMessed || bl.isYellow;
      
      if (count >= 2 && !(isRB && isFR && isLF && isBL))
      {
        if (rb.isMessedNotYellow())
        {
          // prioritizes non-yellow messed edges
          if (fr.isMessedNotYellow())
          {
            // do an algorithim to swap em
            swapSide('r');
            rb.isMessed = false;
            fr.isMessed = false;
          }
          else if (bl.isMessedNotYellow())
          {
            // do an algorithim to swap em
            swapSide('b');
            rb.isMessed = false;
            bl.isMessed = false;
          }
          else if (fr.isMessed)
          {
            // do the same alg to swap em
            swapSide('r');
            fr.isMessed = false;
          }
          else if (bl.isMessed)
          {
            // do the same alg to swap em
            swapSide('b');
            bl.isMessed = false;
          }
          else
          {
            quit = lookAtTopEdges(rb, fr, lf, bl);
          }
        }
        else if (fr.isMessedNotYellow())
        {
          if (lf.isMessedNotYellow())
          {
            swapSide('f');
            fr.isMessed = false;
            lf.isMessed = false;
          }
          else if (rb.isMessedNotYellow())
          {
            swapSide('r');
            fr.isMessed = false;
            rb.isMessed = false;
          }
          else if (lf.isMessed)
          {
            swapSide('f');
            lf.isMessed = false;
          }
          else if (rb.isMessed)
          {
            swapSide('r');
            rb.isMessed = false;
          }
          else
          {
            quit = lookAtTopEdges(rb, fr, lf, bl);
          }
        }
        else if (lf.isMessedNotYellow())
        {
          if (fr.isMessedNotYellow())
          {
            swapSide('f');
            lf.isMessed = false;
            fr.isMessed = false;
          }
          else if (bl.isMessedNotYellow())
          {
            swapSide('l');
            lf.isMessed = false;
            bl.isMessed = false;
          }
          else if (fr.isMessed)
          {
            swapSide('f');
            fr.isMessed = false;
          }
          else if (bl.isMessed)
          {
            swapSide('l');
            bl.isMessed = false;
          }
          else
          {
            quit = lookAtTopEdges(rb, fr, lf, bl);
          }
        }
        else if (bl.isMessedNotYellow())
        {
          if (rb.isMessedNotYellow())
          {
            swapSide('b');
            bl.isMessed = false;
            rb.isMessed = false;
          }
          else if (lf.isMessedNotYellow())
          {
            swapSide('l');
            bl.isMessed = false;
            lf.isMessed = false;
          }
          else if (rb.isMessed)
          {
            swapSide('b');
            rb.isMessed = false;
          }
          else if (lf.isMessed)
          {
            swapSide('l');
            lf.isMessed = false;
          }
          else
          {
            quit = lookAtTopEdges(rb, fr, lf, bl);
          }
        }
        else
        {
          quit = lookAtTopEdges(rb, fr, lf, bl);
        }
      }
      
      else
      {
        quit = lookAtTopEdges(rb, fr, lf, bl);
      }
      
      rb = new Edge(myCube[2][1][2], myCube[1][1][0], rb.isMessed(), rb.isYellow());
      fr = new Edge(myCube[3][1][2], myCube[2][1][0], fr.isMessed(), fr.isYellow());
      lf = new Edge(myCube[4][1][2], myCube[3][1][0], lf.isMessed(), lf.isYellow());
      bl = new Edge(myCube[1][1][2], myCube[4][1][0], bl.isMessed(), bl.isYellow());
      rb.determineYellow();
      fr.determineYellow();
      lf.determineYellow();
      bl.determineYellow();
      if (rb.leftSide == right && rb.rightSide == back)
        rb.isMessed = false;
      if (fr.leftSide == front && fr.rightSide == right)
        fr.isMessed = false;
      if (lf.leftSide == left && lf.rightSide == front)
        lf.isMessed = false;
      if (bl.leftSide == back && bl.rightSide == left)
        bl.isMessed = false;
      
      if (fr.isMessed && bl.isMessed && !rb.isMessed && !lf.isMessed)
        quit = true;
      else if (!fr.isMessed && !bl.isMessed && rb.isMessed && lf.isMessed)
        quit = true;
      
      if (quit)
      {
        if (rb.isMessedOrYellow())
          putInEdgeRight(back, right);
        if (fr.isMessedOrYellow())
          putInEdgeRight(right, front);
        if (lf.isMessedOrYellow())
          putInEdgeRight(front, left);
        if (bl.isMessedOrYellow())
          putInEdgeRight(left, back);
        if (rb.leftSide == right && rb.rightSide == back)
        {
          if (fr.leftSide == front && fr.rightSide == right)
          {
            if (lf.leftSide == left && lf.rightSide == front)
            {
              if (bl.leftSide == back && bl.rightSide == left)
                trueQuit = true;
            }
          }
        }
      }
      if (trueQuit)
        break;
      
      rb = new Edge(myCube[2][1][2], myCube[1][1][0], rb.isMessed(), rb.isYellow());
      fr = new Edge(myCube[3][1][2], myCube[2][1][0], fr.isMessed(), fr.isYellow());
      lf = new Edge(myCube[4][1][2], myCube[3][1][0], lf.isMessed(), lf.isYellow());
      bl = new Edge(myCube[1][1][2], myCube[4][1][0], bl.isMessed(), bl.isYellow());
      rb.determineYellow();
      fr.determineYellow();
      lf.determineYellow();
      bl.determineYellow();
      
      isAnyMessed = (rb.isMessedNotYellow() || fr.isMessedNotYellow());
      isAnyMessed = (isAnyMessed || lf.isMessedNotYellow() || bl.isMessedNotYellow());
    }
  }
  
  public boolean lookAtTopEdges(Edge rb, Edge fr, Edge lf, Edge bl)
  {
    //System.out.println("here");
    boolean quit = false;
    int bTop = myCube[1][0][1];
    int rTop = myCube[2][0][1];
    int fTop = myCube[3][0][1];
    int lTop = myCube[4][0][1];
    int tTop = myCube[5][0][1];
    int tLeft = myCube[5][1][0];
    int tRight = myCube[5][1][2];
    int tBottom = myCube[5][2][1];
    Edge topBack = new Edge(tTop, bTop, true, false);
    Edge topRight = new Edge(tRight, tTop, true, false);
    Edge topFront = new Edge(tBottom, fTop, true, false);
    Edge topLeft = new Edge(tLeft, lTop, true, false);
    int count = 0;
    
    // System.out.println(moves + " ALLAHU");
    for (int i = 0; i < 100; i++)
    {
      count = 0;
      if (bTop == back)
      {
        // System.out.println("here?" + moves);
        if (tTop == left)
          putInEdgeRight(left, back);
        else if (tTop == right)
          putInEdgeLeft(right, back);
      }
      else
        count++;
      if (rTop == right)
      {
        // System.out.println("here?" + moves);
        if (tRight == back)
          putInEdgeRight(back, right);
        else if (tRight == front)
          putInEdgeLeft(front, right);
        else
          count++;
      }
      else
        count++;
      if (fTop == front)
      {
        // System.out.println("here" + moves);
        if (tBottom == right)
          putInEdgeRight(right, front);
        else if (tBottom == left)
          putInEdgeLeft(left, front);
        else
          count++;
      }
      else
        count++;
      if (lTop == left)
      {
        // System.out.println("here " + moves + lTop + " " + tLeft);
        if (tLeft == front)
          putInEdgeRight(front, left);
        else if (tLeft == back)
          putInEdgeLeft(back, left);
        else
          count++;
        // System.out.println("here " + moves + i);
      }
      else
        count++;
      
      rb = new Edge(myCube[2][1][2], myCube[1][1][0], rb.isMessed(), rb.isYellow());
      fr = new Edge(myCube[3][1][2], myCube[2][1][0], fr.isMessed(), fr.isYellow());
      lf = new Edge(myCube[4][1][2], myCube[3][1][0], lf.isMessed(), lf.isYellow());
      bl = new Edge(myCube[1][1][2], myCube[4][1][0], bl.isMessed(), bl.isYellow());
      
      if (rb.leftSide == right && rb.rightSide == back)
        rb.isMessed = false;
      if (fr.leftSide == front && fr.rightSide == right)
        fr.isMessed = false;
      if (lf.leftSide == left && lf.rightSide == front)
        lf.isMessed = false;
      if (bl.leftSide == back && bl.rightSide == left)
        bl.isMessed = false;
      
      if (rb.leftSide == right && rb.rightSide == back)
      {
        if (fr.leftSide == front && fr.rightSide == right)
        {
          if (lf.leftSide == left && lf.rightSide == front)
          {
            if (bl.leftSide == back && bl.rightSide == left)
              break;
          }
        }
      }
      
      topBack = new Edge(tTop, bTop, true, false);
      topRight = new Edge(tRight, tTop, true, false);
      topFront = new Edge(tBottom, fTop, true, false);
      topLeft = new Edge(tLeft, lTop, true, false);
      
      topBack.determineYellow();
      topRight.determineYellow();
      topFront.determineYellow();
      topLeft.determineYellow();
      
      if (topBack.isYellow && topRight.isYellow && topFront.isYellow && topLeft.isYellow)
      {
        return true;
      }
      
      if (count == 4)
        doValue(top);
      
      bTop = myCube[1][0][1];
      rTop = myCube[2][0][1];
      fTop = myCube[3][0][1];
      lTop = myCube[4][0][1];
      tTop = myCube[5][0][1];
      tLeft = myCube[5][1][0];
      tRight = myCube[5][1][2];
      tBottom = myCube[5][2][1];
      topBack = new Edge(tTop, bTop, true, false);
      topRight = new Edge(tRight, tTop, true, false);
      topFront = new Edge(tBottom, fTop, true, false);
      topLeft = new Edge(tLeft, lTop, true, false);
    }
    if (topBack.leftSide == top || topBack.rightSide == top)
      topBack.isYellow = true;
    else if (topRight.leftSide == top || topRight.rightSide == top)
      topRight.isYellow = true;
    else if (topFront.leftSide == top || topFront.rightSide == top)
      topFront.isYellow = true;
    else if (topLeft.leftSide == top || topLeft.rightSide == top)
      topLeft.isYellow = true;
    if (topBack.isYellow || topRight.isYellow || topFront.isYellow || topLeft.isYellow)
      quit = true;
    //System.out.println(quit + moves);
    return quit;
  }
  
  public void putInEdgeLeft(int whichSide, int otherSide)
  {
    doRevValue(top);
    doRevValue(whichSide);
    doValue(top);
    doValue(whichSide);
    fixRightCorner(otherSide);
  }
  /*
   public void makePairEdgeLeft(int whichSide)
   {
   doRevValue(top);
   doRevValue(whichSide);
   doValue(top);
   doValue(whichSide);
   }*/
  
  public void putInEdgeRight(int whichSide, int otherSide)
  {
    doValue(top);
    doValue(whichSide);
    doRevValue(top);
    doRevValue(whichSide);
    fixLeftCorner(otherSide);
  }
  /*
   public void makePairEdgeRight(int whichSide)
   {
   doValue(top);
   doValue(whichSide);
   doRevValue(top);
   doRevValue(whichSide);
   }*/
  
  public void fixMessed(Edge rb, Edge fr, Edge lf, Edge bl)
  {
    if (rb.isMessedNotYellow())
    {
      // prioritizes non-yellow messed edges
      if (fr.isMessedNotYellow())
      {
        // do an algorithim to swap em
        swapSide('r');
      }
      else if (bl.isMessedNotYellow())
      {
        // do an algorithim to swap em
        swapSide('b');
      }
      else if (fr.isMessed)
      {
        // do the same alg to swap em
        swapSide('r');
      }
      else if (bl.isMessed)
      {
        // do the same alg to swap em
        swapSide('b');
      }
    }
    else if (fr.isMessedNotYellow())
    {
      if (lf.isMessedNotYellow())
        swapSide('f');
      else if (rb.isMessedNotYellow())
        swapSide('r');
      else if (lf.isMessed)
        swapSide('f');
      else if (rb.isMessed)
        swapSide('r');
    }
    else if (lf.isMessedNotYellow())
    {
      if (fr.isMessedNotYellow())
        swapSide('f');
      else if (bl.isMessedNotYellow())
        swapSide('l');
      else if (fr.isMessed)
        swapSide('f');
      else if (bl.isMessed)
        swapSide('l');
    }
    else if (bl.isMessedNotYellow())
    {
      if (rb.isMessedNotYellow())
        swapSide('b');
      else if (lf.isMessedNotYellow())
        swapSide('l');
      else if (rb.isMessed)
        swapSide('b');
      else if (lf.isMessed)
        swapSide('l');
    }
  }
  
  public void swapSide(char c)
  {
    if (c == 'r')
    {
      moves = moves + "r2u2r2u2r2";
      r2();
      u2();
      r2();
      u2();
      r2();
    }
    else if (c == 'b')
    {
      moves = moves + "b2u2b2u2b2";
      b2();
      u2();
      b2();
      u2();
      b2();
    }
    else if (c == 'l')
    {
      moves = moves + "l2u2l2u2l2";
      l2();
      u2();
      l2();
      u2();
      l2();
    }
    else if (c == 'f')
    {
      moves = moves + "f2u2f2u2f2";
      f2();
      u2();
      f2();
      u2();
      f2();
    }
  }
  
  public void fixLeftEdge(int whichSide, int leftEdge)
  {
    doValue(bottom);
    pushOutBotCorner(whichSide);
    doValue(top);
    doRevValue(bottom);
    fixRightCorner(leftEdge);
  }
  
  public void fixLeftEdge2(int whichSide, int leftEdge)
  {
    doRevValue(bottom);
    pushOutBotCorner(whichSide);
    doRevValue(top);
    doValue(bottom);
    fixRightCorner(leftEdge);
  }
  
  public void fixRightEdge(int whichSide, int rightEdge)
  {
    doRevValue(bottom);
    pushOutBotCorner(whichSide);
    doValue(bottom);
    doRevValue(top);
    fixRightCorner(rightEdge);
  }
  
  public void fixRightEdge2(int whichSide, int rightEdge)
  {
    doValue(bottom);
    pushOutBotCorner(whichSide);
    doRevValue(bottom);
    doValue(top);
    fixRightCorner(rightEdge);
  }
  
  public void fixOppEdge(int whichSide, int opp)
  {
    moves = moves + "d2";
    d2();
    doValue(whichSide);
    moves = moves + "u2";
    u2();
    doRevValue(whichSide);
    moves = moves + "d2";
    d2();
    fixRightCorner(opp);
  }
  
  public void solveBotCorners()
  {
    // these variables represent corners
    int backLeft = myCube[1][0][0];
    int backRight = myCube[1][0][2];
    int rightLeft = myCube[2][0][0];
    int rightRight = myCube[2][0][2];
    int frontLeft = myCube[3][0][0];
    int frontRight = myCube[3][0][2];
    int leftLeft = myCube[4][0][0];
    int leftRight = myCube[4][0][2];
    int topTopLeft = myCube[5][0][0];
    int topTopRight = myCube[5][0][2];
    int topBottomRight = myCube[5][2][2];
    int topBottomLeft = myCube[5][2][0];
    boolean isAnyWhite = (backLeft == bottom || rightLeft == bottom || frontLeft == bottom);
    isAnyWhite = (isAnyWhite || leftLeft == bottom || backRight == bottom || leftRight == bottom);
    isAnyWhite = (isAnyWhite || frontRight == bottom || rightRight == bottom);
    boolean isAnyTopWhite = (topTopLeft == bottom || topTopRight == bottom);
    isAnyTopWhite = (isAnyTopWhite || topBottomRight == bottom || topBottomLeft == bottom);
    boolean quit = false;
    
    for (int i = 0; i < 100; i++)
    {
      if (backLeft == bottom && rightRight == right)
        fixLeftCorner(right);
      else if (rightLeft == bottom && frontRight == front)
        fixLeftCorner(front);
      else if (frontLeft == bottom && leftRight == left)
      {
        fixLeftCorner(left);
        // printCube();
        // System.out.println(moves);
      }
      else if (leftLeft == bottom && backRight == back)
        fixLeftCorner(back);
      else if (backRight == bottom && leftLeft == left)
        fixRightCorner(left);
      else if (leftRight == bottom && frontLeft == front)
        fixRightCorner(front);
      else if (frontRight == bottom && rightLeft == right)
      {
        // printCube();
        fixRightCorner(right);
      }
      else if (rightRight == bottom && backLeft == back)
        fixRightCorner(back);
      else if (isAnyWhite) // else do a u move to put a corner in place
        doValue(top);
      else
      {
        if (topTopLeft == bottom && backRight == left && leftLeft == back)
          pushOutCorner(left);
        else if (topTopRight == bottom && rightRight == back && backLeft == right)
          pushOutCorner(back);
        else if (topBottomRight == bottom && frontRight == right && rightLeft == front)
          pushOutCorner(right);
        else if (topBottomLeft == bottom && leftRight == front && frontLeft == left)
          pushOutCorner(front);
        else if (isAnyTopWhite)
          doValue(top);
        else
          quit = areCornersGood();
      }
      if (quit)
        break;
      
      backLeft = myCube[1][0][0];
      backRight = myCube[1][0][2];
      rightLeft = myCube[2][0][0];
      rightRight = myCube[2][0][2];
      frontLeft = myCube[3][0][0];
      frontRight = myCube[3][0][2];
      leftLeft = myCube[4][0][0];
      leftRight = myCube[4][0][2];
      topTopLeft = myCube[5][0][0];
      topTopRight = myCube[5][0][2];
      topBottomRight = myCube[5][2][2];
      topBottomLeft = myCube[5][2][0];
      
      isAnyWhite = (backLeft == bottom || rightLeft == bottom || frontLeft == bottom);
      isAnyWhite = (isAnyWhite || leftLeft == bottom || backRight == bottom || leftRight == bottom);
      isAnyWhite = (isAnyWhite || frontRight == bottom || rightRight == bottom);
      isAnyTopWhite = (topTopLeft == bottom || topTopRight == bottom);
      isAnyTopWhite = (isAnyTopWhite || topBottomRight == bottom || topBottomLeft == bottom);
    }
  }
  
  public void fixLeftCorner(int whichSide)
  {
    doRevValue(top);
    doRevValue(whichSide);
    doValue(top);
    doValue(whichSide);
  }
  
  public void fixRightCorner(int whichSide)
  {
    doValue(top);
    doValue(whichSide);
    doRevValue(top);
    doRevValue(whichSide);
  }
  
  public void pushOutCorner(int whichSide)
  {
    doValue(whichSide);
    doValue(top);
    doValue(top);
    doRevValue(whichSide);
    doRevValue(top);
  }
  
  public void pushOutBotCorner(int whichSide)
  {
    doValue(whichSide);
    doValue(top);
    doRevValue(whichSide);
    doRevValue(top);
  }
  
  public boolean areCornersGood()
  {
    boolean isValid = false;
    if (myCube[0][2][2] != bottom || myCube[1][2][0] != back || myCube[2][2][2] != right)
      pushOutBotCorner(back);
    else if (myCube[0][0][2] != bottom || myCube[2][2][0] != right || myCube[3][2][2] != front)
      pushOutBotCorner(right);
    else if (myCube[0][0][0] != bottom || myCube[3][2][0] != front || myCube[4][2][2] != left)
      pushOutBotCorner(front);
    else if (myCube[0][0][0] != bottom || myCube[4][2][0] != left || myCube[1][2][2] != back)
      pushOutBotCorner(left);
    else
      isValid = true;
    return isValid;
  }
  
}