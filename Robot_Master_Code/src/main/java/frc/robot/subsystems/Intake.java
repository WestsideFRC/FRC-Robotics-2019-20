/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // No def command
    // setDefaultCommand(new MySpecialCommand());
  }
  TalonSRX intakeMotor = new TalonSRX(RobotMap.INTAKE_SPIN_MOTOR_ID);
  
  Solenoid solenoid = new Solenoid(RobotMap.INTAKE_SOLENOID_ID);
  
  public void setIntakeSpeed(double percent){
   intakeMotor.set(ControlMode.PercentOutput, percent);
  }

  public void setPosition(boolean isDown){
    solenoid.set(isDown);
  }

  public boolean toglePosition(){
    solenoid.set(solenoid.get());
    return solenoid.get();
  }
}






