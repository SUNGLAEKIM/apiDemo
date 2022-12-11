package com.demo.apiDemo.product;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final BaseProductRepository baseProductRepository;

    public ProductService(ProductRepository productRepository, BaseProductRepository baseProductRepository) {
        this.productRepository = productRepository;
        this.baseProductRepository = baseProductRepository;
    }

    public List<BaseProductDTO.Response> findAll() {
        List<BaseProduct> baseProducts = baseProductRepository.findAll();
        List<BaseProductDTO.Response> baseProductDTOS = new ArrayList<>();

        for(BaseProduct baseProduct : baseProducts) {
            BaseProductDTO.Response response = new BaseProductDTO.Response(baseProduct);
            baseProductDTOS.add(response);
        }

        return baseProductDTOS;
    }

    public BaseProductDTO.Response findByBaseProductId(Long baseProductId) {
        return new BaseProductDTO.Response(baseProductRepository.findByBaseProductId(baseProductId).get());
    }

    public List<ProductDTO.Response> findAllByBaseProductId(Long baseProductId) {
        List<Product> products = productRepository.findAllByBaseProductId(baseProductId);
        List<ProductDTO.Response> productDTOS = new ArrayList<>();

        for(Product product : products) {
            ProductDTO.Response response = new ProductDTO.Response(product);
            productDTOS.add(response);
        }

        return productDTOS;
    }
}
