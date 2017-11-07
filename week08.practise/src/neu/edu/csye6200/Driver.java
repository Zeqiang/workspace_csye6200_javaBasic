package neu.edu.csye6200;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Driver {

	public static void main(String[] args) {
		
		Thing.demo();
		
		LocalDate graduation = LocalDate.of(2016, Month.DECEMBER, 17);
		System.out.println(graduation);
		
//		ZoneId id = ZoneId.of("Europe/Paris");
//		ZonedDateTime zoned = ZonedDateTime.of(dateTime, id);
//		assertEquals(id, ZoneId.from(zoned));
		
		LocalTime time1 = LocalTime.parse("10:15:30"); 
		System.out.println(time1);
		
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
	}
}
