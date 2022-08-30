package test;

import spring.test.A;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author:hdx
 * @Date:2021/12/7 9:53
 * @Description:
 */
public class BankInfoView {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("SELECT\n" +
                    "\t'sy_buff_bank_order_info_natural_"+ i +"' AS `tableName`,\n" +
                    "\t`a"+ i +"`.`id` AS `id`,\n" +
                    "\t`a"+ i +"`.`type` AS `type`,\n" +
                    "\t`a"+ i +"`.`orderid` AS `orderid`,\n" +
                    "\t`a"+ i +"`.`status` AS `status`,\n" +
                    "\t`a"+ i +"`.`consume_status` AS `consume_status`,\n" +
                    "\t`a"+ i +"`.`company_cost` AS `company_cost`,\n" +
                    "\t`a"+ i +"`.`company_profit` AS `company_profit`,\n" +
                    "\t`a"+ i +"`.`company_type` AS `company_type`,\n" +
                    "\t`a"+ i +"`.`addpoint_reserve` AS `addpoint_reserve`,\n" +
                    "\t`a"+ i +"`.`addpoint_money` AS `addpoint_money`,\n" +
                    "\t`a"+ i +"`.`addpoint_waitmoney` AS `addpoint_waitmoney`,\n" +
                    "\t`a"+ i +"`.`addpoint_type` AS `addpoint_type`,\n" +
                    "\t`a"+ i +"`.`refund_addpoint_money` AS `refund_addpoint_money`,\n" +
                    "\t`a"+ i +"`.`refund_addpoint_waitmoney` AS `refund_addpoint_waitmoney`,\n" +
                    "\t`a"+ i +"`.`refund_company_cost` AS `refund_company_cost`,\n" +
                    "\t`a"+ i +"`.`refund_company_profit` AS `refund_company_profit`,\n" +
                    "\t`a"+ i +"`.`create_time` AS `create_time`,\n" +
                    "\t`a"+ i +"`.`update_time` AS `update_time` \n" +
                    "FROM\n" +
                    "\t`sy_buff_bank_order_info_natural_"+ i +"` `a"+ i +"` UNION ALL \n");
        }
        System.out.println(sb.toString());


    }

}



