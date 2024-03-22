package namdq.fpoly.asm_ph35172.DTO;

public class ShoeDTO {

    private  String name;
    private String brand;
    private long price;
    private String size;
    private String url;
    private  String _id;

    public ShoeDTO() {
    }

    public ShoeDTO(String nameShoe, String brand, long price, String sizeShoe, String url) {
        this.name = nameShoe;
        this.brand = brand;
        this.price = price;
        this.size = sizeShoe;
        this.url = url;
    }

    public String get_Id() {
        return _id;
    }

    public void set_Id(String _id) {
        this._id = _id;
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

    @Override
    public String toString() {
        return "ShoeDTO{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", url='" + url + '\'' +
                ", id='" + _id + '\'' +
                '}';
    }
}
