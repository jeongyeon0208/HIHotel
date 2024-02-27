package umc5th.hihotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.domain.Hotel;
import umc5th.hihotel.repository.HotelRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    //호텔정보 저장
    @Transactional
    public Long saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel.getId();
    }

    //전체 호텔방 조회
    @Transactional(readOnly = true)
    public List<Hotel> findHotels() {
        return hotelRepository.findAll();
    }


}
