package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;

public class ClimberDown extends CommandBase {
    private final Climber climber;

    private Timer timer = new Timer();

    public ClimberDown(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }
    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        climber.speed = -1;
    }
    @Override
    public void end(boolean interrupted) {
        climber.speed = 0;
    }
    @Override
    public boolean isFinished() {
        return climber.encoder.getPosition() <= climber.min;
    }
    
}
