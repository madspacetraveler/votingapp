package pl.votingapp.bo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import pl.votingapp.repository.VotingRepository;

import static org.junit.jupiter.api.Assertions.*;

class VotingServiceTest {

    private VotingRepository votingRepository;

    @Before
    public void setup(){
        votingRepository.findAll();
    }

    @Test
    void countVotings() {
        long count = votingRepository.findAll().size();
        assertEquals(1,count);
    }

    @Test
    void countEligibleVotings() {
    }

    @Test
    void countResolutions() {
    }

}