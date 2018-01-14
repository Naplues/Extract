package trans.xml;

/**
 * 参考文献中的作者信息
 * 
 * @author naplues
 *
 */
public class RefAuthor {
	private String referencesFirstName; // 前名
	private String referencesMiddleName; // 中名
	private String referencesLastName; // 后名
	private String referencesInitials; // 首字母缩略字3
	private String referencesAffiliation; //工作单位3
	private String referencesCountry; // 国家3

	public RefAuthor() {
		super();
		this.referencesFirstName = new String();
		this.referencesMiddleName = new String();
		this.referencesLastName = new String();
		this.referencesInitials = new String();
		this.referencesAffiliation = new String();
		this.referencesCountry = new String();
	}

	public String getReferencesFirstName() {
		return referencesFirstName;
	}

	public void setReferencesFirstName(String referencesFirstName) {
		this.referencesFirstName = referencesFirstName;
	}

	public String getReferencesMiddleName() {
		return referencesMiddleName;
	}

	public void setReferencesMiddleName(String referencesMiddleName) {
		this.referencesMiddleName = referencesMiddleName;
	}

	public String getReferencesLastName() {
		return referencesLastName;
	}

	public void setReferencesLastName(String referencesLastName) {
		this.referencesLastName = referencesLastName;
	}

	public String getReferencesInitials() {
		return referencesInitials;
	}

	public void setReferencesInitials(String referencesInitials) {
		this.referencesInitials = referencesInitials;
	}

	public String getReferencesAffiliation() {
		return referencesAffiliation;
	}

	public void setReferencesAffiliation(String referencesAffiliation) {
		this.referencesAffiliation = referencesAffiliation;
	}

	public String getReferencesCountry() {
		return referencesCountry;
	}

	public void setReferencesCountry(String referencesCountry) {
		this.referencesCountry = referencesCountry;
	}
}
