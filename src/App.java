import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Ingrese su operacion:\n" +
        "Solo se admiten numeros y caracteres de operacion: + - * /\n");

        Scanner sc = new Scanner(System.in);

        String op = sc.nextLine();

        if (!op.matches("[0-9+\\-*/]+")) {
            System.out.println("Error: La cadena contiene caracteres no válidos.");
            return;
        }

        Pattern pattern = Pattern.compile("\\d+|[\\+\\-\\*/]");
        Matcher matcher = pattern.matcher(op);

        List<String> cadena = new ArrayList<>();

        matcher.reset();

        while(matcher.find()){
            cadena.add(matcher.group());
        }

        List<Integer> numeros = new ArrayList<>();
        List<Character> operadores = new ArrayList<>();

        for(String c : cadena){
            if(c.matches("\\d+")){
                numeros.add(Integer.parseInt(c));
            }else{
                operadores.add(c.charAt(0));
            }
        }

        int[] n = new int[numeros.size()];
        char[] o = new char[operadores.size()];

        int i = 0;
        System.out.println("Operadores");
        for (Character c : operadores) {
            o[i] = c;
            System.out.print(c + " ");
            i++;
        }

        int j = 0;
        System.out.println("\nNumeros");
        for (int num : numeros) {
            n[j] = num;
            System.out.print(num + " ");
            j++;
        }

        Operaciones operaciones = new Operaciones(n, o);
        System.out.println("\nresultado: " + operaciones.operacion());
    }
}
