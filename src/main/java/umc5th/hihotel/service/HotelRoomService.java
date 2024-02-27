package umc5th.hihotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.domain.Hotel;
import umc5th.hihotel.domain.HotelRoom;
import umc5th.hihotel.repository.HotelRoomRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelRoomService {
    private final HotelRoomRepository hotelRoomRepository;

    //호텔방 정보 저장
    @Transactional
    public Long saveHotelRoom(HotelRoom hotelRoom) {
        hotelRoomRepository.save(hotelRoom);
        return hotelRoom.getId();
    }

    //전체 호실 조회
    @Transactional(readOnly = true)
    public List<HotelRoom> findHotelRooms() {
        return hotelRoomRepository.findAll();
    }
}
