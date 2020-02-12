/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class TeleOp extends CommandGroup {
  /**
   * Add your docs here.
   */

  //all teleop commands
  public TeleOpDrive drive = new TeleOpDrive();
  public TeleOpFlyWheel flywheel = new TeleOpFlyWheel();

  public TeleOp() {
    //set all commands to run at the smae time durring teleop
    System.out.print("teleop running"); //to see if the method runs
    addParallel(drive);
    addParallel(flywheel);
    
  }
}
