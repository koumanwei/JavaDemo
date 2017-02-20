package com.koumanwei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {
	public static void main(String[] args) {
		// copy("/Users/koumanwei/eclipse", "/Users/koumanwei/nihao/");
		// System.out.println("复制成功");
		// varParam();
		// varParam("id", "ver");

		// uploadImage("/Users/koumanwei/Desktop/nihao.png",
		// "http://192.168.1.208/img.php");
		getStrLength();
	}

	private static void copy(String src, String des) {
		File file1 = new File(src);
		File[] fs = file1.listFiles();
		File file2 = new File(des);
		if (!file2.exists()) {
			file2.mkdirs();
		}
		for (File f : fs) {
			if (f.isFile()) {
				// 调用文件拷贝的方法
				fileCopy(f.getPath(), des + "\\" + f.getName());
			} else if (f.isDirectory()) {
				copy(f.getPath(), des + "\\" + f.getName());
			}
		}
	}

	/**
	 * 文件拷贝的方法
	 */
	private static void fileCopy(String src, String des) {
		BufferedReader br = null;
		PrintStream ps = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
			ps = new PrintStream(new FileOutputStream(des));
			String s;
			while ((s = br.readLine()) != null) {
				ps.println(s);
				ps.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br != null)
					br.close();
				if (ps != null)
					ps.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void varParam(String... param) {
		for (int i = 0; i < param.length; i++) {
			String str = param[i];
			if ("id".equals(str)) {
				System.out.println(str);
			} else if ("ver".equals(str)) {
				System.out.println(str);
			}

		}
	}

	private static void uploadImage(String imagePath, String url) {
		File file = new File(imagePath);
		MultipartBody.Builder builder = new MultipartBody.Builder();
		builder.setType(MultipartBody.FORM);
		builder.addFormDataPart("image", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
		// for (int i = 0; i < fileList.size(); i++) {
		// builder.addPart(RequestBody.create(MediaType.parse("image/png"),
		// fileList.get(i))).build();
		// builder.addFormDataPart("file" + i, "koumanwei" + i,
		// RequestBody.create(MEDIA_TYPE_PNG, fileList.get(i)))
		// .build();
		// }
		MultipartBody body = builder.build();

		// 创建okHttpClient对象
		OkHttpClient mOkHttpClient = new OkHttpClient();
		// 创建一个Request
		Request request = new Request.Builder().url(url).post(body).build();
		// new call
		Call call = mOkHttpClient.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println("shibai" + e.getMessage());
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				boolean successful = response.isSuccessful();
				if (successful) {
					System.out.println("chenggong");
					System.out.println(response.body().string());
				} else {
				}
			}
		});
	}

	private static void getStrLength() {
		String str = "";
		System.out.println(str.length());
	}
}
