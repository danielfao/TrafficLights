package exercise.thread;

public enum TrafficLightColor {
	
	GREEN(1000), YELLOW(300), RED(2000);
	
	private int waitingTime;
	
	TrafficLightColor(int waitingTime){
		this.waitingTime = waitingTime;
	}
	
	public int getWaitingTime() {
		return waitingTime;
	}
}
