package homeworks._08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

class Pokemon{
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.setName(name);
        this.setElement(element);
        this.setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

class Trainer{
    private String name;
    private int numberOfBadges;
    private LinkedList<Pokemon> pokemons;

    public Trainer(String name, LinkedList<Pokemon> pokemons) {
        this.setName(name);
        this.setNumberOfBadges(0);
        this.setPokemons(pokemons);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public LinkedList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(LinkedList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getName());
        result.append(" ");
        result.append(this.getNumberOfBadges());
        result.append(" ");
        result.append(this.getPokemons().size());

        return result.toString();
    }
}

public class Pr08PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputData = reader.readLine();
        LinkedHashMap<String, Trainer> trainersByName = new LinkedHashMap<>();
        while (!inputData.equals("Tournament")){
            String[] input = inputData.split("\\s+");
            String trainerName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainersByName.containsKey(trainerName)){
                trainersByName.put(trainerName, new Trainer(trainerName, new LinkedList<>()));
            }

            trainersByName.get(trainerName).getPokemons().add(pokemon);

            inputData = reader.readLine();
        }

        String wantedElement = reader.readLine();
        while (!wantedElement.equals("End")){
            for (Map.Entry<String, Trainer> trainerEntry : trainersByName.entrySet()) {
                if (hasPokemonWithWantedElement(trainerEntry.getValue().getPokemons(), wantedElement)){
                    trainerEntry.getValue().setNumberOfBadges(trainerEntry.getValue().getNumberOfBadges() + 1);
                }else {
                    for (Pokemon pokemon : trainerEntry.getValue().getPokemons()) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                        if (pokemon.getHealth() <= 0){
                            trainerEntry.getValue().getPokemons().remove(pokemon);
                        }
                    }
                }
            }

            wantedElement = reader.readLine();
        }

        LinkedHashMap<String, Trainer> sortedTrainers = trainersByName.entrySet()
                .stream()
                .sorted((firstTrainer, secondTrainer) -> {
                    Integer firstTrainerAmountOfBadges = firstTrainer.getValue().getNumberOfBadges();
                    Integer secondTrainerAmountOfBadges = secondTrainer.getValue().getNumberOfBadges();

                    return secondTrainerAmountOfBadges.compareTo(firstTrainerAmountOfBadges);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y)-> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        for (Map.Entry<String,Trainer> trainerEntry : sortedTrainers.entrySet()) {
            System.out.println(trainerEntry.getValue());
        }
    }

    private static boolean hasPokemonWithWantedElement(LinkedList<Pokemon> pokemons, String element){
        boolean result = false;
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)){
                result = true;
                return result;
            }
        }

        return result;
    }
}
