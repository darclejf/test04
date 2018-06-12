package com.darclejf.models;

/**
 * @author DarcleJF
 */
public class ScoreOutputModel implements Comparable<ScoreOutputModel>   {
    private int numberContestant;
    private int problemsSolved = 0;
    private int timePenalties = 0;
    
    public ScoreOutputModel(int numberContestant, int problemsSolved, int timePenalties) {
        this.numberContestant = numberContestant;
        this.problemsSolved = problemsSolved;
        this.timePenalties = timePenalties;
    }

    /**
	 * @return the numberContestant
	 */
	public int getNumberContestant() {
		return numberContestant;
    }
    
	/**
	 * @param numberContestant the numberContestant to set
	 */
	public void setNumberContestant(int numberContestant) {
		this.numberContestant = numberContestant;
    }
    
	/**
	 * @return the problemsSolved
	 */
	public int getProblemsSolved() {
		return problemsSolved;
    }
    
	/**
	 * @param problemsSolved the problemsSolved to set
	 */
	public void setProblemsSolved(int problemsSolved) {
		this.problemsSolved = problemsSolved;
    }
    
	/**
	 * @return the timePenalties
	 */
	public int getTimePenalties() {
		return timePenalties;
	}
	/**
	 * @param timePenalties the timePenalties to set
	 */
	public void setTimePenalties(int timePenalties) {
		this.timePenalties = timePenalties;
    }
    
    @Override
    public boolean equals(Object obj) {
		if (this == obj)
            return true;
            
		if (obj == null)
            return false;
            
		if (getClass() != obj.getClass())
			return false;

        ScoreOutputModel other = (ScoreOutputModel)obj;
		if (this.numberContestant != other.numberContestant) 
            return false;

        if (this.problemsSolved != other.problemsSolved) 
            return false;

        if (this.timePenalties != other.timePenalties) 
            return false;
            
		return true;
	}

	@Override
	public String toString() {
		return this.numberContestant + " " +  this.problemsSolved + " " +  this.timePenalties + "\n";
	}

	@Override
	public int compareTo(ScoreOutputModel c) {
		if(problemsSolved != c.problemsSolved)
			return c.problemsSolved - problemsSolved;
		if(timePenalties != c.timePenalties)
			return timePenalties - c.timePenalties;
		return numberContestant - c.numberContestant;
	}
}