/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

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
    // speed is way too high try not going percentage 0-100 and try decimals ex: .5 = 50%
    if(oi.controller.getRawButtonPressed(RobotMap.INTAKE_IN)){
      Robot.intake.setIntakeSpeed(0.5);
    }else if(oi.controller.getRawButtonReleased(RobotMap.INTAKE_IN)){
      Robot.intake.setIntakeSpeed(0);
    }
    if(oi.controller.getRawButtonPressed(RobotMap.INTAKE_OUT)){
       Robot.intake.setIntakeSpeed(-0.5);
    }else if(oi.controller.getRawButtonReleased(RobotMap.INTAKE_OUT)){
      Robot.intake.setIntakeSpeed(0);
    }


    // if(oi.controller.getRawAxis(OI.LT_RT_AXIS) > -.5) {
    //   Robot.intake.setPosition(false);
    // }
    // if(oi.controller.getRawAxis(OI.LT_RT_AXIS) < -.5) {
    //   Robot.intake.setPosition(true);
    // }

    if(oi.controller.getRawButtonPressed(RobotMap.INTAKE_UP)){
      Robot.intake.setPositionDown();
    }
    if(oi.controller.getRawButtonPressed(RobotMap.INTAKE_DOWN)){
      Robot.intake.setPositionUp();
    }

    //Robot.intake.setIntakeSpeed(oi.controller.getRawAxis(RobotMap.INTAKE_SPEED));

    //double x = oi.controller.getRawAxis(RobotMap.INTAKE_IN_AND_OUT);
    //
    // if(x<-.1){
    //
    // } 
    // else if(x>.1){
    //   if(x>.9){
    //     Robot.intake.setIntakeSpeed(.5);
    //   }
    //   else if(x>.7){
    //     Robot.intake.setIntakeSpeed(.3);
    //   }
    //   else if(x>.4){
    //     Robot.intake.setIntakeSpeed(.1);
    //   } 
    //   else {
    //
    //   }
    // } 
    // else {
    //   Robot.intake.setIntakeSpeed(0);
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
