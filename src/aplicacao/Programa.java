package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidade.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int num = sc.nextInt();
		System.out.print("Data Check-in(dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data check-out(dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data do Check-out deve ser posterior a data de Check-in");
		}else {
			Reserva reserv = new Reserva(num, checkIn, checkOut);
			System.out.println(reserv);
			System.out.println();
			System.out.println("Entre com uma data para atualizar a reserva ");
			System.out.print("Data Check-in(dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data check-out(dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserv.atualizarDatas(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na reserva: " +  erro);
			}else {
			System.out.println(reserv);
			}
		sc.close();
	}
	}
}

