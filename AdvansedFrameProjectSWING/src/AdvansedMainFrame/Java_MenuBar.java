package AdvansedMainFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;


public class Java_MenuBar extends JFrame {

    /**
     * Creates new form Java_MenuBar
     */
    public Java_MenuBar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        jMenuBar1 = new JMenuBar();
        jMenu3 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jSeparator1 = new JPopupMenu.Separator();
        jMenuItem2 = new JMenuItem();
        jMenuItem_Save = new JMenuItem();
        jMenu1 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jMenu3.setText("File");

        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new ImageIcon(getClass().getResource("save.png"))); // NOI18N
        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setIcon(new ImageIcon(getClass().getResource("add.png"))); // NOI18N
        jMenuItem3.setText("Add");
        jMenu3.add(jMenuItem3);
        jMenu3.add(jSeparator1);

        jMenuItem2.setIcon(new ImageIcon(getClass().getResource("edit.png"))); // NOI18N
        jMenuItem2.setText("Edit");
        jMenu3.add(jMenuItem2);

        jMenuItem_Save.setIcon(new ImageIcon(getClass().getResource("close.png"))); // NOI18N
        jMenuItem_Save.setText("Delete");
        jMenu3.add(jMenuItem_Save);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Dev");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                       

    private void jMenuItem1ActionPerformed(ActionEvent evt) {                                           
        
        System.out.println("Save");
        
    }                                          

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Java_MenuBar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Java_MenuBar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Java_MenuBar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Java_MenuBar.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java_MenuBar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JMenu jMenu1;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem_Save;
    private JPopupMenu.Separator jSeparator1;
    // End of variables declaration                   
}