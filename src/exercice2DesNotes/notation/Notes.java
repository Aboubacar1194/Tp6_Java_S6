package exercice2DesNotes.notation;

import java.util.Arrays;

public class Notes {

    public static final int NOTE_MIN = 0 ;
    public static final int NOTE_MAX = 20;
    private  int capacite = 0 ;
    public   float[] notes ;
    private  int nombreDeNotes = 0;
    private float noteMaximale = 0;
    public float noteMinimale = 0;
    public float moyenneDesNotes = 0;

    public Notes(int capacite){
        this.capacite = capacite;
        notes = new float[capacite];
    }

    public boolean ajoute(float note){
        boolean OK = false;
        if ( (nombreDeNotes < capacite) && noteAutorisee(note) ){
            OK = true;
            notes[nombreDeNotes] = note;
            ++ nombreDeNotes;
        }
        return OK;
    }

    private boolean noteAutorisee(float note){
        return (NOTE_MIN < note ) && ( note <= NOTE_MAX) ;
    }

    public boolean capaciteAtteinte(){
        return nombreDeNotes >= capacite;
    }

    public int capacite(){
        return capacite;
    }

    public float min(){
        noteMinimale = notes[0];
        for (float nombre : notes ) {
            if ( nombre <= noteMinimale )
                noteMinimale = nombre;
        }
        return noteMinimale;
    }

    public float max(){

        noteMaximale = notes[0];
        for (float nombre : notes ) {
            if ( nombre >= noteMaximale )
                noteMaximale = nombre;
        }
        return noteMaximale;
    }

    private float somme(){
        float somme = 0;
        for (float nombre : notes ) {
            somme += nombre;
        }
        return somme;
    }

    public float moyenne(){
          moyenneDesNotes = somme() / nombre();
        return moyenneDesNotes;
    }

    public int nombre(){
        return nombreDeNotes;
    }














}
