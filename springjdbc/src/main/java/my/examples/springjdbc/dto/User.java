package my.examples.springjdbc.dto;

import java.util.Date;

public class User {
    private Long user_id;
    private String nickname;
    private String email;
    private String passwd;
    private Date regdate;

    public User(){
        regdate = new Date();
    }

    public Long getUser_Id() {
        return user_id;
    }

    public void setUser_Id(Long user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
