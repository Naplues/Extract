package trans.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * XML模板: 1.固定  2.网页  3.舍弃 31(11, ,2)
 * 
 * 1 The Learned Press 杂志的出版商名称
 * 
 * 1 Macrolinguistics 杂志 的标题
 * 
 * 1 1934-5755 该杂志的印刷期刊号
 * 
 * 1 2473-6376 该杂志的电子期刊号
 * 
 * 1 Lingustic 议题
 * 
 * 1 EN,ZH 对该问题发表的文章的用语
 * 
 * 1 N 特殊议题
 * 
 * 1 N 补充议题
 * 
 * 1 Y issueOA议题开放
 * 
 * 1 researchArticle 文章类型
 * 
 * 1 Y articleOA文章开放
 * 
 * 2 2017-5 2016-4 2009-3 2008-2 2007-1 卷数
 * 
 * 2 期
 * 
 * 2 季度 （summer, autumn, spring, winter）
 * 
 * 2 出版时间
 * 
 * 2 文章标题
 * 
 * 2 副标题 看具体文章
 * 
 * 2 文章语言
 * 
 * 2 文章开始页码
 * 
 * 2 文章结束页码
 * 
 * 2 作者列表
 * 
 * 2 doi 文章标题的数字对象标识符
 * 
 * 2 摘要
 * 
 * 2 摘要语言 EN
 * 
 * 2 关键字
 * 
 * 2 摘要url
 * 
 * 2 PDF url
 * 
 * 2 全文语言EN,ZH
 * 
 * 2 参考文献
 * 
 * 3 零件号 partNumber
 * 
 * 3 全文
 * 
 * @author naplues
 *
 */
public class Template {
	// 杂志信息Journal
	private String publisherName;
	private String journalTitle;
	private String pISSN;
	private String eISSN;
	private String volumn;
	private String issue;
	private String partNumber;
	private String issueTopic;
	private String issueLanguage;
	private String season;
	private String specialIssue;
	private String supplementaryIssue;
	private String issueOA;
	private String pubDateYear;
	private String pubDateMonth;
	private String pubDateDay;
	// 文章信息
	private String articleType;
	private String articleTitle;
	private String subTitle;
	private String articleLanguage;
	private String articleOA;
	private String firstPage;
	private String lastPage;
	// 作者列表
	private List<Author> authorList; 
	// 文章信息
	private String doi;
	private String absTract;
	private String abstractLanguage;
	private String keyWords;
	private String fullText;
	// URL信息
	private String urlAbstract;
	private String urlPDF;
	private String fullTextLanguage;
	// 参考文献信息
	private List<References> referencesList;

	public Template() {
		super();
		this.publisherName = new String("The Learned Press");
		this.journalTitle = new String("Macrolinguistics");
		this.pISSN = new String("1934-5755");
		this.eISSN = new String("2473-6376");
		this.issueTopic = new String("Lingustics");
		this.issueLanguage = new String("EN,ZH");
		this.articleType = new String("Research Article");
		this.specialIssue = new String("N");
		this.supplementaryIssue = new String("N");
		this.issueOA = new String("Y");
		this.articleOA = new String("Y");

		this.volumn = new String();
		this.issue = new String();
		this.season = new String();
		this.pubDateYear = new String();
		this.pubDateMonth = new String();
		this.pubDateDay = new String();
		this.articleTitle = new String();
		this.subTitle = new String();
		this.articleLanguage = new String();
		this.firstPage = new String();
		this.lastPage = new String();
		this.authorList = new ArrayList<>();
		this.doi = new String();
		this.absTract = new String();
		this.abstractLanguage = new String();
		this.keyWords = new String();
		this.urlAbstract = new String();
		this.urlPDF = new String();
		this.fullTextLanguage = new String();
		this.referencesList = new ArrayList<>();
		
		this.fullText = new String();
		this.partNumber = new String();// ignore
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getJournalTitle() {
		return journalTitle;
	}

	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	public String getpISSN() {
		return pISSN;
	}

	public void setpISSN(String pISSN) {
		this.pISSN = pISSN;
	}

	public String geteISSN() {
		return eISSN;
	}

	public void seteISSN(String eISSN) {
		this.eISSN = eISSN;
	}

	public String getVolumn() {
		return volumn;
	}

	public void setVolumn(String volumn) {
		this.volumn = volumn;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getIssueTopic() {
		return issueTopic;
	}

	public void setIssueTopic(String issueTopic) {
		this.issueTopic = issueTopic;
	}

	public String getIssueLanguage() {
		return issueLanguage;
	}

	public void setIssueLanguage(String issueLanguage) {
		this.issueLanguage = issueLanguage;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSpecialIssue() {
		return specialIssue;
	}

	public void setSpecialIssue(String specialIssue) {
		this.specialIssue = specialIssue;
	}

	public String getSupplementaryIssue() {
		return supplementaryIssue;
	}

	public void setSupplementaryIssue(String supplementaryIssue) {
		this.supplementaryIssue = supplementaryIssue;
	}

	public String getIssueOA() {
		return issueOA;
	}

	public void setIssueOA(String issueOA) {
		this.issueOA = issueOA;
	}

	public String getPubDateYear() {
		return pubDateYear;
	}

	public void setPubDateYear(String pubDateYear) {
		this.pubDateYear = pubDateYear;
	}

	public String getPubDateMonth() {
		return pubDateMonth;
	}

	public void setPubDateMonth(String pubDateMonth) {
		this.pubDateMonth = pubDateMonth;
	}

	public String getPubDateDay() {
		return pubDateDay;
	}

	public void setPubDateDay(String pubDateDay) {
		this.pubDateDay = pubDateDay;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getArticleLanguage() {
		return articleLanguage;
	}

	public void setArticleLanguage(String articleLanguage) {
		this.articleLanguage = articleLanguage;
	}

	public String getArticleOA() {
		return articleOA;
	}

	public void setArticleOA(String articleOA) {
		this.articleOA = articleOA;
	}

	public String getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getAbsTract() {
		return absTract;
	}

	public void setAbsTract(String absTract) {
		this.absTract = absTract;
	}

	public String getAbstractLanguage() {
		return abstractLanguage;
	}

	public void setAbstractLanguage(String abstractLanguage) {
		this.abstractLanguage = abstractLanguage;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public String getUrlAbstract() {
		return urlAbstract;
	}

	public void setUrlAbstract(String urlAbstract) {
		this.urlAbstract = urlAbstract;
	}

	public String getUrlPDF() {
		return urlPDF;
	}

	public void setUrlPDF(String urlPDF) {
		this.urlPDF = urlPDF;
	}

	public String getFullTextLanguage() {
		return fullTextLanguage;
	}

	public void setFullTextLanguage(String fullTextLanguage) {
		this.fullTextLanguage = fullTextLanguage;
	}

	public List<References> getReferencesList() {
		return referencesList;
	}

	public void setReferencesList(List<References> referencesList) {
		this.referencesList = referencesList;
	}

}
