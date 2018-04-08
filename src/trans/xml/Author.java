package trans.xml;

/**
 * 文章作者信息10(,6,4)
 * 
 * 2 firstName
 * 
 * 2 lastName
 * 
 * 2 作者所属国家语言ZH/EN
 * 
 * 2 工作单位
 * 
 * 2 国家
 * 
 * 2 邮箱
 * 
 * 3 middleName||首字母||电话||传真
 * 
 * @author naplues
 *
 */
public class Author {
	private String firstName;
	private String middleName;
	private String lastName;
	private String initials;
	private String authorLanguage;
	private String affiliation;
	private String country;
	private String phone;
	private String fax;
	private String authorEmails;

	public Author() {
		super();
		this.firstName = new String();
		this.lastName = new String();
		this.authorLanguage = new String();
		this.affiliation = new String();
		this.country = new String();
		this.authorEmails = new String();

		this.middleName = new String();
		this.initials = new String();
		this.phone = new String();
		this.fax = new String();
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
