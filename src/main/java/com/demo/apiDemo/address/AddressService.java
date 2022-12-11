package com.demo.apiDemo.address;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(AddressDTO.Request addressDTO) {
        return addressRepository.save(addressDTO.toEntity());
    }

    public List<AddressDTO.Response> findAllByMemberId(Long memberId) {
        List<Address> addresses= addressRepository.findAllByMemberId(memberId);
        List<AddressDTO.Response> addressDTOS = new ArrayList<>();

        for(Address address : addresses) {
            AddressDTO.Response response = new AddressDTO.Response(address);
            addressDTOS.add(response);
        }

        return addressDTOS;
    }

    public AddressDTO.Response findByAddressId(Long addressId) {
        return new AddressDTO.Response(addressRepository.findByAddressId(addressId).get());
    }
}
