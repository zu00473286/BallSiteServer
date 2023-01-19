package tw.myapp.BallSiteApp.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.BallSiteApp.repository.SiteRepository;

import java.sql.Date;
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

    public JSONObject getAddResult(int site_id, int member_id, Date day, int period_id) {
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
