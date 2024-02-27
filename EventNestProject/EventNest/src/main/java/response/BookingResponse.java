package response;

import java.time.LocalDate;

import com.project.EventNest.model.Venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//basically a DTO -> Data Transfer Object

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
	private Long booking_id;
	
	private LocalDate bookDate;

	private String guestFullName;

	private String guestEmail;

	private int NumOfGuests;

	private String bookingConfirmationCode;

	private Venue venue;

	public BookingResponse(Long booking_id, LocalDate bookDate, String bookingConfirmationCode) {
		super();
		this.booking_id = booking_id;
		this.bookDate = bookDate;
		this.bookingConfirmationCode = bookingConfirmationCode;
	}

}
