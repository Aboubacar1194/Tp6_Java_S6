package teste;

import exercice2DesNotes.notation.Notes;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class NotesTest {

    @Nested
    class lesNotes{

        Notes notes = new Notes(1);

        @ParameterizedTest
        @ValueSource(ints = {0,10,15,20})
        void ajout(int value) {
            Assertions.assertTrue(notes.ajout(value));
        }
        @ParameterizedTest
        @ValueSource(ints = {-1,-5,21,30})
        void ajoute(int value) {
            Assertions.assertAll(
                    () -> { Assertions.assertFalse(notes.ajout(value)); },
                    () -> { Assertions.assertFalse(notes.ajout(value)); }
            );
        }

        @Test
        void capaciteAtteinte() {
            Assertions.assertFalse(notes.capaciteAtteinte());
        }

        @Test
        void capacite() {
            Assertions.assertAll(
                    () -> { Assertions.assertTrue(notes.capacite() == 1); },
                    () -> { Assertions.assertFalse(notes.capacite() > 1); },
                    () -> { Assertions.assertFalse(notes.capacite() < 1); }
                    );
        }

        @Test
        void min() {
        }

        @Test
        void max() {
        }

        @Test
        void moyenne() {
        }

        @Test
        void nombre() {
        }
    }




}