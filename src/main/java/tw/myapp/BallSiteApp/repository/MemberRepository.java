package tw.myapp.BallSiteApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
    public long adduser(String username, String mobile, String user, String pass) {
        String add = "INSERT INTO Members (name,mobile,email,passwd) VALUES (?,?,?,?) " +
                "WHERE NOT EXISTS (SELECT 1 FROM Members WHERE email='?')";
        jdbcTemplate.execute(add);
        String query = "SELECT COUNT(*) FROM members WHERE email=?";
        long count = jdbcTemplate.queryForObject(query, Long.class);
        return count;
    }

}
