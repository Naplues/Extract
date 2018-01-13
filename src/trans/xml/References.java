package trans.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考文献信息
 * 
 * @author naplues
 *
 */
public class References {
	// 参考文献信息
	private String referencesarticleTitle; // 引用文章标题
	private String referencesFirstPage; // 引用文章起始页
	private String referencesLastPage; // 引用文章结束页
	private List<RefAuthor> refAuthorList; // 引用文章作者列表

	public References() {
		super();
		this.referencesarticleTitle = new String();
		this.referencesFirstPage = new String();
		this.referencesLastPage = new String();
		this.refAuthorList = new ArrayList<RefAuthor>();
	}

	public References(String referencesarticleTitle, String referencesFirstPage, String referencesLastPage,
			List<RefAuthor> refAuthorList) {
		super();
		this.referencesarticleTitle = referencesarticleTitle;
		this.referencesFirstPage = referencesFirstPage;
		this.referencesLastPage = referencesLastPage;
		this.refAuthorList = refAuthorList;
	}

	public String getReferencesarticleTitle() {
		return referencesarticleTitle;
	}

	public void setReferencesarticleTitle(String referencesarticleTitle) {
		this.referencesarticleTitle = referencesarticleTitle;
	}

	public String getReferencesFirstPage() {
		return referencesFirstPage;
	}

	public void setReferencesFirstPage(String referencesFirstPage) {
		this.referencesFirstPage = referencesFirstPage;
	}

	public String getReferencesLastPage() {
		return referencesLastPage;
	}

	public void setReferencesLastPage(String referencesLastPage) {
		this.referencesLastPage = referencesLastPage;
	}

	public List<RefAuthor> getRefAuthorList() {
		return refAuthorList;
	}

	public void setRefAuthorList(List<RefAuthor> refAuthorList) {
		this.refAuthorList = refAuthorList;
	}
}
