package sg.edu.nus.team7adproject.Adapter;

public class Suppliers {
    private String Id;
    private String SupplierCode;
    private String SupplierName;
    private String SupplierAddress;
    private int ContactNo;
    private int FaxNo;

    public Suppliers() {
    }

    public Suppliers(String id, String supplierCode, String supplierName, String supplierAddress, int contactNo, int faxNo) {
        Id = id;
        SupplierCode = supplierCode;
        SupplierName = supplierName;
        SupplierAddress = supplierAddress;
        ContactNo = contactNo;
        FaxNo = faxNo;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSupplierCode() {
        return SupplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        SupplierCode = supplierCode;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getSupplierAddress() {
        return SupplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        SupplierAddress = supplierAddress;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public void setContactNo(int contactNo) {
        ContactNo = contactNo;
    }

    public int getFaxNo() {
        return FaxNo;
    }

    public void setFaxNo(int faxNo) {
        FaxNo = faxNo;
    }
}
