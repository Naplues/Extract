package trans.gui;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import trans.parse.HTMLParser;
import trans.xml.Template;
import trans.xml.XMLHandler;

public class Window implements ActionListener {
	// 创建 JFrame 实例
	public JFrame frame = new JFrame("文章数据提取程序");

	public static JPanel panel = new JPanel();
	public static JPanel leftPanel = new JPanel();
	public static JPanel bottomPanel = new JPanel();
	public static JPanel operatePanel = new JPanel(); // 操作面板
	public static JPanel contentPanel = new JPanel(); // 内容面板
	public static JPanel panel1 = new JPanel(); // 1
	public static JPanel panel2 = new JPanel(); // 2
	public static JPanel panel3 = new JPanel(); // 3
	public static JPanel panel4 = new JPanel(); // 4

	// url输入框
	public static JTextField input = new JTextField(20);

	// journal标签16
	public static JLabel publisherName = new JLabel(Label.publisherName, JLabel.RIGHT);
	public static JLabel journalTitle = new JLabel(Label.journalTitle);
	public static JLabel PISSN = new JLabel(Label.PISSN);
	public static JLabel EISSN = new JLabel(Label.EISSN);
	public static JLabel volume = new JLabel(Label.volume);
	public static JLabel issue = new JLabel(Label.isssue);
	public static JLabel partNumber = new JLabel(Label.partNumber);
	public static JLabel issueTopic = new JLabel(Label.issueTopic);
	public static JLabel issueLanguage = new JLabel(Label.issueLanguage);
	public static JLabel season = new JLabel(Label.season);
	public static JLabel specialIssue = new JLabel(Label.specialIssue);
	public static JLabel supplementaryIssue = new JLabel(Label.supplementaryIssue);
	public static JLabel issueOA = new JLabel(Label.issueOA);
	public static JLabel pubDateYear = new JLabel(Label.pubDateYear);
	public static JLabel pubDateMonth = new JLabel(Label.pubDateMonth);
	public static JLabel pubDateDay = new JLabel(Label.pubDateDay);

	// journal输入框
	public static JTextField publisherNameText = new JTextField(15);
	public static JTextField journalTitleText = new JTextField(15);
	public static JTextField PISSNText = new JTextField(15);
	public static JTextField EISSNText = new JTextField(15);
	public static JTextField volumeText = new JTextField(15);
	public static JTextField issueText = new JTextField(15);
	public static JTextField partNumberText = new JTextField(15);
	public static JTextField issueTopicText = new JTextField(15);
	public static JTextField issueLanguageText = new JTextField(15);
	public static JTextField seasonText = new JTextField(15);
	public static JTextField specialIssueText = new JTextField(15);
	public static JTextField supplementaryIssueText = new JTextField(15);
	public static JTextField issueOAText = new JTextField(15);
	public static JTextField pubDateYearText = new JTextField(15);
	public static JTextField pubDateMonthText = new JTextField(15);
	public static JTextField pubDateDayText = new JTextField(15);

	// article 标签
	public static JLabel articleType = new JLabel("ArticleType");
	public static JLabel articleTitle = new JLabel("ArticleTitle");
	public static JLabel subtitle = new JLabel("SubTitle");
	public static JLabel articleLanguage = new JLabel("ArticleLanguage");
	public static JLabel articleOA = new JLabel("ArticleOA");
	public static JLabel firstPage = new JLabel("FirstPage");
	public static JLabel lastPage = new JLabel("LastPage");
	public static JLabel doi = new JLabel("DOI");
	public static JLabel absTract = new JLabel("Abstract");
	public static JLabel abstractLanguage = new JLabel("AbstractLanguage");
	public static JLabel keyWords = new JLabel("Keywords");
	public static JLabel fullText = new JLabel("Fulltext");
	public static JLabel abstractUrl = new JLabel("Urls abstract");
	public static JLabel pdfUrl = new JLabel("Urls pdf");
	public static JLabel fulltextLanguage = new JLabel("FulltextLanguage");

