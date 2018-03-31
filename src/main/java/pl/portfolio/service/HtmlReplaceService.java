package pl.portfolio.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HtmlReplaceService {
	
	private static final String PATTERN = "<(.*?)>";
	
	public String replaceHtml(String content){
		return StringUtils.replaceAll(content, PATTERN, " ");
	}
	
	public String abbreviate(String content, String text){
		log.info("content: " + content);
		log.info("content: " + content);
		log.info("searchText: " + text);
		log.info("length: " + content.length());
		int searchTextStart;
		String searchText = text;
		while((searchTextStart = StringUtils.indexOfIgnoreCase(content,searchText)) == -1 ){
			if(searchText.length() == 0)
				return StringUtils.join("... ", content, " ...");
			searchText = searchText.substring(0, searchText.length() -1);
			log.info("shorter searchText: " + searchText);
		}
		log.info("searchTextStart: " + searchTextStart);
		int searchTextEnd = searchTextStart + text.length();
		log.info("searchTextEnd: " + searchTextEnd);
		int shortcutStart = searchTextStart > 26 ? searchTextStart - 25 : 0;
		log.info("shortcutStart: " + shortcutStart);
		int firstSpace = shortcutStart == 0 ? 0 : StringUtils.lastIndexOf(StringUtils.left(content, shortcutStart), " ");
		log.info("firstSpace: " + firstSpace);
		int resultStart = firstSpace != -1 ? firstSpace : searchTextStart;
		log.info("resultStart: " + resultStart);
		int shortcutEnd = content.length() - searchTextEnd > 31 ? searchTextEnd + 30 : content.length();
		log.info("shortcutEnd: " + shortcutEnd);
		int lastSpace = shortcutEnd == content.length() ? content.length() :StringUtils.lastIndexOf(content,  " ", shortcutEnd);
		log.info("lastSpace: " + lastSpace);
		if(lastSpace < searchTextStart)
			lastSpace = content.length();
		int resultEnd = lastSpace != -1 ? lastSpace : searchTextEnd;
		log.info("resultEnd: " + resultEnd);
		
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
