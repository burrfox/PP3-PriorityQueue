import java.util.Comparator;

public class City implements Comparable<City> {

    private Integer population;
    private String name;

    public City(int population, String name) {
        this.population = population;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int compareTo(City o) {
        return o.getPopulation() - this.population;
    }
}

