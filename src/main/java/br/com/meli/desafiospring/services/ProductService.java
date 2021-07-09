package br.com.meli.desafiospring.services;

import br.com.meli.desafiospring.dto.category.CategoryDTO;
import br.com.meli.desafiospring.dto.product.ProductDTO;
import br.com.meli.desafiospring.entities.Product;
import br.com.meli.desafiospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public ProductDTO create(ProductDTO productDTO) {
        CategoryDTO category = categoryService.findById(productDTO.getCategory());

        Product product = new Product(
                productDTO.getProduct_id(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes(),
                category.getId(),
                productDTO.getPrice()
        );

        productRepository.add(product);

        return productDTO;
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

}
