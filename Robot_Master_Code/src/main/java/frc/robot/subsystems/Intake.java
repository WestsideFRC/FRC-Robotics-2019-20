/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
  
  DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID_ID1, RobotMap.INTAKE_SOLENOID_ID2);
  
  public void setIntakeSpeed(double percent){
   intakeMotor.set(ControlMode.PercentOutput, percent);
  }

  public void setPositionDown(){
    solenoid.set(Value.kForward);
  }
  public void setPositionUp(){
    solenoid.set(Value.kReverse);
  }

  public void setPositionOff(){
    solenoid.set(Value.kOff);
  }

}






