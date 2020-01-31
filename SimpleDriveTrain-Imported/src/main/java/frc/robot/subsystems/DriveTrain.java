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

  public VictorSPX LeftMotor1 = new VictorSPX(RobotMap.LEFT_MOTOR1_ID);
  public VictorSPX RightMotor1 = new VictorSPX(RobotMap.RIGHT_MOTOR1_ID);
  public VictorSPX LeftMotor2 = new VictorSPX(RobotMap.LEFT_MOTOR2_ID);
  public VictorSPX RightMotor2 = new VictorSPX(RobotMap.RIGHT_MOTOR2_ID);
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ControlDrive());
  }

  public DriveTrain(){
    LeftMotor1.setInverted(true); //makes sure both sides turn the same direction
    LeftMotor2.setInverted(true);
  }

  //makes sure the left motors are never turned against each other
  public void setLeftMotors(double percent){
    LeftMotor1.set(ControlMode.PercentOutput, percent);
    LeftMotor2.set(ControlMode.PercentOutput, percent);

  }

  //makes sure the right motors are never turned against each other
  public void setRightMotors(double percent){
    RightMotor1.set(ControlMode.PercentOutput, percent);
    RightMotor2.set(ControlMode.PercentOutput, percent);

  }

}
