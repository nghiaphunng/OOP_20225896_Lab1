package javacore_theory.week2;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationGeneration {
    /*    bài toán hoán vị n;*/
    int n;
    int[] arr = new int[1001];
    boolean[] visited = new boolean[1001];

    private void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        Arrays.fill(visited, false);
    }

    private void print(){
        for(int i = 1;i <= n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void Try(int i){
        for(int j = 1; j <= n;j++){
            if(!visited[j]){
                arr[i] = j;
                visited[j] = true;

                if(i == n) print();
                else Try(i + 1);

                //backtrack
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationGeneration permutationGeneration = new PermutationGeneration();

        permutationGeneration.input();
        permutationGeneration.Try(1);
    }
}
