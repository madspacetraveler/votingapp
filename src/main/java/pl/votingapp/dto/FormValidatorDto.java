package pl.votingapp.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormValidatorDto {

    String resolutionLength;
    String titleLength;
    String content;
    String moderator;
    String secretary;
    String checkboxes;
    boolean allGood;
}
