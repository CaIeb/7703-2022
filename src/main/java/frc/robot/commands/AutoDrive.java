package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private final double time;

    private Timer timer = new Timer();

    public AutoDrive(Drivetrain drivetrain, double time) {
        this.drivetrain = drivetrain;
        this.time = time;
        addRequirements(drivetrain);
    }
    @Override
    public void initialize() {
        drivetrain.isAuto = true;
        timer.reset();
        timer.start();
    }
    @Override
    public void execute() {
        drivetrain.arcadeDrive(0, .5);
    }
    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
        timer.stop();
        timer.reset();
        drivetrain.isAuto = false;
    }
    @Override
    public boolean isFinished() {
        return timer.get() >= time;
    }
    
}
