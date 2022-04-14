package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

/**
 * https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html#simple-command-example
 * https://github.com/wpilibsuite/allwpilib/blob/main/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/hatchbottraditional/commands/DefaultDrive.java
 */
public class DrivingTeleopCommand extends CommandBase {

    private final Joystick joystick;

    private final DrivingSubsystem drivingSubsystem;
    private final ShootingSubsystem shootingSubsystem;

    public DrivingTeleopCommand(DrivingSubsystem drivingSubsystem, ShootingSubsystem shootingSubsystem) {
        this.drivingSubsystem = drivingSubsystem;
        this.joystick = new Joystick(0);
        this.shootingSubsystem = shootingSubsystem;
        addRequirements(drivingSubsystem);
        addRequirements(shootingSubsystem);
    }

    /**Logitech contro
     * This is called once for each time the command starts
     */
    @Override
    public void initialize() {}

    /**
     * Called when {@link #isFinished()} returns true
     * @param interrupted A boolean to say whether the command was interrupted by another command or explicitly cancelled
     */
    @Override
    public void end(boolean interrupted) {}

    /**
     * @return If the command is finished executing
     */
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void execute() {
        drivingSubsystem.arcadeDrive(
                joystick.getZ() * Constants.MOTOR_POWER_PERCENT,
                joystick.getY() * Constants.MOTOR_POWER_PERCENT
        );
        double value = ((-joystick.getRawAxis(3))/2)+.5;
        DriverStation.reportWarning(value + "", false);
        DriverStation.reportWarning("RPM: " + shootingSubsystem.rightBus.getEncoder().getVelocity(), false);
        if(joystick.getRawButton(1)) {
            shootingSubsystem.fire(value);
        } else {
            shootingSubsystem.fire(0);
        }
    }
}
