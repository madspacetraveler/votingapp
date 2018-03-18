package pl.grabowski_durka.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grabowski_durka.dto.FlatDto;
import pl.grabowski_durka.dto.VotingDto;
import pl.grabowski_durka.entity.Flat;
import pl.grabowski_durka.entity.Voting;
import pl.grabowski_durka.repository.FlatRepository;
import pl.grabowski_durka.repository.VotingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotingService {

    private final VotingRepository votingRepository;
    private List<VotingDto> votings = new ArrayList<>();

    public List<VotingDto> findVotings() {
        votings = votingRepository.findAll()
                .stream()
                .map(this::mapVotings)
                .collect(Collectors.toList());
        return votings;
    }

    private VotingDto mapVotings(Voting voting) {
        return VotingDto.builder()
                .id(voting.getId())
                .buildingId(voting.getBuildingId())
                .date(voting.getDate())
                .resolution(voting.getResolution())
                .title(voting.getTitle())
                .content(voting.getContent())
                .votesFor(voting.getVotesFor())
                .votesAgainst(voting.getVotesAgainst())
                .votesAbstain(voting.getVotesAbstain())
                .moderator(voting.getModerator())
                .secretary(voting.getSecretary())
                .result(voting.getResult())
                .resultContent(voting.getResultContent())
                .build();
    }

    public List<VotingDto> findVotingWithVotingId(Long id) {
        return votings.stream()
                .filter(voting -> voting.getBuildingId().equals(id))
                .collect(Collectors.toList());
    }
}
