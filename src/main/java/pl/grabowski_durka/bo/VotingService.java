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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotingService {

    private final VotingRepository votingRepository;
    private final FlatService flatService;

    private VotingDto mapVotings(Voting voting) {
        return VotingDto.builder()
                .id(voting.getId())
                //                .buildingId(voting.getBuildingId())
                .date(voting.getDate())
                .adres(voting.getAdres())
                .resolution(voting.getResolution())
                .title(voting.getTitle())
                .content(voting.getContent())
                .votesFor(voting.getVotesFor())
                .votesAgainst(voting.getVotesAgainst())
                .votesAbstain(voting.getVotesAbstain())
                .moderator(voting.getModerator())
                .secretary(voting.getSecretary())
                .result(voting.isResult())
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
        float areaBuilding = votingDto.getBuilding().getArea();
        votingDto.setVotesFor(0);
        votingDto.setVotesAgainst(0);
        votingDto.setVotesAgainst(0);
        for ( FlatDto flatDto : votingDto.getFlatVoteDtoList() )
        {
            if ( flatDto.isVotesFor() ){
                votingDto.setVotesFor(votingDto.getVotesFor() + flatDto.getArea()/areaBuilding);
            }
            if ( flatDto.isVotesAgainst() ){
                votingDto.setVotesAgainst(votingDto.getVotesAgainst() + flatDto.getArea()/areaBuilding);
            }
            if ( flatDto.isVotesAbstain() ){
                votingDto.setVotesAbstain(votingDto.getVotesAbstain() + flatDto.getArea()/areaBuilding);
            }
        }
        if ( votingDto.getVotesFor() > 0.5 ) { votingDto.setResult(true); }
        votingDto.setDate(Date.valueOf(LocalDate.now()));
        votingRepository.save(mapResult(votingDto));
    }

    private Voting mapResult(VotingDto votingDto) {

        return Voting.builder()
                .id(votingDto.getId())
                .buildingId(votingDto.getBuilding().getId())
                .adres(votingDto.getBuilding().getAdres())
                .date(votingDto.getDate())
                .resolution(votingDto.getResolution())
                .title(votingDto.getTitle())
                .content(votingDto.getContent())
                .votesFor(votingDto.getVotesFor())
                .votesAgainst(votingDto.getVotesAgainst())
                .votesAbstain(votingDto.getVotesAbstain())
                .moderator(votingDto.getModerator())
                .secretary(votingDto.getSecretary())
                .result(votingDto.isResult())
                .resultContent(votingDto.getResultContent())
                .build();
    }

    public Long countResolutions(){ return (long) votingRepository.findAll().size(); }

    public Long countVotings(){ return (long) votingRepository.findAll().size(); }

    public List<VotingDto> findVotings() {
        return votingRepository.findAll()
                .stream()
                .map(this::mapVotings)
                .collect(Collectors.toList());
    }
}
