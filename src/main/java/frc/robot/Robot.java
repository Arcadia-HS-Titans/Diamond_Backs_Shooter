// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  //LEFT
  private final PWMSparkMax PURPLE_MOTOR = new PWMSparkMax(9);
  private final PWMSparkMax BROWN_MOTOR = new PWMSparkMax(8);
  MotorController leftController = new MotorControllerGroup(PURPLE_MOTOR, BROWN_MOTOR);
  //RIGHT
  private final PWMSparkMax YELLOW_MOTOR = new PWMSparkMax(7);
  private final PWMSparkMax ORANGE_MOTOR = new PWMSparkMax(6);
  MotorController rightController = new MotorControllerGroup(YELLOW_MOTOR, ORANGE_MOTOR);

  private final DifferentialDrive robotDrive1 = new DifferentialDrive(leftController, rightController);

  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    rightController.setInverted(true);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      robotDrive1.arcadeDrive(1, 1); // drive forwards half speed
    } else {
      robotDrive1.stopMotor(); // stop robot
    }
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit () {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    robotDrive1.arcadeDrive(m_stick.getY(), m_stick.getX());
    //robotDrive2.arcadeDrive(m_stick.getY(), m_stick.getX());
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}