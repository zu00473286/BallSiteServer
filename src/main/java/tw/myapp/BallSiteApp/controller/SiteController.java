package tw.myapp.BallSiteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.BallSiteApp.repository.SiteRepository;

@RestController
@RequestMapping("/api/site")
public class SiteController {

    @Autowired
    SiteRepository siteRepo;


    @GetMapping("/count")
    public String getRoomCount() {
        long count = siteRepo.getSiteCount();
        return "總共有" + count + "個球場";
    }

}
