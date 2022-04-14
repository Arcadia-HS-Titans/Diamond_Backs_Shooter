package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootingSubsystem extends SubsystemBase {
    public final CANSparkMax rightBus;
    public final CANSparkMax leftBus;

    public ShootingSubsystem() {
        this.rightBus = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
        this.leftBus = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
    }

    public void fire(double percentage) {
        this.leftBus.set(percentage);
        this.rightBus.set(-percentage);
    }
}
