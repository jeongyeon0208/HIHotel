package umc5th.hihotel.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import umc5th.hihotel.DTO.CustomerDto;
import umc5th.hihotel.DTO.HotelDto;
import umc5th.hihotel.domain.Hotel;
import umc5th.hihotel.service.CustomerService;
import umc5th.hihotel.service.HotelService;

public class HotelController {

    private HotelService hotelService;

//    @GetMapping("/user/join")
//    public String createCustomerFormDto(Model model) {
//        model.addAttribute("customerFormDto", new CustomerDto());
//        return "";
//    }

    @PostMapping("/admin/hotel/insert")
    public String createHotel(@Validated Hotel hotel) {
        Long HotelId = hotelService.saveHotel(hotel);
        return "/admin/hotels";
    }

}
