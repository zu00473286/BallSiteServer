package tw.myapp.BallSiteApp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.BallSiteApp.repository.SiteRepository;
import tw.myapp.BallSiteApp.service.SiteService;

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

    // 處理 app 球場資料請求
    @GetMapping("/SiteAll")
    public List<Map<String, Object>>  SiteAll() {
        return siteService.getSiteAll();

    }


}
