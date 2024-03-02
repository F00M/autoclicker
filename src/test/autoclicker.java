package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;

import main.autoclickerEngine;

public class autoclicker {
    private static boolean leftButtonPressed = false;
    public static void main(String[] args) throws AWTException, NativeHookException {
        Robot robot = new Robot();
        autoclickerEngine engine = new autoclickerEngine(robot);

        GlobalScreen.registerNativeHook();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

        GlobalScreen.addNativeMouseListener(new NativeMouseListener() {
                @Override
                public void nativeMouseClicked(NativeMouseEvent nativeEvent) {
                    // Handle mouse clicked event if needed
                }

                @Override
                public void nativeMousePressed(NativeMouseEvent nativeEvent) {
                    if (nativeEvent.getButton() == NativeMouseEvent.BUTTON1) {
                        leftButtonPressed = true;
                    }
                }

                @Override
                public void nativeMouseReleased(NativeMouseEvent nativeEvent) {
                    if (nativeEvent.getButton() == NativeMouseEvent.BUTTON1) {
                        leftButtonPressed = false;
                    }
                }
            });

        System.out.println("RUNNING...");
        while (true) {
            if (leftButtonPressed) {
                engine.simulatePress();
                System.out.println("CLICK");
            }
        }
    }
}
