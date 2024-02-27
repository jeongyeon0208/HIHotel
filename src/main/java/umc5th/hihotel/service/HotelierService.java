package umc5th.hihotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.repository.HotelRepository;
import umc5th.hihotel.repository.HotelierRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelierService {

    private final HotelierRepository hotelierRepository;


}


