package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private DoubleSupplier throttle;
    private DoubleSupplier rotation;
    public TeleDrive(Drivetrain drivetrain, DoubleSupplier throttle, DoubleSupplier rotation) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }
    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        drivetrain.arcadeDrive(throttle.getAsDouble(), rotation.getAsDouble());
    }
    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }
}
