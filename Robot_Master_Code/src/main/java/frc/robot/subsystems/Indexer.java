/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Indexer extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  @Override
  public void initDefaultCommand() {
    //not used
  }
  
  //private VictorSPX rightMotor = new VictorSPX(RobotMap.RIGHT_INDEXER_MOTOR_ID);
  private TalonSRX indexerMotor = new TalonSRX(RobotMap.INDEXER_MOTOR_ID);
  private TalonSRX flywheelIntakeMotor = new TalonSRX(RobotMap.FLYwHEEL_INTAKE_MOTOR_ID);

  public void spinIndexer(double percent){
    indexerMotor.set(ControlMode.PercentOutput, percent);
  }

  public void shoot(double percent){
    flywheelIntakeMotor.set(ControlMode.PercentOutput, percent); 
  }
}
