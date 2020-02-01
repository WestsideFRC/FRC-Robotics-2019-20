/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//CAN maping
	public static final int LEFT_DRIVE_MOTOR1_ID = 5; 	//front left motor CAN ID
	public static final int RIGHT_DRIVE_MOTOR1_ID = 4;	//front right motor CAN ID
	public static final int LEFT_DRIVE_MOTOR2_ID = 2;		//back left motor CAN ID
	public static final int RIGHT_DRIVE_MOTOR2_ID = 3;	//back right motor CAN ID

	public static final int LEFT_FLYWHEEL_MOTOR1_ID = 7; 	//front left motor CAN ID
	public static final int RIGHT_FLYWHEEL_MOTOR1_ID = 6;	//front right motor CAN ID
	public static final int LEFT_FLYWHEEL_MOTOR2_ID = 0;		//back left motor CAN ID
	public static final int RIGHT_FLYWHEEL_MOTOR2_ID = 1;	//back right motor CAN ID


	//Controller maping
	public static final int CONTROLLER_PORT = 0; //the port the controller is pluged into
	public static final int DRIVE_AXIS = 1; //the axis that controls moving forward and backward
	public static final int TURN_AXIS = 4;	//the axis that controls turning left and right


	//program constants
	public static final double TURN_SENSITIVITY = 1; 	//how much the robot turns in responce to the joystick (angular speed per joystick level)
	public static final double DRIVE_SENSITIVITY = 1;	//how fast the robot moves in responce to the joystick (speed per joystick level)

}