	// article 输入框
	public static JTextField articleTypeText = new JTextField(15);
	public static JTextField articleTitleText = new JTextField(15);
	public static JTextField subtitleText = new JTextField(15);
	public static JTextField articleLanguageText = new JTextField(15);
	public static JTextField articleOAText = new JTextField(15);
	public static JTextField firstPageText = new JTextField(15);
	public static JTextField lastPageText = new JTextField(15);
	public static JTextField doiText = new JTextField(15);
	public static JTextField abstractText = new JTextField(15);
	public static JTextField abstractLanguageText = new JTextField(15);
	public static JTextField keyWordsText = new JTextField(15);
	public static JTextField fullTextText = new JTextField(15);
	public static JTextField abstractUrlText = new JTextField(15);
	public static JTextField pdfUrlText = new JTextField(15);
	public static JTextField fulltextLanguageText = new JTextField(15);

	// 创建操作按钮
	public static JButton loadButton = new JButton("加载数据");
	public static JButton exportButton = new JButton("保存并导出");

	public Template template = new Template();

	public Window() {
		placeComponents(); // 摆放组件
	}

	public void placeComponents() {
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 设置窗体居中显示
		frame.add(Window.panel); // 添加面板
		panel.setLayout(new BorderLayout()); // 设置默认BorderLayout布局
		panel.add(operatePanel, BorderLayout.NORTH); // 操作面板
		panel.add(contentPanel, BorderLayout.CENTER); // 内容面板
		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		// 操作面板
		operatePanel.add(input);
		operatePanel.add(loadButton);
		operatePanel.add(exportButton);

		// 内容面板
		// 添加标签
		contentPanel.setLayout(new GridLayout(1, 4)); // 设置内容面板
		panel1.setLayout(new GridLayout(16, 1)); // 设置布局
		// panel1.setBorder(BorderFactory.createTitledBorder("Journal"));
		panel2.setLayout(new GridLayout(16, 1)); // 设置布局
		panel3.setLayout(new GridLayout(15, 1));
		panel4.setLayout(new GridLayout(15, 1));
		contentPanel.add(panel1);
		contentPanel.add(panel2);
		contentPanel.add(panel3);
		contentPanel.add(panel4);

		panel1.add(publisherName);
		panel1.add(journalTitle);
		panel1.add(PISSN);
		panel1.add(EISSN);
		panel1.add(volume);
		panel1.add(issue);
		panel1.add(partNumber);
		panel1.add(issueTopic);
		panel1.add(issueLanguage);
		panel1.add(season);
		panel1.add(specialIssue);
		panel1.add(supplementaryIssue);
		panel1.add(issueOA);
		panel1.add(pubDateYear);
		panel1.add(pubDateMonth);
		panel1.add(pubDateDay);

		// 创建文本域用于用户输入
		panel2.add(publisherNameText);
		publisherNameText.setEditable(false);
		panel2.add(journalTitleText);
		journalTitleText.setEditable(false);
		panel2.add(PISSNText);
		PISSNText.setEditable(false);
		panel2.add(EISSNText);
		EISSNText.setEditable(false);
		panel2.add(volumeText);
		volumeText.setEditable(false);
		panel2.add(issueText);
		issueText.setEditable(false);
		panel2.add(partNumberText);
		panel2.add(issueTopicText);
		issueTopicText.setEditable(false);
		panel2.add(issueLanguageText);
		panel2.add(seasonText);
		panel2.add(specialIssueText);
		specialIssueText.setEditable(false);
		panel2.add(supplementaryIssueText);
		supplementaryIssueText.setEditable(false);
		panel2.add(issueOAText);
		issueOAText.setEditable(false);
		panel2.add(pubDateYearText);
		pubDateYearText.setEditable(false);
		panel2.add(pubDateMonthText);
		pubDateMonthText.setEditable(false);
		panel2.add(pubDateDayText);
		pubDateDayText.setEditable(false);

		// 添加文章标签
		panel3.add(articleType);
		panel3.add(articleTitle);
		panel3.add(subtitle);
		panel3.add(articleLanguage);
		panel3.add(articleOA);
		panel3.add(firstPage);
		panel3.add(lastPage);
		panel3.add(doi);
		panel3.add(absTract);
		panel3.add(abstractLanguage);
		panel3.add(keyWords);
		panel3.add(fullText);
		panel3.add(abstractUrl);
		panel3.add(pdfUrl);
		panel3.add(fulltextLanguage);

		// 添加 文章内容
		panel4.add(articleTypeText);
		articleTypeText.setEditable(false);
		panel4.add(articleTitleText);
		articleTitleText.setEditable(false);
		panel4.add(subtitleText);
		subtitleText.setEditable(false);
		panel4.add(articleLanguageText);
		panel4.add(articleOAText);
		articleOAText.setEditable(false);
		panel4.add(firstPageText);
		firstPageText.setEditable(false);
		panel4.add(lastPageText);
		lastPageText.setEditable(false);
		panel4.add(doiText);
		doiText.setEditable(false);
		panel4.add(abstractText);
		abstractText.setEditable(false);
		panel4.add(abstractLanguageText);
		panel4.add(keyWordsText);
		keyWordsText.setEditable(false);
		panel4.add(fullTextText);
		panel4.add(abstractUrlText);
		abstractUrlText.setEditable(false);
		panel4.add(pdfUrlText);
		pdfUrlText.setEditable(false);
		panel4.add(fulltextLanguageText);
		
		
		// 添加事件监听
		loadButton.addActionListener(this);
		exportButton.addActionListener(this);
		frame.setVisible(true);// 设置界面可见
	}

