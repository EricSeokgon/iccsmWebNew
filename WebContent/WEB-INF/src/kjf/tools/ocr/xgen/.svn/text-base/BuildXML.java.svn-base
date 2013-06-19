/**
 * 
 */
package kjf.tools.ocr.xgen;



import java.io.File;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Sewon
 *
 */
public class BuildXML {
	
	public Document makeBuildXML(String rootDir, String fileName, String buildXMLFile){
		
		Document doc= new DocumentImpl();
		try{
	        NodeList xslts = this.backupXSLTs(buildXMLFile);
	        Element root = this.makeRootTag(doc);
	        this.makeTargetInit(doc, root, rootDir);
	        this.makeTargetCodegen(doc, root, fileName, xslts);
	        this.makeTargetCompile(doc, root);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return doc;
	}
	
	
	private Element makeRootTag(Document doc){
		Element element = doc.createElement("project");		
		doc.appendChild(element);
	
		Attr attr = doc.createAttribute("default");
		attr.setValue("compile");
		element.setAttributeNode(attr);
		
        return element;
	}
	
	private void makeTargetInit(Document doc, Element root, String rootDir){
		Element target = doc.createElement("target");
        root.appendChild(target);		
        Attr attr = doc.createAttribute("name");
		attr.setValue("init");
		target.setAttributeNode(attr);
        
        Element element = doc.createElement("tstamp");
        target.appendChild(element);		

        element = doc.createElement("echo");
        target.appendChild(element);
        attr = doc.createAttribute("message");
		attr.setValue("------------------- DAO generator start!! ----------------");
		element.setAttributeNode(attr);
		
		element = doc.createElement("property");
		target.appendChild(element);
		attr = doc.createAttribute("name");
		attr.setValue("root.dir");
		element.setAttributeNode(attr);		
		attr = doc.createAttribute("value");
		//attr.setValue("../../../../");
		attr.setValue(rootDir);
		element.setAttributeNode(attr);		

		
		element = doc.createElement("property");
		target.appendChild(element);
		attr = doc.createAttribute("name");
		attr.setValue("xsl.dir");
		element.setAttributeNode(attr);		
		attr = doc.createAttribute("value");
		attr.setValue("${root.dir}src/kjf/tools/ocr/xsl/");
		element.setAttributeNode(attr);		

		element = doc.createElement("property");
		target.appendChild(element);
		attr = doc.createAttribute("name");
		attr.setValue("gen.dir");
		element.setAttributeNode(attr);		
		attr = doc.createAttribute("value");
		attr.setValue("${root.dir}src/sp/dao/");
		element.setAttributeNode(attr);		

		element = doc.createElement("property");
		target.appendChild(element);
		attr = doc.createAttribute("name");
		attr.setValue("xml.dir");
		element.setAttributeNode(attr);		
		attr = doc.createAttribute("value");
		attr.setValue("${root.dir}src/sp/dao/xml/");
		element.setAttributeNode(attr);		

		element = doc.createElement("property");
		target.appendChild(element);
		attr = doc.createAttribute("name");
		attr.setValue("sql.dir");
		element.setAttributeNode(attr);		
		attr = doc.createAttribute("value");
		attr.setValue("${root.dir}src/sp/dao/sql/");
		element.setAttributeNode(attr);		

		element = doc.createElement("property");
		target.appendChild(element);		
		attr = doc.createAttribute("name");
		attr.setValue("classes.dest");
		element.setAttributeNode(attr);		
		attr = doc.createAttribute("value");
		attr.setValue("${root.dir}classes");
		element.setAttributeNode(attr);		
		
		
		element = doc.createElement("taskdef");
		target.appendChild(element);
		attr = doc.createAttribute("name");
		attr.setValue("xslt");
		element.setAttributeNode(attr);		
		attr = doc.createAttribute("classname");
		attr.setValue("kjf.tools.ocr.Xslt");
		element.setAttributeNode(attr);		

	}
	
	
	private void makeTargetCodegen(Document doc, Element root, String fileName, NodeList xslts){
		Element target = doc.createElement("target");
        root.appendChild(target);		
        Attr attr = doc.createAttribute("name");
		attr.setValue("codegen");
		target.setAttributeNode(attr);
		attr = doc.createAttribute("depends");
		attr.setValue("init");
		target.setAttributeNode(attr);
        
        Element element = doc.createElement("echo");
        target.appendChild(element);		
        attr = doc.createAttribute("message");
		attr.setValue("DAO, entity, Helper generate");
		element.setAttributeNode(attr);
		
		// 기존 xslt 적용
		this.applyBackupXSLTs(doc, target, xslts);
		
		// 현재 Table의 XSLT 적용
		Node newNode = this.makeXSLTTag(fileName, doc);
		
		// 중복 체크
		boolean duplicate = this.checkDuplicate(doc, target, newNode, doc.getElementsByTagName("xslt"));
		if( ! duplicate){
			target.appendChild(newNode);
		}
		
	}
	
	private boolean checkDuplicate(Document doc, Element target, Node newNode, NodeList xslts){
		boolean duplicate = false;
		Node tmpNode = null;
		for(int i=0; i < xslts.getLength(); i++){
			tmpNode = xslts.item(i);
			if(tmpNode.getAttributes().getNamedItem("infile").getNodeValue().equals(newNode.getAttributes().getNamedItem("infile").getNodeValue())){
				target.removeChild(tmpNode);
				target.appendChild(newNode);
				duplicate = true;
				break;
			}			
		}
		return duplicate;
	}
	
	private void makeTargetCompile(Document doc, Element root){
		Element target = doc.createElement("target");
        root.appendChild(target);		
        Attr attr = doc.createAttribute("name");
		attr.setValue("compile");
		target.setAttributeNode(attr);
		attr = doc.createAttribute("depends");
		attr.setValue("init, codegen");
		target.setAttributeNode(attr);
        
        Element element = doc.createElement("echo");
        target.appendChild(element);		
        attr = doc.createAttribute("message");
		attr.setValue("Compiling the sources ");
		element.setAttributeNode(attr);
		
        element = doc.createElement("javac");
        target.appendChild(element);		
        attr = doc.createAttribute("srcdir");
		attr.setValue("${gen.dir}");
		element.setAttributeNode(attr);		
        attr = doc.createAttribute("destdir");
		attr.setValue("${classes.dest}");
		element.setAttributeNode(attr);		
        attr = doc.createAttribute("debug");
		attr.setValue("${debug}");
		element.setAttributeNode(attr);		
        attr = doc.createAttribute("deprecation");
		attr.setValue("${deprecation}");
		element.setAttributeNode(attr);		
        attr = doc.createAttribute("optimize");
		attr.setValue("${optimize}");
		element.setAttributeNode(attr);		
				
	}	
	
	private void applyBackupXSLTs(Document doc, Element target, NodeList xslts){
		
		String fileName = null;
		if(xslts != null){
			for(int i = 0; i < xslts.getLength(); i++){
				fileName = xslts.item(i).getAttributes().getNamedItem("infile").getNodeValue();
				fileName = fileName.substring(fileName.indexOf("}")+1, fileName.length());
				target.appendChild( makeXSLTTag(fileName , doc));
			}
		}
	}
		
	private Node makeXSLTTag(String fileName, Document doc){
    	File file = new File(fileName);
    	Element xsltNode = doc.createElement("xslt");
    	
    	Attr attr = doc.createAttribute("infile");
    	attr.setValue("${xml.dir}"+file.getName());
    	xsltNode.setAttributeNode(attr);    	
    	attr = doc.createAttribute("xsltfile");
    	attr.setValue("${xsl.dir}");
    	xsltNode.setAttributeNode(attr);    	
    	attr = doc.createAttribute("dependent");
    	attr.setValue("${xml.dir}"+file.getName());
    	xsltNode.setAttributeNode(attr);    	
    	attr = doc.createAttribute("outfile");
    	attr.setValue("${gen.dir}"+file.getName().substring(0, file.getName().length()-4));
    	xsltNode.setAttributeNode(attr);    	
    	attr = doc.createAttribute("sqlfile");
    	attr.setValue("${sql.dir}"+file.getName().substring(0, file.getName().length()-4));
    	xsltNode.setAttributeNode(attr);    	
    	attr = doc.createAttribute("smart");
    	attr.setValue("yes");
    	xsltNode.setAttributeNode(attr);    	
    	return xsltNode;
    }
	
	
	private NodeList backupXSLTs(String buildXMLFile){
		File xmlFile = new File(buildXMLFile);
		NodeList backupNodeList = null;
		
		if(xmlFile.exists()){
			//DOMParser parser2 = new DOMParser();
			Document doc = null;
			try {
				
				DOMParser parser = new DOMParser();

				parser.parse(convertToUri(buildXMLFile));
				doc = parser.getDocument();
				backupNodeList = doc.getElementsByTagName("xslt");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return backupNodeList;
	}

	private String convertToUri(String fileName){
		String uri = "file:///"+fileName;
		return uri;
	}
}
