package umc5th.hihotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.domain.Booking;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.domain.HotelRoom;
import umc5th.hihotel.repository.BookingRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    //예약하기
    @Transactional
    public Long saveBooking(Booking booking){
        bookingRepository.save(booking);
        return booking.getId();
    }


    //전체 예약 조회 - 관리자용
    @Transactional(readOnly = true)
    public List<Booking> findBookings() {
        return bookingRepository.findAll();
    }

    //전체 예약 조회 - 고객용
    @Transactional(readOnly = true)
    public Optional<Booking> findBookingsByCustomer(Customer customer) {
        Optional<Booking> findBookingsById = bookingRepository.findById(customer.getId());
        return findBookingsById;
    }


    //예약 수정 - 고객용
    @Transactional
    public void updateBookingByCustomer(Customer customer, HotelRoom hotelRoom, Date checkIn, Date checkOut) {
        Booking findBooking = bookingRepository.findByCidHidRoomNumber(customer.getId(), hotelRoom.getHotel().getId(),hotelRoom.getRoomNum());
        findBooking.setCheckin(checkIn);
        findBooking.setCheckout(checkOut);
    }
}
