package test;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @Author:hdx
 * @Date:2021/11/17 9:54
 * @Description:
 */
public class test {
        public static void main(String[] args) throws Exception {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
            post.addRequestHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
            NameValuePair[] data = { new NameValuePair("Uid", "hdxdx"),//中国网建sms平台注册的用户名
                    new NameValuePair("Key", "d41d8cd98f00b204e980"),//中国网建sms平台注册的用户密钥
                    new NameValuePair("smsMob", "13751945684"),//将要发送到的手机号码
                    new NameValuePair("smsText", "【shouyou网络】验证码：5684，请勿把验证码告知他人。如非本人操作请忽略") };//要发送的短信内容
            post.setRequestBody(data);

            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:" + statusCode);
            for (Header h : headers) {
                System.out.println(h.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes(
                    "gbk"));
            System.out.println(result); // 打印返回消息状态

            post.releaseConnection();
        }


}
