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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.commands.TeleOpFlyWheel;

/**
 * Add your docs here.
 */
public class FlyWheel extends Subsystem {

 
  //instances of all four motors that spin the flywheel
  //All motors are set as slaves to the RIGHT_LOW_FLYWHEEL_MOTOR_ID
  private TalonSRX LeftLowFlyMotor = new TalonSRX(RobotMap.LEFT_LOW_FLYWHEEL_MOTOR_ID);
  private VictorSPX RightLowFlyMotor = new VictorSPX(RobotMap.RIGHT_LOW_FLYWHEEL_MOTOR_ID); //this motor is the master
  private VictorSPX LeftHighFlyMotor = new VictorSPX(RobotMap.LEFT_HIGH_FLYWHEEL_MOTOR_ID);
  private TalonSRX RightHighFlyMotor = new TalonSRX(RobotMap.RIGHT_HIGH_FLYWHEEL_MOTOR_ID);


  
  //private TalonSRX indexerMotor = new TalonSRX(RobotMap.INDEXER_MOTOR_ID);

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new TeleOpFlyWheel());
  }
  
  //set direct references to the master motor for easy use
  //The Master Motor is RightLowMotor.
  private final IMotorController MASTER_MOTOR_ID = RightHighFlyMotor;
  private TalonSRX MasterMotor = RightHighFlyMotor;

  private Solenoid hood = new Solenoid(RobotMap.HOOD_ID);
  
  public FlyWheel(){
    //set left motors inverted
    LeftLowFlyMotor.setInverted(false);
    LeftHighFlyMotor.setInverted(false);
    RightLowFlyMotor.setInverted(true);
    RightHighFlyMotor.setInverted(true);

    //set all motors to be slaves to RightLowFlyMotor
    //LeftLowFlyMotor.follow(MASTER_MOTOR_ID);
    LeftLowFlyMotor.follow(MASTER_MOTOR_ID);
    LeftHighFlyMotor.follow(MASTER_MOTOR_ID);
    RightLowFlyMotor.follow(MASTER_MOTOR_ID);

    //setup PID

      //setup sensor input
      MasterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
      //set sensor phase
      MasterMotor.setSensorPhase(false); //TODO: set the phase to be correct

      //set PID constants - 
      MasterMotor.config_kP(0, 1); //TODO: set kP
      MasterMotor.config_kI(0, 0); 
      MasterMotor.config_kD(0, 1); //TODO: set kD
      MasterMotor.config_kF(0, 1);

  }

  //mothod for setting motor power
  //don't use now. We have PID setup, so we don't need this
  public void setRawFlyWheelPower(double percent){
    MasterMotor.set(ControlMode.PercentOutput, percent); //only right1 needs to be changed
  }
  // public void spinIndexer(double percent){
  //   indexerMotor.set(ControlMode.PercentOutput, percent);
  // }

  public void hoodUp(){
    hood.set(true);
  }
  public void hoodDown(){
    hood.set(false);
  }


  //PID controll function
  /*
    Magnetic Encoder Native Units
    
      this uses Magnetic encoder native units
      the Mag encoder has 4096 "native units" per revolution
      at 600 RPM, the talon will read 4096 native units/100ms

      also note that the motors speed is different because of the drivetrain

      (Shooter_rpm) = (motor_rpm) / 4

      (775pro_max_speed) = 18730 rpm

      convert percentMaxSpeed to native units per 100ms
      percent max speed * max speed{18700} = motor_rpm
      motor_rpm / 4 = Shooter_rpm
      Shooter_rpm * 4096 (native units/100ms) / 600 (rpm) = 


      18700 / 4 * 4096 / 600 = 95744/3 
      percent max speed * 95744/3 = native units per 100ms
  */
  public void setConstantVelocity(double PercentMaxSpeed){
    
    MasterMotor.set(ControlMode.Velocity, 
      PercentMaxSpeed * 95744/3
    );
  }






}
