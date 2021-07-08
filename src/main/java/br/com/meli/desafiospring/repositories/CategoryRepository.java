package br.com.meli.desafiospring.repositories;

import br.com.meli.desafiospring.entities.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private List<Category> categories = new ArrayList<>();

    public void add(Category category) {
        categories.add(category);
    }
}
