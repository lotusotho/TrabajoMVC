package servicio;

import java.math.BigDecimal;

/**
 * Bean del heroe
 */

public class Hero {
	private int id;
    private String name;
    private String race;
    private String faction;
    private String title;
    private BigDecimal life;
    private int runicPower;
    private BigDecimal strength;
    private BigDecimal stamina;

    public Hero(String name, String race, String faction, String title, BigDecimal life, int runicPower,
    		BigDecimal strength, BigDecimal stamina) {
        this.name = name;
        this.race = race;
        this.faction = faction;
        this.title = title;
        this.life = life;
        this.runicPower = runicPower;
        this.strength = strength;
        this.stamina = stamina;
    }

    public int getId() {
    	return this.id;
    }

    public void setId(int id) {
    	this.id = id;
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

	public BigDecimal getLife() {
		return life;
	}

	public void setLife(BigDecimal life) {
		this.life = life;
	}

	public int getRunicPower() {
		return runicPower;
	}

	public void setRunicPower(int runicPower) {
		this.runicPower = runicPower;
	}

	public BigDecimal getStrength() {
		return strength;
	}

	public void setStrength(BigDecimal strength) {
		this.strength = strength;
	}

	public BigDecimal getStamina() {
		return stamina;
	}

	public void setStamina(BigDecimal stamina) {
		this.stamina = stamina;
	}

	@Override
	public String toString() {
		return "Heroes [id=" + id + ", name=" + name + ", race=" + race + ", faction=" + faction + ", title=" + title
				+ ", life=" + life + ", runicPower=" + runicPower + ", strength=" + strength + ", stamina=" + stamina
				+ "]";
	}
}
