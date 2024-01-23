package service;

import repository.CategoryRepository;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository1) {
        this.categoryRepository = categoryRepository1;
    }
}
