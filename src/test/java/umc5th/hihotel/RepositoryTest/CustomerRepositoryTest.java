package umc5th.hihotel.RepositoryTest;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EntityManager em;


    @Test
    public void 모두찾기() throws Exception {
            //given
        Customer customer1 = new Customer();
        customer1.setCid("001");
        customer1.setName("kim");
        em.persist(customer1);

        Customer customer2 = new Customer();
        customer2.setCid("002");
        customer2.setName("lee");
        em.persist(customer2);


            //when
        em.flush();
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        //then
        List<Customer> findCustomers = customerRepository.findAll();
        Assertions.assertEquals(customers, findCustomers);
        System.out.println("customers = " + customers);
        System.out.println("findCustomers = " + findCustomers);
    }


}


