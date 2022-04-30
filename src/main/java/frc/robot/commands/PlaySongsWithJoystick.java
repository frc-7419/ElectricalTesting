// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.ArrayList;
import java.util.Arrays;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;
import com.team7419.music.MusicSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PlaySongsWithJoystick extends CommandBase {
  private Orchestra orchestra;
  private int selection = 0;
  private XboxController joystick;

  private int delay = 0;

  private String[] songs = new String[] {
    "song1.chrp",
    "song2.chrp",
    "song3.chrp",
    "song4.chrp",
    "song5.chrp",
    "song6.chrp",
    "song7.chrp",
    "song8.chrp",
    "song9.chrp", /* the remaining songs play better with three or more FXs */
    "song10.chrp",
    "song11.chrp",
  };

  public PlaySongsWithJoystick(XboxController joystick, MusicSubsystem... musicSubsystems) {
    ArrayList<TalonFX> instruments = new ArrayList<TalonFX>();
    this.joystick = joystick;
    for (MusicSubsystem musicSubsystem : musicSubsystems) {
      instruments.addAll(Arrays.asList(musicSubsystem.getTalons()));
    }
    orchestra = new Orchestra(instruments);
    addRequirements(musicSubsystems);
  }

  public void loadSelection(int sel) {
    orchestra.loadMusic(songs[sel]);
    System.out.println("Song selected is: " + songs[sel]);
    delay = 10;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (delay > 0) {
      delay--;
      if (delay == 0) {
        orchestra.play();
      }
    }

    if (joystick.getBButtonPressed()) {
      if (orchestra.isPlaying()) {
        orchestra.pause();
      } else {
        orchestra.play();
      }
    }

    int dPad = joystick.getPOV();
    if (dPad == 0 ) { // up
      selection++;
      selection %= songs.length; // sanity check
      loadSelection(selection);
    } else if (dPad == 180) { // ddown
      selection--;
      if (selection < 0) {
        selection = songs.length-1;
      }
      loadSelection(selection);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
