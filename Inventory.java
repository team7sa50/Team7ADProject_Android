package sg.edu.nus.team7adproject.Adapter;

public class Inventory {
    private String Id;
    private String itemCode;
    private String description;
    private double price;
    private int stock;
    private String measurementUnit;
    private String location;

    public Inventory() {
    }

    public Inventory(String itemCode, String description, double price, int stock, String measurementUnit, String location) {
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.measurementUnit = measurementUnit;
        this.location = location;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
