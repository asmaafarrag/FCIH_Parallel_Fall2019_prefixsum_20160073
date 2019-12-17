
package pkg33aaaaaa;
import java.util.Arrays;
/**
 *
 * @author asmaa
 */
public class serialPrefix 
{
   
    static void serialPrefixSum(int input[], int n,int output[]) 
    { 
		output[0] = input[0]; 
		
		// Adding present element with previous element 
		for( int i = 1; i < n; ++i ) 
			output[i] = output[i-1] + input[i]; 
    } 
        
     
	
	
	public static void main(String[] args) 
	{ 
		int input[] = { 9,8,3,2,7,1,6,4 }; 
		int n = input.length; 
		int output[] = new int[n]; 
		System.out.println(Arrays.toString(input));
                
                
		serialPrefixSum(input, n, output); 
                
                //parallelprefixsum(arr, n, prefixSum);
		long start = System.currentTimeMillis();
                
		System.out.println(Arrays.toString(output));
                        
  
                System.out.println("Execution Time: " + (System.currentTimeMillis() - start)+ " seconds.");
	} 

}
 

