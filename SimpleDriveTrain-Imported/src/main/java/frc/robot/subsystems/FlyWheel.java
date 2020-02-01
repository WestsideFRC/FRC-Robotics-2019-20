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

  public void flyWheel(){
    //set left motors inverted
    LeftFlyMotor1.setInverted(true);
    LeftFlyMotor2.setInverted(true);
    RightFlyMotor1.setInverted(false);
    RightFlyMotor2.setInverted(false);

    //set all motors to be slaves to RightFlyMotor1
    LeftFlyMotor1.set(ControlMode.Follower, RobotMap.RIGHT_FLYWHEEL_MOTOR1_ID);
    LeftFlyMotor2.set(ControlMode.Follower, RobotMap.RIGHT_FLYWHEEL_MOTOR1_ID);
    RightFlyMotor2.set(ControlMode.Follower,RobotMap.RIGHT_FLYWHEEL_MOTOR1_ID);
  }
  
  //instance of 




  //instances of all four motors that spin the flywheel
  //All motors are set as slaves to the RIGHT_FLYWHEEL_MOTOR1_ID
  private VictorSPX LeftFlyMotor1 = new VictorSPX(RobotMap.LEFT_FLYWHEEL_MOTOR1_ID);
  private VictorSPX RightFlyMotor1 = new VictorSPX(RobotMap.RIGHT_FLYWHEEL_MOTOR1_ID); //this motor is the master
  private VictorSPX LeftFlyMotor2 = new VictorSPX(RobotMap.LEFT_FLYWHEEL_MOTOR2_ID);
  private VictorSPX RightFlyMotor2 = new VictorSPX(RobotMap.RIGHT_FLYWHEEL_MOTOR2_ID);

  //mothod for setting motor power
  public void setFlyWheelPower(double percent){
    RightFlyMotor1.set(ControlMode.PercentOutput, percent); //only right1 needs to be changed
  }

}
