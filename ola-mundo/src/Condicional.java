public class Condicional {

    public static void main(String[] args) {
        int anoDeLancamento = 2024;
        boolean incluidoNoPlano = true;
        double notaDoFilme = 10.0;
        String tipoPlano = "plus";

        if(anoDeLancamento >= 2024){
            System.out.println("Lançamento que estão em alta!");
        } else {
            System.out.println("Filme retro que vale a pena assistir");
        }

        if (incluidoNoPlano == true || tipoPlano.equals("plus")){
            System.out.println("Sistema liberado");
        } else {
            System.out.println("Deve pagar o plano");
        }
    }

}
