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

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotingService {

    private final VotingRepository votingRepository;

    private final FlatService flatService;

    public List<VotingDto> findVotings() {
        return votingRepository.findAll()
                .stream()
                .map(this::mapVotings)
                .collect(Collectors.toList());
    }



    private VotingDto mapVotings(Voting voting) {
        return VotingDto.builder()
                .id(voting.getId())
//                .buildingId(voting.getBuildingId())
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
                .flatVoteDtoList(flatService.findFlatsWithBuildingId(voting.getBuildingId()))
                .build();
    }

//    public VotingDto findVotingById(Long id){
//        return votings.stream()
//                .filter(voting -> voting.getId().equals(id))
//                .findFirst()
//                .orElseThrow(()-> new NoSuchElementException());
//    }

    public void addVoting(VotingDto votingDto) {
//        this.votings.add(VotingDto.builder()
//                .id(votingDto.getId())
//                .buildingId(votingDto.getBuildingId())
//                .date(Date.valueOf(LocalDate.now()))
//                .resolution("rezolution")
//                .title("Sprzątanie po psach")
//                .content("Wszyscy mają lazić z workami na gówno w kieszeni")
//                .votesFor(votingDto.getVotesFor())
//                .votesAgainst(votingDto.getVotesAgainst())
//                .votesAbstain(votingDto.getVotesAbstain())
//                .moderator("Grzegorz Grabowski")
//                .secretary("Marcin Durka")
//                .result(false)
//                .resultContent("Wlazł kotek na płotek")
//                .build()
//        );


    }
}
