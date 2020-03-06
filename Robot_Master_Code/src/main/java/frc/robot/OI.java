/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public XboxController controller = new XboxController(RobotMap.CONTROLLER_PORT);

  //XBOX CONTROLLER MAPPING
  
  //Axis
  public static final int JOYST_LEFT_Y = 2; 
  public static final int JOYST_LEFT_X = 1;
  public static final int JOYST_RIGHT_Y = 5;
  public static final int JOYST_RIGHT_X = 4;

  public static final int SHOULDER_AXIS = 3; //TODO: change numbers to match what should be their!!!
  public static final int DPAD_X = 5;
  //public static final int DPAD_Y = ;


  //buttons
  public static final int BUTTON_X = 3;
  public static final int BUTTON_A = 1;
  public static final int BUTTON_B = 2;
  public static final int BUTTON_Y = 4;
  
  public static final int LB = 5;
  public static final int RB = 6;

  //public static final int LT = 7;
  //public static final int RT = 8;

  public static final int BACK = 7;
  public static final int START = 8;



























//old Logitech stuff

  // //Logitech controller we will use in competition
  // public Joystick controller = new Joystick(RobotMap.CONTROLLER_PORT);

  // //public XboxController xBox = new XboxController(RobotMap.CONTROLLER_PORT);



  // //Logitech Controller Mapping TODO: make sure maping is correct

  // //Axis
  // public static final int JOYST_LEFT_Y = 1; 
  // public static final int JOYST_LEFT_X = 2;
  // public static final int JOYST_RIGHT_Y = 4;
  // public static final int JOYST_RIGHT_X = 3;

  // //public static final int SHOULDER_AXIS = 3; //TODO: change numbers to match what should be their!!!
  // public static final int DPAD_X = 5;
  // public static final int DPAD_Y = 6;


  // //buttons
  // public static final int BUTTON_X = 1;
  // public static final int BUTTON_A = 2;
  // public static final int BUTTON_B = 3;
  // public static final int BUTTON_Y = 4;
  
  // public static final int LB = 5;
  // public static final int RB = 6;

  // public static final int LT = 7;
  // public static final int RT = 8;

  // public static final int BACK = 9;
  // public static final int START = 10;

}
