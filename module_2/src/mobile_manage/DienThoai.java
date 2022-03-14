package mobile_manage;

public abstract class DienThoai {
    private int id;
    private String name;
    private double price;
    private int nums;
    private String product;

    public DienThoai(int id, String name, double price, int nums, String product) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.nums = nums;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
