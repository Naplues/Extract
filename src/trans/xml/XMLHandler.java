package trans.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLHandler {

	/**
	 * 根据模板生成dom4j文档
	 * 
	 * @param template
	 * @param filePath
	 */
	public static void generateXML(Template template, String filePath) {
		Element root = DocumentHelper.createElement("ArticleSet");
		// 文章集子元素
		Element article = root.addElement("Article");
		// 文章子元素
		Element journal = article.addElement("Journal");

		article.addElement("ArticleType").addText(template.getArticleType());
		article.addElement("ArticleTitle").addText(template.getArticleTitle());
		article.addElement("SubTitle").addText(template.getSubTitle());
		article.addElement("ArticleLanguage").addText(template.getArticleLanguage());
		article.addElement("ArticleOA").addText(template.getArticleOA());
		article.addElement("FirstPage").addText(template.getFirstPage());
		article.addElement("LastPage").addText(template.getLastPage());

		Element authorList = article.addElement("AuthorList").addText("");

		article.addElement("DOI").addText(template.getDoi());
		article.addElement("Abstract").addText(template.getAbsTract());
		article.addElement("AbstractLanguage").addText(template.getAbstractLanguage());
		article.addElement("Keywords").addText(template.getKeyWords());
		article.addElement("Fulltext").addText(template.getFullText());

		Element urls = article.addElement("URLs");

		article.addElement("FulltextLanguage").addText(template.getFullTextLanguage());

		Element references = article.addElement("ref-list").addText("");

		// journal子标签
		journal.addElement("PublisherName").addText(template.getPublisherName());
		journal.addElement("JournalTitle").addText(template.getJournalTitle());
		journal.addElement("PISSN").addText(template.getpISSN());
		journal.addElement("EISSN").addText(template.geteISSN());
		journal.addElement("Volume").addText(template.getVolumn());
		journal.addElement("Issue").addText(template.getIssue());
		journal.addElement("PartNumber").addText(template.getPartNumber());
		journal.addElement("IssueTopic").addText(template.getIssueTopic());
		journal.addElement("IssueLanguage").addText(template.getIssueLanguage());
		journal.addElement("Season").addText(template.getSeason());
		journal.addElement("SpecialIssue").addText(template.getSpecialIssue());
		journal.addElement("SupplementaryIssue").addText(template.getSupplementaryIssue());
		journal.addElement("IssueOA").addText(template.getIssueOA());
		Element pubDate = journal.addElement("PubDate");
		pubDate.addElement("Year").addText(template.getPubDateYear());
		pubDate.addElement("Month").addText(template.getPubDateMonth());
		pubDate.addElement("Day").addText(template.getPubDateDay());

		// authorList 子标签
		List<Author> authorTemplateList = template.getAuthorList();
		for (Author authorTemplate : authorTemplateList) {
			Element author = authorList.addElement("Author");
			author.addElement("FirstName").addText(authorTemplate.getFirstName());
			author.addElement("MiddleName").addText(authorTemplate.getMiddleName());
			author.addElement("LastName").addText(authorTemplate.getLastName());
			author.addElement("Initials").addText(authorTemplate.getInitials());
			author.addElement("AuthorLanguage").addText(authorTemplate.getAuthorLanguage());
			author.addElement("Affiliation").addText(authorTemplate.getAffiliation());
			author.addElement("Country").addText(authorTemplate.getCountry());
			author.addElement("Phone").addText(authorTemplate.getPhone());
			author.addElement("Fax").addText(authorTemplate.getFax());
			author.addElement("AuthorEmails").addText(authorTemplate.getAuthorEmails());
		}

		// URL 子标签
		urls.addElement("abstract").addText(template.getUrlAbstract());
		urls.addElement("Fulltext").addElement("pdf").addText(template.getUrlPDF());

		// 参考文献子标签
		references.addElement("title").addText("References");

		int refIndex = 1;
		List<References> referencesTemplateList = template.getReferencesList();
		for (References referencesTemplate : referencesTemplateList) {
			Element refBody = references.addElement("Citation").addAttribute("ID", "CR" + refIndex);
			refBody.addElement("CitationNumber").addText(refIndex + "");
			refIndex++;
			Element refAuthorList = refBody.addElement("BibArticle").addText("");
			List<RefAuthor> refAuthorListTemplate = referencesTemplate.getRefAuthorList();

			for (RefAuthor refAuthorTemplate : refAuthorListTemplate) {
				Element refAuthor = refAuthorList.addElement("BibAuthorName");
				refAuthor.addElement("Initials").addText(refAuthorTemplate.getReferencesFirstName());
				refAuthor.addElement("FamilyName").addText(refAuthorTemplate.getReferencesLastName());
			}
			refAuthorList.addElement("Year").addText(referencesTemplate.getYear());
			refAuthorList.addElement("ArticleTitle").addText(referencesTemplate.getReferencesarticleTitle())
					.addAttribute("Language", "En");
			refAuthorList.addElement("JournalTitle").addText("");
			refAuthorList.addElement("VolumeID").addText("");
			refAuthorList.addElement("FirstPage").addText(referencesTemplate.getReferencesFirstPage());
			refAuthorList.addElement("LastPage").addText(referencesTemplate.getReferencesLastPage());
			refAuthorList.addElement("Occurrence").addAttribute("Type", "DOI").addElement("Handle").addText("");

			refBody.addElement("BibUnstructured").addText(referencesTemplate.getContent());
		}

		// 写入文件
		try {
			Document document = DocumentHelper.createDocument(root);
			OutputFormat format = new OutputFormat("    ", true); // 把生成的XML文档存放在硬盘上 true代表是否换行
			format.setEncoding("UTF-8");// 设置编码格式
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(filePath), format);
			xmlWriter.write(document);
			xmlWriter.close();
			System.out.println(".......................generate success!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
