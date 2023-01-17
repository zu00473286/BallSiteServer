package tw.myapp.BallSiteApp.repository;

import java.util.List;
import java.util.Map;

public interface ISiteDao {

    // 呼叫 getSiteCount 回傳 所有球場數量
    public Long getSiteCount();

    // 呼叫 getBadmintonAll 回傳 所有羽球場地的資訊
    public List<Map<String, Object>> getBadmintonAll();

}
