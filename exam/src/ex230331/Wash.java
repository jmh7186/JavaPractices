package ex230331;

public interface Wash {
	public void startButton();
	public void stopButton();
	public void pauseButton();
	public void changeButton(int speed);
	default void dry() {}
	default void clean() {}
}
