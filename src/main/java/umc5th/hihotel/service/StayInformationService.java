package umc5th.hihotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.domain.Booking;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.domain.HotelRoom;
import umc5th.hihotel.domain.StayInformation;
import umc5th.hihotel.repository.StayInformationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StayInformationService {

    private final StayInformationRepository stayInformationRepository;

    //투숙정보 저장
    @Transactional
    public Long saveStayInformation(StayInformation stayInformation){
        stayInformationRepository.save(stayInformation);
        return stayInformation.getId();
    }


    //전체 예약 조회 - 관리자용
    @Transactional(readOnly = true)
    public List<StayInformation> findStayInformations() {
        return stayInformationRepository.findAll();
    }


    //전체 예약 조회 - 고객용
    @Transactional(readOnly = true)
    public Optional<StayInformation> findStayInformationsByCustomer(Customer customer) {
        Optional<StayInformation> findBookingsById = stayInformationRepository.findById(customer.getId());
        return findBookingsById;
    }


}
