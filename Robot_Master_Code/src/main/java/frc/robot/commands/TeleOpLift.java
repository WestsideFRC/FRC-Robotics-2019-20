/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TeleOpLift extends Command {

  private OI oi = Robot.m_oi;

  public TeleOpLift() {
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    int pov = oi.controller.getPOV();

    if(pov!=-1){
      if(pov > 45 && pov < 135){
        Robot.lift.setPower(.95);
      }
      else if(pov < 315 && pov > 225){
        Robot.lift.setPower(-.95);
      } 
      else {
        Robot.lift.brakeStop();
      }
    } else {
      Robot.lift.brakeStop();
    }



  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
