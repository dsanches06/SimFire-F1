import java.util.*;
/**
 * Escreva a descrição da classe Quarter aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Quarter
{
//capacidade maxima de veiculos
    public static final int MAX_VEHICLES = 3;
    //capacidade maxima de bombeiros
    public static final int MAX_FIREMAN = 20;
    //nome
    private String name;
    //localizaçao
    private Location location;
    //lista de veiculos
    private CombatVehicle[] vehicles;
    //lista de bomeiros
    private Fireman[] firemans;
    //contador de bombeiro
    private int countFireman;
    //contador de veiculos
    private int countVehicles;

    /* Construtor */
    public Quarter(String name, Location location) {
        //se nome for valido
        if ((isNameValid(name))
                //e localizaçao for valida
                && (location.isLocationValid(location))) {
            this.name = name;
            this.location = location;
            this.vehicles = new CombatVehicle[MAX_VEHICLES];
            this.firemans = new Fireman[MAX_FIREMAN];
            this.countFireman = 0;
            this.countVehicles = 0;
        }
    }

    //validar meios de alocaçao ao combate, validar veiculos com bombeiros e quantidade de agua?
    public boolean isMeansOfAllocationToCombatIsvalid(CombatVehicle vehicle) {
        //se o veiculo nao existir no quartel
        if (existVehicle(vehicle.getId()) != true) {
                  System.out.println("NAO VALIDO 1");
            //retorna falso
            return false;
        } //verifica ainda se nao contem condutor e bombeiro ajudante, min=3 e max=8         
        else if (vehicle.validMeansOfAllocationOfCombat() != true) {
                  System.out.println("NAO VALIDO 2");
            return false;
        }
        //
        System.out.println("VALIDO");
        //retorna verdadeira;
        return true;
    }

    /*
     metodo para validar os meios de alocaçao e mover o 
      veiculo para a posiçao do fogo 
     */
    public CombatVehicle sendVehicleToCombatFire(CombatVehicle vehicle, Fire fire) {
        //se o veiculo a enviar
        CombatVehicle vehicleRemove = null;
        //se o veiculo nao existir no quartel
        if (existVehicle(vehicle.getId()) == true) {
            if (isMeansOfAllocationToCombatIsvalid(vehicle) == true) {
                //elimina o veiculo do quartel e cria uma copia
                vehicleRemove = removeCombatVehicle(vehicle.getId());
                //veiculo recebe os dados do fogo
                vehicleRemove.setFire(fire);
                //envia a posiçao do fogo, para o veiculo
                vehicleRemove.setLocation(fire.getLocation());
            }
        }//retorna o veiculo
        return vehicleRemove;
    }

    //mostrar informaçao do quartel
    public void showInf() {
        System.out.println("--- QUARTEL DE BOMBEIROS ---\n");
        System.out.println("Nome: " + this.name);
        this.location.showInf();
        //mostrar os restantes bombeiro
        System.out.print(" -- DADOS DOS BOMBEIROS --");
        for (int i = 0; i < this.countFireman; i++) {
            this.firemans[i].showInf();
            System.out.println(" ");
        }
        System.out.println("\n -- DADOS DOS VEICULOS --");
        for (int i = 0; i < countVehicles; i++) {
            this.vehicles[i].showInf();
            System.out.println("--");
        }

    }

    private boolean isNameValid(String nome) {
        return !(nome.isEmpty() || nome.length() == 0);
    }

    //adicionar bombeiro
    public boolean addFireman(Fireman fireman) {
        //se bombeiro existir
        if (existFireman(fireman.getId()) == true) {
            //retorna falso
            return false;
        }
        fireman.setQuarter(this);
        firemans[countFireman] = fireman;
        countFireman++;
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

    //adicionar veiculo
    public boolean addCombatVehicle(CombatVehicle vehicle) {
        //se veiculo existir
        if (existVehicle(vehicle.getId()) == true) {
            //retorna falso
            return false;
        }
        vehicle.setQuarter(this);
        vehicles[countVehicles] = vehicle;
        countVehicles++;
        return true;
    }

    //adicionar bombeiro
    public CombatVehicle removeCombatVehicle(int vehiclesID) {
        int idx;
        CombatVehicle vehicleRemove = null;
        //se bombeiro existir
        if (existVehicle(vehiclesID) == true) {
            //obter a posição do camião
            idx = indexOfVehicleByID(vehiclesID);
            //se for diferente de - 1
            if (idx != -1) {
                //cria uma cópia
                vehicleRemove = vehicles[idx];
                //faz o loop
                for (int i = idx; i < countVehicles - 1; i++) {
                    //elimina da posição
                    vehicles[idx] = vehicles[idx + 1];
                }//diminui a quantidade - 1
                countVehicles--;
            }
        }//retorna o bombeiro removido
        return vehicleRemove;
    }

    /* Metódo que valida o bombeiro no quartel */
    public boolean existVehicle(int vehicleID) {
        int idx;
        //se tiver veiculo
        if (this.countVehicles > 0) {
            //obter a posição do camião
            idx = indexOfVehicleByID(vehicleID);
            //se for diferente de - 1
            if (idx != -1) {
                //retorna verdadeira
                return true;
            }
        }//se for o contrário, retorna falso
        return false;
    }

    /* Metódo para obter a posição do veiculo no quartel */
    private int indexOfVehicleByID(int vehicleID) {
            //faz o loop
            for (int i = 0; i < countVehicles; i++) {
                //se não for nula
                if ((vehicles[i] != null)
                        //e tiver o mesmo codigo
                        && (vehicles[i].getId() == vehicleID)) {
                    //retorna a posição no array
                    return i;
                }
        }//se for o contrário, retorna -1
        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CombatVehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(CombatVehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public Fireman[] getFiremans() {
        return firemans;
    }

    public void setFiremans(Fireman[] firemans) {
        this.firemans = firemans;
    }
}
