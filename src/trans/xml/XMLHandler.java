package trans.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLHandler {
	/**
	 * 打印XML内容
	 */
	public static void printXML(String filePath) {
		try {
			SAXReader reader = new SAXReader();
			Document document = (Document) reader.read(new File(filePath));
			Element root = document.getRootElement();
			listNodes(root); //展示结点

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	public static void listNodes(Element node) {
		System.out.println("当前结点的名称：" + node.getName());
		// 获取当前结点的所有属性结点
		List<Attribute> list = node.attributes();
		// 遍历属性结点
		for (Attribute attribute : list) {
			System.out.println("属性： " + attribute.getName() + ": " + attribute.getValue());
		}
		// 如果当前结点内容不为空,则输出
		if (!node.getTextTrim().equals("")) {
			System.out.println(node.getName() + ": " + node.getText());
		}
		// 迭代当前结点下面的子结点,递归调用
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			listNodes(iterator.next());
		}
	}

	/**
	 * 根据模板生成dom4j文档
	 * 
	 * @param template
	 * @return
	 */
	public static void generateXML(Template template, String filePath) {
		Element root = DocumentHelper.createElement("ArticleSet");
		// 文章集子元素
		Element article = root.addElement("Article");
		// 文章子元素
		Element journal = article.addElement("Journal");

		article.addElement("ArticleType").addText("");
		article.addElement("ArticleTitle").addText("");
		article.addElement("SubTitle").addText("");
		article.addElement("ArticleLanguage").addText("");
		article.addElement("ArticleOA").addText("");
		article.addElement("FirstPage").addText("");
		article.addElement("LastPage").addText("");

		Element authorList = article.addElement("AuthorList");

		article.addElement("DOI").addText("");
		article.addElement("Abstract").addText("");
		article.addElement("AbstractLanguage").addText("");
		article.addElement("Keywords").addText("");
		article.addElement("Fulltext").addText("");

		Element urls = article.addElement("URLs");

		article.addElement("FulltextLanguage").addText("");

		Element references = article.addElement("References");

		// journal子标签
		journal.addElement("PublisherName").addText("");
		journal.addElement("JournalTitle").addText("");
		journal.addElement("PISSN").addText("");
		journal.addElement("EISSN").addText("");
		journal.addElement("Volume").addText("");
		journal.addElement("Issue").addText("");
		journal.addElement("PartNumber").addText("");
		journal.addElement("IssueTopic").addText("");
		journal.addElement("IssueLanguage").addText("");
		journal.addElement("Season").addText("");
		journal.addElement("SpecialIssue").addText("");
		journal.addElement("SupplementaryIssue").addText("");
		journal.addElement("IssueOA").addText("");
		Element pubDate = journal.addElement("PubDate");
		pubDate.addElement("Year").addText("");
		pubDate.addElement("Month").addText("");
		pubDate.addElement("Day").addText("");

		// authorList 子标签
		for (int i = 0; i < 1; i++) {
			Element author = authorList.addElement("Author");
			author.addElement("FirstName").addText("");
			author.addElement("MiddleName").addText("");
			author.addElement("LastName").addText("");
			author.addElement("Initials").addText("");
			author.addElement("AuthorLanguage").addText("");
			author.addElement("Affiliation").addText("");
			author.addElement("Country").addText("");
			author.addElement("Phone").addText("");
			author.addElement("Fax").addText("");
			author.addElement("AuthorEmails").addText("");
		}

		// URL 子标签
		urls.addElement("abstract").addText("");
		urls.addElement("Fulltext").addText("").addElement("pdf").addText("");

		// 参考文献子标签
		for (int i = 0; i < 1; i++) {
			references.addElement("ReferencesarticleTitle").addText("");
			references.addElement("ReferencesfirstPage").addText("");
			references.addElement("ReferenceslastPage").addText("");
			Element refAuthorList = references.addElement("authorList");
			for (int j = 0; j < 1; j++) {
				Element refAuthor = refAuthorList.addElement("author");
				refAuthor.addElement("ReferencesfirstName").addText("");
				refAuthor.addElement("ReferencesmiddleName").addText("");
				refAuthor.addElement("ReferenceslastName").addText("");
				refAuthor.addElement("ReferencesInitials").addText("");
				refAuthor.addElement("Referencesaffiliation").addText("");
				refAuthor.addElement("Referencescountry").addText("");
			}
		}

		// 写入文件
		try {
			Document document = DocumentHelper.createDocument(root);
			OutputFormat format = new OutputFormat("    ", true); // 把生成的xml文档存放在硬盘上 true代表是否换行
			format.setEncoding("UTF-8");// 设置编码格式
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(filePath), format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
