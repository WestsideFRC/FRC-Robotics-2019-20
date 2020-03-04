/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX left = new TalonSRX(RobotMap.LEFT_LIFT_ID);
  private TalonSRX right = new TalonSRX(RobotMap.RIGHT_LIFT_ID);

  private TalonSRX liftMotors = right;
  private IMotorController LiftMotors = liftMotors;

  public Lift(){

    left.setInverted(true);
    right.setInverted(false);

    right.setNeutralMode(NeutralMode.Brake);
    left.setNeutralMode(NeutralMode.Brake);

    left.follow(LiftMotors);

  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setPower(double percent){
    liftMotors.set(ControlMode.PercentOutput, percent);
  }

  public void brakeStop(){
    liftMotors.neutralOutput();
  }

}
