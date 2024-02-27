package response;

import java.sql.Blob;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import com.project.EventNest.model.BookedVenue;

import lombok.Data;
import lombok.NoArgsConstructor;


//basically a DTO -> Data Transfer Object
@Data
@NoArgsConstructor
public class VenueResponse {
	private Long id;
	private String venue_type;
	private double price;
	private boolean  isBooked = false;
	private String photo;
	private List<BookingResponse> bookings;
	
	
	public VenueResponse(Long id, String venue_type, double price) {
		super();
		this.id = id;
		this.venue_type = venue_type;
		this.price = price;
	}
	
	
	public VenueResponse(Long id, String venue_type, double price, boolean isBooked, byte[] photoBytes,
			List<BookingResponse> bookings) {
		super();
		this.id = id;
		this.venue_type = venue_type;
		this.price = price;
		this.isBooked = isBooked;
		//converting string to bytes so it can be displayed as an image
		this.photo = photoBytes != null? Base64.encodeBase64String(photoBytes) : null;
		this.bookings = bookings;
	}
	
	
}