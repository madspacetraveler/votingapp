package pl.votingapp.bo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.votingapp.dto.FlatDto;
import pl.votingapp.dto.FormValidatorDto;
import pl.votingapp.dto.VotingDto;
import pl.votingapp.entity.Voting;
import pl.votingapp.repository.VotingRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotingService {

    private final VotingRepository votingRepository;
    private final FlatService flatService;

    private VotingDto mapVotings(Voting voting) {
        return VotingDto.builder()
                .id(voting.getId())
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

    public VotingDto addVoting(VotingDto votingDto) {
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
        Voting voting = mapResult(votingDto);
        voting = votingRepository.save(voting);
        return mapVotings(voting);
    }

    public FormValidatorDto validateVoting(VotingDto votingDto){
        FormValidatorDto formValidatorDto = new FormValidatorDto();
        formValidatorDto.setAllGood(true);
        //Checkboxes validation
        for (FlatDto flatDto: votingDto.getFlatVoteDtoList()) {
            int check = 0;
            if (flatDto.isVotesAbstain()) check++;
            if (flatDto.isVotesAgainst()) check++;
            if (flatDto.isVotesFor()) check++;
            if (check != 1) formValidatorDto.setAllGood(false);
            formValidatorDto.setCheckboxes("Proszę o prawidłowy wybór głosów: Należy wybrać jedną opcję dla kazdego mieszkania.");
        }
        //Resolution number validation
        int resolutionMinLength = 4;
        int resolutionMaxLength = 16;
        if (votingDto.getResolution().length()<resolutionMinLength){
            formValidatorDto.setResolutionLength("Nr uchwały jest za krótki, podaj minimum "+resolutionMinLength+" znaków i nie więcej niż "+resolutionMaxLength);
            formValidatorDto.setAllGood(false);
        } else if (votingDto.getResolution().length()>resolutionMaxLength){
            formValidatorDto.setResolutionLength("Nr uchwały jest za długi, podaj minimum "+resolutionMinLength+" znaków i nie więcej niż "+resolutionMaxLength);
            formValidatorDto.setAllGood(false);
        }
        //Title length validation
        int titleMinLength = 16;
        int titleMaxLength = 256;
        if (votingDto.getTitle().length()<titleMinLength){
            formValidatorDto.setTitleLength("Tytuł uchwały jest za krótki, podaj minimum "+titleMinLength+" znaków i nie więcej niż "+titleMaxLength);
            formValidatorDto.setAllGood(false);
        } else if (votingDto.getTitle().length()>titleMaxLength){
            formValidatorDto.setTitleLength("Tytuł uchwały jest za długi, podaj minimum "+titleMinLength+" znaków i nie więcej niż "+titleMaxLength);
            formValidatorDto.setAllGood(false);
        }
        //Content length validation
        int contentMinLength = 64;
        int contentMaxLength = 8192;
        if (votingDto.getContent().length()<contentMinLength){
            formValidatorDto.setContent("Treść uchwały jest za krótka, podaj minimum "+contentMinLength+" znaków i nie więcej niż "+contentMaxLength);
            formValidatorDto.setAllGood(false);
        } else if (votingDto.getContent().length()>contentMaxLength){
            formValidatorDto.setContent("Treść uchwały jest za długa, podaj minimum "+contentMinLength+" znaków i nie więcej niż "+contentMaxLength);
            formValidatorDto.setAllGood(false);
        }
        //Moderator validation
        if (votingDto.getModerator().equals("none")){
            formValidatorDto.setModerator("Wybierz moderatora!");
            formValidatorDto.setAllGood(false);
        }
        //Secretary validation
        if (votingDto.getSecretary().equals("none")){
            formValidatorDto.setSecretary("Wybierz sekretarza!");
            formValidatorDto.setAllGood(false);
        }
        return formValidatorDto;
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

    public Long countVotings(){ return (long) votingRepository.findAll().size(); }

    public Long countEligibleVotings(VotingDto votingDto){
        return votingDto.getFlatVoteDtoList().stream().count(); }

    public Long countResolutions(){
        return votingRepository.findAll()
                .stream()
                .filter(Voting::isResult)
                .count();
    }

    public List<VotingDto> findVotings() {
        return votingRepository.findAll()
                .stream()
                .map(this::mapVotings)
                .collect(Collectors.toList());
    }

    public List<VotingDto> findAcceptedVotings() {
        return votingRepository.findAll()
                .stream()
                .filter(Voting::isResult)
                .map(this::mapVotings)
                .collect(Collectors.toList());
    }

    public List<VotingDto> findRejectedVotings() {
        return votingRepository.findAll()
                .stream()
                .filter(voting -> !voting.isResult())
                .map(this::mapVotings)
                .collect(Collectors.toList());
    }

    public List<VotingDto> findVotingsByBuildingId(Long id) {
        return votingRepository.findAll()
                .stream()
                .filter(voting -> voting.getBuildingId().equals(id))
                .map(this::mapVotings)
                .collect(Collectors.toList());
    }

    public VotingDto findVotingById(Long id) {
        return mapVotings(votingRepository.findOne(id));
    }
}
