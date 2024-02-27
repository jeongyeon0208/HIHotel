package umc5th.hihotel.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Hotelier {

    @Id @GeneratedValue
    @Column(name = "hotelier_id")
    private Long id;

    @Column(unique=true)
    private String hlid;

    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
