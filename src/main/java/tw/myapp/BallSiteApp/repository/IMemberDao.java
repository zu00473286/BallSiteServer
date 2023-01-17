package tw.myapp.BallSiteApp.repository;

/*
    將 MemberDao 的各種方法 定義(規範/規則) 先列出來
    後續實作 遵照這個規則
 */
public interface IMemberDao {

    // 呼叫 checkUser 回傳登入是否驗證成功
    public Long checkUser(String user, String pass);

    // 呼叫 addUser 回傳註冊帳號是否成功
    public long adduser(String username, String mobile, String user, String pass);
}
