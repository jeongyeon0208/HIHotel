package umc5th.hihotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import umc5th.hihotel.DTO.CustomerDto;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.service.CustomerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    //회원가입
    @GetMapping("/user/signup")
    public String createCustomerFormDto(Model model) {
        model.addAttribute("customerFormDto", new CustomerDto());
        return "/";
    }

    @PostMapping("/user/signup")
    public String createCustomer(@Validated CustomerDto customerDto) {
        Long customerId = customerService.join(customerDto);
        return "/user/signin"; //로그인 페이지로 이동
    }


    //로그인
    @GetMapping("/user/signin")
    public String signinFormDto(){
        return "user/signin";
    }


    @GetMapping("/users")
    public String list(Model model) {

        List<Customer> customers = customerService.findCustomers();
        model.addAttribute("customers", customers);
        return "users/userList";
    }
}
