/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // all instances of drive motors
  // LeftMotor2 and RightMotor2 are slaves to LeftMotor1 and RightMotor1
  // respectively
  private TalonSRX LeftMotor1 = new TalonSRX(RobotMap.LEFT_DRIVE_MOTOR1_ID);
  private TalonSRX RightMotor1 = new TalonSRX(RobotMap.RIGHT_DRIVE_MOTOR1_ID);
  private VictorSPX LeftMotor2 = new VictorSPX(RobotMap.LEFT_DRIVE_MOTOR2_ID);
  private VictorSPX RightMotor2 = new VictorSPX(RobotMap.RIGHT_DRIVE_MOTOR2_ID);
  
  //not used since the ControlDrive will control all comands
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new TeleOpDrive());
  }

  public DriveTrain(){
    //invert the left motors so that all motors spin the wheels forward
    RightMotor1.setInverted(true);
    RightMotor2.setInverted(true);

    //set the left and right #2 motors to be slaves to the #1 motors
    //this way, both motors in the same gear box will spin at exactly the same speed
    LeftMotor2.set(ControlMode.Follower, RobotMap.LEFT_DRIVE_MOTOR1_ID);
    RightMotor2.set(ControlMode.Follower,RobotMap.RIGHT_DRIVE_MOTOR1_ID);

  }

  //method for setting the speed of the left wheels
  public void setLeftMotors(double percent){
    LeftMotor1.set(ControlMode.PercentOutput, percent);
  }

  //method for setting the speed of the right wheels
  public void setRightMotors(double percent){
    RightMotor1.set(ControlMode.PercentOutput, percent);
  }

}
