package it.giobr.jogogourmet;

import javax.swing.*;

public class Main {

    public static final String TITLE = "Jogo Gourmet";

    private static final Tree tree = new Tree();
    private static final int FECHOU = -1;
    private static final int YES = 0;

    public static void main(String[] args) {
        while (true) {
            JOptionPane.showMessageDialog(null, "Pense em um prato que gosta", TITLE, JOptionPane.PLAIN_MESSAGE);

            try {
                startGame();
            } catch (RuntimeException e) {
                break;
            }
        }
    }

    private static void startGame() {
        while (true) {
            var response = makeQuestion(tree.getCurrentLabel());

            if (response) {
                if (!tree.goLeft()) {
                    hit();
                    tree.reset();
                    break;
                }
            } else {
                if (!tree.goRight()) {
                    addFood();
                    tree.reset();
                    break;
                }
            }
        }
    }

    private static boolean makeQuestion(String label) {
        var response = JOptionPane.showConfirmDialog(null,
                "O prato que você pensou é " + label + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == FECHOU) {
            throw new RuntimeException("Fechou o jogo");
        }

        return response == YES;
    }

    private static void hit() {
        JOptionPane.showMessageDialog(null,
                "Acertei de novo!",
                TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void addFood() {
        String newFood = readInput("Qual prato você pensou?", "Desisto");

        String newType = readInput(newFood + " é ______  mas " + tree.getCurrentLabel() + " não.", "Complete");

        tree.add(newType, newFood);
    }

    private static String readInput(String message, String Desisto) {
        var response = JOptionPane.showInputDialog(null,
                message,
                Desisto,
                JOptionPane.QUESTION_MESSAGE);

        if (response == null) {
            throw new RuntimeException("Fechou o jogo");
        }

        return response;
    }
}