package mobile_manage;

public class DienThoaiChinhHang extends DienThoai {
    private double warrantyPeriod;
    private String warrantyCoverage;

    public DienThoaiChinhHang(int id, String name, double price, int nums, String s, double product, double warrantyPeriod, String warrantyCoverage) {
        super(id, name, price, nums, product);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCoverage = warrantyCoverage;
    }

    public double getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(double warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }

    @Override
    public String toString() {
        return "DienThoaiChinhHang{" +
                "warrantyPeriod=" + warrantyPeriod +
                ", warrantyCoverage='" + warrantyCoverage + '\'' +
                '}';
    }
}
