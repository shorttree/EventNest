package com.project.EventNest.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookedVenue {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long booking_id;
	
//future scope -> later can make an event for multiple days
//so we can add start date and end date
@Column(name = "bookDate")	
private LocalDate bookDate;

@Column(name = "FullName")
private String guestFullName;

@Column(name = "Email")
private String guestEmail;

@Column(name = "TotalGuests")
private int NumOfGuests;

//future scope -> later can split guests into different categories 
//like children , adults etc 
@Column(name = "ConfirmationCode")
private String bookingConfirmationCode;

@ManyToOne(fetch = FetchType.LAZY)

//will be a joint column because with this column we will 
//be joining our bookedVenue with venue table
@JoinColumn(name = "Venue_id")
private Venue venue;

public void setNumOfGuests(int numOfGuests) {
	NumOfGuests = numOfGuests;
}
public void setBookingConfirmationCode(String bookingConfirmationCode) {
	this.bookingConfirmationCode = bookingConfirmationCode;
}


}
