package sg.edu.nus.team7adproject.Adapter;

public class Requisitions {
    private String id;
    private String dateSubmitted;
    private String status;
    private String remarks;

    public Requisitions() {
    }

    public Requisitions(String id, String dateSubmitted, String status, String remarks) {
        this.id = id;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
