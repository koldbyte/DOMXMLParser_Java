package com.sapient.xml102.main;

import com.sapient.xml102.pojo.Trainee;

public class XMLRunner {

	public static void main(String[] args) {
		System.out.println("Running XML Reader....");
		new XMLRunner().runReader();
		System.out.println("Completed XML Reader....");		
	}

	private void runReader() {
		Trainee trainee = new Trainee();
		trainee.read("src/xml/TraineeProfile.xml");
		System.out.println(trainee);
	}

}
