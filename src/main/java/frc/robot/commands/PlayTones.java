// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.team7419.music.Music;
import com.team7419.music.MusicSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PlayTones extends CommandBase {
  private Music music;
  private MusicSubsystem musicSubsystems[];

  private int _noteIter = 0; // !< Iterates over the notes
  private int _timeoutMs = 0; // !< Count down from prev notes to track when to play next note.
  private int _state = 0; // !< State machine to track tone vs off state.
  private double _frequencyToPlay = 0; // !< The actual frequency to play through the TalonFX.
  private final int dt_ms = 20; // 20 ms loop time
  
  /** Creates a new PlayTones. */
  public PlayTones(Music music, MusicSubsystem... musicSubsystems) {
    this.music = music;
    this.musicSubsystems = musicSubsystems;
    addRequirements(musicSubsystems);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (_timeoutMs >= 0) {
      /* still waiting for note duration */
      _timeoutMs -= dt_ms;
    } else if (_noteIter >= music.notes.length) {
      /* all notes played, start all over */
      _noteIter = 0;
    } else {
      /* get the next note and duration */
      int freq = (int) music.notes[_noteIter];
      int durMs = (int) music.durationsMs[_noteIter];

      /* state machine */
      switch (_state) {
      case 0:
        /* save the frequency to play */
        _frequencyToPlay = freq;
        /* arm the timeout, jump to state 1 */
        _timeoutMs = durMs;
        _state = 1;
        break;

      case 1: // play off for a bit. You don't necessarily need this, depends on the type of
              // music
        /* release the piano key for a bit */
        _frequencyToPlay = 0;
        /* back to state 0 for next press */
        _state = 0;
        _timeoutMs = 20;
        ++_noteIter;
        break;
      }
    }

    for (MusicSubsystem musicSubsystem : musicSubsystems) {
      musicSubsystem.playTone(_frequencyToPlay);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    for (MusicSubsystem musicSubsystem : musicSubsystems) {
      musicSubsystem.stopTone();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
