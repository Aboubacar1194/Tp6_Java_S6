package teste;

import exercice2DesNotes.notation.Notes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class NotesTest {

    @Nested
    class lesNotes{

        Notes notes ;
        @BeforeEach
        void initialisation(){
           notes = new Notes(3);
           notes.ajoute(2.0f);
           notes.ajoute(15.0f);
        }

        @ParameterizedTest
        @ValueSource(ints = {10,15,20})
        void ajout(int value) {
            Assertions.assertTrue(notes.ajoute(value));
        }
        @ParameterizedTest
        @ValueSource(ints = {-1,-5,21,30})
        void ajoute(int value) {
            Assertions.assertAll(
                    () -> { Assertions.assertFalse(notes.ajoute(value)); },
                    () -> { Assertions.assertFalse(notes.ajoute(value)); }
            );
        }

       /* @Test
        void capaciteAtteinte() {
            Assertions.assertFalse(notes.capaciteAtteinte());
        }*/

        @Test
        void capacite() {
            Assertions.assertAll(
                    () -> { Assertions.assertTrue(notes.capacite() == 3); },
                    () -> { Assertions.assertFalse(notes.capacite() > 3); },
                    () -> { Assertions.assertFalse(notes.capacite() < 3); }
                    );
        }

        @Test
        void min() {
            Assertions.assertAll(

                    () -> { Assertions.assertTrue(notes.min() == 0); },
                    () -> { notes.ajoute(2.0f);
                        System.out.println(Arrays.toString(notes.notes));
                        System.out.println(notes.min());
                            Assertions.assertTrue(notes.min() == 2); },
                    () -> { Assertions.assertFalse(notes.min() > 2); }
                    );
        }

        @Test
        void max() {
            notes.ajoute(1);
            Assertions.assertAll(
                    () -> { Assertions.assertTrue(notes.max() == 15); },
                    () -> { Assertions.assertFalse(notes.max() < 15); },
                    () -> { Assertions.assertFalse(notes.max() > 15); }
            );

        }

        @Test
        void moyenne() {
            Assertions.assertAll(
                    () -> {  Assertions.assertTrue(notes.moyenne() == 8.5); },

                    () -> { notes.ajoute(13);
                            Assertions.assertTrue(notes.moyenne() == 10.0); }
            );

        }

        @Test
        void nombre() {
            Assertions.assertAll(
                    () -> {  Assertions.assertTrue(notes.nombre() == 2); },

                    () -> { notes.ajoute(20);
                        Assertions.assertTrue(notes.nombre() == 3); }
            );

        }
    }




}