package servicio;

import java.math.BigDecimal;

/**
 * Bean del heroe
 */

public class Hero {
	private int id;
    private String name;
    private int race_id;
    private int faction_id;
    private int heroClass_id;
    private String title;
    private BigDecimal life;
    private int runicPower;
    private BigDecimal strength;
    private BigDecimal stamina;

    public Hero(String name, int race, int faction, int heroClass_id, String title, BigDecimal life, int runicPower,
    		BigDecimal strength, BigDecimal stamina) {
        this.name = name;
        this.race_id = race;
        this.faction_id = faction;
        this.heroClass_id = heroClass_id;
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

	public int getRace_id() {
		return race_id;
	}

	public void setRace_id(int race_id) {
		this.race_id = race_id;
	}

	public int getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(int faction_id) {
		this.faction_id = faction_id;
	}

	public int getHeroClass_id() {
		return heroClass_id;
	}

	public void setHeroClass_id(int heroClass_id) {
		this.heroClass_id = heroClass_id;
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
		return "Hero [id=" + id + ", name=" + name + ", race_id=" + race_id + ", faction_id=" + faction_id
				+ ", heroClass_id=" + heroClass_id + ", title=" + title + ", life=" + life + ", runicPower="
				+ runicPower + ", strength=" + strength + ", stamina=" + stamina + "]";
	}
	
}
