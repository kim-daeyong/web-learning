package my.examples.businesscard.dto;

public class BusinessCard {
    private int id;
    private String name;
    private String phone;
    private String corporatioNname;

    public BusinessCard() {
    }

    public BusinessCard(String name, String phone, String corporatioNname) {
        this.name = name;
        this.phone = phone;
        this.corporatioNname = corporatioNname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCorporatioNname() {
        return corporatioNname;
    }

    public void setCorporatioNname(String corporatioNname) {
        this.corporatioNname = corporatioNname;
    }

    @Override
    public String toString() {
        return "BusinessCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", corporatioNname='" + corporatioNname + '\'' +
                '}';
    }
}
