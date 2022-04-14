package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class AutoCommand extends CommandBase {
    private DrivingSubsystem drivingSubsystem;


    public AutoCommand(DrivingSubsystem drivingSubsystem) {
        this.drivingSubsystem = drivingSubsystem;
        addRequirements(drivingSubsystem);
    }

    /**
     * This is called once for each time the command starts
     */
    @Override
    public void initialize() {
    }

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

    private Timer timer;

    @Override
    public void execute() {
    }
}
