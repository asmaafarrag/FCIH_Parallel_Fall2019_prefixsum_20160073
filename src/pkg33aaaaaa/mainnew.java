
package pkg33aaaaaa;
import java.util.Scanner;
import java.util.Date;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author asmaa
 */
public class mainnew  {
    
     static ThreadPoolExecutor executor;
    
    
     public static void main(String[] args) throws InterruptedException {
        
        int n = 8;
        int input[] = new int[]{9,8,3,2,7,1,6,4};
        //Scanner in = new Scanner(System.in);
        //int  inp = in.nextInt();
        //int input[]=new int [inp];
        int output[] = new int[n];
        
        
        int numofthreads = Runtime.getRuntime().availableProcessors();
        CountDownLatch latch = new CountDownLatch(numofthreads);
        CountDownLatch latch2 = new CountDownLatch(numofthreads);
        
         executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numofthreads);
        int size = n/numofthreads ;
        int Prefixsum[] = new int[numofthreads];
        int startIndex=0, endIndex=size;
        
        

        double currentTime = 0d;
        
         Date start, end;
         start = new Date();
    for(int i = 0 ; i < numofthreads ; i++)
        {
            running Task = new running(startIndex ,endIndex ,n,i,1,0,input,output,Prefixsum,latch);
            executor.execute(Task);

            startIndex=endIndex;
            
            if (i<numofthreads-1) {
                    endIndex=endIndex+size; 
            } else {
                    endIndex=n;
            }

        }
       latch.await();
        for(int i = 1 ; i<numofthreads; i++)
        {
            Prefixsum[i]+=Prefixsum[i-1];
        }

    
        startIndex=size;
        endIndex=startIndex+size;
        for(int i = 0 ; i < numofthreads-1 ; i++)
        {
            running Task = new running(startIndex ,endIndex ,n,i,0,1,input,output,Prefixsum,latch2);
            executor.execute(Task);
            startIndex=endIndex;
            if (i<numofthreads-1) {
                    endIndex=endIndex+size; 
            } else {
                   endIndex=n;
            }
            
        }
    
    end = new Date();
       
       currentTime = end.getTime() - start.getTime();
      System.out.println(Arrays.toString(input));
      System.out.println(Arrays.toString(output));
      System.out.println("parallel Time: " + (currentTime) + " seconds.");
     
        currentTime = 0d;
        
         start = new Date();
       
      serialPrefix.serialPrefixSum( input, 8, Prefixsum);
        end = new Date();
        
         currentTime = end.getTime() - start.getTime();
        
     System.out.println("serial Time: " + (currentTime)+ " seconds."); 
     
     executor.shutdown();
}}
