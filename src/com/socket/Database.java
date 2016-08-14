package com.socket;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Database {

	public String filePath;

	public Database(String filePath) {
		this.filePath = filePath;
	}

	public boolean userExists(String username) {
		// System.out.println("achi1hth");

		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// System.out.println("hfjhf");
			Document doc = dBuilder.parse(fXmlFile);
			// System.out.println("fdg");
			doc.getDocumentElement().normalize();
			// System.out.println("achi");
			NodeList nList = doc.getElementsByTagName("user");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (getTagValue("username", eElement).equals(username)) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception ex) {
			System.out.println("Database exception : userExists()");
			ex.printStackTrace();
			return false;
		}
	}

	public boolean checkLogin(String username, String password, String type) {

		if (!userExists(username)) {
			return false;
		}

		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("user");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (getTagValue("username", eElement).equals(username)
							&& getTagValue("password", eElement).equals(
									password)
							&& getTagValue("type", eElement).equals(type)) {
						return true;
					}
				}
			}
			System.out.println("Hippie");
			return false;
		} catch (Exception ex) {
			System.out.println("Database exception : userExists()");
			return false;
		}
	}

	public boolean checkLogin(String username, String password) {

		if (!userExists(username)) {
			return false;
		}

		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("user");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (getTagValue("username", eElement).equals(username)) {
						return true;
					}
				}
			}
			System.out.println("Hippie");
			return false;
		} catch (Exception ex) {
			System.out.println("Database exception : userExists()");
			return false;
		}
	}

	public void addUser(String username, String password) {

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filePath);

			Node data = doc.getFirstChild();

			Element newuser = doc.createElement("user");
			Element newusername = doc.createElement("username");
			newusername.setTextContent(username);
			Element newpassword = doc.createElement("password");
			newpassword.setTextContent(password);

			newuser.appendChild(newusername);
			newuser.appendChild(newpassword);
			data.appendChild(newuser);

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);

		} catch (Exception ex) {
			System.out.println("Exceptionmodify xml");
		}
	}

	public void addUser(String username, String pw, String type,
			String levelTerm, String pos, String mobile, String mail,
			String stNo, String addr, String Id) {

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filePath);

			Node data = doc.getFirstChild();

			Element newuser = doc.createElement("user");

			Element newusername = doc.createElement("username");
			newusername.setTextContent(username);
			Element newpassword = doc.createElement("password");
			newpassword.setTextContent(pw);
			Element newtype = doc.createElement("type");
			newtype.setTextContent(type);
			Element newlt = doc.createElement("lt");
			newlt.setTextContent(levelTerm);
			Element newpos = doc.createElement("position");
			newpos.setTextContent(pos);
			Element newcontact = doc.createElement("contact");
			newcontact.setTextContent(mobile);
			Element newemail = doc.createElement("email");
			newemail.setTextContent(mail);
			Element newstno = doc.createElement("studentNo");
			newstno.setTextContent(stNo);
			Element newaddr = doc.createElement("address");
			newaddr.setTextContent(addr);
			Element newid = doc.createElement("userID");
			newid.setTextContent(Id);

			newuser.appendChild(newusername);
			newuser.appendChild(newpassword);
			newuser.appendChild(newtype);
			newuser.appendChild(newlt);
			newuser.appendChild(newpos);
			newuser.appendChild(newcontact);
			newuser.appendChild(newemail);
			newuser.appendChild(newstno);
			newuser.appendChild(newaddr);
			newuser.appendChild(newid);

			data.appendChild(newuser);

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);

		} catch (Exception ex) {
			System.out.println("Exceptionmodify xml");
		}
	}

	public static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}
