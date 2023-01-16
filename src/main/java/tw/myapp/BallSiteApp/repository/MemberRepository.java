package tw.myapp.BallSiteApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository implements IMemberDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long checkUser(String user, String pass) {
        String query = "SELECT COUNT(*) FROM Members WHERE email=? AND passwd=?;";
        long count = jdbcTemplate.queryForObject(query, new Object[]{user,pass},Long.class);
        return count;
    }

    @Override
    public List<Map<String, Object>> adduser() {
        // 新增一筆資料進去 如果此信箱不存在
        String append =
                "INSERT INTO Members (name,mobile,email,passwd) SELECT (?,?,?,?) " +
                "WHERE NOT EXISTS ( SELECT 1 FROM Members WHERE Members.email='?');";
        // 如果此信箱已存在 則回傳 "此信箱已註冊過"

        return null;
    }

}
