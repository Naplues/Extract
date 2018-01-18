package trans.parse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import trans.xml.Author;
import trans.xml.RefAuthor;
import trans.xml.References;
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
				HttpEntity entity = response.getEntity(); // 获取响应实体
				if (entity != null)
					return EntityUtils.toString(entity); // 打印响应状态
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
	public static Template analyzeHTMLByString(String url, String html) {
		boolean isChina = false;
		Template template = new Template();
		//
		Document document = Jsoup.parse(html);
		// Journal OK
		String[] VI = document.getElementsByAttribute("colspan").get(1).text().split(" ")[1].split("_");
		template.setVolumn(getVolume(VI[1]));
		template.setIssue(VI[0]);
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
			// 每个作者
			authors[i] = authors[i].trim();// 去掉首尾的空格
			Author tempAuthor = new Author();
			String[] names = authors[i].split(" ");
			// 多个工作单位
			if (affilis.length > 1)
				tempAuthor.setAffiliation(affilis[i]);
			else
				tempAuthor.setAffiliation(affilis[0]);

			String[] tempA = tempAuthor.getAffiliation().split(",");
			// 中文姓名
			if (tempA[tempA.length - 1].trim().equals("China")
					|| tempA[tempA.length - 1].trim().equals("Nanjing University")
					|| tempA[tempA.length - 1].trim().equals("Hangzhou Dianzi University")
					|| tempA[tempA.length - 1].trim().equals("China")) {
				tempAuthor.setFirstName(names[names.length - 1]); // First Name
				tempAuthor.setLastName(names[0]); // Last Name
				tempAuthor.setCountry("China");
				isChina = true;
			} else {
				// 外文姓名
				tempAuthor.setFirstName(names[0]); // First Name
				tempAuthor.setLastName(names[names.length - 1]); // Last Name
				tempAuthor.setCountry(tempA[tempA.length - 1].trim()); // 其他国家名称
			}

			tempAuthor.setAuthorLanguage("");
			tempAuthor.setAuthorEmails("");
			// tempAuthor.setAuthorEmails("http://www.macrolinguistics.com/" +
			// document.getElementsByTag("a").get(15).attr("href"));
			// 文章地址
			authorList.add(tempAuthor);
		}
		template.setAuthorList(authorList);

		// DOI OK--
		template.setAbsTract(document.getElementsByTag("span").get(0).text());
		template.setKeyWords(document.getElementsByAttribute("colspan").get(5).text());
		template.setDoi(document.getElementsByAttribute("colspan").get(6).text());
		template.setAbstractLanguage(getLanguage(document.getElementsByTag("span").get(0).text()));

		// URL OK--
		template.setUrlAbstract(url);
		template.setUrlPDF("http://www.macrolinguistics.com/" + document.getElementsByTag("a").get(15).attr("href"));
		template.setFullTextLanguage("EN");

		// References

		String[] refs = document.getElementsByAttribute("colspan").get(7).select("span").html()
				.split("<br>|</br>|&nbsp;");
		List<String> origin = new ArrayList<>();
		for (int i = 0; i < refs.length; i++) {
			if (refs[i].endsWith("\n")) {
				origin.add(refs[i].replace("\n", ""));
				if (i != refs.length - 1) // 非最后一句
					origin.add("");
			} else if (!refs[i].trim().equals("")) {
				origin.add(refs[i]);
			}
		}

		template.setReferencesList(parseReferences(origin, isChina));
		return template;
	}

	/**
	 * 获取参考文献信息,处理换行
	 * 
	 * @return
	 */
	public static List<References> parseReferences(List<String> origins, boolean isChina) {

		List<String> lines = new ArrayList<>();
		int len = 0;
		boolean lastEmpty = false;
		for (String s : origins) {
			if (s.equals("")) {
				lastEmpty = true;
				continue;
			}
			// 上一行是空，说明该行是上一文献的一部分
			if (lastEmpty) {
				lines.set(len - 1, lines.get(len - 1) + s);
				lastEmpty = false;
				continue;
			}
			lines.add(s);
			len++;
		}

		List<References> referencesList = new ArrayList<>();
		for (String line : lines) {
			// 分离参考文献的组成部分". ", "[A]"
			String[] temp = line.split("\\. |\\[A\\]\\.|\\[C\\]\\.|\\[D\\]\\.|\\[J\\]\\.|\\[M\\]\\.|\\[M\\],");
			// 参考文献 文献名[2]
			References references = new References();
			// 文献作者
			List<RefAuthor> refAuthorsList = new ArrayList<>();
			String[] tempAuthor = temp[0].split("&");

			for (String authorString : tempAuthor) {
				for (int j = 0; j < authorString.length(); j++) {
					if (authorString.startsWith(" ")) {
						authorString = authorString.substring(1);
					}
				}
				RefAuthor refAuthor = new RefAuthor();
				String[] names = authorString.split(" ");// 分开前后中名

				if (isChina) {
					refAuthor.setReferencesFirstName(names[names.length - 1]);
					refAuthor.setReferencesLastName(names[0]);
				} else {
					refAuthor.setReferencesFirstName(names[0]);
					refAuthor.setReferencesLastName(names[names.length - 1]);
				}

				refAuthorsList.add(refAuthor);
			}
			if (temp.length > 2)
				references.setReferencesarticleTitle(temp[2]); // 设置文献标题

			String page = findString(temp[temp.length - 1]);
			// 设置页码
			if (!page.equals("")) {
				String[] tempPage = page.split("-");
				references.setReferencesFirstPage(tempPage[0]);
				references.setReferencesLastPage(tempPage[1]);
			}

			references.setRefAuthorList(refAuthorsList); // 设置作者列表
			referencesList.add(references);
		}
		return referencesList;
	}

	/**
	 * 获取季度
	 * 
	 * @param month
	 * @return
	 */
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

	/**
	 * 获取卷号
	 * 
	 * @param year
	 * @return
	 */
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

	public static String getLanguage(String sentence) {
		for (int i = 0; i < sentence.length(); i++) {
			if (isChinese(sentence.charAt(i)))
				return "EN,ZH";
		}
		return "EN";
	}

	/**
	 * 判断是否含有中文
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @author gzq
	 * @date Sep 11, 2015 11:45:31 AM
	 * @param fileUrl
	 *            远程地址
	 * @param fileLocal
	 *            本地路径
	 * @throws Exception
	 */
	public static void downloadFile(String fileUrl, String fileLocal) {
		try {

			URL url = new URL(fileUrl);
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setConnectTimeout(100000);
			urlCon.setReadTimeout(100000);
			int code = urlCon.getResponseCode();
			if (code != HttpURLConnection.HTTP_OK) {
				throw new Exception("文件读取失败");
			}
			// 读文件流
			DataInputStream in = new DataInputStream(urlCon.getInputStream());
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fileLocal));
			byte[] buffer = new byte[2048];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 匹配页码
	 * 
	 * @param str
	 * @return
	 */
	public static String findString(String str) {
		str = str.replace(" ", "");// 去掉空格
		Pattern p = Pattern.compile("[0-9]*[1-9][0-9]*-[0-9]*[1-9][0-9]*"); // 使用正则表达式匹配
		Matcher m = p.matcher(str);
		while (m.find()) {
			return m.group();
		}
		return "";
	}
}
