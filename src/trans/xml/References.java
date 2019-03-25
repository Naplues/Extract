package trans.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考文献信息4(,4,)
 * <p>
 * 2 引用文章标题
 * <p>
 * 2 引用文章起始页
 * <p>
 * 2 引用文章结束页
 * <p>
 * 2 引用作者列表
 *
 * @author naplues
 */
public class References {
    // 参考文献信息
    private String year;
    private String referencesarticleTitle;
    private String referencesFirstPage;
    private String referencesLastPage;
    private List<RefAuthor> refAuthorList;
    private String content;

    private String type; //book journal
    private String publisherName;
    private String publisherLocation;

    private String volume;
    private String journalName;

    public References() {
        super();
        this.referencesarticleTitle = new String();
        this.referencesFirstPage = new String();
        this.referencesLastPage = new String();
        this.refAuthorList = new ArrayList<>();
        this.content = new String();
        this.publisherName = new String();
        this.publisherLocation = new String();
        this.volume=new String();
        this.journalName=new String();
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherLocation() {
        return publisherLocation;
    }

    public void setPublisherLocation(String publisherLocation) {
        this.publisherLocation = publisherLocation;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }
}
