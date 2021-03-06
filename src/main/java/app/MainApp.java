package app;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import utils.DomainMapUtil;
import utils.MutableInt;

public class MainApp {

	public static void main(String[] args) {

		try {
			String url = scanInput();
			Document doc = Jsoup.connect(url).get();
			List<Element> links = doc.select("a");
			Map<String, MutableInt> domainMap = DomainMapUtil.createDomainMap(links);
			DomainMapUtil.printMap(domainMap);
		} catch (IOException e) {
			System.out.println("Bad url or connection error");
		} catch (IllegalArgumentException e){
			System.out.println("Bad url");
		}

	}

	public static String scanInput() {
		System.out.println("Enter url:");
		String result = "";
		try (Scanner scan = new Scanner(System.in);) {
			result = scan.nextLine();
		}
		return result;
	}

}
