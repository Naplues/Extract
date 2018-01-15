package trans.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	// journal标签16
	public static JLabel publisherName = new JLabel(Label.publisherName);
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

	// 创建操作按钮
	public static JButton loadButton = new JButton("加载数据");
	public static JButton exportButton = new JButton("导出");

	private void placeComponents() {
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 设置窗体居中显示
		frame.add(Window.panel); // 添加面板
		panel.setLayout(new BorderLayout()); // 设置默认BorderLayout布局
		panel.add(operatePanel, BorderLayout.NORTH); // 操作面板
		panel.add(contentPanel, BorderLayout.CENTER); // 内容面板
		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		// 操作面板
		operatePanel.add(loadButton);
		operatePanel.add(exportButton);

		// 内容面板
		// 添加标签
		contentPanel.setLayout(new GridLayout(1, 4)); // 设置内容面板
		panel1.setLayout(new GridLayout(16, 1)); // 设置布局
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
		panel2.add(journalTitleText);
		panel2.add(PISSNText);
		panel2.add(EISSNText);
		panel2.add(volumeText);
		panel2.add(issueText);
		panel2.add(partNumberText);
		panel2.add(issueTopicText);
		panel2.add(issueLanguageText);
		panel2.add(seasonText);
		panel2.add(specialIssueText);
		panel2.add(supplementaryIssueText);
		panel2.add(issueOAText);
		panel2.add(pubDateYearText);
		panel2.add(pubDateMonthText);
		panel2.add(pubDateDayText);

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

		// 添加事件监听
		loadButton.addActionListener(this);

		frame.setVisible(true);// 设置界面可见
	}

	/**
	 * 动作实现
	 */
	public void actionPerformed(ActionEvent e) {
		// 加载数据事件
		if (e.getSource() == loadButton) {
			publisherNameText.setText("hello world");
		}
		else if(e.getSource()==exportButton) {
			
		}

	}
	public static void main(String[] args) {
		Window window = new Window();
		window.placeComponents();// 添加组件
	}

}
