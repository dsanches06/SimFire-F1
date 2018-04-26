import java.text.*;
import java.util.*;
/**
 * Escreva a descrição da classe Time aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Time
{
     //hora
    private int hour;
    //minuto
    private int minute;

    /* Construtor por defualt */
    public Time() {
        this.hour = 0;
        this.minute = 0;
    }

    /* Construtor que recebe hora e minuto */
    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /* Construtor que recebe a hora do sistema */
    public Time(Time time) {
        this.hour = time.hour;
        this.minute = time.minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    //mostrar horas
    public void showTime() {
        System.out.format("%02dh%02d\n", this.hour, this.minute);
    }

    //obter a hora do sistema
    public static Time getSistemTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date horaSistema = Calendar.getInstance().getTime();
        String dataFormatada = sdf.format(horaSistema);
        String hora = dataFormatada.charAt(0) + "" + dataFormatada.charAt(1);
        String minuto = dataFormatada.charAt(3) + "" + dataFormatada.charAt(4);
        Time time = new Time(Integer.valueOf(hora), Integer.valueOf(minuto));
        return time;
    }
}
