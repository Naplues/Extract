package trans.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLHandler {
	/**
	 * 打印XML内容
	 */
	public static void printXML() {
		SAXReader reader = new SAXReader();
		Document document;
		try {

			document = (Document) reader.read(new File("test.xml"));
			Element root = document.getRootElement();
			listNodes(root);

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	public static void listNodes(Element node) {
		System.out.println("当前结点的名称：" + node.getName());
		// 获取当前结点的所有属性结点
		List<Attribute> list = node.attributes();
		// 遍历属性结点
		for (Attribute attribute : list) {
			System.out.println("属性： " + attribute.getName() + ": " + attribute.getValue());
		}
		// 如果当前结点内容不为空,则输出
		if (!node.getTextTrim().equals("")) {
			System.out.println(node.getName() + ": " + node.getText());
		}
		// 迭代当前结点下面的子结点,递归调用
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			listNodes(iterator.next());
		}
	}

	/**
	 * 导出XML文件
	 * 
	 * @param filePath
	 */
	public static void exportXML(String filePath) {
		// 创建文档及设置根元素节点的方式
		Element root = DocumentHelper.createElement("Person");
		Document document = DocumentHelper.createDocument(root);
		// 给根节点添加属性
		//root.addAttribute("School", "南大").addAttribute("Location", "江西");

		// 给根节点添加孩子节点
		Element element1 = root.addElement("Student");
		element1.addElement("Name").addAttribute("Marrige", "单身").addText("小章");
		element1.addElement("Age").addText("21");
		
		//连加5个属性
		for(int i=0;i<5;i++) {
			Element element2 = root.addElement("Student");
			element2.addElement("Name").addAttribute("Marrige", "单身").addText("小红").addElement("爱好").addText("唱歌");
			element2.addElement("age").addText("22");
		}

		// 写入文件
		try {
			OutputFormat format = new OutputFormat("    ", true); // 把生成的xml文档存放在硬盘上 true代表是否换行
			format.setEncoding("UTF-8");// 设置编码格式
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(filePath), format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
