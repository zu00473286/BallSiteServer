package tw.myapp.BallSiteApp.repository;

import java.util.List;
import java.util.Map;

public interface ISiteDao {

    // 呼叫 getSiteCount 回傳 所有球場數量
    public Long getSiteCount();

    // 呼叫 getSiteAll 回傳 所有場地的資訊
    public List<Map<String, Object>> getSiteAll();

}
