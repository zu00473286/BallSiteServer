package tw.myapp.BallSiteApp.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.BallSiteApp.repository.SiteRepository;

@Service
public class SiteService {

    @Autowired
    SiteRepository siteRepository;

    public String getRoomCount() {
        long count = siteRepository.getSiteCount();
        return "共有" + count + "個球場";
    }

    public JSONObject getBadmintonAll() {
        return null;
    }
}
