/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;



import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class TeleOpIndexer extends Command {
  
 private OI oi = Robot.m_oi;

  public TeleOpIndexer() {
    requires(Robot.indexer);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if(oi.controller.getBumper(Hand.kRight)){ 
      Robot.indexer.spinIndexer(0.5);
      Robot.indexer.shoot(-0.5);
    } else {
      Robot.indexer.spinIndexer(0);
      Robot.indexer.shoot(0);
    }

    if(oi.controller.getBumper(Hand.kLeft)){
      Robot.indexer.shoot(0.5);
    }else {
      Robot.indexer.shoot(0); 
    }

    // if(oi.controller.getRawButtonPressed(OI.START)){ 
    //   Robot.indexer.spinIndexer(0.5);
    //   Robot.indexer.shoot(-0.5);
    // }else if (oi.controller.getRawButtonReleased(OI.START)){
    //   Robot.indexer.spinIndexer(0);
    //   Robot.indexer.shoot(0);
    // }

    // if(oi.controller.getRawButtonPressed(OI.BACK)){
    //   Robot.indexer.shoot(0.5);
    // }else if(oi.controller.getRawButtonReleased(OI.BACK)){
    //   Robot.indexer.shoot(0); 
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
