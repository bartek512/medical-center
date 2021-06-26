package medical.center.mappers;

import medical.center.domain.SpecializationEntity;
import medical.center.types.SpecializationTO;

import java.util.Set;
import java.util.stream.Collectors;

public class SpecializationMapper {

    public static SpecializationTO toSpecializationTO(SpecializationEntity entity) {
        if (entity == null)
            return null;

        return new SpecializationTO.SpecializationTOBuilder().withId(entity.getId()).withName(entity.getName()).build();

    }

    public static SpecializationEntity toSpecializationEntity(SpecializationTO specializationTO) {
        if (specializationTO == null)
            return null;
        SpecializationEntity specializationEntity = new SpecializationEntity();
        specializationEntity.setName(specializationTO.getName());

        return specializationEntity;
    }

    public static Set<SpecializationTO> map2TOs(Set<SpecializationEntity> specializationEntities) {
        return specializationEntities.stream().map(SpecializationMapper::toSpecializationTO).collect(Collectors.toSet());
    }

    public static Set<SpecializationEntity> map2Entities(Set<SpecializationTO> specializationTOs) {
        return specializationTOs.stream().map(SpecializationMapper::toSpecializationEntity).collect(Collectors.toSet());
    }
}
