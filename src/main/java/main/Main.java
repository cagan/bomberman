package main;

import javax.swing.*;

public class Main {
    public static BomberMain bomberMain = null;
    public static boolean J2 = false;

    /**
     * Starts Bomberman
     */
    public static void startBomberman() {
        bomberMain = new BomberMain();
    }

    /**
     * Starts the program by creating an instance of MainFrame.
     */
    public static void main(String[] args) {
        /** default look and feel: metal */
        int lookAndFeel = 1;
        /** check supplied parameters (if any) */
        for (int i = 0; i < args.length; i++) {
            /** if "bomberman" parameter is supplied */
            if (args[i].equals("Bomberman") || args[i].equals("bomberman"))
            /** if you look and feel parameter is supplied */
            if (args[i].startsWith("-l")) {
                if (args[i].substring(2).equals("System")) lookAndFeel = 0;
                else if (args[i].substring(2).equals("Metal")) lookAndFeel = 1;
                else if (args[i].substring(2).equals("Windows")) lookAndFeel = 2;
                else if (args[i].substring(2).equals("Mac")) lookAndFeel = 3;
                else if (args[i].substring(2).equals("Motif")) lookAndFeel = 4;
            }
        }
        if (lookAndFeel != 1) {
            try {
                String laf = "javax.swing.plaf.metal.MetalLookAndFeel";
                if (lookAndFeel == 0)
                    laf = UIManager.getSystemLookAndFeelClassName();
                else if (lookAndFeel == 2)
                    laf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                else if (lookAndFeel == 3)
                    laf = "javax.swing.plaf.mac.MacLookAndFeel";
                else laf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
                UIManager.setLookAndFeel(laf);
            } catch (Exception e) {
                new ErrorDialog(e);
            }
        }

        startBomberman();
    }
}
