package umc5th.hihotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.hihotel.DTO.CustomerDto;
import umc5th.hihotel.domain.Customer;
import umc5th.hihotel.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    //회원가입
    @Transactional
    public Long join(CustomerDto customerDto) {
        Customer customer = Customer.createCustomer(customerDto);
        validateDuplicateCustomer(customer);
        customerRepository.save(customer);
        return customer.getId();
    }

    //중복회원검증
    private void validateDuplicateCustomer(Customer customer) {
        Customer findCustomer = customerRepository.findByCid(customer.getCid());
        if (findCustomer != null) {
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
    }

    //전체 고객 조회
    @Transactional(readOnly = true)
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Customer> findOne(Long customerId){
        return customerRepository.findById(customerId);
    }

}
