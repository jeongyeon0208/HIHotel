package umc5th.hihotel;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.DTO.CustomerDto;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.repository.CustomerRepository;
import umc5th.hihotel.service.CustomerService;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.fail;

@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입(){
            //given
        CustomerDto customerDto = CustomerDto.builder()
                .cid("001")
                .name("KIM")
                .phone("010-1234-1234")
                .build();

            //when
        Long saveId = customerService.join(customerDto);

            //then
        em.flush();
        Assertions.assertEquals(customerDto.getCid(), em.find(Customer.class, saveId).getCid());
    }

    @Test
    public void 중복회원검증() throws Exception {
        //given
        CustomerDto customerDto1 = CustomerDto.builder()
                .cid("002")
                .name("KIM")
                .phone("010-1234-1234")
                .build();

        CustomerDto customerDto2 = CustomerDto.builder()
                .cid("002")
                .name("LEE")
                .phone("010-2345-2345")
                .build();

        //when
        customerService.join(customerDto1);
        try {
            customerService.join(customerDto2);
            em.flush();
        } catch (IllegalStateException e) {
            List<Customer> findAll = customerRepository.findAll();
            System.out.println("findAll = " + findAll);
            return;
        }

        //then
        fail("예외가 발생해야된다");

    }
}
