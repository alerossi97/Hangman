/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import hangman.Hangman;
import hangman.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class HangmanServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(4000);

            while (true) {
                Socket socket = server.accept();



                NetPlayer player = new NetPlayer();
                Hangman game = new Hangman();
                game.playGame(player);

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                while (true)
                    System.out.println(in.readLine());

            }

        }catch (Exception e){
            e.getMessage();
        }

    }
}
