/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;


public class TeleOpFlyWheel extends Command {

  private OI oi = Robot.m_oi;

  public TeleOpFlyWheel() {
    requires(Robot.flyWheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.print("Flywheel online");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(oi.xBox.getRawButtonPressed(RobotMap.FLYWHEEL_BUTTON_50)){
      Robot.flyWheel.setConstantVelocity(0.5);
      //Robot.flyWheel.spinIndexer(0.5);
    }
    if(oi.xBox.getRawButtonPressed(RobotMap.FLYWHEEL_BUTTON_75)){
      Robot.flyWheel.setConstantVelocity(0.75);
      //Robot.flyWheel.spinIndexer(0.5);
    }
    
    if(oi.xBox.getRawButtonPressed(RobotMap.FLYWHEEL_BUTTON_100)){
      Robot.flyWheel.setConstantVelocity(0.95);
      //Robot.flyWheel.spinIndexer(0.5);
    }
    
    if(oi.xBox.getRawButtonPressed(RobotMap.FLYWHEEL_BUTTON_0)){
      Robot.flyWheel.setConstantVelocity(0);
      //Robot.flyWheel.spinIndexer(0);
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
