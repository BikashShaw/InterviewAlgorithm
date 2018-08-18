package complex.algo.fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        Map<Integer, Integer> bdMap = new TreeMap<>();
        int maxYear = 0;
        int maxPopulation = 0;
        for (PersonBDYears personBDYears : personBDYearsList) {
            for (int aliveYear = personBDYears.birthYear; aliveYear <= personBDYears.deathYear; aliveYear++) {
                Integer population = 1;
                if (bdMap.containsKey(aliveYear)) {
                    population = bdMap.get(aliveYear);
                    population++;
                    bdMap.replace(aliveYear, population);

                } else {
                    bdMap.put(aliveYear, population);
                }
                if (population > maxPopulation) {
                    maxPopulation = population;
                    maxYear = aliveYear;
                }
            }
        }
        System.out.println(bdMap);

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
        personBDYearsList.add(new PersonBDYears(2000, 2008)); //


        MaxPopulation maxPopulation = new MaxPopulation();

        System.out.println(maxPopulation.maxPopulation(personBDYearsList));
    }
}
