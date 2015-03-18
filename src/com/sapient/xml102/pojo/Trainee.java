package com.sapient.xml102.pojo;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Trainee {

	private PersonalDetails personalDetails;

	private TrainingDetails trainingDetails;

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public TrainingDetails getTrainingDetails() {
		return trainingDetails;
	}

	public void setTrainingDetails(TrainingDetails trainingDetails) {
		this.trainingDetails = trainingDetails;
	}

	public Trainee(PersonalDetails personalDetails,
			TrainingDetails trainingDetails) {
		super();
		this.personalDetails = personalDetails;
		this.trainingDetails = trainingDetails;
	}

	public Trainee() {
		super();
	}

	@Override
	public String toString() {
		return "Trainee [\npersonalDetails = " + personalDetails
				+ "\n\ntrainingDetails = " + trainingDetails + 
				"\n]";
	}

	public void read(String url) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = documentBuilder.parse(new FileInputStream(url));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element root = doc.getDocumentElement();
		// loop through children of root
		NodeList rootNodes = root.getChildNodes();
		for (int i = 0; i < rootNodes.getLength(); i++) {
			Node node = rootNodes.item(i);
			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.getNodeName().equals("Personal")) {
					PersonalDetails personal = new PersonalDetails();
					personal.read(child);
					setPersonalDetails(personal);
				} else if (child.getNodeName().equals("Training")) {
					TrainingDetails trainingDetails = new TrainingDetails();
					trainingDetails.read(child);
					setTrainingDetails(trainingDetails);
				}
			}

		}
	}
}
