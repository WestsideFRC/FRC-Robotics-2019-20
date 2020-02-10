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

  //Logitech Controller Mapping TODO: complete. do not use until complete
  public static int JOYST_LEFT_VERT = 0;
  public static int JOYST_LEFT_HORIZ = 0;
  public static int JOYST_RIGHT_VERT = 0;
  public static int JOYST_RIGHT_HORIZ = 0;
  public static int BUTTON_A = 0;
  public static int BUTTON_B = 0;
  public static int BUTTON_C = 0;
  public static int BUTTON_D = 0;
  public static int LEFT = 0;
  public static int RIGHT = 0;
  public static int UP = 0;
  public static int DOWN = 0;
  public static int LB = 0;
  public static int RB = 0;
  public static int LT = 0;
  public static int RT = 0;

}
