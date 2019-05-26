package com.alphabet.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * EXCEL导出工具类(兼容2007) 采用POI
 */
public class ExcelUtil {
    protected static Log log = LogFactory.getLog(ExcelUtil.class);
    private Workbook wb = null;// 工作簿
    private Sheet sheet = null;
    private Font font = null;

    public enum ExcelType {
        XLS, // Excel2003
        XLSX;// Excel2007
    }

    public ExcelUtil() {
        super();
    }

    /**
     * 将EXCEL数据输出到流中（用于WEB导出）
     * 
     * @param name
     *            工作表的名字
     */
    public ExcelUtil(ExcelType type, String name) {
        try {
            switch (type) {
            case XLS:
                wb = new HSSFWorkbook();
                break;
            case XLSX:
                wb = new XSSFWorkbook();
                break;
            default:
                wb = new HSSFWorkbook();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        init(name);
    }
    
    //创建excelUti
    public ExcelUtil(ExcelType type){
    	  try {
              switch (type) {
              case XLS:
                  wb = new HSSFWorkbook();
                  break;
              case XLSX:
                  wb = new XSSFWorkbook();
                  break;
              default:
                  wb = new HSSFWorkbook();
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
    }
    /**
     * 初始化参数
     * 
     * @param sheetName
     *            工作薄名称
     */
    private void init(String sheetName) {
        font = wb.createFont();// 定义字体
        sheet = wb.createSheet(sheetName);
    }

    /**
     * 创建一个sheet
     * 
     * @param sheetName
     *            工作薄名称
     */
    public Sheet creatSheet(String sheetName, int index) {
        return wb.createSheet(sheetName);
    }

    public CellStyle getHeaderStyle() {
        return getFormat(14);
    }

    public CellStyle getDefaultStyle() {
        return getFormat(12);
    }

    /**
     * 生成一个单元格的样式
     * 
     * @param fontSize
     *            字体大小
     * @param align
     *            对齐方式
     * @return
     */
    public CellStyle getFormat(int fontSize, short... align) {
        font.setFontHeightInPoints((short) fontSize);
        CellStyle style = wb.createCellStyle();
        style.setFont(font);
        try {
            if (align.length == 0) {
                style.setAlignment(CellStyle.ALIGN_CENTER);// 左右居中
            } else {
                style.setAlignment(align[0]);
            }
            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
            style.setBorderTop(CellStyle.BORDER_THIN);
            style.setBorderRight(CellStyle.BORDER_THIN);
            style.setBorderBottom(CellStyle.BORDER_THIN);
            style.setBorderLeft(CellStyle.BORDER_THIN);

            // style.setTopBorderColor(HSSFColor.BLACK.index);
            // style.setRightBorderColor(HSSFColor.BLACK.index);
            // style.setBottomBorderColor(HSSFColor.BLACK.index);
            // style.setLeftBorderColor(HSSFColor.BLACK.index);
            // style.setWrapText(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return style;
    }
    /**
     * 生成一个单元格的样式
     * @param fontSize 字体
     * @param align 对齐方式
     * @param backgroundColor 背景颜色
     * @return
     */
    public CellStyle getCellStyleFormat(int fontSize, short align,short backgroundColor,short fontColor) {
        return getCellStyleFormat(fontSize, align, backgroundColor, fontColor, Font.BOLDWEIGHT_NORMAL);
    }
    public CellStyle getHeaderCellStyle(){
    	Font cellFont = wb.createFont();// 定义字体
    	cellFont.setFontHeightInPoints((short)12);
    	//cellFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        CellStyle style = wb.createCellStyle();
        style.setFont(cellFont);
        try {
        	style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
        	style.setAlignment(CellStyle.ALIGN_CENTER);
            style.setBorderTop(CellStyle.BORDER_THIN);
            style.setBorderRight(CellStyle.BORDER_THIN);
            style.setBorderBottom(CellStyle.BORDER_THIN);
            style.setBorderLeft(CellStyle.BORDER_THIN);
            style.setWrapText(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return style;
    }
    /**
     * 生成一个单元格的样式
     * @param fontSize 字体
     * @param align 对齐方式
     * @param backgroundColor 背景颜色
     * @param boldWeight 
     * @return
     */
    public CellStyle getCellStyleFormat(int fontSize, short align,short backgroundColor,short fontColor,short boldWeight) {
    	Font cellFont = wb.createFont();// 定义字体
    	cellFont.setFontHeightInPoints((short) fontSize);
    	cellFont.setBoldweight(boldWeight);
    	cellFont.setColor(fontColor);
        CellStyle style = wb.createCellStyle();
        style.setFont(cellFont);
        try {
        	style.setAlignment(align);
            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
            style.setBorderTop(CellStyle.BORDER_THIN);
            style.setBorderRight(CellStyle.BORDER_THIN);
            style.setBorderBottom(CellStyle.BORDER_THIN);
            style.setBorderLeft(CellStyle.BORDER_THIN);
            style.setFillForegroundColor(backgroundColor);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return style;
    }
    
    /**
     * 判断对齐方式
     * 
     * @param align
     * @return
     */
    public short getAlign(char align) {
        switch (align) {
        case 'C':
            return CellStyle.ALIGN_CENTER;
        case 'R':
            return CellStyle.ALIGN_RIGHT;
        case 'L':
            return CellStyle.ALIGN_LEFT;
        default:
            return CellStyle.ALIGN_CENTER;
        }
    }

    /**
     * 添加一个单元格
     * 
     * @param colIndex
     *            列号
     * @param rowIndex
     *            行号
     * @param content
     *            单元格内容
     * @param style
     *            格式
     * @return
     */
    public void addCell(int colIndex, int rowIndex, String content, CellStyle... style) {
        try {
            Row row = sheet.getRow(rowIndex);
            if (row == null) {
                row = sheet.createRow(rowIndex);
            }
            Cell cell = row.createCell(colIndex);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(content);
            if (style.length > 0) {
                cell.setCellStyle(style[0]);
            } else {
                cell.setCellStyle(this.getDefaultStyle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一个单元格
     * 
     * @param colIndex
     *            列号
     * @param rowIndex
     *            行号
     * @param content
     *            单元格内容
     * @param style
     *            格式
     * @return
     */
    public void addCell(int colIndex, int rowIndex, int content, CellStyle... style) {
        try {
            Row row = sheet.getRow(rowIndex);
            if (row == null) {
                row = sheet.createRow(rowIndex);
            }
            Cell cell = row.createCell(colIndex);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(content);
            if (style.length > 0) {
                cell.setCellStyle(style[0]);
            } else {
                cell.setCellStyle(this.getDefaultStyle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给指定Sheet添加一个单元格
     * 
     * @param colIndex
     *            列号
     * @param rowIndex
     *            行号
     * @param content
     *            单元格内容
     * @param style
     *            格式
     * @return
     */
    public void addCell(Sheet sheet, int colIndex, int rowIndex, String content, CellStyle... style) {
        try {
            Row row = sheet.getRow(rowIndex);
            if (row == null) {
                row = sheet.createRow(rowIndex);
            }
            Cell cell = row.createCell(colIndex);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(content);
            if (style.length > 0) {
                cell.setCellStyle(style[0]);
            } else {
                cell.setCellStyle(this.getDefaultStyle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置某一列的宽度
     * 
     * @param col
     *            列号
     * @param width
     *            宽度
     */
    public void setWidth(int col, int width) {
        sheet.setColumnWidth(col, width * 256);
    }

    /**
     * 设置某一列的宽度
     * 
     * @param col
     *            列号
     * @param width
     *            宽度
     */
    public void setWidth(Sheet sheet, int col, int width) {
        sheet.setColumnWidth(col, width * 256);
    }

    /**
     * 将数据写出，并关闭工作簿
     */
    public void writeAndClose(OutputStream out) {
        try {
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 读excel的头的名字
     * 
     * @author Chenzy
     * @param fileName
     *            文件路径
     * @return
     * @throws ExcelException
     */
    public static String getExcelSheetNames(String fileName) {
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(is);
            return wb.getSheetName(0);
        } catch (Exception fnE) {
            log.error(fnE);
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 读excel的字段名
     * 
     * @author Chenzy
     * @param fileName
     * @param sheetName
     * @return
     * @throws ExcelException
     */
    public static List<String> getExcelColumnName(String fileName, String sheetName) {
        InputStream is = null;
        List<String> headers = new ArrayList<String>();
        try {
            is = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet = wb.getSheet(sheetName);
            Iterator rit = sheet.rowIterator();
            if (rit.hasNext()) {
                Row row = (Row) rit.next();
                Iterator cit = row.cellIterator();
                while (cit.hasNext()) {
                    Cell cell = (Cell) cit.next();
                    headers.add(cell.getRichStringCellValue().getString());
                }
            }
            return headers;

        } catch (Exception fnE) {
            log.error(fnE);
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return headers;
    }

    public static int getRows(Sheet sheet) {
        int rows = 0;
        Iterator rit = sheet.rowIterator();
        while (rit.hasNext()) {
            rit.next();
            rows++;
        }
        return rows;
    }

    public static int getColumns(Sheet sheet) {
        int columns = 0;
        Iterator rit = sheet.rowIterator();
        if (rit.hasNext()) {
            Row row = (Row) rit.next();
            Iterator cit = row.cellIterator();
            while (cit.hasNext()) {
                cit.next();
                columns++;
            }
        }
        return columns;
    }
    
    //合并单元格
    //开始行，结束行，开始列，结束列
    public void mergedRegion(short a1,short a2,short a3,short a4){
    	sheet.addMergedRegion(new CellRangeAddress(a1,a2,a3,a4));
    }
    
    public void setRowHeight(int rowIndex, short h) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        row.setHeight((short)(h*20));
    }

    public static void main(String[] args) throws Exception {
        // 创建cells
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("new sheet");
        // 注意以下的代码很多方法的参数是short 而不是int 所以需要做一次类型转换
        HSSFRow row = sheet.createRow((short) 0);
        // sheet 创建一行
        HSSFCell cell = row.createCell(0);
        // 行创建一个单元格
        cell.setCellValue(1);
        // 设定单元格的值
        // 值的类型参数有多中double ,String ,boolean,
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue("This is a string");
        row.createCell(3).setCellValue(true);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        wb.write(fileOut);
        fileOut.close();

    }
    
    /**
     * 添加一个单元格
     */
    @SuppressWarnings("deprecation")
	public void setHeader() {
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 3));
    	sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 5));
    	sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 7));
    	sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
    	sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
    	sheet.addMergedRegion(new CellRangeAddress(0, 1, 9, 9));
    	sheet.createFreezePane(10, 2);//设置冻结窗口（宽×高）
    }
    
    /**
     * 招聘需求单元格
     */
    @SuppressWarnings("deprecation")
  	public void setHeader1() {
    	sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 17));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 18, 24));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 25, 27));
        for(int i = 0;i<28;i++){
            sheet.addMergedRegion(new CellRangeAddress(1, 1, i, i));
        }
    }
    
    
    /**
     * 功能：拷贝sheet
     * 实际调用 	copySheet(targetSheet, sourceSheet, targetWork, sourceWork, true)
     * @param targetSheet
     * @param sourceSheet
     * @param targetWork
     * @param sourceWork                                                                   
     */
    public static void copySheet(HSSFSheet targetSheet, HSSFSheet sourceSheet,
            HSSFWorkbook targetWork, HSSFWorkbook sourceWork) throws Exception{
        if(targetSheet == null || sourceSheet == null || targetWork == null || sourceWork == null){
            throw new IllegalArgumentException("调用PoiUtil.copySheet()方法时，targetSheet、sourceSheet、targetWork、sourceWork都不能为空，故抛出该异常！");
        }
        copySheet(targetSheet, sourceSheet, targetWork, sourceWork, true);
    }

    /**
     * 功能：拷贝sheet
     * @param targetSheet
     * @param sourceSheet
     * @param targetWork
     * @param sourceWork
     * @param copyStyle					boolean 是否拷贝样式
     */
    public static void copySheet(HSSFSheet targetSheet, HSSFSheet sourceSheet,
            HSSFWorkbook targetWork, HSSFWorkbook sourceWork, boolean copyStyle)throws Exception {
        
        if(targetSheet == null || sourceSheet == null || targetWork == null || sourceWork == null){
            throw new IllegalArgumentException("调用PoiUtil.copySheet()方法时，targetSheet、sourceSheet、targetWork、sourceWork都不能为空，故抛出该异常！");
        }
        
        //复制源表中的行
        int maxColumnNum = 0;

        Map styleMap = (copyStyle) ? new HashMap() : null;
        
        HSSFPatriarch patriarch = targetSheet.createDrawingPatriarch(); //用于复制注释
        for (int i = sourceSheet.getFirstRowNum(); i <= sourceSheet.getLastRowNum(); i++) {
            HSSFRow sourceRow = sourceSheet.getRow(i);
            HSSFRow targetRow = targetSheet.createRow(i);
            
            if (sourceRow != null) {
                copyRow(targetRow, sourceRow,
                        targetWork, sourceWork,patriarch, styleMap);
                if (sourceRow.getLastCellNum() > maxColumnNum) {
                    maxColumnNum = sourceRow.getLastCellNum();
                }
            }
        }
        
        //复制源表中的合并单元格
        mergerRegion(targetSheet, sourceSheet);
        
        //设置目标sheet的列宽
        for (int i = 0; i <= maxColumnNum; i++) {
            targetSheet.setColumnWidth(i, sourceSheet.getColumnWidth(i));
        }
    }
    
    /**
     * 功能：拷贝row
     * @param targetRow
     * @param sourceRow
     * @param styleMap
     * @param targetWork
     * @param sourceWork
     * @param targetPatriarch
     */
    public static void copyRow(HSSFRow targetRow, HSSFRow sourceRow,
            HSSFWorkbook targetWork, HSSFWorkbook sourceWork,HSSFPatriarch targetPatriarch, Map styleMap) throws Exception {
        if(targetRow == null || sourceRow == null || targetWork == null || sourceWork == null || targetPatriarch == null){
            throw new IllegalArgumentException("调用PoiUtil.copyRow()方法时，targetRow、sourceRow、targetWork、sourceWork、targetPatriarch都不能为空，故抛出该异常！");
        }
        
        //设置行高
        targetRow.setHeight(sourceRow.getHeight());
        
        for (int i = sourceRow.getFirstCellNum(); i <= sourceRow.getLastCellNum(); i++) {
            HSSFCell sourceCell = sourceRow.getCell(i);
            HSSFCell targetCell = targetRow.getCell(i);
            
            if (sourceCell != null) {
                if (targetCell == null) {
                    targetCell = targetRow.createCell(i);
                }
                
                //拷贝单元格，包括内容和样式
                copyCell(targetCell, sourceCell, targetWork, sourceWork, styleMap);
                
                //拷贝单元格注释
                copyComment(targetCell,sourceCell,targetPatriarch);
            }
        }
    }
    
    /**
     * 功能：拷贝cell，依据styleMap是否为空判断是否拷贝单元格样式
     * @param targetCell			不能为空
     * @param sourceCell			不能为空
     * @param targetWork			不能为空
     * @param sourceWork			不能为空
     * @param styleMap				可以为空				
     */
    public static void copyCell(HSSFCell targetCell, HSSFCell sourceCell, HSSFWorkbook targetWork, HSSFWorkbook sourceWork,Map styleMap) {
        if(targetCell == null || sourceCell == null || targetWork == null || sourceWork == null ){
            throw new IllegalArgumentException("调用PoiUtil.copyCell()方法时，targetCell、sourceCell、targetWork、sourceWork都不能为空，故抛出该异常！");
        }
        
        //处理单元格样式
        if(styleMap != null){
            if (targetWork == sourceWork) {
                targetCell.setCellStyle(sourceCell.getCellStyle());
            } else {
                String stHashCode = "" + sourceCell.getCellStyle().hashCode();
                HSSFCellStyle targetCellStyle = (HSSFCellStyle) styleMap
                        .get(stHashCode);
                if (targetCellStyle == null) {
                    targetCellStyle = targetWork.createCellStyle();
                    targetCellStyle.cloneStyleFrom(sourceCell.getCellStyle());
                    styleMap.put(stHashCode, targetCellStyle);
                }
                
                targetCell.setCellStyle(targetCellStyle);
            }
        }
        
        //处理单元格内容
        switch (sourceCell.getCellType()) {
        case HSSFCell.CELL_TYPE_STRING:
            targetCell.setCellValue(sourceCell.getRichStringCellValue());
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:
            targetCell.setCellValue(sourceCell.getNumericCellValue());
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            targetCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
            break;
        case HSSFCell.CELL_TYPE_BOOLEAN:
            targetCell.setCellValue(sourceCell.getBooleanCellValue());
            break;
        case HSSFCell.CELL_TYPE_ERROR:
            targetCell.setCellErrorValue(sourceCell.getErrorCellValue());
            break;
        case HSSFCell.CELL_TYPE_FORMULA:
            targetCell.setCellFormula(sourceCell.getCellFormula());
            break;
        default:
            break;
        }
    }
    
    /**
     * 功能：拷贝comment
     * @param targetCell
     * @param sourceCell
     * @param targetPatriarch
     */
    public static void copyComment(HSSFCell targetCell,HSSFCell sourceCell,HSSFPatriarch targetPatriarch)throws Exception{
        if(targetCell == null || sourceCell == null || targetPatriarch == null){
            throw new IllegalArgumentException("调用PoiUtil.copyCommentr()方法时，targetCell、sourceCell、targetPatriarch都不能为空，故抛出该异常！");
        }
        
        //处理单元格注释
        HSSFComment comment = sourceCell.getCellComment();
        if(comment != null){
            HSSFComment newComment = targetPatriarch.createComment(new HSSFClientAnchor());
            newComment.setAuthor(comment.getAuthor());
            newComment.setColumn(comment.getColumn());
            newComment.setFillColor(comment.getFillColor());
            newComment.setHorizontalAlignment(comment.getHorizontalAlignment());
            newComment.setLineStyle(comment.getLineStyle());
            newComment.setLineStyleColor(comment.getLineStyleColor());
            newComment.setLineWidth(comment.getLineWidth());
            newComment.setMarginBottom(comment.getMarginBottom());
            newComment.setMarginLeft(comment.getMarginLeft());
            newComment.setMarginTop(comment.getMarginTop());
            newComment.setMarginRight(comment.getMarginRight());
            newComment.setNoFill(comment.isNoFill());
            newComment.setRow(comment.getRow());
            newComment.setShapeType(comment.getShapeType());
            newComment.setString(comment.getString());
            newComment.setVerticalAlignment(comment.getVerticalAlignment());
            newComment.setVisible(comment.isVisible());
            targetCell.setCellComment(newComment);
        }
    }
    
    /**
     * 功能：复制原有sheet的合并单元格到新创建的sheet
     * 
     * @param targetSheet
     * @param sourceSheet
     */
    public static void mergerRegion(HSSFSheet targetSheet, HSSFSheet sourceSheet)throws Exception {
        if(targetSheet == null || sourceSheet == null){
            throw new IllegalArgumentException("调用PoiUtil.mergerRegion()方法时，targetSheet或者sourceSheet不能为空，故抛出该异常！");
        }
        
        for (int i = 0; i < sourceSheet.getNumMergedRegions(); i++) {
            CellRangeAddress oldRange = sourceSheet.getMergedRegion(i);
            CellRangeAddress newRange = new CellRangeAddress(
                    oldRange.getFirstRow(), oldRange.getLastRow(),
                    oldRange.getFirstColumn(), oldRange.getLastColumn());
            targetSheet.addMergedRegion(newRange);
        }
    }

    /**
     * 功能：重新定义HSSFColor.PINK的色值
     * 
     * @param workbook
     * @return
     */
    public static HSSFColor setMBorderColor(HSSFWorkbook workbook) {
        HSSFPalette palette = workbook.getCustomPalette();
        HSSFColor hssfColor = null;
        byte[] rgb = { (byte) 0, (byte) 128, (byte) 192 };
        try {
            hssfColor = palette.findColor(rgb[0], rgb[1], rgb[2]);
            if (hssfColor == null) {
                palette.setColorAtIndex(HSSFColor.PINK.index, rgb[0], rgb[1],
                        rgb[2]);
                hssfColor = palette.getColor(HSSFColor.PINK.index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hssfColor;
    }
}
