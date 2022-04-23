package simplefitnesstracker;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application {

	ActivityType rank[] = new ActivityType[4];
	Main mainObj;

	public static void main(String args[]) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		mainObj = new Main();

		// Stage to input activity data

		primaryStage.setTitle("Fitness Tracker");
		primaryStage.setResizable(false);

		Label activityLabel = new Label("Activity Type:");
		Label timeLabel = new Label("Time (in min):");
		String[] activities = { "Swimming", "Running", "Kick Boxing", "Strength Training", };
		ComboBox activitiesBox = new ComboBox(FXCollections.observableArrayList(activities));
		TextField timeField = new TextField();
		Button addActivity = new Button("Add Activity");
		Button showResults = new Button("Show Results");

		GridPane grid = new GridPane();
		grid.add(activityLabel, 1, 2);
		grid.add(timeLabel, 1, 3);
		grid.add(activitiesBox, 2, 2);
		grid.add(timeField, 2, 3);
		grid.add(showResults, 3, 4);
		grid.add(addActivity, 4, 4);
		grid.setHgap(15);
		grid.setVgap(15);

		Scene scene = new Scene(grid, 550, 150);

		primaryStage.setX(400);
		primaryStage.setY(300);

		addActivity.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				mainObj.activityName = (String) activitiesBox.getValue();
				mainObj.time = Integer.parseInt(timeField.getText());

				if (mainObj.time > 0 && mainObj.activityName != null) {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Fitness Tracker");
					alert.setHeaderText(null);
					alert.setContentText("Activity Recorded Successfully!");
					alert.showAndWait();
					mainObj.selectActivity(mainObj.activityName, mainObj.time);
					rank[0] = mainObj.swimming;
					rank[1] = mainObj.running;
					rank[2] = mainObj.kickBoxing;
					rank[3] = mainObj.strengthTraining;

				} else {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Fitness Tracker");
					alert.setHeaderText(null);
					alert.setContentText("Please enter activity/correct time");
					alert.showAndWait();

				}
			}
		});

		showResults.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				// Stage to show results

				Stage secondStage = new Stage();
				secondStage.setTitle("Results");
				secondStage.setResizable(false);

				Label activitiesRank = new Label("Activities Rank:");
				activitiesRank.setFont(new Font("Arial", 24));
				Button sortActivities = new Button("Sort");

				Label rank0 = new Label("1. " + rank[0].getActivityName() + ":\ncalories burnt: "
						+ rank[0].getTotalCaloriesBurnt() + "\nheart rate increase: " + rank[0].getTotalHeartRateInc());
				Label rank1 = new Label("\n2. " + rank[1].getActivityName() + ":\ncalories burnt: "
						+ rank[1].getTotalCaloriesBurnt() + "\nheart rate increase: " + rank[1].getTotalHeartRateInc());
				Label rank2 = new Label("\n3. " + rank[2].getActivityName() + ":\ncalories burnt: "
						+ rank[2].getTotalCaloriesBurnt() + "\nheart rate increase: " + rank[2].getTotalHeartRateInc());
				Label rank3 = new Label("\n4. " + rank[3].getActivityName() + ":\ncalories burnt: "
						+ rank[3].getTotalCaloriesBurnt() + "\nheart rate increase: " + rank[3].getTotalHeartRateInc());
				Label results = new Label("Results:");
				results.setFont(new Font("Arial", 24));
				Label totalCaloriesBurnt = new Label("Total Calories Burnt: " + mainObj.totalCalories);
				Label totalHeartRate = new Label("Total Heart Rate: " + mainObj.currentBPM);

				GridPane grid2 = new GridPane();
				grid2.add(activitiesRank, 1, 1);
				grid2.add(sortActivities, 10, 1);
				grid2.add(rank0, 1, 2);
				grid2.add(rank1, 1, 3);
				grid2.add(rank2, 1, 4);
				grid2.add(rank3, 1, 5);
				grid2.add(results, 1, 6);
				grid2.add(totalCaloriesBurnt, 1, 7);
				grid2.add(totalHeartRate, 1, 8);
				grid2.setHgap(15);
				grid2.setVgap(15);

				Scene scene2 = new Scene(grid2, 400, 575);

				secondStage.setX(1000);
				secondStage.setY(200);

				sortActivities.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

						mainObj.sortRanking(rank);
						secondStage.hide();

						Stage thirdStage = new Stage();
						thirdStage.setTitle("Results");
						thirdStage.setResizable(false);

						Label activitiesRank = new Label("Activities Rank:");
						activitiesRank.setFont(new Font("Arial", 24));
						Button sortActivities = new Button("Sort");

						Label rank0 = new Label("1. " + rank[0].getActivityName() + ":\ncalories burnt: "
								+ rank[0].getTotalCaloriesBurnt() + "\nheart rate increase: "
								+ rank[0].getTotalHeartRateInc());
						Label rank1 = new Label("\n2. " + rank[1].getActivityName() + ":\ncalories burnt: "
								+ rank[1].getTotalCaloriesBurnt() + "\nheart rate increase: "
								+ rank[1].getTotalHeartRateInc());
						Label rank2 = new Label("\n3. " + rank[2].getActivityName() + ":\ncalories burnt: "
								+ rank[2].getTotalCaloriesBurnt() + "\nheart rate increase: "
								+ rank[2].getTotalHeartRateInc());
						Label rank3 = new Label("\n4. " + rank[3].getActivityName() + ":\ncalories burnt: "
								+ rank[3].getTotalCaloriesBurnt() + "\nheart rate increase: "
								+ rank[3].getTotalHeartRateInc());
						Label results = new Label("Results:");
						results.setFont(new Font("Arial", 24));
						Label totalCaloriesBurnt = new Label("Total Calories Burnt: " + mainObj.totalCalories);
						Label totalHeartRate = new Label("Total Heart Rate: " + mainObj.currentBPM);

						GridPane grid3 = new GridPane();
						grid3.add(activitiesRank, 1, 1);
						grid3.add(sortActivities, 10, 1);
						grid3.add(rank0, 1, 2);
						grid3.add(rank1, 1, 3);
						grid3.add(rank2, 1, 4);
						grid3.add(rank3, 1, 5);
						grid3.add(results, 1, 6);
						grid3.add(totalCaloriesBurnt, 1, 7);
						grid3.add(totalHeartRate, 1, 8);
						grid3.setHgap(15);
						grid3.setVgap(15);

						Scene scene3 = new Scene(grid3, 400, 575);

						thirdStage.setX(1000);
						thirdStage.setY(200);

						thirdStage.setScene(scene3);
						thirdStage.show();

					}
				});

				secondStage.setScene(scene2);
				secondStage.show();
			}
		});

		primaryStage.setScene(scene);
		primaryStage.show();

	}
}