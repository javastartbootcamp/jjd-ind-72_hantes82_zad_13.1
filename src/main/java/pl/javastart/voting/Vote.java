package pl.javastart.voting;

import java.util.Objects;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public class Vote {

    private String voter;
    private Boolean vote; // true - ZA, false - PRZECIW, null - wstrzymanie się

    public Vote(String voter, Boolean vote) {
        this.voter = voter;
        this.vote = vote;
    }

    public String getVoter() {
        return voter;
    }

    public Boolean getVote() {
        return vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vote vote1)) {
            return false;
        }
        return Objects.equals(voter, vote1.voter) && Objects.equals(vote, vote1.vote);
    }

}
