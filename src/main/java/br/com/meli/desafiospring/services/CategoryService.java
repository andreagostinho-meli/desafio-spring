package br.com.meli.desafiospring.services;

import br.com.meli.desafiospring.dto.category.CategoryDTO;
import br.com.meli.desafiospring.dto.category.create.CreateCategoryRequestDTO;
import br.com.meli.desafiospring.entities.Category;
import br.com.meli.desafiospring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private int id = 1;

    public CategoryDTO create(CreateCategoryRequestDTO createCategoryRequestDTO) {
        Category category = new Category(id, createCategoryRequestDTO.getName());
        id++;

        categoryRepository.add(category);

        return new CategoryDTO(category.getId(), category.getName());
    }
}
