/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mecer;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class GPS {

    private double xCoordinate, yCoordinate;
    private int time;

    public GPS() {
        this(0, 0, 0);
    }

    public GPS(double xCoordinate, double yCoordinate, int time) {
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
        this.setTime(time);
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString(){
        return String.format("(%.2f, %.2f,%d)",xCoordinate,yCoordinate,time);
    }
}
