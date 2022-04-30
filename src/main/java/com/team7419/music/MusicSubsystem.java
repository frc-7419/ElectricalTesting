// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team7419.music;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MusicSubsystem extends SubsystemBase {
  private TalonFX[] talons;

  public MusicSubsystem(TalonFX... talons) {
    this.talons = talons;
  }

  public void playTone(double tone) {
    for (TalonFX talon : talons) {
      talon.set(TalonFXControlMode.MusicTone, tone);
    }
  }

  public TalonFX[] getTalons() {
    return talons;
  }

  public void stopTone() {
    for (TalonFX talon : talons) {
      talon.set(TalonFXControlMode.MusicTone, 0);
    }
  }
}