import lombok.Data;

@Data
public class TimeEntry {

	private Long id;
	private final LocalDateTime start;
	private LocalDateTime stop;
	private String description;
	
}
