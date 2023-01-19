package tw.myapp.BallSiteApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Override
    public Long checkRent(int site_id, Date day, int period_id) {
        String query = "SELECT COUNT(*) FROM RentPremises WHERE site_id=? AND day=? AND period_id=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{site_id, day, period_id}, Long.class);
        return count;
    }

    @Override
    public Long addRent(int site_id, int member_id, Date day, int period_id) {
        String add = "INSERT INTO RentPremises (site_id, member_id, day, period_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(add, new Object[]{site_id, member_id, day, period_id});
        return null;
    }
}
