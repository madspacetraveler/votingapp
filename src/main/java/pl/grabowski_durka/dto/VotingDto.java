package pl.grabowski_durka.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

/**
 * @author Marcin
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VotingDto {

    private Long id;
    private Long buildingId;
    private Date date;
    private String resolution;
    private String title;
    private String content;
    private float votesFor;
    private float votesAgainst;
    private float votesAbstain;
    private String moderator;
    private String secretary;
    private boolean result;
    private String resultContent;
}
