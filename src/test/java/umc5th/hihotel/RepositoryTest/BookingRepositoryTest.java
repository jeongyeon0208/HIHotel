package umc5th.hihotel.RepositoryTest;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.domain.Booking;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.domain.Hotel;
import umc5th.hihotel.repository.BookingRepository;
import umc5th.hihotel.service.BookingService;

@SpringBootTest
@Transactional
public class BookingRepositoryTest {

    @Autowired BookingRepository bookingRepository;

    @Autowired BookingService bookingService;

    @Autowired EntityManager em;

    @Test
    public void 예약하기(){
        //given
        Customer customer1 = new Customer();
        customer1.setCid("001");
        customer1.setName("kim");
        em.persist(customer1);

        Hotel hotel1 = new Hotel();
        hotel1.setHid("111");
        hotel1.setAddress("abcd");
        hotel1.setName("HHOTEL");
        em.persist(hotel1);

        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        Booking booking3 = new Booking();


        //when


        //then


    }
}
