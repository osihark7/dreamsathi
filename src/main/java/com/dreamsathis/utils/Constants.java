package com.dreamsathis.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import org.springframework.web.multipart.MultipartFile;

public class Constants {

	// live 
	public static final String BASE_DIR = "/var/lib/tomcat8/webapps/";
	public static final String BASE_IP = "http://172.105.50.222:8080";
	public static final String BLOG_IMAGE = "blog_mage/";

	public static final String invalidData = "invalidData";
	public static final String requestSuccess = "requestSuccess";

	public static final String user_Info = "USER_INFO";
	public static final String loginSuccess = "You are loged in successfully !!";
	public static final String accountNotVerified = "Your account is not verified !!";
	// public static final String unathorized = "unathorized";

	public static final String permission = "Permission denied !!";
	public static final String dataGetSucceed = "Data fatch successfully !!";
	public static final String recordNotFound = "Record  not found !!";
	public static final String recordDelete = "Record delete successfully !!";
	public static final String addData = "Data add successfully !!";
	public static final String updateData = "Data update successfully !!";
	public static final String userSignUp = "You are Register succusessfully please verify your account and login !!";
	public static final String accountVerified = "Your account verified successfully!!";
	public static final String accountVerifiedAlready = "Your account is alredy verified !!";
	public static final String invalidCredentials = "Username and password are incorrect !!";
	public static final String loginStatus = "Please Login first !!";
	public static final String requiredField = "Required field are not empty !!";
	public static final String logOut = "You have successfully logged out... !!";
	public static final String unathorized = " Unable to login. Incorrect username and password. Please Enter Correct username and Password. ";

	public static String getRandomPassword() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!$_";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static String getDateAndTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		return String.valueOf(df.format(new Date()));
	}

	public static String genrateOTP() {
		Random rndm_method = new Random();
		int[] otp = rndm_method.ints(6, 0, 9).toArray();
		StringBuilder sb = new StringBuilder();
		sb.append(otp[0]);
		sb.append(otp[1]);
		sb.append(otp[2]);
		sb.append(otp[3]);
		sb.append(otp[4]);
		sb.append(otp[5]);
		return sb.toString();
	}

	public static String saveMultiPartFile(MultipartFile file, String path, String fileNameWithExtension) {
		if (file != null) {
			File dir = new File(path + File.separator);

			if ((!dir.exists()) && (dir.mkdirs())) {
				System.err.println(" Directory Created Successfully ");
			}
			dir = new File(path + File.separator + fileNameWithExtension);
			try {
				FileOutputStream fileOuputStream = new FileOutputStream(dir);
				Throwable localThrowable3 = null;
				try {
					fileOuputStream.write(file.getBytes());
					fileOuputStream.flush();
					fileOuputStream.close();
				} catch (Throwable localThrowable1) {
					localThrowable3 = localThrowable1;
					throw localThrowable1;
				} finally {
					if (fileOuputStream != null) {
						if (localThrowable3 != null) {
							try {
								fileOuputStream.close();
							} catch (Throwable localThrowable2) {
								localThrowable3.addSuppressed(localThrowable2);
							}
						} else {
							fileOuputStream.close();
						}
					}
				}
			} catch (Exception e) {
				System.err.println(" ::: EXCEPTION in save file ::: " + e.getMessage());
			}
		}
		return fileNameWithExtension;
	}

	public static final String DEFAULT_PAGE_NUMBER = "1";
	public static final String DEFAULT_PAGE_SIZE = "10";
	public static final String DEFAULT_SORT_BY = "id";
	public static final String DEFAULT_SORT_DIRECTION = "asc";

}
