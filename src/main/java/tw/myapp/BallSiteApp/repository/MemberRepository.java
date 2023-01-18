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
        String query = "SELECT COUNT(*) FROM members WHERE email=? AND passwd=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{user,pass}, Long.class);
        return count;
    }

    @Override
    public Long checkEmail(String email) {
        String query = "SELECT COUNT(*) FROM members WHERE email=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{email}, Long.class);
        return count;
    }

    @Override
    public String addUser(String name, String mobile, String email, String pass) {
        String add = "INSERT INTO Members (name,mobile,email,passwd) VALUES (?,?,?,?)";
        jdbcTemplate.update(add, new Object[] {name,mobile,email,pass});
        return "";
    }

    @Override
    public List<Map<String, Object>> getUserAll(String email) {
        String search = "SELECT * FROM members WHERE email=?";
        List<Map<String, Object>> row = jdbcTemplate.queryForList(search);
        return row;
    }

}
