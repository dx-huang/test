import sun.net.www.http.HttpClient;

import java.io.IOException;

/**
 * @Author:hdx
 * @Date:2022/8/24 13:51
 * @Description: 钉钉机器人风险告警通知工具类
 */
public class DingTalkUtil {

    public static final String url = "/robot/send?access_token=";

    public void sendDingTalk(String path, String msg) throws IOException {
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
//        JSONObject bodys = new JSONObject();
//        bodys.put("msgtype", "text");
//        JSONObject text = new JSONObject();
//        text.put("content", msg);
//        bodys.put("text", text);
//        JSONObject at = new JSONObject();
//        at.put("isAtAll", false);
//        bodys.put("at", at);
//        StringEntity se = new StringEntity(bodys.toJSONString(), "utf-8");
//        httpPost.setEntity(se);
//        httpClient.execute(httpPost);
    }
}
