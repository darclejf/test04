package com.darclejf.models;

/**
 * @author DarcleJF
 * @version 1.00
 */
public class ContestantProblemModel {
    
    private int number;
    private boolean solved;
    private int countErros;
    
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
	 * @return the solved
	 */
	public boolean isSolved() {
		return solved;
	}

	/**
	 * @param solved the solved to set
	 */
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	/**
	 */
	public int getCountErros() {
		return this.countErros;
	}

	/**
	 */
	public void addCountErros() {
		this.countErros++;
	}
}