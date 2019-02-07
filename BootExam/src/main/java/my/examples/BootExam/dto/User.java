package my.examples.BootExam.dto;

import lombok.Data;

import java.util.Date;
@Data
public class User {
        private Long id;
        private String name;
        private String nickname;
        private String email;
        private String passwd;
        private Date regdate;
}
