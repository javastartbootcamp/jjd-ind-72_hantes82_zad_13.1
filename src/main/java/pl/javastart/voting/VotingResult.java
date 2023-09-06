package pl.javastart.voting;

import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private final double voteFor;
    private final double voteAgainst;
    private final double voteHold;
    private final List<Vote> votedList;

    public VotingResult(double voteFor, double voteAgainst, double voteHold, List<Vote> votedList) {
        this.voteFor = voteFor;
        this.voteAgainst = voteAgainst;
        this.voteHold = voteHold;
        this.votedList = votedList;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        System.out.printf("Głosów za: %.2f%%\n", (voteFor / votedList.size()) * 100);
        System.out.printf("Głosów przeciw: %.2f%%\n", (voteAgainst / votedList.size()) * 100);
        System.out.printf("Wstrzymało się: %.2f%%\n", (voteHold / votedList.size()) * 100);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : votedList) {
            if (vote.getVoter().equals(voterName)) {
                if (vote.getVote() != null) {
                    if (vote.getVote()) {
                        System.out.println(voterName + ": ZA");
                    } else {
                        System.out.println(voterName + ": PRZECIW");
                    }
                } else {
                    System.out.println(voterName + ": WSTRZYMAŁ SIĘ");
                }
            }
        }
    }
}
