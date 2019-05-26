package com.alphabet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 功能:zip压缩、解压 说明:使用Apache Ant里提供的zip工具。
 * 不使用java.util.zip的包,把ant.jar放到classpath中. 程序中使用import org.apache.tools.zip.*;
 */
public class ZipUtil {
	static final int BUFFER = 512;

	public ZipUtil() {
	}

	static public void zip(String srcPathName, String zipFile) {
		File file = new File(srcPathName);
		if (!file.exists())
			throw new RuntimeException(srcPathName + "不存在！");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
			CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,
					new CRC32());
			ZipOutputStream out = new ZipOutputStream(cos);
			String basedir = "";
			ZipUtil.zip(file, out, basedir);
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 压缩函数，本函数循环调用
	 * 
	 * @param src
	 *            压缩文件或者文件夹
	 * @param out
	 * @param base
	 *            基准文件夹
	 * @throws Exception
	 */
	public static void zip(File src, ZipOutputStream out, String base)
			throws Exception {
		if (src.isDirectory()) { // 如果是目录
			File[] files = src.listFiles(); // 列举出目录中所有的内容
			// 对于目录，必须在entry名字后面加上"/"，表示它将以目录项存储。
			// 注意：下面不能用File.separator(这里解析为"\")，需要用"/",否则文件夹下会产生一个空文件
			// out.putNextEntry(new ZipEntry(base + File.separator)); // 放入一级目录
			out.setEncoding("utf-8");
			out.putNextEntry(new ZipEntry(base + "/")); // 放入一级目录

			base = base.length() == 0 ? "" : base + File.separator;
			for (int i = 0; i < files.length; i++) {
				ZipUtil.zip(files[i], out, base + files[i].getName());
			}

		} else { // 如果是文件
			if ("".equals(base)) {
				out.putNextEntry(new ZipEntry(base + File.separator));
				base = src.getName();
			}
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(src);
			byte[] data = new byte[BUFFER];
			int b;
			while ((b = in.read(data)) != -1) {
				out.write(data, 0, b);
			}
			in.close();

		}
	}

	/**
	 * 
	 * @param path
	 *            存储文件路径
	 * @param zipDirectory
	 *            目标文件夹名字
	 */
	// 压缩文件夹内的文件
	public void doZip(String path, String zipDirectory) {// zipDirectoryPath:需要压缩的文件夹名
		try {
			File src = new File(path + zipDirectory);
			String zipFileName = new String((zipDirectory + ".zip").getBytes(),
					"ISO-8859-1");
			;// 压缩后生成的zip文件名
			HttpServletResponse response = ServletActionContext.getResponse();
			// 设置响应正文的MIME类型
			response.setContentType("application/force-download");
			// response.setHeader("Content-length", "");
			response.setHeader("Content-Disposition", "attachment;filename=\""
					+ zipFileName + "\" ");
			ZipOutputStream out = new ZipOutputStream(response
					.getOutputStream());
			out.flush();
			zip(src, out, zipDirectory);
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param zipFileName
	 *            源文件路径
	 * @param destPath
	 *            目标文件路径
	 */
	// 解压指定zip文件
	public void unZip(String zipFileName, String destPath) {// zipFileName需要解压的zip文件名
		String outputDirectory = destPath;
		try {
			ZipFile zipFile = new ZipFile(zipFileName);
			Enumeration e = zipFile.getEntries();
			ZipEntry zipEntry = null;
			while (e.hasMoreElements()) {
				zipEntry = (ZipEntry) e.nextElement();
				if (zipEntry.isDirectory()) {
					String name = zipEntry.getName();
					name = name.substring(0, name.length() - 1);
					File f = new File(outputDirectory + File.separator + name);
					f.getParentFile().mkdirs();
					f.mkdirs();

				} else {
					File f = new File(outputDirectory + File.separator
							+ zipEntry.getName());
					if (f.getParentFile().exists() == false) {
						f.getParentFile().mkdirs();
					}

					f.createNewFile();
					InputStream in = zipFile.getInputStream(zipEntry);
					FileOutputStream out = new FileOutputStream(f);
					int c;
					byte[] by = new byte[BUFFER];
					while ((c = in.read(by)) != -1) {
						out.write(by, 0, c);
					}
					out.flush();
					out.close();
					in.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param zipFileName
	 * @param destPath
	 * @return  解压后的文件路径
	 */
	public String unZip1(String zipFileName, String destPath) {// unZipfileName需要解压的zip文件名
		String outputDirectory = destPath;
		String retFilePath = "";
		String ext = "";
		try {
			ZipFile zipFile = new ZipFile(zipFileName);
			Enumeration e = zipFile.getEntries();
			ZipEntry zipEntry = null;
			while (e.hasMoreElements()) {
				zipEntry = (ZipEntry) e.nextElement();
				if (zipEntry.isDirectory()) {
					String name = zipEntry.getName();
					name = name.substring(0, name.length() - 1);
					File f = new File(outputDirectory + File.separator + name);
					f.getParentFile().mkdirs();
					f.mkdirs();

				} else {
					File f = new File(outputDirectory + File.separator
							+ zipEntry.getName());
					if (f.getParentFile().exists() == false) {
						f.getParentFile().mkdirs();
					}

					f.createNewFile();
					ext = f.getName().substring((f.getName().lastIndexOf('.')+1));
					if("xls".equals(ext.toLowerCase()) || "xlsx".equals(ext.toLowerCase())){
						retFilePath = f.getPath();						
					}
					InputStream in = zipFile.getInputStream(zipEntry);
					FileOutputStream out = new FileOutputStream(f);
					int c;
					byte[] by = new byte[1024];
					while ((c = in.read(by)) != -1) {
						out.write(by, 0, c);
					}
					out.flush();
					out.close();
					in.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retFilePath;
	}
	
	public static void main(String[] args) {	
		Calendar cal =Calendar.getInstance();
                  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                  cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY); //获取本周一的日期

		System.out.println(df.format(cal.getTime()));
		//这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		//增加一个星期，才是我们中国人理解的本周日的日期
		
	         System.out.println(df.format(cal.getTime()));
	}
}
