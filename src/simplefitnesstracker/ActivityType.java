package simplefitnesstracker;

public class ActivityType {

	private String activityName;
	private int caloriesBurntPerMin;
	private double heartRateIncPerMin;
	private int totalCaloriesBurnt;
	private double totalHeartRateInc;

	public ActivityType(String string, int caloriesBurntPerMin, double heartRateIncPerMin) {
		this.activityName = string;
		this.caloriesBurntPerMin = caloriesBurntPerMin;
		this.heartRateIncPerMin = heartRateIncPerMin;
	}

	public int getTotalCaloriesBurnt() {
		return totalCaloriesBurnt;
	}

	public void setTotalCaloriesBurnt(int totalCaloriesBurnt) {
		this.totalCaloriesBurnt += totalCaloriesBurnt;
	}

	public double getTotalHeartRateInc() {
		return totalHeartRateInc;
	}

	public void setTotalHeartRateInc(double totalHeartRateInc) {
		this.totalHeartRateInc += totalHeartRateInc;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getCaloriesBurntPerMin() {
		return caloriesBurntPerMin;
	}

	public void setCaloriesBurntPerMin(int caloriesBurntPerMin) {
		this.caloriesBurntPerMin = caloriesBurntPerMin;
	}

	public double getHeartRateIncPerMin() {
		return heartRateIncPerMin;
	}

	public void setHeartRateIncPerMin(double heartRateIncPerMin) {
		this.heartRateIncPerMin = heartRateIncPerMin;
	}

}
