package com.example.synthesizer;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener {

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCsharp;
    private Button buttonD;
    private Button buttonDsharp;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFsharp;
    private Button buttonG;
    private Button buttonGsharp;
    private Button buttonPlayScale;
    private Button buttonPlayScaleE;
    private Button buttonChallenge2;
    private Button buttonTwinkle;
    private Button buttonMii;
    private NumberPicker numberPickerTimes;
    private NumberPicker numberPickerNote;
    private Map<Integer, Integer> noteMap;

    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCsharp;
    private int noteD;
    private int noteDsharp;
    private int noteE;
    private int noteF;
    private int noteFsharp;
    private int noteG;
    private int noteGsharp;

    private Button buttonHighA;
    private Button buttonHighBb;
    private Button buttonHighB;
    private Button buttonHighC;
    private Button buttonHighCsharp;
    private Button buttonHighD;
    private Button buttonHighDsharp;
    private Button buttonHighE;
    private Button buttonHighF;
    private Button buttonHighFsharp;
    private Button buttonHighG;
    private Button buttonHighGsharp;
    private int noteHighA;
    private int noteHighBb;
    private int noteHighB;
    private int noteHighC;
    private int noteHighCsharp;
    private int noteHighD;
    private int noteHighDsharp;
    private int noteHighE;
    private int noteHighF;
    private int noteHighFsharp;
    private int noteHighG;
    private int noteHighGsharp;
    private int noteHighHighAsharp;
    private int noteHighHighB;
    private int noteHighHighCsharp;
    private int noteHighHighD;
    private int noteHighHighFsharp;
    private int noteHighHighA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
        initializeNumberPickers();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        // in a map, you store a key:value pair
        // key is button id
        // value is note id
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_csharp, noteCsharp);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_dsharp, noteDsharp);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fsharp, noteFsharp);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gsharp, noteGsharp);
        noteMap.put(R.id.button_synth_highA, noteHighA);
        noteMap.put(R.id.button_synth_highB, noteHighB);
        noteMap.put(R.id.button_synth_highBb, noteHighBb);
        noteMap.put(R.id.button_synth_highC, noteHighC);
        noteMap.put(R.id.button_synth_highCsharp, noteHighCsharp);
        noteMap.put(R.id.button_synth_highD, noteHighD);
        noteMap.put(R.id.button_synth_highDsharp, noteHighDsharp);
        noteMap.put(R.id.button_synth_highE, noteHighE);
        noteMap.put(R.id.button_synth_highF, noteHighF);
        noteMap.put(R.id.button_synth_highFsharp, noteHighFsharp);
        noteMap.put(R.id.button_synth_highG, noteHighG);
        noteMap.put(R.id.button_synth_highGsharp, noteHighGsharp);


    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCsharp = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDsharp = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFsharp = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGsharp = soundPool.load(this, R.raw.scalegs, 1);

        noteHighA = soundPool.load(this, R.raw.scalehigha, 1);
        noteHighBb = soundPool.load(this, R.raw.scalehighbb, 1);
        noteHighB = soundPool.load(this, R.raw.scalehighb, 1);
        noteHighC = soundPool.load(this, R.raw.scalehighc, 1);
        noteHighCsharp = soundPool.load(this, R.raw.scalehighcs, 1);
        noteHighD = soundPool.load(this, R.raw.scalehighd, 1);
        noteHighDsharp = soundPool.load(this, R.raw.scalehighds, 1);
        noteHighE = soundPool.load(this, R.raw.scalehighe, 1);
        noteHighF = soundPool.load(this, R.raw.scalehighf, 1);
        noteHighFsharp = soundPool.load(this, R.raw.scalehighfs, 1);
        noteHighG = soundPool.load(this, R.raw.scalehighg, 1);
        noteHighGsharp = soundPool.load(this, R.raw.scalehighgs, 1);
        noteHighHighA = soundPool.load(this, R.raw.scalehighhigha, 1);
        noteHighHighFsharp = soundPool.load(this, R.raw.scalehighhighfs, 1);
        noteHighHighD = soundPool.load(this, R.raw.scalehighhighd, 1);
        noteHighHighCsharp = soundPool.load(this, R.raw.scalehighhighcs, 1);
        noteHighHighB = soundPool.load(this, R.raw.scalehighb, 1);
        noteHighHighAsharp = soundPool.load(this, R.raw.scalehighas, 1);

    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCsharp.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDsharp.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFsharp.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGsharp.setOnClickListener(noteListener);
        buttonPlayScale.setOnClickListener(this);
        buttonPlayScaleE.setOnClickListener(this);

        buttonHighA.setOnClickListener(noteListener);
        buttonHighBb.setOnClickListener(noteListener);
        buttonHighB.setOnClickListener(noteListener);
        buttonHighC.setOnClickListener(noteListener);
        buttonHighCsharp.setOnClickListener(noteListener);
        buttonHighD.setOnClickListener(noteListener);
        buttonHighDsharp.setOnClickListener(noteListener);
        buttonHighE.setOnClickListener(noteListener);
        buttonHighF.setOnClickListener(noteListener);
        buttonHighFsharp.setOnClickListener(noteListener);
        buttonHighG.setOnClickListener(noteListener);
        buttonHighGsharp.setOnClickListener(noteListener);

        buttonChallenge2.setOnClickListener(this);
        buttonTwinkle.setOnClickListener(this);
        buttonMii.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonB = findViewById(R.id.button_synth_b);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCsharp = findViewById(R.id.button_synth_csharp);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDsharp = findViewById(R.id.button_synth_dsharp);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFsharp = findViewById(R.id.button_synth_fsharp);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGsharp = findViewById(R.id.button_synth_gsharp);
        buttonPlayScale = findViewById(R.id.button_synth_scale);
        buttonPlayScaleE = findViewById(R.id.button_synth_scaleE);
        buttonChallenge2 = findViewById(R.id.button_synth_challenge2);
        buttonTwinkle = findViewById(R.id.button_synth_twinkle);
        buttonMii = findViewById(R.id.button_synth_mii);
        numberPickerNote = findViewById(R.id.numberPicker_synth_note);
        numberPickerTimes = findViewById(R.id.numberPicker_synth_times);

        buttonHighA = findViewById(R.id.button_synth_highA);
        buttonHighB = findViewById(R.id.button_synth_highB);
        buttonHighBb = findViewById(R.id.button_synth_highBb);
        buttonHighC = findViewById(R.id.button_synth_highC);
        buttonHighCsharp = findViewById(R.id.button_synth_highCsharp);
        buttonHighD = findViewById(R.id.button_synth_highD);
        buttonHighDsharp = findViewById(R.id.button_synth_highDsharp);
        buttonHighE = findViewById(R.id.button_synth_highE);
        buttonHighF = findViewById(R.id.button_synth_highF);
        buttonHighFsharp = findViewById(R.id.button_synth_highFsharp);
        buttonHighG = findViewById(R.id.button_synth_highG);
        buttonHighGsharp = findViewById(R.id.button_synth_highGsharp);


    }

    @Override
    public void onClick(View view) {
        // one method to handle the clicks of all the buttons
        // but don't forget to tell the buttons who is doing the listening
        switch (view.getId()) {
            case R.id.button_synth_scale:
                playScale();
                break;
            case R.id.button_synth_scaleE:
                playScaleE();
                break;
            case R.id.button_synth_challenge2:
                promptResponse();
                break;
            case R.id.button_synth_twinkle:
                playTwinkle();
                break;
            case R.id.button_synth_mii:
                playMii();
        }
    }

    private void playMii() {
        Song scale = new Song();

        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteD, Note.WHOLE_NOTE));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE));
