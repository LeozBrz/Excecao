package modelo.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numSala;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reserva() {
	}
	
	public Reserva(Integer numSala, Date checkIn, Date checkOut) {
		this.numSala = numSala;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getnumSala() {
		return numSala;
	}

	public void setnumSala(Integer numSala) {
		this.numSala = numSala;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String atualizarDatas(Date checkIn, Date checkOut) {
		
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na Reserva: Para atualizar a reserva deve conter uma data futura";
		}
		if (!checkOut.after(checkIn)) {
			return "Erro na reserva: a data do Check-out deve ser posterior a data de Check-in";
		}	
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	public String toString() {
		return "Sala " + numSala + ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
}
