package cn.dfun.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class App {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.jianshu.com/u/0ec5817e53a4").get();
        Element body = doc.body();
        System.out.println("body: " + body);
	}
}
