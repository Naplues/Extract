package trans.xml;

/**
 * 参考文献中的作者信息6(,2,4)
 *
 * 2 firstName
 * 
 * 2 lastName
 * 
 * 3 middleName||首字母||工作单位||国家
 * 
 * @author naplues
 *
 */
public class RefAuthor {
	private String referencesFirstName;
	private String referencesMiddleName;
	private String referencesLastName;
	private String referencesInitials;
	private String referencesAffiliation;
	private String referencesCountry;

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
