/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg33aaaaaa;

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
        // TODO code application logic here
//        int n = 16;
        int n = 8; // arraysize

       //int InArr[] = new int[]{4,9,5,1,0,5,1,6,6,4,6,5,1,6,9,3};
        int input[] = new int[]{6,4,16,10,16,14,2,8};
        int output[] = new int[n];
        
        
        int numofthreads = Runtime.getRuntime().availableProcessors();
         executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numofthreads);
        //double m;
       // m = Math.ceil( (double)n/TNum );
        int size = n/numofthreads ;
        int Prefixsum[] = new int[numofthreads];
        
        int startIndex=0, endIndex=size;
        
        CountDownLatch latch = new CountDownLatch(numofthreads);
        CountDownLatch latch2 = new CountDownLatch(numofthreads);
         
        double currentTime = 0d;
        
         Date start, end;
         start = new Date();
         
    //1st Parallel Version
    //System.out.println(numofthreads);
    
        
        
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
        //System.out.println("HI122"); 
        
       //serial prefixsum lel prefixarr
        for(int i = 1 ; i<numofthreads; i++)
        {
            Prefixsum[i]+=Prefixsum[i-1];
        }

        //System.out.println("HI3");
        
        //2nd paralell prefixsum
    
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
      //System.out.println(Arrays.toString(PrefixArr));
      System.out.println("parallel Time: " + (currentTime)
                + " seconds.");
     
        currentTime = 0d;
        
         start = new Date();
       
      serialPrefix.serialPrefixSum( input, 8, Prefixsum);
        end = new Date();
        
         currentTime = end.getTime() - start.getTime();
        
     System.out.println("serial Time: " + (currentTime)
                + " seconds."); 
     
     executor.shutdown();
}}
