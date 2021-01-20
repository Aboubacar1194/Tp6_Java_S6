package exercice1.premierTestJunit;

/**
 * Classe Entier destine a contenir un nombre entier.
 * La classe est modifiable.
 * @author L. Torres
 *
 */
public class Entier {
        /**
         * Valeur entiere
         */
        private int valeur;

        /**
         * Creeun entier de valeur donnee en parametre.
         * @param nombre pour initialiser la valeur de l'entier
         */
        public Entier( int nombre ) {
            valeur = nombre;
        }

        /**
         * Cree un entier de valeur 0.
         */
        public Entier( ) {
            this(0);
        }

        /**
         * Double la valeur de l'entier.
         */
        public void doubler() {
            valeur *= 2;
        }

        /**
         * Renvoie la valeur de l'entier.
         * @return la valeur de l'entier
         */
        public int valeur() {
            return valeur;
        }

}
