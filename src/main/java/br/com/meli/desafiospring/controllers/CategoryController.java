package br.com.meli.desafiospring.controllers;

import br.com.meli.desafiospring.dto.category.CategoryDTO;
import br.com.meli.desafiospring.dto.category.create.CreateCategoryRequestDTO;
import br.com.meli.desafiospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CategoryDTO create(@Valid @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO) {
        return categoryService.create(createCategoryRequestDTO);
    }
}
