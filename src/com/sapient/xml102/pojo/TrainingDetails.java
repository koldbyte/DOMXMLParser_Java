package com.sapient.xml102.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TrainingDetails {
	private String stream;
	private Date DateOfJoining;
	private Integer TotalScore;

	public TrainingDetails() {
		super();
	}

	public TrainingDetails(String stream, Date dateOfJoining, Integer totalScore) {
		super();
		this.stream = stream;
		DateOfJoining = dateOfJoining;
		TotalScore = totalScore;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Date getDateOfJoining() {
		return DateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}

	public Integer getTotalScore() {
		return TotalScore;
	}

	public void setTotalScore(Integer totalScore) {
		TotalScore = totalScore;
	}

	@Override
	public String toString() {
		return "{\nstream=" + stream + 
				"\nDateOfJoining=" + DateOfJoining + 
				"\nTotalScore=" + TotalScore + 
				"\n}";
	}

	public void read(Element mainNode) {
		NodeList childNodes = mainNode.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.getNodeName().equals("Stream")) {
					setStream(child.getTextContent());
				} else if (child.getNodeName().equals("DateOfJoining")) {
					if (child.getTextContent() != null) {
						try {
							setDateOfJoining(new SimpleDateFormat("yyyy-MM-dd")
									.parse(child.getTextContent()));
						} catch (DOMException | ParseException e) {
							e.printStackTrace();
						}
					}
				} else if (child.getNodeName().equals("TotalScore")) {
					if (child.getTextContent() != null) {
						setTotalScore(Integer.parseInt(child.getTextContent()));
					}
				}
			}
		}
	}
}
