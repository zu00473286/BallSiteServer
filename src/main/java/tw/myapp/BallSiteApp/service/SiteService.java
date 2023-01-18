package tw.myapp.BallSiteApp.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.BallSiteApp.repository.SiteRepository;

import java.awt.*;
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

    public List<Map<String, Object>> getBadmintonAll() {
        return siteRepository.getBadmintonAll();
    }
}
