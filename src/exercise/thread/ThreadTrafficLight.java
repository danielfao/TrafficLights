package exercise.thread;

public class ThreadTrafficLight implements Runnable{
	private TrafficLightColor color;
	private boolean stop;
	private boolean colorChanged;

	public ThreadTrafficLight(){
		this.color = TrafficLightColor.RED;
		this.stop = false;
		this.colorChanged = false;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (!stop){
			try {
				Thread.sleep(this.color.getWaitingTime());
				this.changeColor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized void changeColor(){
		switch (this.color) {
		case RED:
			this.color = TrafficLightColor.GREEN;
			break;
		case YELLOW:
			this.color = TrafficLightColor.RED;
			break;
		case GREEN:
			this.color = TrafficLightColor.YELLOW;
			break;
		default:
			break;
		}
		this.colorChanged = true;
		notify();
	}
	
	public synchronized void waitColorChange(){
		while(!this.colorChanged){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.colorChanged = false;
		}
	}
	
	public synchronized void turnOffTrafficLight(){
		this.stop = true;
	}
	
	public TrafficLightColor getColor() {
		return color;
	}
}
