package pl.portfolio.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class HtmlReplaceService {
	private static final String PATTERN = "<(.*?)>";
	
	public String replaceHtml(String content){
		return StringUtils.replaceAll(content, PATTERN, " ");
	}
	
	public String abbreviate(String content, String text){
		System.out.println("content: " + content);
		System.out.println("searchText: " + text);
		System.out.println("length: " + content.length());
		int searchTextStart;
		String searchText = text;
		while((searchTextStart = StringUtils.indexOfIgnoreCase(content,searchText)) == -1 ){
			if(searchText.length() == 0)
				return StringUtils.join("... ", content, " ...");
			searchText = searchText.substring(0, searchText.length() -1);
			System.out.println("shorter searchText: " + searchText);
		}
		System.out.println("searchTextStart: " + searchTextStart);
		int searchTextEnd = searchTextStart + text.length();
		System.out.println("searchTextEnd: " + searchTextEnd);
		int shortcutStart = searchTextStart > 26 ? searchTextStart - 25 : 0;
		System.out.println("shortcutStart: " + shortcutStart);
		int firstSpace = shortcutStart == 0 ? 0 : StringUtils.lastIndexOf(StringUtils.left(content, shortcutStart), " ");
		System.out.println("firstSpace: " + firstSpace);
		int resultStart = firstSpace != -1 ? firstSpace : searchTextStart;
		System.out.println("resultStart: " + resultStart);
		int shortcutEnd = content.length() - searchTextEnd > 31 ? searchTextEnd + 30 : content.length();
		System.out.println("shortcutEnd: " + shortcutEnd);
		int lastSpace = shortcutEnd == content.length() ? content.length() :StringUtils.lastIndexOf(content,  " ", shortcutEnd);
		System.out.println("lastSpace: " + lastSpace);
		if(lastSpace < searchTextStart)
			lastSpace = content.length();
		int resultEnd = lastSpace != -1 ? lastSpace : searchTextEnd;
		System.out.println("resultEnd: " + resultEnd);
		
		return StringUtils.join(
				"... ",
				content.substring(resultStart, searchTextStart),
				"<strong>",
				content.substring(searchTextStart, searchTextEnd),
				"</strong>",
				content.substring(searchTextEnd, resultEnd),
				" ...");
	}
}
