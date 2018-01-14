package trans.parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import trans.xml.Author;
import trans.xml.Template;

/**
 * 
 * @author gzq
 *
 */
public class HTMLParser {

	/*
	 * 爬取网页信息
	 */
	public static String pickData(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 打印响应状态
				if (entity != null) {
					return EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * 使用jsoup解析网页信息
	 */
	public static void analyzeHTMLByString(Template template, String url, String html) {
		//
		Document document = Jsoup.parse(html);
		// Journal OK
		template.setVolumn(getVolume(document.getElementsByAttribute("colspan").get(1).text().split(" ")[1].split("_")[1]));
		template.setIssue(document.getElementsByAttribute("colspan").get(1).text().split(" ")[1].split("_")[0]);
		String[] pubDate = document.getElementsByAttribute("colspan").get(3).text().split("-");
		template.setPubDateYear(pubDate[0]);
		template.setPubDateMonth(pubDate[1]);
		template.setPubDateDay(pubDate[2]);
		template.setSeason(getSeason(pubDate[1]));

		// Article OK--
		String[] title = document.getElementsByClass("title").text().split("——");
		template.setArticleTitle(title[0]);
		if (title.length == 2)
			template.setSubTitle(title[1]);
		template.setArticleLanguage("EN,ZH");
		String[] page = document.getElementsByAttribute("colspan").get(2).text().split("-");
		template.setFirstPage(page[0]);
		template.setLastPage(page[1]);

		// AuthorList
		String[] authors = document.getElementsByAttribute("width").text().split(";");
		String[] affilis = document.getElementsByAttribute("colspan").get(0).text().split(";");
		List<Author> authorList = new ArrayList<>();
		for (int i = 0; i < authors.length; i++) {
			for (int j = 0; j < authors[i].length(); j++) {
				if (authors[i].startsWith(" ")) {
					authors[i] = authors[i].substring(1);
				}
			}
			Author tempAuthor = new Author();
			String[] names = authors[i].split(" ");

			tempAuthor.setFirstName(names[0]);
			if (names.length > 2) {
				String mName = "";
				for (int j = 1; j < names.length - 1; j++)
					mName += names[j];
				tempAuthor.setMiddleName(mName);
			}
			tempAuthor.setLastName(names[names.length - 1]);
			tempAuthor.setAuthorLanguage("");
			if (affilis.length > 1)
				tempAuthor.setAffiliation(affilis[i]);
			else
				tempAuthor.setAffiliation(affilis[0]);
			tempAuthor.setCountry("");
			tempAuthor.setAuthorEmails("");

			authorList.add(tempAuthor);
		}
		template.setAuthorList(authorList);

		// DOI OK--
		template.setAbsTract(document.getElementsByTag("span").get(0).text());
		template.setKeyWords(document.getElementsByAttribute("colspan").get(5).text());
		template.setDoi(document.getElementsByAttribute("colspan").get(6).text());
		template.setAbstractLanguage("EN");

		// URL OK--
		template.setUrlAbstract(url);
		template.setUrlPDF("http://www.macrolinguistics.com/" + document.getElementsByTag("a").get(15).attr("href"));
		template.setFullTextLanguage("EN");
		
		// References
		 System.out.println(document.getElementsByAttribute("colspan").get(7));
		

	}

	public static String getSeason(String month) {
		int m = Integer.parseInt(month);
		if (m >= 3 && m <= 5)
			return "spring";
		if (m >= 6 && m <= 8)
			return "summer";
		if (m >= 9 && m <= 11)
			return "autumn";
		return "winter";
	}

	public static String getVolume(String year) {
		if (year.equals("2007"))
			return "1";
		if (year.equals("2008"))
			return "2";
		if (year.equals("2009"))
			return "3";
		if (year.equals("2016"))
			return "4";
		if (year.equals("2017"))
			return "5";
		return "";
	}

}
