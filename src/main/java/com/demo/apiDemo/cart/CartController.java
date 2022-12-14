package com.demo.apiDemo.cart;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cart")
public class CartController {

    private final CartService cartService;
    private final CartListRepository cartListRepository;

    public CartController(CartService cartService,
                          CartListRepository cartListRepository) {
        this.cartService = cartService;
        this.cartListRepository = cartListRepository;
    }

    /**
     * 장바구니(마스터)를 저장
     * @param cartDTO
     * @return
     * CartDTO.Request parameter 로 장바구니를 저장한다.
     *
     * private Long cartId;
     * private Long memberId;
     * private Long totalQuantity;
     * private Long totalPrice;
     *
     */
    @PostMapping(value = "/save_cart")
    public Cart save(@RequestBody CartDTO.Request cartDTO) {
        return cartService.save(cartDTO);
    }

    /**
     * 장바구니(디테일)를 저장
     * @param cartListDTO
     * @return
     * CartListDTO.Request parameter 로 장바구니 상세를 저장한다.
     *
     * private Long cartListId;
     * private Long cartId;
     * private Long productId;
     * private Long quantity;
     * private Long price;
     *
     */
    @PostMapping(value = "/save_cart_list")
    public CartList save(@RequestBody CartListDTO.Request cartListDTO) {
        return cartService.save(cartListDTO);
    }

    /**
     * 사용자 장바구니(마스터) 조회
     * @param cartDTO
     * @return
     * memberId 를 FK로 가지는 장바구니를 조회한다.
     */
    @GetMapping(value = "/find_by_member_id")
    public CartDTO.Response findByMemberId(@RequestBody CartDTO.Response cartDTO) {
        return cartService.findByMemberId(cartDTO.getMemberId());
    }

    /**
     * 사용자 장바구니(디테일) 조회
     * @param cartDTO
     * @return
     * cartId 를 FK로 가지는 장바구니 상세를 조회한다.
     * 장바구니 리스트 및 리스트의 상품 정보도 동시에 가져온다.
     */
    @GetMapping(value = "/find_all_by_cart_id")
    public CartDTO.Response findAllByCartId(@RequestBody CartDTO.Response cartDTO) {
        return cartService.findAllByCartId(cartDTO.getCartId());
    }

    /**
     * 장바구니(마스터) 삭제
     * @param cartDTO
     * cartId PK로 장바구니(마스터)를 삭제한다.
     * cf) 실제 운영시, 삭제는 state column의 flag를 이용하여 삭제 여부를 update하는 방식인 soft-delete를 사용하지만
     * 예제에서는 삭제여부를 쉽게 확인하기 위해 hard-delete 방식을 사용함
     */
    @DeleteMapping(value = "/delete_by_cart_id")
    public void deleteByCartId(@RequestBody CartDTO.Response cartDTO) {
        cartService.deleteByCartId(cartDTO.getCartId());
    }

    /**
     * 장바구니(디테일) 삭제
     * @param cartListDTO
     * cartListId PK로 장바구니(디테일)를 삭제한다.
     */
    @DeleteMapping(value = "/delete_by_cart_list_id")
    public void deleteByCartListId(@RequestBody CartListDTO.Response cartListDTO) {
        cartService.deleteByCartListId(cartListDTO.getCartListId());
    }

}
