package tw.myapp.BallSiteApp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.BallSiteApp.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    //處理 app login 需求
    @PostMapping("/login")
    public String login(@RequestBody String body) {
        // 轉成 Java 物件 方便屬性取出
        // 將符合 JSON格式的字串傳入建構式 自動 parse 轉乘 JSONObject
        JSONObject object = new JSONObject(body);
        System.out.println("後端接收訊息: " + object.toString(4));
        System.out.println("data 資料??? " + object.getJSONObject("data").toString(4));
        JSONObject data = object.getJSONObject("data");
        System.out.println("帳號: " + data.getString("user") + " ,密碼: " + data.getString("pass"));
        return memberService
                .getLoginResult(data.getString("user"), data.getString("pass"))
                .toString();
    }

    // 處理 app 註冊請求
    @PostMapping("/register")
    public String register(@RequestBody String body) {
        JSONObject object = new JSONObject(body);
        System.out.println("後端接收訊息: " + object.toString(4));
        System.out.println("data 資料??? " + object.getJSONObject("data").toString(4));
        JSONObject data = object.getJSONObject("data");
        System.out.println("使用者: " + data.getString("name") + " ,帳號: " + data.getString("email"));
        return memberService
                .getAddResult(
                        data.getString("name"),
                        data.getString("mobile"),
                        data.getString("email"),
                        data.getString("passwd"))
                .toString();
    }

}
