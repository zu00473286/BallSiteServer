package tw.myapp.BallSiteApp.repository;

import java.util.Map;

/*
    將 MemberDao 的各種方法 定義(規範/規則) 先列出來
    後續實作 遵照這個規則
 */
public interface IMemberDao {

    // 呼叫 checkUser 回傳 登入是否驗證成功
    public Long checkUser(String user, String pass);

    // 呼叫 checkEmail 確認 帳號是否已存在
    public Long checkEmail(String email);

    // 呼叫 addUser 回傳 註冊帳號是否成功
    public String addUser(String username, String mobile, String user, String pass);

    // 呼叫 getUserAll 回傳 某某會員所有資料(需先確認已登入, 由前端判斷)
    public Map<String, Object> getUserAll(String email);
}
