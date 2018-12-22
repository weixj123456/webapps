package org.com.tools.exceltool;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;

import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 总结

1). 顺序：读取workbook——>读取工作表——>然后根据先行、后列的顺序，依次解析。
2). 通过getFirstRowNum()和getFirstCellNum()获取的初始行号和列号是物理值，默认从0开始，与表格中看到的相差1。
3). “.”是特殊字符，用它进行字符串分割时需要转义~
 * @author weixj
 *
 */


@Controller
@WebServlet(name = "readExcelServlet", urlPatterns = "/readExcelServlet")
public class readExcelServlet //extends HttpServlet 
{
   // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        public void excelServlet() {
//	    request.setCharacterEncoding("UTF-8");

        //excel文件路径
        String excelPath = "E:\\readExcel\\test.xlsx";

        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                //    System.out.println("rIndex: " + rIndex);
                	System.out.println("   " );
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);                      
                //       /**     
                            if (cell != null) {
                                System.out.print(cell.toString()+" ");
                       //         System.out.print(" "+"======");
                            }  
                   //         */
                        }
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    	public static boolean isBlankObject(Object model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		    Field[] field = model.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组  
            for(int j=0 ; j<field.length ; j++){     //遍历所有属性
                String name = field[j].getName();    //获取属性的名字
                
                //System.out.println("attribute name:"+name);     
                name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
                //String type = field[j].getGenericType().toString();    //获取属性的类型
                Method m = model.getClass().getMethod("get"+name);
                if(!StringUtils.isBlank((String)m.invoke(model))){
                    return false;
                }             
            }
    		
    		return true;
    	}

        
        
        
        public List<List<Object>> readExcelContent(InputStream is) {
//          Map<Integer, String> content = new HashMap<Integer, String>();
          List<List<Object>> listArray = new ArrayList<List<Object>>();
          try {
        	  POIFSFileSystem  fs = new POIFSFileSystem(is);
        	  Workbook   wb = new HSSFWorkbook(fs);
          } catch (IOException e) {
              e.printStackTrace();
          }
          HSSFWorkbook wb = null;
		@SuppressWarnings("null")
		Sheet sheet = wb.getSheetAt(0); //得到第一个表单
          // 得到总行数
          int rowNum = sheet.getLastRowNum();
          Row row = sheet.getRow(0); //得到第一行
          int colNum = row.getPhysicalNumberOfCells();
          List<Object> list = null;
          // 正文内容应该从第二行开始,第一行为表头的标题
          for (int i = 1; i <= rowNum; i++) {
          	HSSFRow row1 = (HSSFRow) sheet.getRow(i);
              if(row1 == null){
              	continue;
              }
              int j = 0;
              list = new ArrayList<Object>();
              while (j < colNum) {
                  // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                  // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                  // str += getStringCellValue(row.getCell((short) j)).trim() +
                  // "-";
                  //str += getCellFormatValue(row.getCell((short) j)).trim() + ",";
                  list.add(j, getCellFormatValue(row1.getCell(j)).trim());
                  j++;
              }
              //str  = str.substring(0, str.length()-1);
              //content.put(i, str);
              //str = "";
              listArray.add(list);
          }
          return listArray;
      }
        
             
        
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
        
        private String getCellFormatValue(HSSFCell cell) {
			// TODO Auto-generated method stub
			return null;
		}




		public static void main(String[] args) {
        	readExcelServlet readexcel=new readExcelServlet();
        	readexcel.excelServlet();
		}
}
