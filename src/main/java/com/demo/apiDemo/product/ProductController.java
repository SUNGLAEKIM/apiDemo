package com.demo.apiDemo.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/find_all_base_product")
    public List<BaseProductDTO.Response> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/find_base_product_by_id")
    public BaseProductDTO.Response findByBaseProductId(@RequestParam("base_product_id") Long baseProductId) {
        return productService.findByBaseProductId(baseProductId);
    }

    @GetMapping(value = "/find_all_product")
    public List<ProductDTO.Response> findAllByBaseProductId(@RequestParam("base_product_id")Long baseProductId) {
        return productService.findAllByBaseProductId(baseProductId);
    }

}
