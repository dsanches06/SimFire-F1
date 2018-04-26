
/**
 * Escreva a descrição da classe CombatVehicle aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CombatVehicle
{
    
    //capacidade maxima entre 1500 a 20000 litros de aguas em ]500[
    private static final int MIN_WATER_CAPACITY = 1500;
    private static final int MAX_WATER_CAPACITY = 20000;
    //lugar maximo de 8 bombeiros
    private static final int MAX_FIREMAN = 8;
    //lugar minimos para 3 bombeiros
    private static final int MIN_FIREMAN = 3;
    //para gerar novo id
    private static int nextNumber = 0;
    //id
    private int id;
    // capacidade atual de agua
    private int waterCapacity;
    //quartel
    private Quarter quarter;
    //localizaçao  
    private Location location;
    //incendio (tipo)
    private Fire fire;
    //lista de lugares para bomeiros
    private Fireman[] firemans;
    //contador de bombeiro
    private int countFireman;

    /* Construtor */
    public CombatVehicle(int waterCapacity) {
        //se a capacidade da agua estiver nos limites
        if (isWaterCapacityValid(waterCapacity) == true) {
            this.id = ++CombatVehicle.nextNumber;
            this.location = null;
            this.quarter = null;
            this.waterCapacity = waterCapacity;
            this.firemans = new Fireman[MAX_FIREMAN];
            this.countFireman = 0;
            this.fire = null;
        }
    }

    //mostrar dados do veiculos
    public void showInf() {
        System.out.format(" VEICULO ID    : %02d\n", this.id);
        this.location.showInf();
        System.out.println(" Capacidade    : " + this.waterCapacity + "L");
        if (this.quarter != null) {
            System.out.println("   Quartel     : " + this.quarter.getName());
            this.quarter.getLocation().showInf();
        } else {
            System.out.println("   Quartel         : N/A");
        }
        System.out.println(" Lugares Ocupados   : " + this.countFireman);
        System.out.println(" Lugares Disponiveis: " + this.getAvailablePlace());
        //mostrar apenas os dados do bombeiro condutor

        if (this.countFireman > 0) {
            System.out.print(" -- DADOS DO CONDUTOR --");
            for (int i = 0; i < this.countFireman; i++) {
                //se for habilitado a conduzir
                if (this.firemans[i].isIsAbleToDrive() == true) {
                    this.firemans[i].showInf();
                }
            }
        } else {
            System.out.format(" Condutor do Veiculo %02d : N/A \n", this.id);
        }

        //mostrar os restantes bombeiro
        if (this.countFireman > 0) {
            System.out.print("\n -- DADOS DOS BOMBEIROS NO VEICULO --");
            for (int i = 0; i < this.countFireman; i++) {
                this.firemans[i].showInf();
                System.out.println("");
            }
        } else {
            System.out.format(" Bombeiros no Veiculo %02d: N/A\n", this.id);
        }

        if (this.fire != null) {
            this.fire.showInf();
        } else {
            System.out.println(" Combate ao Fogo : N/A");
        }

    }

    /*
      Metodo para validar meios de alocaçao
      verificar se existe no min=3 e max=8 bombeiros no veiculo
      sendo 1 condutor + os restantes bombeiro ajudante
     */
    public boolean validMeansOfAllocationOfCombat() {
        //se tiver 3 ou mais bombeiros
        if ((this.countFireman >= CombatVehicle.MIN_FIREMAN)
                //e tiver no maximo 8 bombeiros
                && (this.countFireman <= CombatVehicle.MAX_FIREMAN)
                //e existir 1 condutor
                && (this.existFiremanAbleToDrive() == true)
                //e tiver agua suficiente
                && (isWaterCapacityValid(waterCapacity) == true)) {
            //retorna falso
            return true;
        }//se for o contrario, retorna falso
        return false;
    }


    /* Metódo para validar a capacidade da agua*/
    private boolean isWaterCapacityValid(int newWaterCapacity) {
        //se latitude estiver entre 1500
        if ((newWaterCapacity >= CombatVehicle.MIN_WATER_CAPACITY)
                // e 20000
                && (newWaterCapacity <= CombatVehicle.MAX_WATER_CAPACITY)) {
            //retorna verdadeira
            return true;
        }
        //se for o contrário, retorna falso
        return false;
    }

    //obter lugar disponivel
    private int getAvailablePlace() {
        int total = this.firemans.length - this.countFireman;
        return total;
    }

    //verificar se ja existe condutor no veiculo
    private boolean existFiremanAbleToDrive() {
        //faz o loop
        for (int i = 0; i < this.countFireman; i++) {
            //se tiver habilitaçao para conduzir
            if (this.firemans[i].isIsAbleToDrive() == true) {
                //retorna verdadeira
                return true;
            }
        }//retorna falso
        return false;
    }

    //se ja existe condutor no veiculo
    private boolean existFiremanToDrive(Fireman fireman) {
        //se tiver habilitaçao para conduzir
        if (existFiremanAbleToDrive()
                && fireman.isIsAbleToDrive() == true) {
            //retorna verdadeira
            return true;
        }//retorna falso
        return false;
    }

    //adicionar bombeiro
    public boolean addFireman(Fireman fireman) {
        //se bombeiro existir
        if (existFireman(fireman.getId()) == true) {
            //retorna falso
            return false;
        } //ou se ja existe 1 condutor
        else if (existFiremanToDrive(fireman) == true) {
            //retorna falso
            return false;
        }//se for igual 8 lugares ocupado
        else if (this.countFireman == CombatVehicle.MAX_FIREMAN) {
            //retorna falso
            return false;
        }
        //adicona o bombeiro no veiculo
        fireman.setVehicles(this);
        //adiciona ao array 
        firemans[countFireman] = fireman;
        //incrementa a posicao no array
        countFireman++;
        //retorna verdadeira
        return true;
    }

    //adicionar bombeiro
    public Fireman removeFireman(int firemanID) {
        int idx;
        Fireman firemanRemove = null;
        //se bombeiro existir
        if (existFireman(firemanID) == true) {
            //obter a posição do camião
            idx = indexOfFiremanByID(firemanID);
            //se for diferente de - 1
            if (idx != -1) {
                //cria uma cópia
                firemanRemove = firemans[idx];
                //faz o loop
                for (int i = idx; i < countFireman - 1; i++) {
                    //elimina da posição
                    firemans[idx] = firemans[idx + 1];
                }//diminui a quantidade - 1
                countFireman--;
            }
        }//retorna o bombeiro removido
        return firemanRemove;
    }

    /* Metódo que valida o bombeiro no quartel */
    public boolean existFireman(int firemanID) {
        int idx;
        //se tiver bombeiro
        if (this.countFireman > 0) {
            //obter a posição do camião
            idx = indexOfFiremanByID(firemanID);
            //se for diferente de - 1
            if (idx != -1) {
                //retorna verdadeira
                return true;
            }
        }//se for o contrário, retorna falso
        return false;
    }

    /* Metódo para obter a posição do bombeiro no quartel */
    private int indexOfFiremanByID(int firemanID) {
        //faz o loop
        for (int i = 0; i < countFireman; i++) {
            //se não for nula
            if ((firemans[i] != null)
                    //e tiver o mesmo codigo
                    && (firemans[i].getId() == firemanID)) {
                //retorna a posição no array
                return i;
            }
        }//se for o contrário, retorna -1
        return -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(int waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        //se a localizaçao for valida
        if (location.isLocationValid(location)) {
            this.location = location;
        }
    }

    public Fire getFire() {
        return fire;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }

    public Fireman[] getFiremans() {
        return firemans;
    }

    public void setFiremans(Fireman[] firemans) {
        this.firemans = firemans;
    }

}
