
/**
 * Escreva a descrição da classe Fire aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Fire
{
     //loclaizaçao
    private Location location;
    //area ocupada pelo fogo
    private int area;
    //duvidas - meios alocado ao combate
    //hora inicio
    private Time begin;
    //hora final
    private Time end;
    //fogo existe
    private boolean isFireExist;

    /* Construtor */
    public Fire(Location location, Time begin) {
        //se localizaçao for valida
        if ((location.isLocationValid(location))
                //e tiver hora do inicio de fogo
                && (begin != null)) {
            this.location = location;
            this.area = 0;//sera calculada conforme a propagaçao do fogo
            this.begin = begin;
            this.end = null;
            if (end == null) {
                this.isFireExist = true;
            }
        }
    }

    /* Construtor */
    public Fire(Location location, int area, Time begin) {
        //se localizaçao for valida
        if ((location.isLocationValid(location))
                //e tiver hora do inicio de fogo
                && (begin != null)) {
            this.location = location;
            this.area = area;
            this.begin = begin;
            this.end = null;
            if (end == null) {
                this.isFireExist = true;
            }
        }
    }

    //para ver se o fogo foi apagado
    public boolean isFireErase() {
        //verifica se o fogo existe
        if (isFireExist == true) {
            return false;
        }
        //obter a hora do sistema
        this.end = Time.getSistemTime();
        return true;
    }

    //mostrar dados dos fogo
    public void showInf() {
        System.out.println(" -- DADOS DO FOGO --");
        this.location.showInf();
        System.out.println("   Area        : " + this.area + "m2");
        System.out.print("   Hora de Inicio: ");
        this.begin.showTime();
        if (this.end != null || isFireErase() == true) {
            System.out.print("   Hora de Fim: ");
            this.end.showTime();
        } else {
            System.out.println("   Hora de Fim: N/A");
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Time getBegin() {
        return begin;
    }

    public void setBegin(Time begin) {
        this.begin = begin;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public boolean isIsFireExist() {
        return isFireExist;
    }

    public void setIsFireExist(boolean isFireExist) {
        this.isFireExist = isFireExist;
    }
}

