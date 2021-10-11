package br.compasso.avalicao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

		public class Atividade2
		{
		    public static void main(final String[] args) {
		        final Scanner entrada = new Scanner(System.in);
		        int cont = 1;
		        System.out.println("Para encerrar a aplicação digite sair");
		        while (cont != 0) {
		            int divertido = 0;
		            int chateado = 0;
		            final String pdrD = ":-\\)";
		            final String pdrC = ":-\\(";
		            final String sair = "sair";
		            final Pattern patternD = Pattern.compile(pdrD);
		            final Pattern patternC = Pattern.compile(pdrC);
		            final Pattern patternsair = Pattern.compile(sair);
		            System.out.println("Digite sua Entrada: ");
		            final String s = entrada.nextLine();
		            final Matcher matcherD = patternD.matcher(s);
		            final Matcher matcherC = patternC.matcher(s);
		            final Matcher matchersair = patternsair.matcher(s);
		            while (matchersair.find()) {
		                System.out.println("Ate a proxima!");
		                cont = 0;
		                System.exit(0);
		            }
		            while (matcherD.find()) {
		                ++divertido;
		            }
		            while (matcherC.find()) {
		                ++chateado;
		            }
		            if (divertido == chateado) {
		                System.out.println("neutro");
		            }
		            else if (divertido > chateado) {
		                System.out.println("divertido");
		            }
		            else {
		                System.out.println("chateado");
		            }
		        }
		    }
		}