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
        String query = "select count(*) from Members where email=? and passwd=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{user,pass},Long.class);
        return count;
    }
}
