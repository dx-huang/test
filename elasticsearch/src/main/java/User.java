import org.elasticsearch.action.index.IndexRequest;

/**
 * @Author:hdx
 * @Date:2022/5/31 10:47
 * @Description:
 */
public class User {
    private Integer id;
    private String name;
    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
