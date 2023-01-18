package tw.myapp.BallSiteApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SiteRepository implements ISiteDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long getSiteCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM sites", Long.class);
    }

    @Override
    public List<Map<String, Object>> getSiteAll() {
        String query = "SELECT * FROM sites";
        List<Map<String, Object>> all = jdbcTemplate.queryForList(query);
        return all;
    }
}
