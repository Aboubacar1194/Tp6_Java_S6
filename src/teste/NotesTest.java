package teste;

import exercice2DesNotes.notation.Notes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NotesTest {

    @Nested
    class lesNotes{

        Notes notes ;
        @BeforeEach
        void initialisation(){
           notes = new Notes(3);
           notes.ajout(2);
           notes.ajout(15);
        }

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
                    () -> { Assertions.assertTrue(notes.capacite() == 3); },
                    () -> { Assertions.assertFalse(notes.capacite() > 3); },
                    () -> { Assertions.assertFalse(notes.capacite() < 3); }
                    );
        }

        @Test
        void min() {
            notes.ajout(20);
            Assertions.assertAll(
                    () -> { Assertions.assertTrue(notes.min() == 2); },
                    () -> { Assertions.assertFalse(notes.min() < 2); },
                    () -> { Assertions.assertFalse(notes.min() > 2); }
                    );
        }

        @Test
        void max() {
            notes.ajout(1);
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

                    () -> { notes.ajout(13);
                            Assertions.assertTrue(notes.moyenne() == 10.0); }
            );

        }

        @Test
        void nombre() {
            Assertions.assertAll(
                    () -> {  Assertions.assertTrue(notes.nombre() == 2); },

                    () -> { notes.ajout(20);
                        Assertions.assertTrue(notes.nombre() == 3); }
            );

        }
    }




}