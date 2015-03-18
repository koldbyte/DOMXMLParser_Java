package com.sapient.xml102.pojo;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PersonalDetails {
	private String name;
	private ArrayList<Long> contactNumbers = new ArrayList<Long>();
	private Address currentAddress;
	private Address permanentAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Long> getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(ArrayList<Long> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}
	
	public void addContactNumber(Long number){
		this.contactNumbers.add(number);
	}
	
	public void addContactNumber(String number){
		Long l = new Long(number);
		addContactNumber(l);
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public PersonalDetails(String name, ArrayList<Long> contactNumbers,
			Address currentAddress, Address permanentAddress) {
		super();
		this.name = name;
		this.contactNumbers = contactNumbers;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
	}

	public PersonalDetails() {
		super();
	}

	@Override
	public String toString() {
		return "{\nname = " + name + 
				"\ncontactNumbers = " + contactNumbers + 
				"\ncurrentAddress = " + currentAddress
				+ "\npermanentAddress = " + permanentAddress + 
				"\n}";
	}

	public void read(Element mainNode) {
		NodeList childNodes = mainNode.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.getNodeName().equals("Name")) {
					setName(child.getTextContent());
				} else if (child.getNodeName().equals("ContactNumber")) {
					if(child.getTextContent() != null){
						addContactNumber(child.getTextContent());
					}
				} else if (child.getNodeName().equals("CurrentAddress")) {
					Address address = new Address();
					address.read(child);
					setCurrentAddress(address);
				} else if (child.getNodeName().equals("PermanentAddress")) {
					Address address = new Address();
					address.read(child);
					setPermanentAddress(address);
				}
			}
		}
	}
}
