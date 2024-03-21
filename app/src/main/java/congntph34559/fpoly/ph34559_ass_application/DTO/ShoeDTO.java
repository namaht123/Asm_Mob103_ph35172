package congntph34559.fpoly.ph34559_ass_application.DTO;

public class ShoeDTO {

    private  String name;
    private String brand;
    private long price;
    private String size;
    private String url;

    public ShoeDTO() {
    }

    public ShoeDTO(String nameShoe, String brand, long price, String sizeShoe, String url) {
        this.name = nameShoe;
        this.brand = brand;
        this.price = price;
        this.size = sizeShoe;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
