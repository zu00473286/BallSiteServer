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

    // 帳號密碼 檢查是否正確
    @Override
    public Long checkUser(String user, String pass) {
        String query = "SELECT COUNT(*) FROM members WHERE email=? AND passwd=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{user,pass}, Long.class);
        return count;
    }

    // 搜尋信箱檢查是否已註冊過
    @Override
    public Long checkEmail(String email) {
        String query = "SELECT COUNT(*) FROM members WHERE email=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{email}, Long.class);
        return count;
    }

    // 註冊會員 將資料寫入資料庫
    @Override
    public String addUser(String name, String mobile, String email, String pass) {
        String add = "INSERT INTO Members (name,mobile,email,passwd) VALUES (?,?,?,?)";
        jdbcTemplate.update(add, new Object[] {name,mobile,email,pass});
        return "";
    }

    // 以會員email 搜尋該會員全部資料
    @Override
    public Map<String, Object> getUserAll(String email) {
        String query = "SELECT * FROM members WHERE email=?";
        Map<String, Object> row = jdbcTemplate.queryForMap(query, email);
        return row;
    }

    // 以會員編號 搜尋該會員租借場地的紀錄
    @Override
    public List<Map<String, Object>> getRentRecord(int member_id) {
        String query = "SELECT * FROM rentPremises WHERE member_id=?";
        List<Map<String, Object>> rowSet = jdbcTemplate.queryForList(query, member_id);
        return rowSet;
    }

}
