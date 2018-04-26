
/**
 * Escreva a descrição da classe Weather aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Weather
{
    //temperatura em ºC -> ]0, 45[
    private static final int MIN_TEMP = 0;
    private static final int MAX_TEMP = 45;
    //humidade em % -> ]0 a 100[
    private static final int MIN_HUMIDITY = 0;
    private static final int MAX_HUMIDITY = 100;
    //velocidade vento em km/h -> ]0 a 100[
    private static final int MIN_WIND_SPEED = 0;
    private static final int MAX_WIND_SPEED = 100;
    //temperatura
    private int temperature;
    //humidade
    private int humidity;
    //velocidade do vento
    private int windSpeed;

    /* COnstrutor por default*/
    public Weather() {
        this(0, 0, 0);
    }

    /* COnstrutor */
    public Weather(int temperature, int humidity, int windSpeed) {
        //e se for valida
        if (isDatesValid(temperature, humidity, windSpeed)) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.windSpeed = windSpeed;
        }// e se nao for valida
        else {
            this.temperature = 0;
            this.humidity = 0;
            this.windSpeed = 0;
        }
    }

    // mostrar dados do tempo
    public void showInf() {
        System.out.println("-- TEMPO --");
        System.out.println("Temperatura: " + temperature + "ºC");
        System.out.println("Humidade: " + humidity + "%");
        System.out.println("Velocidade de Vento: " + windSpeed + "km/h");
    }

    /* Metódo para validar os dados de entrada */
    private boolean isDatesValid(float newTemperature, float newHumidity, int newWindSpeed) {
        //se temperatura for válida 
        if ((isTemperatureValid(newTemperature) == true)
                //se humidade for válida 
                && (isHumidityValid(newHumidity) == true)
                // velocidade do vento for valida
                && (isWindSpeedValid(newWindSpeed))) {
            //retorna verdadeira
            return true;
        }
        //se for o contrário, retorna falso
        return false;
    }

    /* Metódo para validar temperatura*/
    public static boolean isTemperatureValid(float newTemperature) {
        //se latitude estiver entre 0ºC
        if ((newTemperature >= Weather.MIN_TEMP)
                // e45ºC
                && (newTemperature <= Weather.MAX_TEMP)) {
            //retorna verdadeira
            return true;
        }//se for o contrário, retorna falso
        return false;
    }

    /* Metódo para validar humidade */
    public static boolean isHumidityValid(float newHumidity) {
        //se humidade estiver entre 0%
        if ((newHumidity >= Weather.MIN_HUMIDITY)
                // e 100%
                && (newHumidity <= Weather.MAX_HUMIDITY)) {
            //retorna verdadeira
            return true;
        }//se for o contrário, retorna falso
        return false;
    }

    /* Metódo para validar velocidade do vento */
    public static boolean isWindSpeedValid(float newWindSpeed) {
        //se humidade estiver entre 0km/h
        if ((newWindSpeed >= Weather.MIN_WIND_SPEED)
                // e 100km/h
                && (newWindSpeed <= Weather.MAX_WIND_SPEED)) {
            //retorna verdadeira
            return true;
        }//se for o contrário, retorna falso
        return false;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }
}
