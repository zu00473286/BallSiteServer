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
        return jdbcTemplate.queryForObject("select count(*) from Sites", Long.class);
    }

    @Override
    public List<Map<String, Object>> getBadmintonAll() {
        return null;
    }
}
