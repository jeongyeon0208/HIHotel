package umc5th.hihotel.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Booking {

    @Id @GeneratedValue
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hotelroom_id")
    private HotelRoom hotelRoom;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Date checkin;

    private Date checkout;

    @Builder
    public Booking(HotelRoom hotelRoom, Customer customer, Date checkin, Date checkout) {
        this.hotelRoom = hotelRoom;
        this.customer = customer;
        this.checkin = checkin;
        this.checkout = checkout;
    }

}
