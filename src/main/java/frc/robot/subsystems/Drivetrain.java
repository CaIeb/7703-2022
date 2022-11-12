// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  public VictorSPX left1 = new VictorSPX(5);
  public VictorSPX left2 = new VictorSPX(1);
  public VictorSPX right1 = new VictorSPX(2);
  public VictorSPX right2 = new VictorSPX(3);
  private final XboxController controller;
  public boolean isAuto = false;
  public double leftSpeed = 0;
  public double rightSpeed = 0;
  /** Creates a new ExampleSubsystem. */
  public Drivetrain(XboxController controller) {
    this.controller = controller;
    left2.follow(left1);
    right2.follow(right1);
    left1.setInverted(false);
    right1.setInverted(false);
  }

  @Override
  public void periodic() {
    if (!isAuto) {
      double throttle = controller.getLeftY();
      throttle = (Math.abs(throttle) <= .1) ? 0 : throttle;
      throttle = Math.copySign(Math.pow(throttle, 2), throttle);
      double rotation = controller.getRightX();
      rotation = (Math.abs(rotation) <= .1) ? 0 : rotation;
      rotation = Math.copySign(Math.pow(rotation, 2), rotation);

      arcadeDrive(rotation, throttle);
      // This method will be called once per scheduler run
    }
    left1.set(ControlMode.PercentOutput, leftSpeed);
    right1.set(ControlMode.PercentOutput, rightSpeed);
  }

  public void arcadeDrive(double throttle, double rotation) {
    leftSpeed = throttle - rotation;
    rightSpeed = throttle + rotation;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
