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
        if(board.getBoard()[i][j].equals("-")){
            System.out.println("Invalid move, play again...");
            return;
        }else{
            Player currPlayer = players.poll();
            board.getBoard()[i][j]=currPlayer.getSymbol();

            if(isPlayerWon(currPlayer, i, j)){
                System.out.println("Player " + currPlayer.getName() + " is won");
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


        return false;
    }

    public boolean winStatus(){
        return isOver;
    }
}
