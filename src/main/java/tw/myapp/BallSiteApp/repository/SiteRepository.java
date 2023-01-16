package tw.myapp.BallSiteApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class SiteRepository implements ISiteDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 呼叫 getRoomCount 應該要回傳所有球場數量
    @Override
    public Long getSiteCount() {
        return jdbcTemplate.queryForObject("select count(*) from Sites", Long.class);
    }
}
