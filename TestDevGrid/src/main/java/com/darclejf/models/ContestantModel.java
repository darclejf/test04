package com.darclejf.models;

import java.util.ArrayList;

/**
 * @author DarcleJF
 * @version 1.00
 */
public class ContestantModel {    
	
	private int number;
	private int solveds;
	private int timePenalties;
	private ArrayList<ContestantProblemModel> problems;

	public ContestantModel() {
		this.problems = new ArrayList<ContestantProblemModel>();
	}
	
    /**
	 * @return the number
	 */
	public int getNumber() {
		return number;
    }
    
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

		/**
	 * @return the solveds
	 */
	public int getSolveds() {
		return solveds;
	}

	/**
	 * @return the timePenalties
	 */
	public int getTimePenalties() {
		return timePenalties;
	}

	public void addProblem(int problemNumber, int time, ResultEnum result) {
		
		ContestantProblemModel problem = this.getProblem(problemNumber);
		
		if (problem.isSolved()) {
			return;
		}

		if (result.equals(ResultEnum.I)) {
			problem.addCountErros();
		}
		else if (result.equals(ResultEnum.C)) {
			this.timePenalties += time + (problem.getCountErros() * 20);
			this.solveds++;
			problem.setSolved(true);
		}
	}

	private ContestantProblemModel getProblem(int number) {
		for (ContestantProblemModel p : this.problems) {
			if (p.getNumber() == number) {
				return p;
			}
		}

		ContestantProblemModel p = new ContestantProblemModel();
		p.setNumber(number);
		this.problems.add(p);
		return p;
	}

	
}