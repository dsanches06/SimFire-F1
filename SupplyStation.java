import java.util.*;
/**
 * Escreva a descrição da classe SupplyStation aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class SupplyStation
{
    
    //capacidade maxima de veiculos
    public static final int MAX_VEHICLES = 3;
    // capacidade atual de agua
    private int waterCapacity;
    //nome
    private String name;
    //localizaçao
    private Location location;
    //lista de veiculos
    private CombatVehicle[] vehicles;
    //contador de veiculos
    private int countVehicles;
    //tempo da entrada de veiculos
    private Time time;

    /* Construtor */
    public SupplyStation(String name, Location location, int waterCapacity) {
        //se nome for valido
        if ((isNameValid(name))
                //e localizaçao for valida
                && (location.isLocationValid(location))) {
            this.name = name;
            this.location = location;
            this.waterCapacity = waterCapacity;
            this.vehicles = new CombatVehicle[MAX_VEHICLES];
            this.countVehicles = 0;
            this.time = null;
        }
    }

    //mostrar informaçao do quartel
    public void showInf() {
        System.out.println("--- POSTO DE ABASTECIMENTO ---\n");
        System.out.println("Nome: " + this.name);
        this.location.showInf();
        System.out.println("Capacidade    : " + this.waterCapacity + "L");
        System.out.println(" -- DADOS DOS VEICULOS --");
        for (int i = 0; i < countVehicles; i++) {
            this.vehicles[i].showInf();
            System.out.println("--");
        }

    }

    private boolean isNameValid(String nome) {
        return !(nome.isEmpty() || nome.length() == 0);
    }
    //adicionar veiculo

    //metodo para reabastecer o veiculo
    public boolean vehicleFuel() {
        //verifica se o veiculo esta na mesma posicao

        return true;
    }

    public boolean addCombatVehicle(CombatVehicle vehicle) {
        //se veiculo existir
        if (existVehicle(vehicle.getId()) == true) {
            //retorna falso
            return false;
        }
        //altera a localizaçao do veiculo para mesma do posto de abastecimento
        vehicle.setLocation(this.location);
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
}
