package service;

import entities.Shareholder;
import repository.ShareHolderBrandRepository;

import java.sql.SQLException;

public class ShareHolderBrandService {
    private  final ShareHolderBrandRepository shareHolderBrandRepository;
    public ShareHolderBrandService( ShareHolderBrandRepository shareHolderBrandRepository1) {

        this.shareHolderBrandRepository = shareHolderBrandRepository1;
    }

}
