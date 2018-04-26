
/**
 * Escreva a descrição da classe Fireman aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Fireman
{
     //para gerar novo id
    private static int nextNumber = 0;
    //id
    private int id;
    //quartel
    private Quarter quarter;
    //veiculo
    private CombatVehicle vehicles;
    //nivel de energia
    private int energy;
    //pode conduzir veiculo ou nao
    private boolean isAbleToDrive;

    /* Construtor para condutor*/
    public Fireman(int energy, boolean isAbleToDrive) {
        this.id = ++Fireman.nextNumber;
        this.energy = energy;
        this.isAbleToDrive = isAbleToDrive;
        this.quarter = null;
        this.vehicles = null;

    }

    //mostrar informaçao do bombeiro
    public void showInf() {
        System.out.format("\n BOMBEIRO ID   : %02d\n", this.id);
        System.out.println("  Energia      : " + this.energy);
        if (isAbleToDrive == true) {
            System.out.println("  Condutor     : SIM");
        }
        if (this.quarter != null) {
            System.out.println("  Quartel      : " + this.quarter.getName());
            this.quarter.getLocation().showInf();
        } else {
            System.out.println("  Quartel      : N/A");
        }
        if (this.vehicles != null) {
            System.out.format("  Veiculo ID   : %02d\n", this.vehicles.getId());
            this.vehicles.getLocation().showInf();
            if (this.vehicles.getQuarter() != null) {
                System.out.print("   Quartel     : " + this.vehicles.getQuarter().getName());
                //this.vehicles.getFireStation().getLocation().showInf();
            } else {
                System.out.print("   Quartel      : N/A");
            }
        } else {
            System.out.print("  Veiculo      : N/A");
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public CombatVehicle getVehicles() {
        return vehicles;
    }

    public void setVehicles(CombatVehicle vehicles) {
        this.vehicles = vehicles;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isIsAbleToDrive() {
        return isAbleToDrive;
    }

    public void setIsAbleToDrive(boolean isAbleToDrive) {
        this.isAbleToDrive = isAbleToDrive;
    }
}
