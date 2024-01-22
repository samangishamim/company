package entities;



public class ShareholderBrand {
    private int shareholderbId;
    private int shareholderId;
    private int brandId;

    public ShareholderBrand() {
    }

    public ShareholderBrand(int shareholderbId, int shareholderId, int brandId) {
        this.shareholderbId = shareholderbId;
        this.shareholderId = shareholderId;
        this.brandId = brandId;
    }

    public int getShareholderbId() {
        return shareholderbId;
    }

    public void setShareholderbId(int shareholderbId) {
        this.shareholderbId = shareholderbId;
    }

    public int getShareholderId() {
        return shareholderId;
    }

    public void setShareholderId(int shareholderId) {
        this.shareholderId = shareholderId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
