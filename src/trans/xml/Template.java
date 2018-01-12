package trans.xml;

import java.util.List;

/**
 * xml模板
 * 
 * @author naplues
 *
 */
public class Template {
	// 杂志信息Journal
	private String publisherName; // 杂志的出版商名称
	private String journalTitle; // 杂志 的标题
	private String pISSN; // 该杂志的印刷期刊号
	private String eISSN; // 该杂志的电子期刊号
	private int volumn; // 卷数
	private String issue; // 版次
	private int partNumber; // 零件号
	private String issueTopic; // 议题
	private String issueLanguage; // 对该问题发表的文章的用语
	private String season; // 如果问题是季节性的（summer, autumn, spring, winter）
	private String specialIssue; // 特殊议题Y/N
	private String supplementaryIssue; // 补充议题Y/N
	private String issueOA; //
	private String pubDateYear; // 出版时间
	private String pubDateMonth;
	private String pubDateDay;

	// 文章信息
	private String articleType;
	private String articleTitle; // 文章标题
	private String subTitle; // 副标题
	private String articleLanguage; // 文章语言
	private String articleOA; //
	private int firstPage; // 文章开始页码
	private int lastPage; // 文章结束页码

	// 作者列表
	private List<Author> authorList; // 作者列表

	// 文章信息
	private String doi; // 文章标题的数字对象标识符
	private String absTract; // 摘要
	private String abstractLanguage; // 摘要语言
	private String keyWords; // 关键字
	private String fullText; // 全文

	// URL信息
	private String urlAbstract; // 摘要url
	private String urlPDF; // PDF url
	private String fullTextLanguage; // 全文语言

	// 参考文献信息
	private List<References> referencesList; // 参考文献

	public Template() {
		super();
	}

	public Template(String publisherName, String journalTitle, String pISSN, String eISSN, int volumn, String issue,
			int partNumber, String issueTopic, String issueLanguage, String season, String specialIssue,
			String supplementaryIssue, String issueOA, String pubDateYear, String pubDateMonth, String pubDateDay,
			String articleType, String articleTitle, String subTitle, String articleLanguage, String articleOA,
			int firstPage, int lastPage, List<Author> authorList, String doi, String absTract, String abstractLanguage,
			String keyWords, String fullText, String urlAbstract, String urlPDF, String fullTextLanguage,
			List<References> referencesList) {
		super();
		this.publisherName = publisherName;
		this.journalTitle = journalTitle;
		this.pISSN = pISSN;
		this.eISSN = eISSN;
		this.volumn = volumn;
		this.issue = issue;
		this.partNumber = partNumber;
		this.issueTopic = issueTopic;
		this.issueLanguage = issueLanguage;
		this.season = season;
		this.specialIssue = specialIssue;
		this.supplementaryIssue = supplementaryIssue;
		this.issueOA = issueOA;
		this.pubDateYear = pubDateYear;
		this.pubDateMonth = pubDateMonth;
		this.pubDateDay = pubDateDay;
		this.articleType = articleType;
		this.articleTitle = articleTitle;
		this.subTitle = subTitle;
		this.articleLanguage = articleLanguage;
		this.articleOA = articleOA;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.authorList = authorList;
		this.doi = doi;
		this.absTract = absTract;
		this.abstractLanguage = abstractLanguage;
		this.keyWords = keyWords;
		this.fullText = fullText;
		this.urlAbstract = urlAbstract;
		this.urlPDF = urlPDF;
		this.fullTextLanguage = fullTextLanguage;
		this.referencesList = referencesList;
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

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
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

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
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
