package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

    public CANSparkMax motor = new CANSparkMax(4, MotorType.kBrushless);
    public RelativeEncoder encoder = motor.getEncoder();
    public int max;
    public int min;
    public double speed;
    public Climber(int max, int min) {
        motor.setIdleMode(IdleMode.kBrake);
        this.max = max;
        this.min = min;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Climb Encoder", encoder.getPosition());
        motor.set(speed);
    }

}
