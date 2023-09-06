package pl.javastart.voting;

import java.util.*;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */

    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> voted = new ArrayList<>(voters.size());
        int counter = 0;
        double voteFor = 0;
        double voteAgainst = 0;
        double voteHold = 0;
        while (counter < voters.size()) {
            System.out.println("Jak głosuje " + voters.get(counter) + "? (z - za, p - przeciw, w - wstrzymanie się)");
            String result = scanner.nextLine();

            switch (result) {
                case "z":
                    voted.add(new Vote(voters.get(counter), true));
                    voteFor++;
                    counter++;
                    break;
                case "p":
                    voted.add(new Vote(voters.get(counter), false));
                    voteAgainst++;
                    counter++;
                    break;
                case "w":
                    voted.add(new Vote(voters.get(counter), null));
                    voteHold++;
                    counter++;
                    break;
                default:
                    System.out.println("Podano niewlasciwa wartosc");
                    result = scanner.nextLine();
                    break;
            }
        }
        return new VotingResult(voteFor, voteAgainst, voteHold, voted); // to możesz (a nawet powinieneś/powinnaś) zmienić :)
    }

}
