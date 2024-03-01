package modelo;

public class Heroes {
    private String name;
    private String race;
    private String faction;
    private String title;
    private double life;
    private int runicPower;
    private double strength;
    private double stamina;

    public Heroes(String name, String race, String faction, String title, double life, int runicPower,
            double strength, double stamina) {
        this.name = name;
        this.race = race;
        this.faction = faction;
        this.title = title;
        this.life = life;
        this.runicPower = runicPower;
        this.strength = strength;
        this.stamina = stamina;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getLife() {
		return life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public int getRunicPower() {
		return runicPower;
	}

	public void setRunicPower(int runicPower) {
		this.runicPower = runicPower;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public double getStamina() {
		return stamina;
	}

	public void setStamina(double stamina) {
		this.stamina = stamina;
	}

	@Override
	public String toString() {
		return "Heroes [name=" + name + ", race=" + race + ", faction=" + faction + ", title=" + title + ", life="
				+ life + ", runicPower=" + runicPower + ", strength=" + strength + ", stamina=" + stamina + "]";
	}
}
