// Question 9: Java Dequeue

// Skill Mapping: Basic

// Description: Solve the HackerRank Problem given as a link below -

// https://www.hackerrank.com/challenges/java-dequeue/problem

import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashMap<Integer,Integer>hm= new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int uc=0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            if(hm.containsKey(num)){
                int torep=hm.get(num);
                hm.put(num, torep+1);

            }else{hm.put(num, 1);}

            if(deque.size()==m){
                if(hm.size()>=uc){
                    uc=hm.size();
                }
                int torem=(int)deque.poll();
                if(hm.get(torem)==1){
                    hm.remove(torem);
                }
                else{
                    int torep=hm.get(torem);
                    hm.put(torem, torep-1);   
                }   
            }    
        }
        System.out.println(uc);
    }
}
