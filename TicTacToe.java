/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class TicTacToe {
    
    static int Turn=1;
    public static  String winner(String[] board){
        if(board[1].equals(board[2]) && board[1].equals(board[3])){
            return board[1];
        }
        else if(board[4].equals(board[5]) && board[4].equals(board[6])){
            return board[4];
        }
        else if(board[7].equals(board[8]) && board[7].equals(board[9])){
            return board[7];
        }
        else if(board[1].equals(board[4]) && board[1].equals(board[7])){
            return board[1];
        }
        else if(board[2].equals(board[5]) && board[2].equals(board[8])){
            return board[2];
        }
        else if(board[3].equals(board[6]) && board[3].equals(board[9])){
            return board[3];
        }
        else if(board[1].equals(board[5]) && board[1].equals(board[9])){
            return board[1];
        }
        else if(board[3].equals(board[5]) && board[3].equals(board[7])){
            return board[3];
        }
        return "";
    }
    
    public static void play(String[] board,int a){
        if(board[a]!="X" && board[a]!="O"){
            if(Turn%2==1){
                board[a]="X";
                        
            }
            else {board[a]="O";}
                
        }               
    }
    public static void printBoard(String[] board){
            System.out.println("        |       |       ");
            System.out.println("    "+board[1]+"   |    "+board[2]+"  |   "+board[3]);
            System.out.println("        |       |       ");
            System.out.println("........|.......|......."); 
            System.out.println("        |       |       ");
            System.out.println("    "+board[4]+"   |    "+board[5]+"  |  "+board[6]);
            System.out.println("        |       |       ");
            System.out.println("........|.......|......."); 
            System.out.println("        |       |       ");
            System.out.println("    "+board[7]+"   |    "+board[8]+"  |   "+board[9]);
            System.out.println("        |       |       ");
    }
    
    
    
    public static void main(String[] args){
        int x;
        String w="";
        String[] board= new String[10];
        for(int i=0;i<10;i++){
            board[i]=String.valueOf(i);
        }
        printBoard(board);
        
        
        Scanner a=new Scanner(System.in);
        for(int i=1;i<10;i++){
            if(Turn%2==1){
                System.out.println("Play player 1:");
            }
            else  System.out.println("Play player 2:");
         do{  
            do {
                
                x=a.nextInt();
                if(x<1 || x>10){
                    System.out.println("NOT VALID position, please play again!");
                }    
            }while (x<1 || x>9);
            if(board[x]=="X" || board[x]=="O"){
                System.out.println("You have already played in this position, please play again!");
            }
          }while(board[x]=="X" || board[x]=="O");
            
            play(board,x);
            
            printBoard(board);
            
            
             w=winner(board);
             if(Turn>=5){
             if(w.equals("X")){
                System.out.println("Winner is player 1!!!");
                break;
                }
            else if(w.equals("O")){
                System.out.println("Winner is player 2!!!"); 
                break;}
             }
            
            Turn++;
        }
        if(w.equals(""))System.out.println("It's a Tie!!");
    }
}
