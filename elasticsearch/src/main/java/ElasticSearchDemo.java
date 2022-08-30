import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:hdx
 * @Date:2022/5/31 10:19
 * @Description:
 */
public class ElasticSearchDemo {

    //1.创建索引
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        CreateIndexRequest request = new CreateIndexRequest("user");
//        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
//        boolean acknowledged = response.isAcknowledged();
//        System.out.println("acknowledged:" + acknowledged);
//        client.close();
//    }

    //2.查看索引
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        GetIndexRequest request = new GetIndexRequest("shopping");
//        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
//        System.out.println(response.getAliases());
//        System.out.println(response.getMappings());
//        System.out.println(response.getSettings());
//        client.close();
//    }

    //3.删除索引
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        DeleteIndexRequest request = new DeleteIndexRequest("user");
//        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
//        System.out.println(response.isAcknowledged());
//        client.close();
//    }


    //4.新增文档
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        IndexRequest request = new IndexRequest();
//        request.index("user").id("001");
//        User user = new User();
//        user.setId(4459);
//        user.setName("玛卡巴卡");
//        user.setTel("10086");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(user);
//        request.source(s, XContentType.JSON);
//        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
//        client.close();
//    }

    //5.修改文档
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        UpdateRequest request = new UpdateRequest();
//        request.index("user").id("001");
//        request.doc(XContentType.JSON, "name","唔西迪西");
//
//
//        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
//
//        client.close();
//    }


    //6.查询文档
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        GetRequest request = new GetRequest();
//        request.index("user").id("001");
//
//        GetResponse response = client.get(request, RequestOptions.DEFAULT);
//        System.out.println(response.getIndex());
//        System.out.println(response.getSourceAsString());
//    }

    //7.删除文档
//    public static void main(String[] args) throws IOException {
//       RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//       DeleteRequest request = new DeleteRequest();
//       request.index("class").id("002");
//        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
//        System.out.println(response.toString());
//        client.close();
//    }

    //8.批量添加文档
//    public static void main(String[] args) throws IOException {
//       RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        BulkRequest request = new BulkRequest();
//
//        User user1 = new User();
//        user1.setId(4459);
//        user1.setName("小明");
//        user1.setTel("10086");
//
//        User user2 = new User();
//        user2.setId(4460);
//        user2.setName("小红");
//        user2.setTel("10000");
//
//        User user3 = new User();
//        user3.setId(4461);
//        user3.setName("小东");
//        user3.setTel("10011");
//
//        User user4 = new User();
//        user4.setId(4462);
//        user4.setName("小停");
//        user4.setTel("16789");
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        request.add(new IndexRequest().index("class").id("001").source(objectMapper.writeValueAsString(user1),XContentType.JSON));
//        request.add(new IndexRequest().index("class").id("002").source(objectMapper.writeValueAsString(user2),XContentType.JSON));
//        request.add(new IndexRequest().index("class").id("003").source(objectMapper.writeValueAsString(user3),XContentType.JSON));
//        request.add(new IndexRequest().index("class").id("004").source(objectMapper.writeValueAsString(user4),XContentType.JSON));
//
//
//        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
//        client.close();
//        System.out.println("完成");
//    }

    //9.批量删除
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        BulkRequest request = new BulkRequest();
//        request.add(new DeleteRequest().index("class").id("002"));
//        request.add(new DeleteRequest().index("shopping").id("1002"));
//
//        client.bulk(request,RequestOptions.DEFAULT);
//        client.close();
//        System.out.println("完成");
//    }

    //10.条件查询
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
//        SearchRequest request = new SearchRequest();
//        request.indices("class");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.query(QueryBuilders.termQuery("name","小明"));
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("hits:" + hits.getTotalHits());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();
//        System.out.println("完成");
//    }


}
