package trans.xml;

/**
 * 文章作者信息
 * 
 * @author naplues
 *
 */
public class Author {
	private String firstName; // 前名
	private String middleName; // 中名
	private String lastName; // 后名
	private String initials; // 首字母
	private String authorLanguage; // 作者所属国家的语言
	private String affiliation; // 作者附属
	private String country; // 作者 国家
	private String phone; // 电话号
	private String fax; // 传真号
	private String authorEmails; // 作者邮箱

	public Author() {
		super();
		this.firstName = new String();
		this.middleName = new String();
		this.lastName = new String();
		this.initials = new String();
		this.authorLanguage = new String();
		this.affiliation = new String();
		this.country = new String();
		this.phone = new String();
		this.fax = new String();
		this.authorEmails = new String();
	}

	public Author(String firstName, String middleName, String lastName, String initials, String authorLanguage,
			String affiliation, String country, String phone, String fax, String authorEmails) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.initials = initials;
		this.authorLanguage = authorLanguage;
		this.affiliation = affiliation;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
		this.authorEmails = authorEmails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getAuthorLanguage() {
		return authorLanguage;
	}

	public void setAuthorLanguage(String authorLanguage) {
		this.authorLanguage = authorLanguage;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAuthorEmails() {
		return authorEmails;
	}

	public void setAuthorEmails(String authorEmails) {
		this.authorEmails = authorEmails;
	}
}
