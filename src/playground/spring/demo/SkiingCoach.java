package playground.spring.demo;

public class SkiingCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "spend 30 minutes bench-pressing";
	}

}
