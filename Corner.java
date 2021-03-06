
public class Corner
{
 public int topSide;
 public int leftSide;
 public int rightSide;
 public int ghostTop;
 public int ghostLeft;
 public int ghostRight;
 
 public Corner(int a, int b, int c, int d, int e, int f)
 {
  topSide = a;
  leftSide = b;
  rightSide = c;
  ghostTop = d;
  ghostLeft = e;
  ghostRight = f;
 }
 
 public boolean inPosition ()
 {
  if (topSide == ghostLeft && leftSide == ghostRight && rightSide == ghostTop)
   return true;
  else if (topSide == ghostRight && leftSide == ghostTop && rightSide == ghostLeft)
   return true;
  else if (topSide == ghostTop && leftSide == ghostLeft && rightSide == ghostRight)
   return true;
  else
   return false;
 }
 
 public boolean isSolved()
 {
  return topSide == ghostTop && leftSide == ghostLeft && rightSide == ghostRight;
 }
 
 public String toString()
 {
  return(topSide + " " + leftSide + " " + rightSide + " " + ghostTop + " " + ghostLeft + " " + ghostRight);
 }
}
