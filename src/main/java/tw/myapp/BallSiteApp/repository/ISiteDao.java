package tw.myapp.BallSiteApp.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ISiteDao {

    // 呼叫 getSiteCount 回傳 所有球場數量
    public Long getSiteCount();

    // 呼叫 getSiteAll 回傳 所有場地的資訊
    public List<Map<String, Object>> getSiteAll();

    // 呼叫 checkRent 確認 該球場該時段是否已被租借
    public Long checkRent(int site_id, Date day, int period_id);

    // 呼叫 addRent 回傳 租借紀錄是否以寫入
    public Long addRent(int site_id, int member_id, Date day, int period_id);

}
