package exercise.thread;

public class TrafficLightSimulator {

	public static void main(String[] args) {
		ThreadTrafficLight trafficLight = new ThreadTrafficLight();
		
		for (int i = 0; i<10; i++){
			System.out.println(trafficLight.getColor());
			trafficLight.waitColorChange();
		}
		
		trafficLight.turnOffTrafficLight();
	}

}
