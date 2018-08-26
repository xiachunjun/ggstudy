package com.ggstudy.logic.excel;

import java.io.File;
import java.util.ArrayList;

public class ExcelTest {
//    private void saveAsExcel(BizContent biz,OrderInfo info){
//        ArrayList<String> dataStr = new ArrayList<String>();
//        StringBuffer strBuff = new StringBuffer();
//
////添加数据
//        strBuff.append(info.getEffectiveDate()).append(",");
//
//        dataStr.add(strBuff.toString());
//        ArrayList<String> fieldName = new ArrayList<String>();
//
////添加列名
//        fieldName.add("生效日期");
//
//
//        File file =new File("./zhongan.xls");
//        if(!file.exists()){
//            System.out.println("不存在");
//            try {
//                System.out.println(file.createNewFile());
//                file.createNewFile();
//                ExcelFileGenerator generator = new ExcelFileGenerator(fieldName,
//                        dataStr);
//                OutputStream os=new FileOutputStream(file);
//                generator.expordExcel(os);
//            } catch (Exception e) {
//                System.out.println("error");
//            }
//
//        }else{
//            try {
//                POIFSFileSystem ps=new POIFSFileSystem(new FileInputStream("c:\\zhongan.xls")); //使用POI提供的方法得到excel的信息
//                HSSFWorkbook wb=new HSSFWorkbook(ps);
//                HSSFSheet sheet=wb.getSheetAt(0); //获取到工作表，因为一个excel可能有多个工作表
//                HSSFRow row=sheet.getRow(0); //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
//                System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum()); //分别得到最后一行的行号，和一条记录的最后一个单元格
//
//                FileOutputStream out=new FileOutputStream("c:\\zhongan.xls"); //向c:\\zhongan.xls中写数据
//                row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据
//                String fileStr=dataStr.get(0);
//                String[] fileStrs=fileStr.split(",");
//                for(int i=0;i<fileStrs.length;i++){
//                    row.createCell(i).setCellValue(fileStrs[i]);
//                }
//                out.flush();
//                wb.write(out);
//                out.close();
//                System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//
//
//
//    }
//    private void saveReceiveStr(String str){
//        File file =new File("c:\\zhongan.txt");
//        if(!file.exists()){
//            System.out.println("不存在");
//            try {
//                System.out.println(file.createNewFile());
//                file.createNewFile();
//            } catch (Exception e) {
//                System.out.println("error");
//            }
//
//        }
//        BufferedWriter out = null;
////追加信息
//        try {
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true),"utf-8"));
//            out.write("时间： "+DateUtils.getNowDate());
//            out.write("\r\n");
//            out.write(str);
//            out.write("\r\n");
//            out.flush();
//            System.out.println("写入成功！");
//        } catch (Exception e) {
//            System.out.println("error");
//        }
//
//
//    }
}
