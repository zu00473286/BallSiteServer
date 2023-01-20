package tw.myapp.BallSiteApp.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.BallSiteApp.repository.SiteRepository;

import java.util.List;
import java.util.Map;

@Service
public class SiteService {

    @Autowired
    SiteRepository siteRepository;

    public String getRoomCount() {
        long count = siteRepository.getSiteCount();
        return "共有" + count + "個球場";
    }

    public List<Map<String, Object>> getSiteAll() {
        return siteRepository.getSiteAll();
    }

    // 取得資料庫 時段及其編號
    public List<Map<String, Object>> getPeriodAll() {
        return siteRepository.getPeriodId();
    }


    // 租借場地資料寫入
    public JSONObject getAddResult(int site_id, int member_id, String day, int period_id) {
        // 判斷是否已被租借 若為0表示無資料(未被租借)
        long rentExist = siteRepository.checkRent(site_id, day, period_id);
        JSONObject responseObject = new JSONObject();
        responseObject.put("type", 2);
        if ( rentExist == 0 ) {
            responseObject.put("status", 11);
            responseObject.put("mesg", "租借成功");
            siteRepository.addRent(site_id, member_id, day, period_id);
        } else {
            responseObject.put("status", 12);
            responseObject.put("mesg", "租借失敗");
        }
        return responseObject;
    }

}
