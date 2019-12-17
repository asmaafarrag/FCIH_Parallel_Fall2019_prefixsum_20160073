/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg33aaaaaa;

/**
 *
 * @author asmaa
 */
public class serialPrefix extends Thread
{
     
    
	// Fills prefix sum array 
    static void serialPrefixSum(int arr[], int n,int prefixSum[]) 
    { 
		prefixSum[0] = arr[0]; 
		
		// Adding present element 
		// with previous element 
		for( int i = 1; i < n; ++i ) 
			prefixSum[i] = prefixSum[i-1] + arr[i]; 
    } 
        
     
	
	// Driver code 
	public static void main(String[] args) 
	{ 
		int arr[] = { 10, 4, 16, 20 }; 
		int n = arr.length; 
		int prefixSum[] = new int[n]; 
		
		serialPrefixSum(arr, n, prefixSum); 
                
                //parallelprefixsum(arr, n, prefixSum);
		long start = System.currentTimeMillis();
                
		for (int i = 0; i < n; i++) {
			System.out.print( prefixSum[i] + " "); 
		System.out.println(""); }
                
                System.out.println("Execution Time: " + (System.currentTimeMillis() - start)+ " seconds.");
	} 

}
 

