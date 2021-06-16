package switchtwentytwenty.project.dto.assemblers.implassemblers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.family.ChangeRelationDTO;
import switchtwentytwenty.project.dto.family.CreateRelationDTO;
import switchtwentytwenty.project.dto.family.InputChangeRelationDTO;
import switchtwentytwenty.project.dto.family.InputRelationDTO;

@Component
@AllArgsConstructor
public class RelationInputDTOAssembler {


    public InputRelationDTO toInputRelationDTO(CreateRelationDTO createRelationDTO, String familyID) {
        return new InputRelationDTO(createRelationDTO.getMemberOneID(), createRelationDTO.getMemberTwoID(), createRelationDTO.getRelationDesignation(), familyID);
    }

    public InputChangeRelationDTO toInputChangeRelationDTO(ChangeRelationDTO changeRelationDTO, String familyID) {
        return new InputChangeRelationDTO(changeRelationDTO, familyID);
    }
}