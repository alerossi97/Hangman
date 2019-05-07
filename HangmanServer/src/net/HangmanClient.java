package net;

import hangman.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HangmanClient extends Player implements Runnable {
    private BufferedReader in = null;
    private PrintStream out = null;
    private String username;

    public HangmanClient(String username) {
        this.username = username;

        Game g;

        try {
            Socket socket = new Socket("localhost", 4000);
            // Apre i canali I/O
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream(), true);

            // Legge dal serer

            while (g.getResult()==GameResult.OPEN){
                out.println(chooseLetter(g));
                out.flush();

            }
                out.close();
                in.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public char chooseLetter(Game game) {
        return 0;
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void run() {

    }
}

