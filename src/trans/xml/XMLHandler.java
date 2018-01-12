package trans.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XMLHandler {
	/**
	 * 打印XML内容
	 */
	public static void printXML() {
		SAXReader reader=new SAXReader();
		Document document;
		try {
			
			document = (Document) reader.read(new File("test.xml"));		
			Element root=document.getRootElement();
			listNodes(root);
	
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void listNodes(Element node) {
		System.out.println("当前结点的名称：" + node.getName());
		//获取当前结点的所有属性结点
		List<Attribute> list=node.attributes();
		//遍历属性结点
		for (Attribute attribute:list) {
			System.out.println("属性： " + attribute.getName() + ": " + attribute.getValue());
		}
		//如果当前结点内容不为空,则输出
		if(!node.getTextTrim().equals("")) {
			System.out.println(node.getName() + ": " + node.getText());
		}
		//迭代当前结点下面的子结点,递归调用
		Iterator<Element> iterator = node.elementIterator();
		while(iterator.hasNext()) {
			listNodes(iterator.next());
		}
	}
}
