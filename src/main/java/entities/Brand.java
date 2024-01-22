package entities;



public class Brand {
    private int brandId;
    private String brandName;
    private String website;
    private  String brandDescription;

    public Brand() {
    }

    public Brand(int brandId, String brandName, String website, String brandDescription) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.website = website;
        this.brandDescription = brandDescription;
    }

    public Brand(String brandName, String website, String brandDescription) {
        this.brandName = brandName;
        this.website = website;
        this.brandDescription = brandDescription;
    }
}
