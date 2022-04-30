package com.team7419.music;

public class Music {
    public double[] notes;
    public int[] durationsMs;

    public Music(double[] notes, int[] durationsMs) {
        this.notes = notes;
        this.durationsMs = durationsMs;
    }

    private static final double NOTE_OFF = (double) 0;
    private static final double NOTE_E6 = (double) 1318.51;
    private static final double NOTE_B5 = (double) 987.767;
    private static final double NOTE_A5sharp = (double) 932.328;
    private static final double NOTE_A5 = (double) 880;
    private static final double NOTE_G5sharp = (double) 830.609;
    private static final double NOTE_G5 = (double) 783.991;
    private static final double NOTE_F5sharp = (double) 739.989;
    private static final double NOTE_F5 = (double) 698.456;
    private static final double NOTE_E5 = (double) 659.255;
    private static final double NOTE_D5sharp = (double) 622.254;
    private static final double NOTE_DS5 = (double) 622.254;
    private static final double NOTE_D5 = (double) 587.33;
    private static final double NOTE_C5sharp = (double) 554.365;
    private static final double NOTE_C5 = (double) 523.251;
    private static final double NOTE_B4 = (double) 493.883;
    private static final double NOTE_A4sharp = (double) 466.164;
    private static final double NOTE_A4 = (double) 440;
    private static final double NOTE_G4sharp = (double) 415.305;
    private static final double NOTE_GS4 = (double) 415.305;
    private static final double NOTE_G4 = (double) 391.995;
    private static final double NOTE_F4sharp = (double) 369.994;
    private static final double NOTE_F4 = (double) 349.228;
    private static final double NOTE_E4 = (double) 329.628;
    private static final double NOTE_D4sharp = (double) 311.127;
    private static final double NOTE_DS4 = (double) 311.127;
    private static final double NOTE_D4 = (double) 293.665;
    private static final double NOTE_C4sharp = (double) 277.183;
    private static final double NOTE_C4 = (double) 261.626;

    // Fur Elise: https://en.wikipedia.org/wiki/F%C3%BCr_Elise
    public static Music furElise = new Music(
        new double[]{ NOTE_E5, NOTE_DS5, NOTE_E5, NOTE_DS5, NOTE_E5, NOTE_B4, NOTE_D5, NOTE_C5, NOTE_A4, NOTE_C4,
        NOTE_E4, NOTE_A4, NOTE_B4, NOTE_E4, NOTE_GS4, NOTE_B4, NOTE_C5, NOTE_E4, NOTE_E5, NOTE_DS5, NOTE_E5, NOTE_DS5,
        NOTE_E5, NOTE_B4, NOTE_D5, NOTE_C5, NOTE_A4, NOTE_C4, NOTE_E4, NOTE_A4, NOTE_B4, NOTE_E4, NOTE_C5, NOTE_B4,
        NOTE_A4, NOTE_B4, NOTE_C5, NOTE_D5, NOTE_E5, NOTE_G4, NOTE_F5, NOTE_E5, NOTE_D5, NOTE_F4, NOTE_E5, NOTE_D5,
        NOTE_C5, NOTE_E4, NOTE_D5, NOTE_C5, NOTE_B4, NOTE_E4, NOTE_E5, NOTE_E4, NOTE_E5, NOTE_E4, NOTE_E5, NOTE_E4,
        NOTE_E5, NOTE_DS4, NOTE_E5, NOTE_D4, NOTE_E5, NOTE_DS4, NOTE_E5, NOTE_B4, NOTE_D5, NOTE_C5, NOTE_A4, NOTE_C4,
        NOTE_E4, NOTE_A4, NOTE_B4, NOTE_E4, NOTE_GS4, NOTE_B4, NOTE_C5, NOTE_E4, NOTE_E5, NOTE_DS5, NOTE_E5, NOTE_DS5,
        NOTE_E5, NOTE_B4, NOTE_D5, NOTE_C5, NOTE_A4, NOTE_C4, NOTE_E4, NOTE_A4, NOTE_B4, NOTE_E4, NOTE_C5, NOTE_B4,
        NOTE_A4, NOTE_OFF},
        new int[]{ 111, 111, 111, 111, 111, 111, 111, 111, 333, 111, 111, 111, 333, 111, 111, 111, 333, 111, 111,
        111, 111, 111, 111, 111, 111, 111, 333, 111, 111, 111, 333, 111, 111, 111, 333, 111, 111, 111, 333, 111, 111, 111,
        333, 111, 111, 111, 333, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111,
        111, 111, 111, 333, 111, 111, 111, 333, 111, 111, 111, 333, 111, 111, 111, 111, 111, 111, 111, 111, 111, 333, 111,
        111, 111, 333, 125, 125, 125, 999, 111, }
    );

    // https://musescore.com/punctuationless/never-gonna-give-you-up
    // if i have to retranscribe this i will be very sad :(
    public static Music rickroll = new Music(
        new double[]{
            NOTE_F4, NOTE_G4, NOTE_C4, NOTE_G4, NOTE_A4, NOTE_C5, NOTE_A4sharp, NOTE_A4, NOTE_F4, NOTE_G4, NOTE_C4, NOTE_E4, NOTE_F4, NOTE_F4, // Intro with second repeat
            NOTE_OFF, NOTE_D4, NOTE_E4, NOTE_F4, NOTE_F4, NOTE_G4, NOTE_E4, NOTE_D4, NOTE_D4, NOTE_E4, NOTE_F4, NOTE_D4, NOTE_C4, NOTE_C5, NOTE_C5, NOTE_G4, NOTE_OFF, NOTE_E4, NOTE_D4, NOTE_C4, NOTE_OFF, // what im thinking of
            NOTE_OFF, NOTE_D4, NOTE_D4, NOTE_E4, NOTE_F4, NOTE_D4, NOTE_C4, NOTE_G4, NOTE_G4, NOTE_G4, NOTE_A4, NOTE_G4, // any other guy
        },
        // 444 = quarter?
        new int[]{
            666, 666, 444, 666, 666, 111, 111, 222, 666, 666, 999, 222, 222, 444,
            222, 222, 222, 222, 222, 999, 222, 222, 222, 222, 444, 
            // i give up rick let me down ima add some dummy values and hopefully its longer than the array above
            444, 444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,444,
        }
    );


}



