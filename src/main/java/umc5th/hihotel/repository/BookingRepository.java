package umc5th.hihotel.repository;


import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.hihotel.domain.Booking;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.domain.StayInformation;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByCidHidRoomNumber(Long id, Long hid, String RoomNumber);
}
