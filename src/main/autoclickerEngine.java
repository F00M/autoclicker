package main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class autoclickerEngine {
    // Delay before program starts (in ms)
    public final static int startDelay = 10000;

    // Delay between each click (in ms)
    private int clickDelay;
    private Robot rob;

    public autoclickerEngine(Robot rob) {
        clickDelay = 250;
        this.rob = rob;
    }

    /**
     * Tells program to wait a specified amount of milliseconds.
     * @param interval interval between clicks in ms
     */
    public void wait(int interval) {
        try {
            Thread.sleep(interval);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Simluates a mouse down and mouse up event seperated by a delay between
     * each click. Takes advantage of Java's Robot class
     */
    public void simulatePress() {
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        rob.mouseMove((int) mousePos.getX(), (int) mousePos.getY());
        
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        wait(clickDelay);
    }

    public static int getStartdelay() {
        return startDelay;
    }

    public int getClickDelay() {
        return clickDelay;
    }

    public void setClickDelay(int clickDelay) {
        this.clickDelay = clickDelay;
    }

    
}
