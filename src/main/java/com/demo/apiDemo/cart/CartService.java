package com.demo.apiDemo.cart;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final CartListRepository cartListRepository;

    public CartService(CartRepository cartRepository, CartListRepository cartListRepository) {
        this.cartRepository = cartRepository;
        this.cartListRepository = cartListRepository;
    }

    public Cart save(CartDTO.Request cartDTO) {
        return cartRepository.save(cartDTO.toEntity());
    }

    public CartList save(CartListDTO.Request cartListDTO) {
        return cartListRepository.save(cartListDTO.toEntity());
    }

    public CartDTO.Response findByMemberId(Long memberId) {
        return new CartDTO.Response(cartRepository.findByMemberId(memberId).get());
    }

    public List<CartListDTO.Response> findAllByCartId(Long cartId) {
        List<CartList> cartLists = cartListRepository.findAllByCartId(cartId);
        List<CartListDTO.Response> cartListDTOS = new ArrayList<>();

        for(CartList cartList : cartLists) {
            CartListDTO.Response response = new CartListDTO.Response(cartList);
            cartListDTOS.add(response);
        }

        return cartListDTOS;
    }

    public void deleteByCartId(Long cartId) {
        cartRepository.deleteByCartId(cartId);
    }

    public void deleteByCartListId(Long cartListId) {
        cartListRepository.deleteByCartListId(cartListId);
    }

}
