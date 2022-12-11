package com.demo.apiDemo.address;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * 주소록 저장
     * @param addressDTO
     * @return
     * AddressDTO.Request parameter 로 주소록을 저장한다.
     *
     * private Long addressId;
     * private Long memberId;
     * private String addressName;
     * private String receiver;
     * private String phoneNumber;
     * private String address2;
     * private String address1;
     * private String zipCode;
     *
     */
    @PostMapping(value = "/save")
    public Address save(@RequestBody AddressDTO.Request addressDTO) {
        return addressService.save(addressDTO);
    }

    /**
     * 사용자 주소록 조회
     * @param addressDTO
     * @return
     * memberId 를 FK로 가지는 모든 주소록을 조회한다.
     */
    @GetMapping(value = "/find_all_by_member_id")
    public List<AddressDTO.Response> findAllByMemberId(@RequestBody AddressDTO.Response addressDTO) {
        return addressService.findAllByMemberId(addressDTO.getMemberId());
    }

    /**
     * 주소록 조회
     * @param addressDTO
     * @return
     * address_id PK로 주소록 1건을 조회한다.
     */
    @GetMapping(value = "/find_by_address_id")
    public AddressDTO.Response findByAddressId(@RequestBody AddressDTO.Response addressDTO) {
        return addressService.findByAddressId(addressDTO.getAddressId());
    }

}
