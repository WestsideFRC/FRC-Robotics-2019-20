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
import frc.robot.commands.PIDFlyWheel;

/**
 * Add your docs here.
 */
public class FlyWheel extends Subsystem {

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new PIDFlyWheel());

  }
  
  //instances of all four motors that spin the flywheel
  //All motors are set as slaves to the RIGHT_LOW_FLYWHEEL_MOTOR_ID
  private VictorSPX LeftLowFlyMotor = new VictorSPX(RobotMap.LEFT_LOW_FLYWHEEL_MOTOR_ID);
  private VictorSPX RightLowFlyMotor = new VictorSPX(RobotMap.RIGHT_LOW_FLYWHEEL_MOTOR_ID); //this motor is the master
  private VictorSPX LeftHighFlyMotor = new VictorSPX(RobotMap.LEFT_HIGH_FLYWHEEL_MOTOR_ID);
  private VictorSPX RightHighFlyMotor = new VictorSPX(RobotMap.RIGHT_HIGH_FLYWHEEL_MOTOR_ID);

  //set direct references to the master motor for easy use
  //The Master Motor is RightLowMotor.
  private final int MASTER_MOTOR_ID = RobotMap.RIGHT_LOW_FLYWHEEL_MOTOR_ID;
  private VictorSPX MasterMotor = RightLowFlyMotor;


  public void FlyWheel(){
    //set left motors inverted
    LeftLowFlyMotor.setInverted(true);
    LeftHighFlyMotor.setInverted(true);
    RightLowFlyMotor.setInverted(false);
    RightHighFlyMotor.setInverted(false);

    //set all motors to be slaves to RightLowFlyMotor
    LeftLowFlyMotor.set(ControlMode.Follower, MASTER_MOTOR_ID);
    LeftHighFlyMotor.set(ControlMode.Follower, MASTER_MOTOR_ID);
    RightHighFlyMotor.set(ControlMode.Follower, MASTER_MOTOR_ID);
  }

  //mothod for setting motor power
  public void setFlyWheelPower(double percent){
    MasterMotor.set(ControlMode.PercentOutput, percent); //only right1 needs to be changed
  }

}
