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

public class RubixBase
{
 public int myCube[][][] = new int[6][3][3]; // 6 for 6 faces, then 3 by 3 2d
            // arrays to represent 9 squares
 public int bottom, back, right, front, left, top; // integers to represent
              // various faces
 String moves = "";

 public RubixBase(int a[][][], int b, int c, int d, int e, int f, int g)
 {
  for (int x = 0; x < 6; x++)
  {
   for (int y = 0; y < 3; y++)
   {
    for (int z = 0; z < 3; z++)
    {
     myCube[x][y][z] = a[x][y][z];
    }
   }
  }
  bottom = b;
  back = c;
  right = d;
  front = e;
  left = f;
  top = g;
 }

 public void rotateFace(int whichFace)
 {
  int temp;
  // rotates edge pieces around center
  temp = myCube[whichFace][1][0];
  myCube[whichFace][1][0] = myCube[whichFace][2][1];
  myCube[whichFace][2][1] = myCube[whichFace][1][2];
  myCube[whichFace][1][2] = myCube[whichFace][0][1];
  myCube[whichFace][0][1] = temp;
  // rotates corner pieces around center
  temp = myCube[whichFace][2][0];
  myCube[whichFace][2][0] = myCube[whichFace][2][2];
  myCube[whichFace][2][2] = myCube[whichFace][0][2];
  myCube[whichFace][0][2] = myCube[whichFace][0][0];
  myCube[whichFace][0][0] = temp;
 }
 
 public void revRotateFace(int whichFace)
 {
  int temp;
  // rotates edge pieces around center
  temp = myCube[whichFace][1][0];
  myCube[whichFace][1][0] = myCube[whichFace][0][1];
  myCube[whichFace][0][1] = myCube[whichFace][1][2];
  myCube[whichFace][1][2] = myCube[whichFace][2][1];
  myCube[whichFace][2][1] = temp;
  // rotates corner pieces around center
  temp = myCube[whichFace][2][0];
  myCube[whichFace][2][0] = myCube[whichFace][0][0];
  myCube[whichFace][0][0] = myCube[whichFace][0][2];
  myCube[whichFace][0][2] = myCube[whichFace][2][2];
  myCube[whichFace][2][2] = temp;
 }

 public void y()
 {
   u();
   dPrime();
   ePrime();
   moves = moves + "y";
 }
 
 public void yPrime()
 {
   uPrime();
   d();
   e();
   moves = moves + "Y";
 }
 
 public void wideD()
 {
   d();
   e();
   moves = moves + "wd";
 }
 
 public void wideDPrime()
 {
   dPrime();
   ePrime();
   moves = moves + "wD";
 }
 
 public void ePrime()
 {
   int temp1 = myCube[1][1][0];
   int temp2 = myCube[1][1][1];
   int temp3 = myCube[1][1][2];
   myCube[1][1][0] = myCube[4][1][0];
   myCube[1][1][1] = myCube[4][1][1];
   myCube[1][1][2] = myCube[4][1][2];
   myCube[4][1][0] = myCube[3][1][0];
   myCube[4][1][1] = myCube[3][1][1];
   myCube[4][1][2] = myCube[3][1][2];
   myCube[3][1][0] = myCube[2][1][0];
   myCube[3][1][1] = myCube[2][1][1];
   myCube[3][1][2] = myCube[2][1][2];
   myCube[2][1][0] = temp1;
   myCube[2][1][1] = temp2;
   myCube[2][1][2] = temp3;
   
   int temp = back;
   back = left;
   left = front;
   front = right;
   right = temp;
 }
 
 public void e()
 {
   int temp1 = myCube[1][1][0];
   int temp2 = myCube[1][1][1];
   int temp3 = myCube[1][1][2];
   myCube[1][1][0] = myCube[2][1][0];
   myCube[1][1][1] = myCube[2][1][1];
   myCube[1][1][2] = myCube[2][1][2];
   myCube[2][1][0] = myCube[3][1][0];
   myCube[2][1][1] = myCube[3][1][1];
   myCube[2][1][2] = myCube[3][1][2];
   myCube[3][1][0] = myCube[4][1][0];
   myCube[3][1][1] = myCube[4][1][1];
   myCube[3][1][2] = myCube[4][1][2];
   myCube[4][1][0] = temp1;
   myCube[4][1][1] = temp2;
   myCube[4][1][2] = temp3;
   
   int temp = back;
   back = right;
   right = front;
   front = left;
   left = temp;
 }
 
