package umc5th.hihotel.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Hotel {

    @Id @GeneratedValue
    @Column(name = "hotel_id")
    private Long id;

    @Column(unique=true)
    private String hid;

    private String name;

    private String num;

    private String address;

    @OneToMany(mappedBy = "hotel")
    private List<Hotelier> hoteliers = new ArrayList<>();

    @OneToMany(mappedBy = "hotel")
    private List<HotelRoom> hotelRooms = new ArrayList<>();
}
