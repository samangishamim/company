package service;

import repository.BrandRepository;

public class BrandService {


    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

}
