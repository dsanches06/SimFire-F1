
/**
 * Escreva a descrição da classe Simulator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Simulator
{
    //Lista de quarteis disponíveis.
    Quarter[] quarters;
    // Lista de veículos disponíveis.
    CombatVehicle[] vehicles;
    //Lista de bombeiros disponíveis.
    Fireman[] firemans;
    //Lista de pontos de abastecimento disponíveis.
    SupplyStation[] supplyStations;
    //Lista de incêndios.
    Fire[] fires;
    //Condições climatéricas.
    Weather[] weathers;

    //Construtor
    public Simulator() {
        this.quarters = new Quarter[5];
        this.vehicles = new CombatVehicle[5];
        this.firemans = new Fireman[10];
        this.supplyStations = new SupplyStation[5];
        this.fires = new Fire[5];
        this.weathers = new Weather[5];
    }

    public void init() {
        //criar 5 condiçoes climatericas
        createWeathers();
        //criar 5 fogos 
        createFires();
        //criar 10 bombeiros
        createFiremans();
        //criar 5 veiculos 
        createVehicles();
        //criar 5 quartel
        createQuarters();
        //criar 5 posto de abastecimento 
        createSupplyStations();
    }

    private void createQuarters() {
        //criar 5 quartel 
        this.quarters[0] = new Quarter("BSL", new Location(-26, 30));
        this.quarters[1] = new Quarter("BSS", new Location());
        this.quarters[2] = new Quarter("BRT", new Location());
        this.quarters[3] = new Quarter("BSP", new Location());
        this.quarters[4] = new Quarter("BVB", new Location());

        this.quarters[0].addCombatVehicle(vehicles[0]);
        CombatVehicle vehicle = this.quarters[0].sendVehicleToCombatFire(vehicles[0], fires[0]);
        vehicle.showInf();
    }

    private void createVehicles() {
        //criar 5 veiculos 
        this.vehicles[0] = new CombatVehicle(2000);
        this.vehicles[1] = new CombatVehicle(2000);
        this.vehicles[2] = new CombatVehicle(2000);
        this.vehicles[3] = new CombatVehicle(2000);
        this.vehicles[4] = new CombatVehicle(2000);

        this.vehicles[0].addFireman(firemans[1]);
        this.vehicles[0].addFireman(firemans[5]);
        this.vehicles[0].addFireman(firemans[3]);
        // this.vehicles[0].validMeansOfAllocationOfCombat();
        // this.vehicles[0].showInf();

        //adicionar veiculos no quartel
    }

    private void createFiremans() {
        //criar 10 bombeiros 
        this.firemans[0] = new Fireman(100, true);//condutor
        this.firemans[1] = new Fireman(100, true);//condutor
        this.firemans[2] = new Fireman(100, true);//condutor
        this.firemans[3] = new Fireman(100, false);//ajudante
        this.firemans[4] = new Fireman(100, false);//ajudante
        this.firemans[5] = new Fireman(100, false);//ajudante
        this.firemans[6] = new Fireman(100, false);//ajudante
        this.firemans[7] = new Fireman(100, false);//ajudante
        this.firemans[8] = new Fireman(100, false);//ajudante
        this.firemans[9] = new Fireman(100, false);//ajudante

        //adicionar bombeiro no quartel
    }

    private void createSupplyStations() {
        //criar 5 posto de abastecimento 
        this.supplyStations[0] = new SupplyStation("PS", new Location(), 1000000);
        this.supplyStations[1] = new SupplyStation("PL", new Location(), 1000000);
        this.supplyStations[2] = new SupplyStation("PB", new Location(), 1000000);
        this.supplyStations[3] = new SupplyStation("PA", new Location(), 1000000);
        this.supplyStations[4] = new SupplyStation("PP", new Location(), 1000000);

    }

    private void createFires() {
        //criar 5 fogos 
        this.fires[0] = new Fire(new Location(30, -30), Time.getSistemTime());
        this.fires[1] = new Fire(new Location(), Time.getSistemTime());
        this.fires[2] = new Fire(new Location(), Time.getSistemTime());
        this.fires[3] = new Fire(new Location(), Time.getSistemTime());

    }

    private void createWeathers() {
        //criar 5 condiçoes climatericas
        this.weathers[0] = new Weather(45, 100, 100);
        this.weathers[1] = new Weather(45, 100, 100);
        this.weathers[2] = new Weather(45, 100, 100);
        this.weathers[3] = new Weather(45, 100, 100);
        this.weathers[4] = new Weather(45, 100, 100);
    }

}
