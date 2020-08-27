package sg.edu.nus.team7adproject.Adapter;

public class Departments {
    private String Id;
    private String DeptCode;
    private String DepartmentName;
    private String ContactName;
    private int Telephone;
    private int FaxNo;
    private String HeadName;
    private String RepName;
    private String CollectionPoint;

    public Departments() {
    }

    public Departments(String id, String deptCode, String departmentName, String contactName, int telephone, int faxNo, String headName, String repName, String collectionPoint) {
        Id = id;
        DeptCode = deptCode;
        DepartmentName = departmentName;
        ContactName = contactName;
        Telephone = telephone;
        FaxNo = faxNo;
        HeadName = headName;
        RepName = repName;
        CollectionPoint = collectionPoint;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int telephone) {
        Telephone = telephone;
    }

    public int getFaxNo() {
        return FaxNo;
    }

    public void setFaxNo(int faxNo) {
        FaxNo = faxNo;
    }

    public String getHeadName() {
        return HeadName;
    }

    public void setHeadName(String headName) {
        HeadName = headName;
    }

    public String getRepName() {
        return RepName;
    }

    public void setRepName(String repName) {
        RepName = repName;
    }

    public String getCollectionPoint() {
        return CollectionPoint;
    }

    public void setCollectionPoint(String collectionPoint) {
        CollectionPoint = collectionPoint;
    }
}
