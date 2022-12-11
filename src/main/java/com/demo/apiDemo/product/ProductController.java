package com.demo.apiDemo.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 전체 상위상품 조회
     * @return
     * 모든 상위상품을 조회한다.
     */
    @GetMapping(value = "/find_all_base_product")
    public List<BaseProductDTO.Response> findAll() {
        return productService.findAll();
    }

    /**
     * 상위상품 조회
     * @param baseProductDTO
     * @return
     * BaseProductId PK로 상위상품 1건을 조회한다.
     */
    @GetMapping(value = "/find_base_product_by_id")
    public BaseProductDTO.Response findByBaseProductId(@RequestBody BaseProductDTO.Response baseProductDTO ) {
        return productService.findByBaseProductId(baseProductDTO.getBaseProductId());
    }

    /**
     * 상위상품 상품옵션 조회
     * @param productDTO
     * @return
     * BaseProductId 를 FK로 가지는 모든 상품옵션을 조회한다.
     */
    @GetMapping(value = "/find_all_product")
    public List<ProductDTO.Response> findAllByBaseProductId(@RequestBody ProductDTO.Response productDTO) {
        return productService.findAllByBaseProductId(productDTO.getBaseProductId());
    }

}
