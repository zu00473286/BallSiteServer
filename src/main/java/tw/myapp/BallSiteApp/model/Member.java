package tw.myapp.BallSiteApp.model;

import lombok.Data;

@Data
public class Member {
    private String member_id;
    private String name;
    private String mobile;
    private String email;
    private String passwd;
    private String money;
}
