import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;

public class ParseXml{
	public static void main(String[] args){
		 getFileName();
	}
	public static String getFileName(){
		try
		{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=factory.newDocumentBuilder();
			InputStream in=Class.forName("ParseXml").getResourceAsStream("config.xml");
			Document document=db.parse(in);
			Element element=document.getDocumentElement();
			String fileName=element.getFirstChild().getNextSibling().getFirstChild().getNodeValue();
			return fileName;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	return "";
	}
}