 public void u()
 {
  int[] temp = new int[3];
  rotateFace(5);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[4][0][a];
   myCube[4][0][a] = myCube[3][0][a];
   myCube[3][0][a] = myCube[2][0][a];
   myCube[2][0][a] = myCube[1][0][a];
   myCube[1][0][a] = temp[a];
  }
 }

 public void l()
 {
  int[] temp = new int[3];
  rotateFace(4);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[1][2 - a][2];
   myCube[1][2 - a][2] = myCube[0][a][0];
   myCube[0][a][0] = myCube[3][a][0];
   myCube[3][a][0] = myCube[5][a][0];
   myCube[5][a][0] = temp[a];
  }
 }

 public void f() // visualize this
 {
  int[] temp = new int[3];
  rotateFace(3);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[4][a][2];
   myCube[4][a][2] = myCube[0][0][a];
   myCube[0][0][a] = myCube[2][2 - a][0];
   myCube[2][2 - a][0] = myCube[5][2][2 - a];
   myCube[5][2][2 - a] = temp[a];
  }
 }

 public void r()
 {
  int[] temp = new int[3];
  rotateFace(2);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[3][a][2];
   myCube[3][a][2] = myCube[0][a][2];
   myCube[0][a][2] = myCube[1][2 - a][0];
   myCube[1][2 - a][0] = myCube[5][a][2];
   myCube[5][a][2] = temp[a];
  }
 }

 public void b()
 {
  int[] temp = new int[3];
  rotateFace(1);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[2][a][2];
   myCube[2][a][2] = myCube[0][2][2 - a];
   myCube[0][2][2 - a] = myCube[4][2 - a][0];
   myCube[4][2 - a][0] = myCube[5][0][a];
   myCube[5][0][a] = temp[a];
  }
 }

 public void d()
 {
  int[] temp = new int[3];
  rotateFace(0);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[4][2][a];
   myCube[4][2][a] = myCube[1][2][a];
   myCube[1][2][a] = myCube[2][2][a];
   myCube[2][2][a] = myCube[3][2][a];
   myCube[3][2][a] = temp[a];
  }
 }

 public void u2()
 {
  u();
  u();
 }

 public void l2()
 {
  l();
  l();
 }

 public void f2()
 {
  f();
  f();
 }

 public void r2()
 {
  r();
  r();
 }

 public void b2()
 {
  b();
  b();
 }

 public void d2()
 {
  d();
  d();
 }

 public void uPrime()
 {
  int[] temp = new int[3];
  revRotateFace(5);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[1][0][a];
   myCube[1][0][a] = myCube[2][0][a];
   myCube[2][0][a] = myCube[3][0][a];
   myCube[3][0][a] = myCube[4][0][a];
   myCube[4][0][a] = temp[a];
  }
 }

 public void lPrime()
 {
  int[] temp = new int[3];
  revRotateFace(4);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[5][a][0];
   myCube[5][a][0] = myCube[3][a][0];
   myCube[3][a][0] = myCube[0][a][0];
   myCube[0][a][0] = myCube[1][2 - a][2];
   myCube[1][2 - a][2] = temp [a];
  }
 }

 public void fPrime()
 {
  int[] temp = new int[3];
  revRotateFace(3);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[5][2][2 - a];
   myCube[5][2][2 - a] = myCube[2][2 - a][0];
   myCube[2][2 - a][0] = myCube[0][0][a];
   myCube[0][0][a] = myCube[4][a][2];
   myCube[4][a][2] = temp[a];
  }
 }

 public void rPrime()
 {
  int[] temp = new int[3];
  revRotateFace(2);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[5][a][2];
   myCube[5][a][2] = myCube[1][2 - a][0];
   myCube[1][2 - a][0] = myCube[0][a][2];
   myCube[0][a][2] = myCube[3][a][2];
   myCube[3][a][2] = temp[a];
  }
 }

 public void bPrime()
 {
  int[] temp = new int[3];
  revRotateFace(1);
  for (int a = 0; a < 3; a++)
  {
   
   temp[a] = myCube[5][0][a];
   myCube[5][0][a] = myCube[4][2 - a][0];
   myCube[4][2 - a][0] = myCube[0][2][2 - a];
   myCube[0][2][2 - a] = myCube[2][a][2];
   myCube[2][a][2] = temp[a];
  }
 }

 public void dPrime()
 {
  int[] temp = new int[3];
  revRotateFace(0);
  for (int a = 0; a < 3; a++)
  {
   temp[a] = myCube[3][2][a];
   myCube[3][2][a] = myCube[2][2][a];
   myCube[2][2][a] = myCube[1][2][a];
   myCube[1][2][a] = myCube[4][2][a];
   myCube[4][2][a] = temp[a];
  }
 }

 public void printCube()
 {
  System.out.println();
  for (int x = 0; x < 6; x++)
  {
   for (int y = 0; y < 3; y++)
   {
    for (int z = 0; z < 3; z++)
    {
     System.out.print(myCube[x][y][z]);
    }
    System.out.println();
   }
   System.out.println();
  }
  System.out.println();
 }

 public void doMove(char move)
 {
  if (move == 'b')
   b();
  else if (move == 'r')
   r();
  else if (move == 'f')
   f();
  else
   l();
 }

 public void doRevMove(char move)
 {
  if (move == 'b')
   bPrime();
  else if (move == 'r')
   rPrime();
  else if (move == 'f')
   fPrime();
  else
   lPrime();
 }
 
 public void doValue(int val)
 {
  if (val == back)
  {
   moves = moves + "b";
   b();
  }
  else if (val == right)
  {
   moves = moves + "r";
   r();
  }
  else if (val == front)
  {
   moves = moves + "f";
   f();
  }
  else if (val == left)
  {
   moves = moves + "l";
   l();
  }
  else if (val == top)
  {
   moves = moves + "u";
   u();
  }
  else if (val == bottom)
  {
   moves = moves + "d";
   d();
  }
 }
 
 public void doValue2(int val)
 {
  if (val == back)
  {
   moves = moves + "b2";
   b2();
  }
  else if (val == right)
  {
   moves = moves + "r2";
   r2();
  }
  else if (val == front)
  {
   moves = moves + "f2";
   f2();
  }
  else if (val == left)
  {
   moves = moves + "l2";
   l2();
  }
  else if (val == top)
  {
   moves = moves + "u2";
   u2();
  }
  else if (val == bottom)
  {
   moves = moves + "d2";
   d2();
  }
 }

 public void doRevValue(int val)
 {
  if (val == back)
  {
   moves = moves + "B";
   bPrime();
  }
  else if (val == right)
  {
   moves = moves + "R";
   rPrime();
  }
  else if (val == front)
  {
   moves = moves + "F";
   fPrime();
  }
  else if (val == left)
  {
   moves = moves + "L";
   lPrime();
  }
  else if (val == top)
  {
   moves = moves + "U";
   uPrime();
  }
  else if (val == bottom)
  {
   moves = moves + "D";
   dPrime();
  }
 }

}