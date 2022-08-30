import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author:hdx
 * @Date:2022/8/24 13:50
 * @Description:
 */
public class GetTwoTimesMonth {

    //startTime：2021-11   endTime：2022-07
    public static List<String> getTwoTimesMonth(String startTime, String endTime) {
        List<String> result = new ArrayList<String>();
        String[] startTimeArr = startTime.split("-");
        Integer startTimeYear = Integer.parseInt(startTimeArr[0]);
        Integer startTimeMonth = Integer.parseInt(startTimeArr[1]);
        String[] endTimeArr = endTime.split("-");
        Integer endTimeYear = Integer.parseInt(endTimeArr[0]);
        Integer endTimeMonth = Integer.parseInt(endTimeArr[1]);
        boolean firstFlag = true;
        while (startTimeYear < endTimeYear || Objects.equals(startTimeYear, endTimeYear) && startTimeMonth <= endTimeMonth) {
            Integer mon = 1;
            if (firstFlag) {
                mon = Integer.parseInt(startTimeArr[1]);
                firstFlag = false;
            }
            while (startTimeYear < endTimeYear ? mon <= 12 : mon <= endTimeMonth) {
                String str = startTimeYear + ((mon == 10 || mon == 11 || mon == 12) ? "-" : "-0") + mon;
                result.add(str);
                mon++;
            }
            startTimeYear++;
            startTimeMonth = 1;
        }
        return result;
    }
}
