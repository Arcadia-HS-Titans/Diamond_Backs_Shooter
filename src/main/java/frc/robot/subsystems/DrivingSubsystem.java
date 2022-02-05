package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivingSubsystem extends SubsystemBase {
    //TODO: For whatever reason, one of the controller groups will go faster than the ither

    // Left motors
    private final PWMSparkMax PURPLE_MOTOR = new PWMSparkMax(Constants.PURPLE_MOTOR_PORT);
    private final PWMSparkMax BROWN_MOTOR = new PWMSparkMax(Constants.BROWN_MOTOR_PORT);
    MotorController leftController = new MotorControllerGroup(PURPLE_MOTOR, BROWN_MOTOR);
    //Right motors
    private final PWMSparkMax YELLOW_MOTOR = new PWMSparkMax(Constants.YELLOW_MOTOR_PORT);
    private final PWMSparkMax ORANGE_MOTOR = new PWMSparkMax(Constants.ORANGE_MOTOR_PORT);
    MotorController rightController = new MotorControllerGroup(YELLOW_MOTOR, ORANGE_MOTOR);

    // Differential drive to control the robot
    private final DifferentialDrive robotDrive = new DifferentialDrive(leftController, rightController);

    // Reference for encoders later https://github.com/wpilibsuite/allwpilib/blob/main/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/hatchbottraditional/subsystems/DriveSubsystem.java
    public DrivingSubsystem() {}

    public void arcadeDrive(double forward, double rotation) {
        robotDrive.arcadeDrive(forward, rotation);
    }
}
