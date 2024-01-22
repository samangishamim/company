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
}
