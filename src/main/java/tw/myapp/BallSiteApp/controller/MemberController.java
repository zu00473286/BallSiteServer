package tw.myapp.BallSiteApp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.myapp.BallSiteApp.service.MemberService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    //處理 app login 需求   postman已測試
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

    // 處理 app 註冊請求  postman已測試
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

    // 處理 app 顯示會員資料請求
    @GetMapping("/memberAll")
    public Map<String, Object> memberAll(@PathVariable String body) {
        JSONObject object = new JSONObject(body);
        JSONObject data = object.getJSONObject("data");
        System.out.println("請求來源帳號: " + data.getString("email"));
        return memberService.getMemberAll(data.getString(body));
    }

    // 處理 app 會員租借紀錄請求
    @GetMapping("/rentRecord")
    public List<Map<String, Object>> rentRecord(@PathVariable int body) {
        JSONObject object = new JSONObject(body);
        JSONObject data = object.getJSONObject("data");
        System.out.println("會員編號: " + data.getInt("member_id"));
        return memberService.getRecordAll(data.getInt("member_id"));
    }

}
