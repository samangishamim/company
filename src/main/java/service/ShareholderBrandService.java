package service;

import repository.ShareholderBrandRepository;

public class ShareholderBrandService {
    private final ShareholderBrandRepository shareholderBrandRepository;

    public ShareholderBrandService(ShareholderBrandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository = shareholderBrandRepository;
    }
}
