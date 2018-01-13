import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
 
public class DFS
{
    private Stack<Integer> stack;
 
    public DFS() 
    {
        stack = new Stack<Integer>();
    }
 
    public void dfs(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length;
 
        int visited[] = new int[number_of_nodes];  
        int element = source;  
        int i = source;  
        System.out.print(element + "\t");  
        visited[source] = 1;  
        stack.push(source);
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = element; 
     while (i < number_of_nodes)
     {
              if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
         {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 0;
                    System.out.print(element + "\t");
             continue;
                }
                i++;
     }
            stack.pop(); 
        } 
    }
 
    public static void main(String...arg)
    {
        int n, m, source;
        Scanner scanner = null;
  try
        {
     //System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();
 
     boolean pho [] = new boolean [n];
     int adjacency_matrix[][] = new int[n][n];
     for (int i = 0; i < m; i++)
     {
       int temp = scanner.nextInt();
       pho[temp] = true;
     }
     for (int i = 0; i < n-1; i++)
     {
       int t1, t2;
       t1 = scanner.nextInt();
       t2 = scanner.nextInt();
       adjacency_matrix[t1][t2] = 1;
       adjacency_matrix[t2][t1] = 1;
     }
     
     /*System.out.println("Enter the adjacency matrix");
     for (int i = 0; i < number_of_nodes; i++)
         for (int j = 0; j < number_of_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();*/
 
     //System.out.println("Enter the source for the graph");
            source = scanner.nextInt(); 
 
            System.out.println("The DFS Traversal for the graph is given by ");
            DFS dfs = new DFS();
            dfs.dfs(adjacency_matrix, source);     
        }catch(InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        } 
        scanner.close(); 
    } 
}