//      scale.add(new Note(noteHighDsharp, Note.WHOLE_NOTE));
        scale.add(new Note(noteHighD, Note.WHOLE_NOTE));
        scale.add(new Note(noteGsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteGsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, 0));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteC, 0));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteC, 0));
        scale.add(new Note(noteE, Note.WHOLE_NOTE));
        scale.add(new Note(noteC, 0));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteC, 0));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteC, 0));
        scale.add(new Note(noteE, Note.WHOLE_NOTE));
        scale.add(new Note(noteDsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE));
        scale.add(new Note(noteHighB, Note.WHOLE_NOTE));
        scale.add(new Note(noteHighB, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighB, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, Note.WHOLE_NOTE));
        scale.add(new Note(noteHighHighAsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighHighB, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighHighCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighHighD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighHighFsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighHighA, Note.WHOLE_NOTE));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteB, Note.WHOLE_NOTE));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteB, Note.WHOLE_NOTE * 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteDsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteDsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteB, Note.WHOLE_NOTE));
        scale.add(new Note(noteDsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, 0));
        scale.add(new Note(noteGsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, 0));
        scale.add(new Note(noteGsharp, Note.WHOLE_NOTE / 4));
        scale.add(new Note(noteE, 0));
        scale.add(new Note(noteGsharp, Note.WHOLE_NOTE / 2));

        playSong(scale);


    }

    private void playTwinkle() {
        Song scale = new Song();

        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE));

        for (int i = 0; i < 2; i++) {
            scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
            scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
            scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
            scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
            scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
            scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
            scale.add(new Note(noteB, Note.WHOLE_NOTE));
        }

        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE));

        playSong(scale);
    }


    private void promptResponse() {
        int[] noteIDs = new int[]{
                noteA, noteB, noteBb, noteC, noteCsharp, noteD, noteDsharp, noteE, noteF, noteFsharp, noteG, noteGsharp,
                noteHighA, noteHighB, noteHighBb, noteHighC, noteHighCsharp, noteHighD, noteHighDsharp, noteHighE, noteHighF, noteHighFsharp, noteHighG, noteHighGsharp
        };
        for (int i = 0; i < numberPickerTimes.getValue(); i++) {
            playNote(new Note(noteIDs[numberPickerNote.getValue()]));
            delay(1000);
        }
    }

    private void initializeNumberPickers() {
        String[] notes = new String[]{
                "A", "B♭", "B", "C", "C♯", "D", "D♯", "E", "F", "F♯", "G", "G♯",
                "A'", "B♭'", "B'", "C'", "C♯'", "D'", "D♯'", "E'", "F'", "F♯'", "G'", "G♯'"
        };
        numberPickerNote.setMaxValue(23);
        numberPickerNote.setMinValue(0);
        numberPickerNote.setDisplayedValues(notes);
        numberPickerTimes.setMinValue(0);
        numberPickerTimes.setMaxValue(20);

    }

    private void playScaleE() {
        Song scale = new Song();

        scale.add(new Note(noteE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));

        playSong(scale);


    }

    private void playSong(Song scale) {
        for (Note note : scale.getNotes()) {
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void playScale() {
        Song scale = new Song();
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteDsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteGsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighCsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighDsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighFsharp, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteHighGsharp, Note.WHOLE_NOTE / 2));

        playSong(scale);

    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note) {
        playNote(note, 0);
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }

    private void playNote(Note note) {
        playNote(note.getNoteID(), 0);
    }

    // make an inner class to handle the button clicks for individual notes

    private class KeyboardNoteListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            // get the id of the button that was clicked
            int id = view.getId();
            // use the map to figure out what note to play
            int note = noteMap.get(id);
            // play the note
            playNote(note);
        }
    }


}

