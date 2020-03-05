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


public class TeleOpIntake extends Command {

  private OI oi = Robot.m_oi;

  public TeleOpIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.print("Intake online");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(oi.controller.getBumper(Hand.kLeft)){
      Robot.intake.setPositionDown();
    }
    if(oi.controller.getBumper(Hand.kRight)){
      Robot.intake.setPositionUp();
    }

    if(oi.controller.getTriggerAxis(Hand.kRight) > .03 || oi.controller.getTriggerAxis(Hand.kRight) < -.03){
      Robot.intake.setIntakeSpeed(oi.controller.getTriggerAxis(Hand.kRight));
      Robot.indexer.spinIndexer(.5);
    } else {
      Robot.intake.setIntakeSpeed(0);
      Robot.indexer.spinIndexer(0);
    }


    // if(oi.controller.getRawButtonPressed(RobotMap.INTAKE_UP)){
    //   Robot.intake.setPositionDown();
    // }
    // if(oi.controller.getRawButtonPressed(RobotMap.INTAKE_DOWN)){
    //   Robot.intake.setPositionUp();
    // }

    // if(oi.controller.getRawButton(RobotMap.INTAKE_IN)){
    //   Robot.intake.setIntakeSpeed(.5);
    //   Robot.indexer.spinIndexer(0.5);
    // }
    // else if(oi.controller.getRawButton(RobotMap.INTAKE_OUT)){
    //   Robot.intake.setIntakeSpeed(-.5);
    //   Robot.indexer.spinIndexer(0.5);
    // } else {
    //   Robot.intake.setIntakeSpeed(0);
    //   Robot.indexer.spinIndexer(0);

    // }
    //Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SENSITIVITY*oi.controller.getRawAxis(RobotMap.INTAKE_SPEED));
    
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
