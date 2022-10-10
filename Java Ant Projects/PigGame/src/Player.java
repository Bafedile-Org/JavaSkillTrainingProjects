/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Player {

    private int score = 0;
    private Dice dice1, dice2;
    private String name;
    private StringBuilder sb = new StringBuilder();

    Player() {
    }

    Player(String name) {
        this.setName(name);
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    Player(String name, Dice dice1, Dice dice2) {
        this.setName(name);
        this.dice1 = dice1;
        this.dice2 = dice2;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setScore(int score) {
        if (score < 0) {
            this.score = 0;
        } else {
            this.score = score;
        }

    }

    int getScore() {
        return score;
    }

    void rollDice() {
        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        System.out.println("You rolled: " + (roll1 + roll2));
        switch (roll1 + roll2) {
            case 3:
                sb.replace(0, sb.length(), "You LOSE!!");
                setScore(getScore() - 1);
                break;
            case 7:
                setScore(getScore()+5);
                sb.replace(0, sb.length(), "You WIN!!");
                break;
            default:
                if (this.getScore() >= 5) {
                    sb.replace(0, sb.length(), "You WIN!!");
                } else {
                    sb.replace(0, sb.length(), "You LOSE!!");
                }
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("Your Score is %d%n"
                + "========================%n"
                + "%16s%n"
                + "========================%n", getScore(), sb.toString());
    }
}
