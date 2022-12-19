package Fitxers;
    public class ListaBienes {
        private Bienes[] Llista;
        private int numBienes;

        public ListaBienes(int dim) {
            Llista = new Bienes[dim];
            numBienes= 0;
        }

        public void afegirBien(Bienes p) {
            if (numBienes >= Llista.length) {
                Bienes[] aux = new Bienes[Llista.length * 2];
                for (int i = 0; i < numBienes; i++)
                    aux[i] = Llista[i];
                Llista = aux;
            }
            Llista[numBienes]=p.copia();
            numBienes++;
        }

        public int getnumBienes() {
            return numBienes;
        }

        public Bienes getLLista(int i) {
            return Llista[i];
        }


        public String toString(int i) {
            return (Llista[i].toString());
        }

    }

