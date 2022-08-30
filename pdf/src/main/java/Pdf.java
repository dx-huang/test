import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.*;
import java.util.*;

/**
 * @Author:hdx
 * @Date:2022/3/31 18:31
 * @Description:
 */
public class Pdf {

    private static Logger logger = LoggerFactory.getLogger(Pdf.class);


    /**
     * 生成PDF 数据流
     * @param template 模板名称
     * @param dataMap pdf里需赋值的信息
     */
    public static byte[] generatePdfStream(String template, Map<String,String> dataMap) {
        try {
            //生成pdf目标文件
            PdfReader pr = new PdfReader("template/" + template + ".pdf");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfStamper ps = new PdfStamper(pr, bos);
//            ps.setEncryption(null, "YW20210115".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
            BaseFont bf = BaseFont.createFont("font/simkai.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            ArrayList<BaseFont> fonts = new ArrayList<BaseFont>();
            fonts.add(bf);
            AcroFields fields = ps.getAcroFields();
            fields.setSubstitutionFonts(fonts);
            for (String key : dataMap.keySet()) {
                fields.setField(key, dataMap.get(key));
            }
            //设置属性生成文档
            ps.setFormFlattening(true);
            ps.close();
            //生成的pdf的文件路径
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            out.write(bos.toByteArray());
            byte[] rest = out.toByteArray();
            out.flush();
            out.close();
            bos.close();
            return rest;
        }catch (Exception e) {
            logger.error("generateSettleBillPdf error={}",e);
        }
        return null;
    }

    /**
     * 获取对账单需要参数
     * @return
     */
    private static Map<String,String> getSettleBillParam() {
        Map<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("anjiu_enterprise","广东安久科技有限公司");
        dataMap.put("anjiu_taxpayer_identity_number","9144010605657285X8");
        dataMap.put("anjiu_address_phone","广州市天河区大观中路95号6栋508房(仅限办公) 020-38370156");
        dataMap.put("anjiu_bank_name_account","中国银行股份有限公司广州站西路支行 662668292329");
        dataMap.put("invoice_content","*信息技术服务*信息服务费");
        dataMap.put("payee","陶然");
        dataMap.put("payee_mobile","18680215520");
        dataMap.put("payee_address","广州市海珠区新港东路70号万胜汇创客PARK 8栋");

        dataMap.put("title","某某公司对账单");
        dataMap.put("enterprise","某某公司");
        dataMap.put("bank_name","某靓仔");
        dataMap.put("bank_account","xx银行");
        dataMap.put("contact","contact111");
        dataMap.put("contact_mobile","contact_mobile111");
        dataMap.put("contact_address","contact_address111");

//        Collections.reverse(sumMoneyList); //月份从最近倒序排列
        for (int i = 1; i <= 6; i++) {
                dataMap.put("batch_time" + i, "batch_time" + i);
                dataMap.put("flow_money" + i,"flow_money" + i);
                dataMap.put("addpoint_money" + i,"addpoint_money" + i);
                dataMap.put("revoke_money" + i,"revoke_money" + i);
                dataMap.put("settle_money" + i,"settle_money" + i);
        }
        dataMap.put("total_addpoint_money","total_addpoint_money111");
        dataMap.put("total_revoke_money","total_revoke_money111");
        dataMap.put("total_settle_money","total_settle_money111");
        return dataMap;
    }

    public static void write(byte[] dataStream, String filename) {
        File file = new File("E:\\Java\\ideaProject\\test\\pdf\\src\\main\\resources\\template\\"+ filename +".pdf");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(dataStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void getSettleBillDownUrl() {
        //获取参数
        Map<String, String> dataMap = getSettleBillParam();
        //构建账单流
        byte[] dataStream = generatePdfStream("对账单模板", dataMap);
        String filename = System.currentTimeMillis() / 1000 + "对账单";
        write(dataStream,filename);
        System.out.println("执行完成");
    }


    public static void main(String[] args) {
        getSettleBillDownUrl();

//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }

}
