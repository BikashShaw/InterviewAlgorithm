package complex.algo.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPopulation {
    public static class PersonBDYears {
        public int birthYear;
        public int deathYear;

        public PersonBDYears(int birthYear, int deathYear) {
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }
    }

    int maxPopulation(List<PersonBDYears> personBDYearsList) {
        int maxYear = 0;
        Map<Integer, Integer> bdMap = new HashMap<>();
        personBDYearsList.forEach(personBDYears -> {
            for (int aliveYear = personBDYears.birthYear; aliveYear <= personBDYears.deathYear ; aliveYear++) {
                if(bdMap.containsKey(aliveYear)) {
                    Integer population = bdMap.get(aliveYear);
                    population++;
                    bdMap.replace(aliveYear, population);
                } else {
                    bdMap.put(aliveYear, 1);
                }
            }
        });

        System.out.println(bdMap);

        int maxPopulation = 0;
        for (Integer aliveYear : bdMap.keySet()) {
            Integer population = bdMap.get(aliveYear);
            if(population > maxPopulation) {
                maxPopulation = population;
                maxYear = aliveYear;
            }
        }

        return maxYear;
    }

    public static void main(String[] args) {
        List<PersonBDYears> personBDYearsList = new ArrayList<>();
        personBDYearsList.add(new PersonBDYears(2010, 2018)); // 15
        personBDYearsList.add(new PersonBDYears(2011, 2017)); // 15
        personBDYearsList.add(new PersonBDYears(2010, 2017)); // 15
        personBDYearsList.add(new PersonBDYears(2012, 2015)); // 15
        personBDYearsList.add(new PersonBDYears(2013, 2016)); // 15
        personBDYearsList.add(new PersonBDYears(2015, 2018)); // 15


        MaxPopulation maxPopulation = new MaxPopulation();

        System.out.println(maxPopulation.maxPopulation(personBDYearsList));
    }
}
