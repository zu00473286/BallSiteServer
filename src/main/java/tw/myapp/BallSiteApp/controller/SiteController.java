package tw.myapp.BallSiteApp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.myapp.BallSiteApp.service.SiteService;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @GetMapping("/count")
    public String count() {
        return siteService.getRoomCount();
    }

    // 處理 app 球場資料請求    postman已測試
    @GetMapping("/SiteAll")
    public List<Map<String, Object>>  SiteAll() {
        return siteService.getSiteAll();
    }

    // 處理 app 租借時段及編號請求     postman已測試
    @GetMapping("/PeriodId")
    public List<Map<String, Object>> PeriodId() {
        return siteService.getPeriodAll();
    }

    // 處理 app 租借球場請求    postman已測試
    @PostMapping("/rentSite")
    public String rentSite(@RequestBody String body) {
        JSONObject object = new JSONObject(body);
        System.out.println("後端接收訊息: " + object.toString(4));
        System.out.println("data 資料??? " + object.getJSONObject("data").toString(4));
        JSONObject data = object.getJSONObject("data");
        return siteService
                .getAddResult(
                        data.getInt("site_id"),
                        data.getInt("member_id"),
                        data.getString("day"),
                        data.getInt("period_id"))
                .toString();
    }

}
