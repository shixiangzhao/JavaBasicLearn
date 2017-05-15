package shixzh.jbl.thread;

public class BallRunnable implements Runnable {

	private Ball ball;
	private BallComponent component;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;

	public BallRunnable(Ball ball, BallComponent component) {
		this.ball = ball;
		this.component = component;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= STEPS; i++) {
				ball.move(component.getBounds());
				component.paintCompinent(component.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
