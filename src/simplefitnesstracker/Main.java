package simplefitnesstracker;

import java.util.Scanner;

public class Main {

	public static ActivityType swimming = new ActivityType("Swimming", 4, 0.002);
	public static ActivityType running = new ActivityType("Running", 5, 0.003);
	public static ActivityType kickBoxing = new ActivityType("Kick Boxing", 3, 0.005);
	public static ActivityType strengthTraining = new ActivityType("Strength Training", 5, 0.006);
	public static ActivityType[] rank = new ActivityType[4];

	public static int time;
	public static int totalCalories = 0;
	public static double currentBPM = 80.0;
	public static String activityName;
	public static Scanner in = new Scanner(System.in);

	static void sortRanking(ActivityType rank[]) {
		int n = rank.length;
		ActivityType temp;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (rank[j - 1].getTotalCaloriesBurnt() < rank[j].getTotalCaloriesBurnt()) {
					temp = rank[j - 1];
					rank[j - 1] = rank[j];
					rank[j] = temp;
				} else if (rank[j - 1].getTotalCaloriesBurnt() == rank[j].getTotalCaloriesBurnt()
						&& rank[j - 1].getTotalHeartRateInc() < rank[j].getTotalHeartRateInc()) {
					temp = rank[j - 1];
					rank[j - 1] = rank[j];
					rank[j] = temp;
				}
			}
		}
	}

	static void selectActivity(String name, int num) {

		switch (name) {

		case "Swimming":
			swimming.setTotalCaloriesBurnt(num * swimming.getCaloriesBurntPerMin());
			swimming.setTotalHeartRateInc(currentBPM * num * swimming.getHeartRateIncPerMin());
			totalCalories += num * swimming.getCaloriesBurntPerMin();
			currentBPM += currentBPM * num * swimming.getHeartRateIncPerMin();
			rank[0] = swimming;
			break;

		case "Running":
			running.setTotalCaloriesBurnt(num * running.getCaloriesBurntPerMin());
			running.setTotalHeartRateInc(currentBPM * num * running.getHeartRateIncPerMin());
			totalCalories += num * running.getCaloriesBurntPerMin();
			currentBPM += currentBPM * num * running.getHeartRateIncPerMin();
			rank[1] = running;
			break;

		case "Kick Boxing":
			kickBoxing.setTotalCaloriesBurnt(num * kickBoxing.getCaloriesBurntPerMin());
			kickBoxing.setTotalHeartRateInc(currentBPM * num * kickBoxing.getHeartRateIncPerMin());
			totalCalories += num * kickBoxing.getCaloriesBurntPerMin();
			currentBPM += currentBPM * num * kickBoxing.getHeartRateIncPerMin();
			rank[2] = kickBoxing;
			break;

		case "Strength Training":
			strengthTraining.setTotalCaloriesBurnt(num * strengthTraining.getCaloriesBurntPerMin());
			strengthTraining.setTotalHeartRateInc(currentBPM * num * strengthTraining.getHeartRateIncPerMin());
			totalCalories += num * strengthTraining.getCaloriesBurntPerMin();
			currentBPM += currentBPM * num * strengthTraining.getHeartRateIncPerMin();
			rank[3] = strengthTraining;
			break;

		}
	}
}
