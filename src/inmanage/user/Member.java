package inmanage.user;

public class Member extends User {

    private String nationality;
    private String profilpic;
    private int age;

    public Member(String firstname, String lastname, String username, String password, String usertype, String nationality, String profilepic, int age) {
        super(firstname, lastname, username, password, usertype);
        this.nationality = nationality;
        this.profilpic = profilepic;
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getProfilpic() {
        return profilpic;
    }

    public void setProfilpic(String profilpic) {
        this.profilpic = profilpic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
