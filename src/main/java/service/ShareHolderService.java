package service;

import repository.ShareHolderRepository;

public class ShareHolderService {
    private final ShareHolderRepository shareHolderRepository;
    public ShareHolderService( ShareHolderRepository shareHolderRepository1) {
        this.shareHolderRepository = shareHolderRepository1;
    }
}