	/**
	 * 读取模板
	 * 
	 * @param template
	 */
	public static void readTemplate(Template template) {
		publisherNameText.setText(template.getPublisherName());
		journalTitleText.setText(template.getJournalTitle());
		PISSNText.setText(template.getpISSN());
		EISSNText.setText(template.geteISSN());
		volumeText.setText(template.getVolumn());
		issueText.setText(template.getIssue());
		partNumberText.setText(template.getPartNumber());
		issueTopicText.setText(template.getIssueTopic());
		issueLanguageText.setText(template.getIssueLanguage());
		seasonText.setText(template.getSeason());
		specialIssueText.setText(template.getSpecialIssue());
		supplementaryIssueText.setText(template.getSupplementaryIssue());
		issueOAText.setText(template.getIssueOA());
		pubDateYearText.setText(template.getPubDateYear());
		pubDateMonthText.setText(template.getPubDateMonth());
		pubDateDayText.setText(template.getPubDateDay());

		articleTypeText.setText(template.getArticleType());
		articleTitleText.setText(template.getArticleTitle());
		subtitleText.setText(template.getSubTitle());
		articleLanguageText.setText(template.getArticleLanguage());
		articleOAText.setText(template.getArticleOA());
		firstPageText.setText(template.getFirstPage());
		lastPageText.setText(template.getLastPage());
		doiText.setText(template.getDoi());
		abstractText.setText(template.getAbsTract());
		abstractLanguageText.setText(template.getAbstractLanguage());
		keyWordsText.setText(template.getKeyWords());
		fullTextText.setText(template.getFullText());
		abstractUrlText.setText(template.getUrlAbstract());
		pdfUrlText.setText(template.getUrlPDF());
		fulltextLanguageText.setText(template.getFullTextLanguage());

	}

	/**
	 * 写入模板
	 * 
	 * @return
	 */
	public static void writeTemplate(Template template) {

	}

	/**
	 * 判断是否为整数
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 动作实现
	 */
	public void actionPerformed(ActionEvent e) {
		// 加载数据事件
		if (e.getSource() == loadButton) {

			if (input.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入文章URL编号!", "提示!", JOptionPane.INFORMATION_MESSAGE);
			} else if (!isNumeric(input.getText().trim())) {
				JOptionPane.showMessageDialog(null, "请输入数字编号!", "提示!", JOptionPane.INFORMATION_MESSAGE);
				input.setText("");
				input.requestFocus();
			} else {
				try {
					String url = "http://www.macrolinguistics.com/index.php?c=msg&id=" + input.getText() + "&";
					String html = HTMLParser.pickData(url);
					template = HTMLParser.analyzeHTMLByString(url, html);
					readTemplate(template); // 读取模板内容并显示
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "请输入正确的URL编号!", "错误!", JOptionPane.ERROR_MESSAGE);
					input.setText("");
					input.requestFocus();
				}

			}
			// 导出数据事件
		} else if (e.getSource() == exportButton) {
			// 根据模板生成XML文档
			XMLHandler.generateXML(template, input.getText() + ".xml");
			JOptionPane.showMessageDialog(null, "成功导出XML!", "成功!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
