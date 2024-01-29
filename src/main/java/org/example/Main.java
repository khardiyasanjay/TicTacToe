package org.example;

import org.example.entity.Board;
import org.example.entity.Player;
import org.example.service.TicTacToeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Player> playerList = new ArrayList<>();
        //default is 2 player with 3*3 board, we can take input for size.
        System.out.println("Enter player 1 name : ");
        String p1name = scanner.next();
        System.out.println("Enter player 1 symbol : ");
        String p1symbol = scanner.next();
        playerList.add(new Player(p1name, p1symbol));

        System.out.println("Enter player 2 name : ");
        String p2name = scanner.next();
        System.out.println("Enter player 2 symbol : ");
        String p2symbol = scanner.next();
        playerList.add(new Player(p2name, p2symbol));

        TicTacToeService ticTacToeService = new TicTacToeService(3, playerList);

        while (!ticTacToeService.winStatus()){
            ticTacToeService.board.getBoardView();
            System.out.println("Enter index to play : ");
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            ticTacToeService.move(i, j);
        }
    }
}