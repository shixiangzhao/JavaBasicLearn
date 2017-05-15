package shixzh.jbl.thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BounceFrame extends JFrame {

	private BallComponent comp;

	public BounceFrame() {
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addBall();
			}
		});
		addButton(buttonPanel, "Close", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}

	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}

	public void addBall() {
		Ball ball = new Ball();
		comp.add(ball);
		Runnable r = new BallRunnable(ball, comp);
		Thread t = new Thread(r);
		t.start();
	}
}
