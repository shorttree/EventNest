package com.project.EventNest.model;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String venue_type;
	private double price;
	private boolean  isBooked = false;
	
	@Lob
	private Blob photo;
	
	@OneToMany(mappedBy = "venue", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BookedVenue> bookings;

	public Venue() {
		//this is done to avoid the null pointer exception
		this.bookings = new ArrayList<>();
	}
	
	public void addBookings(BookedVenue booking){
		if (bookings == null) {
			bookings = new  ArrayList<>();
		}
		bookings.add(booking);
		booking.setVenue(this);
		isBooked = true;
		String bookingCode = RandomStringUtils.randomNumeric(10);
		booking.setBookingConfirmationCode(bookingCode);
	}
	

}
