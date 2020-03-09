/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DefaultAuton extends Command {
  public DefaultAuton() {
    requires(Robot.driveTrain);
    requires(Robot.flyWheel);
    requires(Robot.indexer);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timedrive();
  }

  //different autons
  private void timedrive(){
    Robot.driveTrain.drive(-0.3);
    Robot.wait(500);
    Robot.driveTrain.stop();
  }

  private void distdrive(){
    Robot.driveTrain.driveDist(2*12, 0.3);
  }

  private void shoot(){
    Robot.flyWheel.setConstantVelocity(2000);
    Robot.wait(500);
    Robot.indexer.shoot(-0.5);
    Robot.indexer.spinIndexer(0.5);
    Robot.wait(7000);
    Robot.flyWheel.stop();
    Robot.indexer.shoot(0);
    Robot.indexer.spinIndexer(0);
  }





  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
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
