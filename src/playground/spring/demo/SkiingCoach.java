package playground.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class SkiingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your ski positon";
	}

}
