/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ControlDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public VictorSPX LeftMotors = new VictorSPX(RobotMap.LEFT_MOTORS_ID);
  public VictorSPX RightMotors = new VictorSPX(RobotMap.RIGHT_MOTORS_ID);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ControlDrive());
  }

  public DriveTrain(){
    LeftMotors.setInverted(true);
  }

  public void setLeftMotors(double percent){
    LeftMotors.set(ControlMode.PercentOutput, percent);
  }

  public void setRightMotors(double percent){
    RightMotors.set(ControlMode.PercentOutput, percent);
  }

}
