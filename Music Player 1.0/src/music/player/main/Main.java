package music.player.main;

import music.player.gui.MainFrame;

/**
 *
 * @author ISSA-PC
 */
public class Main {

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();

        // Frame settings
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null); // set location at center
        mainFrame.setSize(370, 130);

        mainFrame.setVisible(true); // show frame

    }

}
