package tw.myapp.BallSiteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.BallSiteApp.repository.SiteRepository;
import tw.myapp.BallSiteApp.service.SiteService;

import java.util.List;

@RestController
@RequestMapping("/api/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @GetMapping("/count")
    public String count() {
        return siteService.getRoomCount();
    }

    @GetMapping("/BadmintonAll")
    public String BadmintonAll() {
        return null;
    }


}
