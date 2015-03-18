package com.sapient.xml102.pojo;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Address {

	private String houseNumber;
	private String street;
	private String city;
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Address(String houseNumber, String street, String city) {
		super();
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
	}
	
	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "(houseNumber=" + houseNumber + ", street=" + street
				+ ", city=" + city + ")";
	}
	
	public void read(Element mainNode) {
		NodeList childNodes = mainNode.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.getNodeName().equals("HouseNumber")) {
					setHouseNumber(child.getTextContent());
				} else if (child.getNodeName().equals("Street")) {
					setStreet(child.getTextContent());
				} else if (child.getNodeName().equals("City")) {
					setCity(child.getTextContent());
				}
			}
		}
	}
	
}
