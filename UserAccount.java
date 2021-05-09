package project.models;

public class UserAccount {
    public int customerID;
    public int sin;
    public String IDType;
    public String IDNum;
    public String name;
    public String address;
    public String phone;
    public String email;
    public String password;

    public UserAccount(int customerID, int sin, String IDType, String IDNum, String name, String address, String phone, String email, String password) {
        this.customerID = customerID;
        this.sin = sin;
        this.IDType = IDType;
        this.IDNum = IDNum;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getSin() {
        return sin;
    }

    public String getIDType() {
        return IDType;
    }

    public String getIDNum() {
        return IDNum;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "customerID=" + customerID +
                ", sin=" + sin +
                ", IDType='" + IDType + '\'' +
                ", IDNum='" + IDNum + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
