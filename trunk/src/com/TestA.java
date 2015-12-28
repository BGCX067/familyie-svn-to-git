package com;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestA {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8080/test2/services/helloWorld2");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		PrintWriter pw = new PrintWriter(conn.getOutputStream());
		pw.println("content=xxx");
		pw.close();
	}
}
