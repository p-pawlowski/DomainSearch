package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;

public class DomainMapUtil {

	public static Map<String, MutableInt> createDomainMap(List<Element> links) {
		Map<String, MutableInt> domainMap = new HashMap<>();
		Pattern pattern = Pattern.compile(
				"/{2}(www\\.)?(((([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])|([a-zA-Z0-9]))\\.)+([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]))");
		for (Element link : links) {
			Matcher matcher = pattern.matcher(link.attr("href"));
			if (matcher.find()) {
				String domainName = matcher.group(2);
				putDomainName(domainMap, domainName);
			}
		}
		return domainMap;
	}

	private static void putDomainName(Map<String, MutableInt> domainMap, String domainName) {
		MutableInt count = domainMap.get(domainName);
		if (count == null) {
			domainMap.put(domainName, new MutableInt());
		} else {
			count.increment();
		}
	}

	public static void printMap(Map<String, MutableInt> domainMap) {
		System.out.println("\nFound domains:\n");
		for (Map.Entry<String, MutableInt> entry : domainMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
