/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //Logitech controller we will use in competition
  public Joystick controller = new Joystick(RobotMap.CONTROLLER_PORT);

  //Logitech Controller Mapping TODO: make sure maping is correct

  //Axis
  public static final int JOYST_LEFT_Y = 0; 
  public static final int JOYST_LEFT_X = 1;
  public static final int JOYST_RIGHT_Y = 2;
  public static final int JOYST_RIGHT_X = 3;
  public static final int SHOULDER_AXIS = 3; //TODO: change numbers to match what should be their!!!
  public static final int DPAD_X = 1;
  public static final int DPAD_Y = 1;

  //buttons
  public static final int BUTTON_X = 1;
  public static final int BUTTON_A = 2;
  public static final int BUTTON_B = 3;
  public static final int BUTTON_Y = 4;
  public static final int LB = 5;
  public static final int RB = 6;

}
