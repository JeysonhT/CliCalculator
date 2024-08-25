import java.lang.ArithmeticException;
public class Operaciones {
    int[] numeros;
    char[] operador;

    public Operaciones(int[] n, char[] o){
        this.numeros = n;
        this.operador = o;
    }

    public int operacion(){

        int resultado = numeros[0];
        for(int i = 0; i<operador.length; i++){
            switch (operador[i]) {
                case '+':
                    resultado+=numeros[i+1];
                    break;
                case '-':
                    resultado-=numeros[i+1];
                    break;
                case '*':
                    resultado*=numeros[i+1];
                    break;
                case '/':
                    try{
                        resultado/=numeros[i+1];
                    } catch (ArithmeticException e){
                        System.out.println("No se puede dividir por cero: " 
                        + e.getMessage());
                    }
                default:
                    System.out.println("Operador no valido");
                    break;
            }
        }

        return resultado;
    }
}
