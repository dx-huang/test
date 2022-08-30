/**
 * @Author:hdx
 * @Date:2022/8/24 13:47
 * @Description:
 */
public class ComposeSqlAndParams {

    public static void main(String[] args) {
        String sql = "select id, name, title, pay_type, status, start_time, end_time, show_start_time, show_end_time, lower_prop_icon, high_prop_icon, `explain`,full_coupon,threshold_coupon,create_by, create_time, update_time from sy_blindbox_activity where (start_time >= ? AND start_time <= ?) OR (end_time >= ? AND end_time <= ?) OR (start_time <= ? AND start_time <= ? AND end_time >= ? AND end_time >= ?) OR (show_start_time >= ? AND show_start_time <= ?) OR (show_end_time >= ? AND show_end_time <= ?) OR (show_start_time <= ? AND show_start_time <= ? AND show_end_time >= ? AND show_end_time >= ?) limit 1";
        String params = "1661616000(Integer), 1661702400(Integer), 1661616000(Integer), 1661702400(Integer), 1661616000(Integer), 1661702400(Integer), 1661616000(Integer), 1661702400(Integer), 1661616000(Integer), 1661788800(Integer), 1661616000(Integer), 1661788800(Integer), 1661616000(Integer), 1661788800(Integer), 1661616000(Integer), 1661788800(Integer)";
        String s = composeSqlAndParams(sql,params);
        System.out.println(s);

    }


    public static String composeSqlAndParams(String sql,String params) {
        //把?转换成%s
        sql = sql.replaceAll("\\?","%s");
        //去掉param的(类型)
        String[] paramsArr = params.split(",");
        StringBuilder builder = new StringBuilder();
        for (String param : paramsArr) {
            if (param.contains("(String)")) {
                //将字符串类型赋上双引号
                builder.append( "\"" + param.substring(0,param.indexOf("(")).trim() + "\"" + ",");
            }else {
                builder.append(param.substring(0,param.indexOf("(")).trim() + ",");
            }
        }
//        System.out.println(builder);
        String[] split = builder.toString().split(",");
        String result = String.format(sql, split);
        return result;
    }
}
