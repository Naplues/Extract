package trans.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * xml模板
 * 
 * @author naplues
 *
 */
public class Template {
	// 杂志信息Journal
	// 1.固定 2.网页 3.舍弃
	private String publisherName; // 杂志的出版商名称 1 The Learned Press
	private String journalTitle; // 杂志 的标题 1 Macrolinguistics
	private String pISSN; // 该杂志的印刷期刊号 1 1934-5755
	private String eISSN; // 该杂志的电子期刊号 1 2473-6376
	private String volumn; // 卷数2 2017-5 2016-4 2009-3 2008-2 2007-1
	private String issue; // 期 2
	private String partNumber; // 零件号3
	private String issueTopic; // 议题1 Lingustic
	private String issueLanguage; // 对该问题发表的文章的用语 1. EN,ZH
	private String season; // 如果问题是季节性的（summer, autumn, spring, winter）春秋根据月份
	private String specialIssue; // 特殊议题N
	private String supplementaryIssue; // 补充议题N
	private String issueOA; // 开放Y
	private String pubDateYear; // 出版时间 2
	private String pubDateMonth; // 2
	private String pubDateDay; // 2

	// 文章信息
	private String articleType; // researchArticle 1
	private String articleTitle; // 文章标题 2
	private String subTitle; // 副标题 看具体文章2
	private String articleLanguage; // 文章语言
	private String articleOA; // Y
	private String firstPage; // 文章开始页码 2
	private String lastPage; // 文章结束页码 2

	// 作者列表
	private List<Author> authorList; // 作者列表

	// 文章信息
	private String doi; // 文章标题的数字对象标识符 2
	private String absTract; // 摘要 2
	private String abstractLanguage; // 摘要语言 EN
	private String keyWords; // 关键字 2
	private String fullText; // 全文3

	// URL信息
	private String urlAbstract; // 摘要url
	private String urlPDF; // PDF url
	private String fullTextLanguage; // 全文语言EN,ZH

	// 参考文献信息
	private List<References> referencesList; // 参考文献

	public Template() {
		super();
		this.publisherName = new String();
		this.journalTitle = new String();
		this.pISSN = new String();
		this.eISSN = new String();
		this.volumn = new String();
		this.issue = new String();
		this.partNumber = new String();
		this.issueTopic = new String();
		this.issueLanguage = new String();
		this.season = new String();
		this.specialIssue = new String();
		this.supplementaryIssue = new String();
		this.issueOA = new String();
		this.pubDateYear = new String();
		this.pubDateMonth = new String();
		this.pubDateDay = new String();
		this.articleType = new String();
		this.articleTitle = new String();
		this.subTitle = new String();
		this.articleLanguage = new String();
		this.articleOA = new String();
		this.firstPage = new String();
		this.lastPage = new String();
		this.authorList = new ArrayList<>();
		this.doi = new String();
		this.absTract = new String();
		this.abstractLanguage = new String();
		this.keyWords = new String();
		this.fullText = new String();
		this.urlAbstract = new String();
		this.urlPDF = new String();
		this.fullTextLanguage = new String();
		this.referencesList = new ArrayList<>();
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
