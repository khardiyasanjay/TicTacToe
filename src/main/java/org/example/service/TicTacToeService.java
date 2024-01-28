package org.example.service;

import org.example.entity.Board;
import org.example.entity.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicTacToeService {
    public Board board;
    private Queue<Player> players;
    private boolean isOver;

    public TicTacToeService(int boardSize, List<Player> playerList){
        board = new Board();
        players = new LinkedList<>();
        isOver = false;
        players.addAll(playerList);
    }

    public boolean getIsCellEmpty(int i, int j){
        return board.getBoard()[i][j].equals("-");
    }

    public void move(int i, int j){
        if(!board.getBoard()[i][j].equals("-")){
            System.out.println("Invalid move, play again...");
            return;
        }else{
            Player currPlayer = players.poll();
            board.getBoard()[i][j]=currPlayer.getSymbol();

            if(isPlayerWon(currPlayer, i, j)){
                System.out.println("Player " + currPlayer.getName() + " won");
                isOver= true;
                return;
            }
            else {
                players.add(currPlayer);
            }
        }
    }

    public boolean isPlayerWon(Player player, int i, int j){
        //check only corresponding row, column and diagonal

        String csymbol = player.getSymbol();

        if(!board.getBoard()[i][j].equals(csymbol))
            return false;

        //check for current row
        int ti = i, tj = j-1;
        int tcnt = 1;
        while(tj>=0){
            tcnt += (board.getBoard()[ti][tj--].equals(csymbol)) ? 1 : 0;
        }
        tj=j+1;
        while (tj<board.getBoard().length){
            tcnt += (board.getBoard()[ti][tj++].equals(csymbol)) ? 1 : 0;
        }
        if(tcnt==board.getBoard().length){
            return true;
        }

        tcnt=1;

        //check for current column
        ti = i-1;
        tj = j;
        while(ti>=0){
            tcnt += (board.getBoard()[ti--][tj].equals(csymbol)) ? 1 : 0;
        }
        ti=i+1;
        while (ti<board.getBoard().length){
            tcnt += (board.getBoard()[ti++][tj].equals(csymbol)) ? 1 : 0;
        }
        if(tcnt==board.getBoard().length){
            return true;
        }

        //check for current diagonal
        tcnt = 1;
        if(i==j){
           ti=i-1;
           tj=j-1;
           while (ti>=0 && tj>=0){
               tcnt += (board.getBoard()[ti--][tj--].equals(csymbol)) ? 1 : 0;
           }
           ti=i+1;
           tj=j+1;
           while (ti<board.getBoard().length && tj<board.getBoard().length){
               tcnt += (board.getBoard()[ti++][tj++].equals(csymbol)) ? 1 : 0;
           }

           if(tcnt==board.getBoard().length){
               return true;
           }
        }

        return false;
    }

    public boolean winStatus(){
        return isOver;
    }
}
