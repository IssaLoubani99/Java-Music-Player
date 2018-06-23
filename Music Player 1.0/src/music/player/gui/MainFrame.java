package music.player.gui;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import music.player.controller.MusicPlayer;

/**
 *
 * @author ISSA-PC
 */
public class MainFrame extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    public MainFrame() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        songName = new javax.swing.JLabel();
        playButton = new javax.swing.JLabel();
        stopButton = new javax.swing.JLabel();
        pausedButton = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        songName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        songName.setForeground(new java.awt.Color(51, 51, 51));
        songName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(songName);
        songName.setBounds(20, 10, 330, 20);

        playButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButtonMouseReleased(evt);
            }
        });
        getContentPane().add(playButton);
        playButton.setBounds(150, 50, 70, 60);

        stopButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopButtonMouseReleased(evt);
            }
        });
        getContentPane().add(stopButton);
        stopButton.setBounds(70, 60, 50, 40);

        pausedButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pausedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pausedButtonMouseReleased(evt);
            }
        });
        getContentPane().add(pausedButton);
        pausedButton.setBounds(250, 50, 50, 60);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background.png"))); // NOI18N
        background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                backgroundMouseDragged(evt);
            }
        });
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backgroundMouseReleased(evt);
            }
        });
        getContentPane().add(background);
        background.setBounds(0, 0, 370, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButtonMouseReleased

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Music Files(*.mp3 , *.wav , ...)", "mp3", "wav");

        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "//Desktop");

        chooser.addChoosableFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File myFile = chooser.getSelectedFile();
            String path = "" + myFile;

            try {
                MusicPlayer.playSong(path);
            } catch (Exception e) {
                System.out.println(e);
            }
            songName.setText(MusicPlayer.getSongName()); // get song name
    }//GEN-LAST:event_playButtonMouseReleased
    }
    private void pausedButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pausedButtonMouseReleased
        if (MusicPlayer.getPlayerState() == false) {
            MusicPlayer.resumeSong();
        } else {
            MusicPlayer.pausedSong();
        }
    }//GEN-LAST:event_pausedButtonMouseReleased

    private void stopButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopButtonMouseReleased
        MusicPlayer.stopSong(); // stop song
    }//GEN-LAST:event_stopButtonMouseReleased

    private void backgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_backgroundMouseDragged

    private void backgroundMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseReleased
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_backgroundMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel pausedButton;
    private javax.swing.JLabel playButton;
    private javax.swing.JLabel songName;
    private javax.swing.JLabel stopButton;
    // End of variables declaration//GEN-END:variables
}
