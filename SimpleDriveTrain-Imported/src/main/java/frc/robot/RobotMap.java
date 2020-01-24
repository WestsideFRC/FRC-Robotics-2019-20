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

	public static final int LEFT_MOTOR1_ID = 0;
	public static final int RIGHT_MOTOR1_ID = 2;
	public static final int LEFT_MOTOR2_ID = 1;
	public static final int RIGHT_MOTOR2_ID = 3;
	public static final int CONTROLLER_PORT = 0;
	public static final int DRIVE_AXIS = 1;
	public static final int TURN_AXIS = 4;
	public static final double TURN_SENSITIVITY = 1;
	public static final double DRIVE_SENSITIVITY = 1;

}
