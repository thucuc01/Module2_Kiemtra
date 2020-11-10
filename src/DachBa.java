import java.io.Serializable;

public class DachBa implements Serializable {
    private String sdt;
    private String group;
    private String name;
    private String gioitinh;
    private String address;
    private String email;

    public DachBa() {
    }

    public DachBa(String sdt, String group, String name, String gioitinh, String address, String email) {
        this.sdt = sdt;
        this.group = group;
        this.name = name;
        this.gioitinh = gioitinh;
        this.address = address;
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DachBa{" +
                "sdt='" + sdt + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
