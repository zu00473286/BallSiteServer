package tw.myapp.BallSiteApp.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.BallSiteApp.repository.MemberRepository;

import java.util.List;
import java.util.Map;


@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    // 回傳登入帳號訊息
    public JSONObject getLoginResult( String username, String passwd) {
        long c = memberRepository.checkUser(username, passwd);
        // 準備一個回傳用的 JSON物件
        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        if ( c == 0 ) {
            responseObject.put("status",12);
            responseObject.put("mesg","驗證失敗");
        } else {
            responseObject.put("status",11);
            responseObject.put("mesg","驗證成功");
        }
        return  responseObject;
    }

    // 回傳註冊帳號訊息
    public JSONObject getAddResult(String name, String mobile, String email, String passwd) {
        long emailExist = memberRepository.checkEmail(email);
        JSONObject responseObject = new JSONObject();
        responseObject.put("type", 2);
        if ( emailExist == 0 ) {
            responseObject.put("status",000);
            responseObject.put("mesg","註冊成功");
            memberRepository.addUser(name, mobile, email, passwd);
        } else {
            responseObject.put("status",22);
            responseObject.put("mesg","信箱已存在");
        }
        return responseObject;
    }

    // 回傳會員資料
    public List<Map<String, Object>> getMemberAll() {
        return memberRepository.getUserAll();

        //JSONObject responseObject = new JSONObject();
        //responseObject.put("type", 2);
        //responseObject.put("status",0);
        //responseObject.put("mesg","撈取資料");
    }

}
