package TestObjects;

public class UserInfo {

    private String user_name, password, name, surName, birthdate, gender, weight, email;

    public static UserInfo getUserInfo1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Name1");
        userInfo.setSurName("Surname1");
        userInfo.setBirthdate("01/01/2001");
        userInfo.setGender("Female");
        userInfo.setWeight("100");
        userInfo.setUser_name("testun1");
        userInfo.setPassword("testpasswd1");
        userInfo.setEmail("testEmail1@test.com");
        return userInfo;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
