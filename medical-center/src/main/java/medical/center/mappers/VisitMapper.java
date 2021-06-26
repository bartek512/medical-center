package medical.center.mappers;

import medical.center.domain.VisitEntity;
import medical.center.types.VisitTO;

import java.util.Set;
import java.util.stream.Collectors;

public class VisitMapper {

    public static VisitTO toVisitTO(VisitEntity visitEntity) {
        if (visitEntity == null)
            return null;


        return new VisitTO.VisitTOBuilder().withId(visitEntity.getId()).withPrice(visitEntity.getPrice())
                .withDoctor(DoctorMapper.toDoctorTO(visitEntity.getDoctor())).withPatient(PatientMapper.toPatientTO(visitEntity.getPatient()))
                .withStartTime(visitEntity.getStartTime())
                .withVisitStatus(visitEntity.getVisitStatus()).build();

    }

    public static VisitEntity toVisitEntity(VisitTO visitTO) {
        if (visitTO == null)
            return null;
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPrice(visitTO.getPrice());
        visitEntity.setVisitStatus(visitTO.getVisitStatus());
        visitEntity.setDoctor(DoctorMapper.toDoctorEntity(visitTO.getDoctor()));
        visitEntity.setPatient(PatientMapper.toPatientEntity(visitTO.getPatient()));
        visitEntity.setStartTime(visitTO.getStartTime());

        return visitEntity;
    }

    public static Set<VisitTO> map2TOs(Set<VisitEntity> visitEntities) {
        return visitEntities.stream().map(VisitMapper::toVisitTO).collect(Collectors.toSet());

    }

    public static Set<VisitEntity> map2Entities(Set<VisitTO> visitTOs) {
        return visitTOs.stream().map(VisitMapper::toVisitEntity).collect(Collectors.toSet());
    }
}
