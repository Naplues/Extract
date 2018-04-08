package trans.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考文献信息4(,4,)
 * 
 * 2 引用文章标题
 * 
 * 2 引用文章起始页
 * 
 * 2 引用文章结束页
 * 
 * 2 引用作者列表
 * 
 * @author naplues
 *
 */
public class References {
	// 参考文献信息
	private String referencesarticleTitle;
	private String referencesFirstPage; 
	private String referencesLastPage;
	private List<RefAuthor> refAuthorList;

	public References() {
		super();
		this.referencesarticleTitle = new String();
		this.referencesFirstPage = new String();
		this.referencesLastPage = new String();
		this.refAuthorList = new ArrayList<>();
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
