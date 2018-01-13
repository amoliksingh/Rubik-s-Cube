import java.util.*;
import java.io.*;
public class TestCube
{
  public static void print (String temp)
  {
    System.out.println(temp);
  }
  
  public static int getValue (char c)
  {
    if (c == 'w')
      return 0;
    else if (c == 'o')
      return 1;
    else if (c == 'g')
      return 2;
    else if (c == 'r')
      return 3;
    else if (c == 'b')
      return 4;
    else
      return 5;
  }
  
  public static void main (String [] args) throws IOException
  {
    Scanner input = new Scanner (new File ("input.txt"));
    int testCube [][][] = new int [6][3][3];
    String rowInfo;
    char [] n = new char [3];
    int value;
    
    for (int x = 0; x < 6; x++)
    {
      /*
      if (x == 0)
        print("Enter bottom face info");
      else if (x == 1)
        print("Enter back face info");
      else if (x == 2)
        print("Enter right face info");
      else if (x == 3)
        print("Enter front face info");
      else if (x == 4)
        print("Enter left face info");
      else
        print("Enter top face info"); */
      
      for (int y = 0; y < 3; y++)
      {/*
        if (y == 0)
          print("Enter top row");
        else if (y == 1)
          print("Enter middle row");
        else
          print("Enter bottom row");*/
        
        rowInfo = input.next();
        n[0] = rowInfo.charAt(0);
        n[1] = rowInfo.charAt(1);
        n[2] = rowInfo.charAt(2);
        for (int z = 0; z < 3; z++)
        {
          value = getValue(n[z]);
          testCube[x][y][z] = value;
        }
      }
    }
    Rubix myCube = new Rubix (testCube, 0, 1, 2, 3, 4, 5);
    myCube.solveTest();
    print("The first line is for the cross, the second is for the corners");
    print("The 3rd and 4th are for edges, 2nd layer and top respectively");
    print("The 5th is for putting the corners in the right place");
    print("And lastly, the 6th is for orienting the corners. \n");
    print(myCube.moves);
    print("\nNote: These moves are for when red is at the front, and white is at the top.");
    input.close();
  }
}