package shixzh.jbl.xml;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * This program displays an XML document as a tree.
 * 
 * @author shixiang.zhao
 */
public class TreeViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new DOMTreeFrame();
                frame.setTitle("TreeViewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
