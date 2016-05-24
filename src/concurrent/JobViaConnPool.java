package concurrent;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 4/27/16.
 * Never forget your dream
 */
public class JobViaConnPool implements Runnable {

    public JobViaConnPool(int runTime, int threadIndex) {
        this.runTime = runTime;
        this.threadIndex = threadIndex;
    }

    private int runTime = 10;
    private List<String> targets;
    private int threadIndex = 0;
    @Override
    public void run() {
        try {
            int count = 1;
            int every10 = 0;
            HttpPost post = new HttpPost("http://cz.duorouwu.com//weixinvoteb/index/vote");

            PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
            manager.setMaxTotal(5);
            manager.setDefaultMaxPerRoute(3);

            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(manager).build();

            for (int i = 0; i < runTime; i++){
                List<NameValuePair> pairs = new ArrayList<>();
                //        pairs.add(new BasicNameValuePair("openid", "oTpdps8xvVohssaWQtScQMLH1xxxx"));
                pairs.add(new BasicNameValuePair("openid", this.generateWeChatId()));
                pairs.add(new BasicNameValuePair("id[]", "9"));

                if(every10 == 10){
                    pairs.add(new BasicNameValuePair("id[]", "28"));
                    every10 = 0;
                }
                every10++;

                //李猛 9; //于燕飞: 25
//                pairs.addAll(targets.stream().map(target -> new BasicNameValuePair("id[]", target)).collect(Collectors.toList()));

                post.setEntity(new UrlEncodedFormEntity(pairs));
                HttpResponse resp = httpClient.execute(post);

                System.out.println(resp.getStatusLine());
                if(resp.getStatusLine().getStatusCode() == 200){
                    System.out.println(threadIndex + ": Voted! " + count++);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateWeChatId(){
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMLOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 28; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
        //System.out.println(output);
        //return output;
    }
}
