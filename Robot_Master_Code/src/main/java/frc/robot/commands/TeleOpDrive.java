/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TeleOpDrive extends Command {

  public TeleOpDrive() {
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.print("drive online");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.print("driverunning");

    double drive = RobotMap.DRIVE_SENSITIVITY * Robot.m_oi.controller.getRawAxis(RobotMap.DRIVE_AXIS);
    double turn = RobotMap.TURN_SENSITIVITY * Robot.m_oi.controller.getRawAxis(RobotMap.TURN_AXIS);

    // if(drive>.1 & Math.abs(turn)>.1){
      Robot.driveTrain.setLeftMotors(drive - turn);
      Robot.driveTrain.setRightMotors(drive + turn);
    // } else {
    //   Robot.driveTrain.setLeftMotors(0);
    //   Robot.driveTrain.setRightMotors(0);
    // }
    
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
