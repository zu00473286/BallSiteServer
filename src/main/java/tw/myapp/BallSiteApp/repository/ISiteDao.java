package tw.myapp.BallSiteApp.repository;

/*
    將 SiteDao 的各種方法 定義(規範/規則) 先列出來
    後續實作 遵照這個規則
 */
public interface ISiteDao {

    // 呼叫 getRoomCount 應該要回傳所有球場數量
    public Long getSiteCount();

}
