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
	public static final int LEFT_DRIVE_MOTOR1_ID = 2; 	//front left motor CAN ID
	public static final int RIGHT_DRIVE_MOTOR1_ID = 3;	//front right motor CAN ID
	public static final int LEFT_DRIVE_MOTOR2_ID = 1;	//back left motor CAN ID
	public static final int RIGHT_DRIVE_MOTOR2_ID = 4;	//back right motor CAN ID

	public static final int LEFT_LOW_FLYWHEEL_MOTOR_ID = 7; 	//lower left motor CAN ID
	public static final int RIGHT_LOW_FLYWHEEL_MOTOR_ID = 5;	//lower right motor CAN ID
	public static final int LEFT_HIGH_FLYWHEEL_MOTOR_ID = 8;	//upper left motor CAN ID
	public static final int RIGHT_HIGH_FLYWHEEL_MOTOR_ID = 6;	//upper right motor CAN ID

	public static final int INDEXER_MOTOR_ID = 10;
	public static final int FLYwHEEL_INTAKE_MOTOR_ID = 11;

	public static final int INTAKE_SPIN_MOTOR_ID = 9;
	public static final int INTAKE_SOLENOID_ID1 = 0; //controls whether the intake is up or down
	public static final int INTAKE_SOLENOID_ID2 = 1;
	
	//Controller maping
	//TODO: set all contrller mappings to OI constants
	public static final int CONTROLLER_PORT = 0; 	//the port the controller is pluged into
	
	public static final int DRIVE_AXIS = OI.JOYST_LEFT_X; 		//the axis that controls moving forward and backward
	public static final int TURN_AXIS = OI.JOYST_RIGHT_Y;			//the axis that controls turning left and right - Note, Aaron changed this from 2 to 0.

	public static final int FLYWHEEL_BUTTON_50 = OI.BUTTON_A;	//buttons that set flywheel power %
	public static final int FLYWHEEL_BUTTON_75 = OI.BUTTON_B;
	public static final int FLYWHEEL_BUTTON_100 = OI.BUTTON_Y;
	public static final int FLYWHEEL_BUTTON_0 = OI.BUTTON_X;
	public static final int INTAKE_IN = OI.RT;
	public static final int INTAKE_OUT = OI.LT;
	//public static final int INTAKE_UP_AND_DOWN = OI.LT_RT_AXIS;
	//public static final int INTAKE_SPEED = OI.SHOULDER_AXIS;
	public static final int INTAKE_UP = OI.RB;
	public static final int INTAKE_DOWN = OI.LB;
	public static final int INDEXER = OI.DPAD_X; 
	//public static final int INDEXER_2 = OI.DPAD_Y; 
	//public static final int INDEXER_3 = OI.DPAD_X; 
	//public static final int INDEXER_4 = OI.DPAD_Y; 
	//program constants
	public static final double TURN_SENSITIVITY = 0.5; 	//how much the robot turns in responce to the joystick (angular speed per joystick level)
	public static final double DRIVE_SENSITIVITY = 1;	//how fast the robot moves in responce to the joystick (speed per joystick level)
	public static final double INTAKE_SENSITIVITY = .3;
}
