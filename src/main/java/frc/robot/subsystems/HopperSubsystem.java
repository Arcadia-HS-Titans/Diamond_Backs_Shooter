package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem extends SubsystemBase {

    //PWMSparkMax
    private final PWMSparkMax hopper = new PWMSparkMax(Constants.HOPPER_PORT);

    public HopperSubsystem() {
        Shuffleboard.getTab("TestingFRC").add("Voltage Hopper", 10);
    }

    public void setSpeed(double voltage) {
        hopper.setVoltage(voltage);
        hopper.set(1.0);
    }
}
