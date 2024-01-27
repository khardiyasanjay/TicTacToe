package org.example.entity;

public class Board {
    private String[][] board = new String[3][3];


    public Board(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]="-";
            }
        }
    }

    public String[][] getBoard(){
        return board;
    }

    public void getBoardView(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
