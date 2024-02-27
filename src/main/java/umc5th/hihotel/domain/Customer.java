package umc5th.hihotel.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc5th.hihotel.DTO.CustomerDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Customer {
    @Id @GeneratedValue
    @Column(name = "customer_id")
    private Long id;

    @Column(unique = true)
    private String cid;
    private String name;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<StayInformation> stayInformations = new ArrayList<>();

    @Builder
    public Customer(String cid, String name, String phone) {
        this.cid = cid;
        this.name = name;
        this.phone = phone;
    }

    public static Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCid(customerDto.getCid());
        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        return customer;
    }




}
