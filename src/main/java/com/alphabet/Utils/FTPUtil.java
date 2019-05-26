package com.alphabet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * FTP服务器工具类
 * 
 * @author hgl
 * @version 
 * @date 2015-07-10
 */
public class FTPUtil {
	
	/**
	 * 上传文件至FTP服务器
	 * 
	 * @param url
	 * 		服务器IP地址
	 * @param port
	 * 		服务器端口
	 * @param userName
	 * 		用户登录名
	 * @param password
	 * 		用户登录密码
	 * @param storePath
	 * 		服务器文件存储路径
	 * @param fileName
	 * 		服务器文件存储名称
	 * @param is
	 * 		文件输入流
	 * @return
	 * 		<b>true</b>：上传成功
	 * 		<br/>
	 * 		<b>false</b>：上传失败
	 */
	public static boolean storeFile (String url, int port, String userName, String password, String storePath, String fileName, InputStream is) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try {
			// 连接至服务器，端口默认为21时，可直接通过URL连接
			ftp.connect(url ,port);
			// 登录服务器
			ftp.login(userName, password);
			// 判断返回码是否合法
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				// 不合法时断开连接
				ftp.disconnect();
				// 结束程序
				return result;
			}
			// 设置文件操作目录
			ftp.changeWorkingDirectory(storePath);
			//ftp.enterLocalPassiveMode();
			// 设置文件类型，二进制
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 设置缓冲区大小
			ftp.setBufferSize(20971520);
			// 上传文件
			result = ftp.storeFile(fileName, is);
			//result = ftp.storeFile(new String(fileName.getBytes("UTF-8"),"iso-8859-1"),is);
			// 关闭输入流
			is.close();
			// 登出服务器
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 判断输入流是否存在
				if (null != is) {
					// 关闭输入流
					is.close();
				}
				// 判断连接是否存在
				if (ftp.isConnected()) {
					// 断开连接
					ftp.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	
	/**
	 * 从FTP服务器下载文件至本地
	 * 
	 * @param url
	 * 		服务器IP地址
	 * @param port
	 * 		服务器端口
	 * @param userName
	 * 		用户登录名
	 * @param password
	 * 		用户登录密码
	 * @param remotePath
	 * 		服务器文件存储路径
	 * @param fileName
	 * 		服务器文件存储名称
	 * @param localPath
	 * 		本地文件存储路径
	 * @return
	 * 		<b>true</b>：下载成功
	 * 		<br/>
	 * 		<b>false</b>：下载失败
	 */
	public static boolean retrieveFile (String url, int port, String userName, String password, String remotePath, String fileName, String localPath) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		OutputStream os = null;
		try {
			// 连接至服务器，端口默认为21时，可直接通过URL连接
			ftp.connect(url ,port);
			// 登录服务器
			ftp.login(userName, password);
			// 判断返回码是否合法
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				// 不合法时断开连接
				ftp.disconnect();
				// 结束程序
				return result;
			}
			// 设置文件操作目录
			ftp.changeWorkingDirectory(remotePath);
			// 设置文件类型，二进制
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 设置缓冲区大小(KB)
			ftp.setBufferSize(30720);
			// 设置字符编码
			ftp.setControlEncoding("UTF-8");
			// 构造本地文件对象
			File localFile = new File(localPath + "/" + fileName);
			// 获取文件操作目录下所有文件名称
			String[] remoteNames = ftp.listNames("\\201105");
			// 循环比对文件名称，判断是否含有当前要下载的文件名
			for (String remoteName: remoteNames) {
				if (fileName.equals(remoteName)) {
					result = true;
					break;
				}
			}
			// 文件名称比对成功时，进入下载流程
			if (result) {
				// 构造文件输出流
				os = new FileOutputStream(localFile);
				// 下载文件
				result = ftp.retrieveFile(new String(fileName.getBytes("UTF-8"),"ISO-8859-1"), os);
				// 关闭输出流
				os.close();
			}
			// 登出服务器
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 判断输出流是否存在
				if (null != os) {
					// 关闭输出流
					os.close();
				}
				// 判断连接是否存在
				if (ftp.isConnected()) {
					// 断开连接
					ftp.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	/**
	 * 商务模块  合同信息 中 上传的 附件 同步至 项目管理服务器（上传功能）
	 * @param url       服务器IP地址
	 * @param port      服务器端口
	 * @param userName  用户登录名
	 * @param password  用户登录密码
	 * @param filePath  服务器文件存储路径     ( 需要进行判断  如果有201506文件夹  则  设置文件操作目录 为"201506"，否则需要新建一文件夹，上传文件置其目录下 )
	 * @param fileName  服务器文件存储名称
	 * @param is		文件输入流
	 * @return
	 *  	<b>true</b>：上传成功
	 * 		<br/>
	 * 		<b>false</b>：上传失败
	 * @author hgl
	 * 10.10.32.2服务器文件 路径  E:\webapps\xmglxt_data\document\201106\1308732167015.pdf
	 */
	public static boolean storeFileToPm (String url, int port, String userName, String password, String filePath, String fileName, InputStream is) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try {
			// 连接至服务器，端口默认为21时，可直接通过URL连接
			ftp.connect(url ,port);
			// 登录服务器
			ftp.login(userName, password);
			// 判断返回码是否合法
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				// 不合法时断开连接
				ftp.disconnect();
				// 结束程序
				return result;
			}
//				ftp.changeWorkingDirectory("/201105");   // 设置文件操作目录
			//获得登陆进去的所有文件夹名称
			String[] remoteNames = ftp.listNames();
			//根据表中文件路径  获取201506 ，并判断当前目录下 是否含有该文件夹
			for (String remoteName: remoteNames) {
				if (filePath.equals(remoteName)) {
					result = true;
					break;
				}
			}
			if (result) {     //如果存在该文件夹
				 // 设置文件操作目录
				ftp.changeWorkingDirectory("/"+filePath);  
			}else{			  //如果不存在，则要新建一个如201507文件夹
				//在 服务器创建文件夹
				ftp.makeDirectory(filePath);         
//					File file =  new File("/"+filePath);
//					if(!file.exists()){
					//在 服务器创建文件夹
//						ftp.makeDirectory(filePath);
					//file.mkdirs();   此创建文件夹方式错误
//					}
				ftp.changeWorkingDirectory("/"+filePath);
			}
			//ftp.enterLocalPassiveMode();
			// 设置文件类型，二进制
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 设置缓冲区大小（不超过20M）
			ftp.setBufferSize(20971520);
			// 上传文件
			result = ftp.storeFile(fileName, is);
			//result = ftp.storeFile(new String(fileName.getBytes("UTF-8"),"iso-8859-1"),is);
			// 关闭输入流
			is.close();
			// 登出服务器
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 判断输入流是否存在
				if (null != is) {
					// 关闭输入流
					is.close();
				}
				// 判断连接是否存在
				if (ftp.isConnected()) {
					// 断开连接
					ftp.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 商务模块  合同信息 中 XQ确认单保存时，从采购系统的下载 附件 同步至 本地（OA）
	 * @param url		服务器IP地址
	 * @param port 		服务器端口
	 * @param userName 		用户登录名
	 * @param password 		用户登录密码
	 * @param remotePath	服务器文件存储路径
	 * @param fileName 		服务器文件存储名称
	 * @param localPath		本地文件存储路径
	 * @return
	 * 		<b>true</b>：下载成功
	 * 		<br/>
	 * 		<b>false</b>：下载失败
	 * @author hgl
	 * OA服务器文件 路径  D:\\upload_document\contract\XQ...\1308732167015.jpg
	 */
	public static boolean retrieveFileFromScmToOa (String url, int port, String userName, String password, String remotePath, String fileName, String localPath) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		OutputStream os = null;
		try {
			// 连接至服务器，端口默认为21时，可直接通过URL连接
			ftp.connect(url ,port);
			// 登录服务器
			ftp.login(userName, password);
			// 判断返回码是否合法
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				// 不合法时断开连接
				ftp.disconnect();
				// 结束程序
				return result;
			}
			// 设置文件操作目录
			ftp.changeWorkingDirectory(remotePath);
			// 设置文件类型，二进制
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 设置缓冲区大小(KB)
			ftp.setBufferSize(30720);
			// 设置字符编码
			ftp.setControlEncoding("UTF-8");
			// 构造本地文件对象
			File localFile = new File(localPath);
			File parent = localFile.getParentFile(); 
			if(parent!=null&&!parent.exists()){ 
				parent.mkdirs(); 
			} 
			localFile.createNewFile();
			// 获取文件操作目录下所有文件名称
			String[] remoteNames = ftp.listNames();
			// 循环比对文件名称，判断是否含有当前要下载的文件名
			for (String remoteName: remoteNames) {
				if (fileName.equals(remoteName)) {
					result = true;
					break;
				}
			}
			// 文件名称比对成功时，进入下载流程
			if (result) {
				// 构造文件输出流
				os = new FileOutputStream(localFile);
				// 下载文件
				result = ftp.retrieveFile(new String(fileName.getBytes("UTF-8"),"ISO-8859-1"), os);
				// 关闭输出流
				os.close();
			}
			// 登出服务器
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 判断输出流是否存在
				if (null != os) {
					// 关闭输出流
					os.close();
				}
				// 判断连接是否存在
				if (ftp.isConnected()) {
					// 断开连接
					ftp.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 删除ftp文件 
	 * @param url
	 * @param port
	 * @param userName
	 * @param password
	 * @param remotePath   服务器欲删除文件路径  like: \201106\1308732167015.pdf
	 * @param fileName	          服务器文件名称
	 * @return
	 */
	 public static boolean deleteUploadFileToPm (String url, int port, String userName, String password, String remotePath, String fileName) {
		 boolean result = false;
			FTPClient ftp = new FTPClient();
			//获得要删除文件的父目录  like:  \201106
			String parentFile = remotePath.substring(0, 6);
			try {
				// 连接至服务器，端口默认为21时，可直接通过URL连接
				ftp.connect(url ,port);
				// 登录服务器
				ftp.login(userName, password);
				// 判断返回码是否合法
				if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
					// 不合法时断开连接
					ftp.disconnect();
					// 结束程序
					return result;
				}
				// 设置文件类型，二进制
				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
				// 设置缓冲区大小(KB)
				ftp.setBufferSize(30720);
				// 设置字符编码
				ftp.setControlEncoding("UTF-8");
				//设置文件操作目录
				ftp.changeWorkingDirectory("/"+parentFile);  
				//先判断欲删除文件是否存在
				
				// 获取文件操作目录下所有文件名称
				String[] remoteNames = ftp.listNames();
				// 循环比对文件名称，判断是否含有当前要删除的文件名
				for (String remoteName: remoteNames) {
					if (fileName.equals(remoteName)) {
						result = true;
						break;
					}
				}
				// 文件名称比对成功时，进入删除流程
				if (result) {
					ftp.deleteFile(fileName);
				}
				// 登出服务器
				ftp.logout();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					// 判断连接是否存在
					if (ftp.isConnected()) {
						// 断开连接
						ftp.disconnect();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return result;
	 }

	/**********************************以下属于测试*********************************/
	/** 
     * FTP下载单个文件测试 
     */ 
	 public static void testDownload() { 
	        FTPClient ftpClient = new FTPClient(); 
	        FileOutputStream fos = null; 

	        try { 
	            ftpClient.connect("192.10.22.169"); 
	            ftpClient.login("Ces", "1596320"); 

	            String remoteFileName = "/201105/contractBasicInfo.txt"; 
	            File file = new File("d:/contractBasicInfo.txt"); 
	            fos = new FileOutputStream(file); 

	            ftpClient.setBufferSize(1024); 
	            //设置文件类型（二进制） 
	            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
	            ftpClient.retrieveFile(remoteFileName, fos); 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	            throw new RuntimeException("FTP客户端出错！", e); 
	        } 
	    } 
	 
    /**
	 * FTP上传单个文件测试
	 */
	public static void testUpload() {
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;

		try {
			ftpClient.connect("192.10.22.169");
			ftpClient.login("Ces", "1596320");

			File file = new File("d:/sql.java");
			fis = new FileInputStream(file);
			//new FileInputStream(new File("d:/contractBasicInfo.txt"));
			//设置上传目录
			ftpClient.changeWorkingDirectory("d:/sql.java");
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("GBK");
			//设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			//文件上传路径
			ftpClient.storeFile("/201106/sql.java", fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("FTP客户端出错！", e);
		} finally {
//	            IOUtils.closeQuietly(fis); 
//	            try { 
//	                ftpClient.disconnect(); 
//	            } catch (IOException e) { 
//	                e.printStackTrace(); 
//	                throw new RuntimeException("关闭FTP连接发生异常！", e); 
//	            } 
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
	}
//	 public static void main(String[] args) throws IOException { 
//	        testUpload(); 
//	        testDownload(); 
//	        System.out.println(retrieveFile("192.10.22.169", 21, "Ces", "1596320", "/201105", "1308732167015.pdf", "D:\\Help"));            //√
//	        System.out.println(storeFile("192.10.22.169", 21, "Ces", "1596320", "/201105", "contractBasicInfo.txt", new FileInputStream(new File("d:/contractBasicInfo.txt"))));
//	    } 
/**********************************以上属于测试*********************************/

}
