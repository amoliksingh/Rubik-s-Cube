
public class Edge
{
	int leftSide = -1;
	int rightSide = -1;
	boolean isMessed = false;
	boolean isYellow = false;
	
	public int getLeftSide()
	{
		return leftSide;
	}

	public void setLeftSide(int leftSide)
	{
		this.leftSide = leftSide;
	}

	public int getRightSide()
	{
		return rightSide;
	}

	public void setRightSide(int rightSide)
	{
		this.rightSide = rightSide;
	}

	public boolean isMessed()
	{
		return isMessed;
	}

	public void setMessed(boolean isMessed)
	{
		this.isMessed = isMessed;
	}

	public boolean isYellow()
	{
		return isYellow;
	}

	public void setYellow(boolean isYellow)
	{
		this.isYellow = isYellow;
	}
	
	public Edge (int left, int right, boolean messed, boolean yellow)
	{
		leftSide = left;
		rightSide = right;
		isMessed = messed;
		isYellow = yellow;
	}
	
	public Edge (int left, int right)
	{
		leftSide = left;
		rightSide = right;
	}
	
	public Edge ()
	{}
	
	public boolean isMessedNotYellow()
	{
		return isMessed&&!isYellow;
	}
	public void determineYellow()
	{
		isYellow = ((leftSide == 5) || (rightSide == 5));
	}
	public boolean isMessedOrYellow()
	{
		return isMessed || isYellow;
	}
	
	public String toString()
	{
		return leftSide + " " + rightSide + isMessed + " " + isYellow;
	}
}
