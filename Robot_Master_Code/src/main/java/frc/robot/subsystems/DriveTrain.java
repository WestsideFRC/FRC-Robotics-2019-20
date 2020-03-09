/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.IMotorController;
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
  
  private final IMotorController LEFT = LeftMotor1;
  private final IMotorController RIGHT = RightMotor1; 
  //not used since the ControlDrive will control all comands
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new TeleOpDrive());
  }

  public DriveTrain(){
    //invert the left motors so that all motors spin the wheels forward
    LeftMotor1.setInverted(true);
    LeftMotor2.setInverted(true);

    //set the left and right #2 motors to be slaves to the #1 motors
    //this way, both motors in the same gear box will spin at exactly the same speed
    LeftMotor2.follow(LEFT);
    RightMotor2.follow(RIGHT);

    LeftMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    RightMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    LeftMotor1.setSensorPhase(true);
    RightMotor1.setSensorPhase(true);

    // LeftMotor1.config_kP(0, .9); //TODO: set kP
    // LeftMotor1.config_kI(0, 0); 
    // LeftMotor1.config_kD(0, 0); //TODO: set kD
    // LeftMotor1.config_kF(0, 12);

    // RightMotor1.config_kP(0, .9); //TODO: set kP
    // RightMotor1.config_kI(0, 0); 
    // RightMotor1.config_kD(0, 0); //TODO: set kD
    // RightMotor1.config_kF(0, 12);

  }

  //method for setting the speed of the left wheels
  public void setLeftMotors(double percent){
    LEFT.set(ControlMode.PercentOutput, percent);
  }

  //method for setting the speed of the right wheels
  public void setRightMotors(double percent){
    RIGHT.set(ControlMode.PercentOutput, percent);
  }

  public void drive(double speed, double turnH){
    setLeftMotors(speed - turnH);
    setRightMotors(speed + turnH);
  }

  public void drive(double speed){
    setLeftMotors(speed);
    setRightMotors(speed);
  }
  public void stop(){
    RIGHT.neutralOutput();
    LEFT.neutralOutput();
  }

  public double kPos = 4*3.14/4096; //the conversion between Sensor Units and inches

  public void driveDist(double inches, double percentOutput){
    RIGHT.setSelectedSensorPosition(0, 0, 10);
    LEFT.setSelectedSensorPosition(0, 0, 10);
    RIGHT.set(ControlMode.PercentOutput, percentOutput);
    LEFT.set(ControlMode.PercentOutput, percentOutput);
    while(RIGHT.getSelectedSensorPosition(0)*kPos < inches);
    stop();
  }

  public void driveTime(double seconds, double percentOutput){
  }
}
