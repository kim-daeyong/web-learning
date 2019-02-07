package my.examples.springjdbc.dto;

import java.util.Date;

public class Board {

    private long post_id;
    private String nickname;
    private String title;
    private String content;
    private Date regdate;
    private long view;

    public Board() {
        this.regdate = regdate;
    }

    public Board(long post_id, String nickname,String title, String content) {
        this();
        this.post_id = post_id;
        this.nickname = nickname;
        this.content = content;
        this.title = title;
    }

    public Board(long post_id, String nickname,String title, String content, Date regdate, long view) {
        this.post_id = post_id;
        this.nickname = nickname;
        this.content = content;
        this.regdate = regdate;
        this.view = view;
        this.title = title;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Board{" +
                "post_id=" + post_id +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", view=" + view +
                '}';
    }
}
