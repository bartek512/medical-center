package medical.center.mappers;

import medical.center.domain.MedicalDutyEntity;
import medical.center.types.MedicalDutyTO;

import java.util.Set;
import java.util.stream.Collectors;

public class MedicalDutyMapper {

    public static MedicalDutyTO toMedicalDutyTO(MedicalDutyEntity medicalDutyEntity) {
        if (medicalDutyEntity == null)
            return null;

        return new MedicalDutyTO.MedicalDutyTOBuilder().withId(medicalDutyEntity.getId())
                .withDate(medicalDutyEntity.getDate())
                .withDoctor(DoctorMapper.toDoctorTO(medicalDutyEntity.getDoctorEntity()))
                .withMedicalCenter(MedicalCenterMapper.toMedicalCenterTO(medicalDutyEntity.getMedicalCenter()))
                .build();
    }

    public static MedicalDutyEntity toMedicalDutyEntity(MedicalDutyTO medicalDutyTO) {
        if (medicalDutyTO == null)
            return null;
        MedicalDutyEntity medicalDutyEntity = new MedicalDutyEntity();

        medicalDutyEntity.setDate(medicalDutyTO.getDate());
        medicalDutyEntity.setMedicalCenter(MedicalCenterMapper.toMedicalCenterEntity(medicalDutyTO.getMedicalCenter()));
        medicalDutyEntity.setDoctorEntity(DoctorMapper.toDoctorEntity(medicalDutyTO.getDoctor()));

        return medicalDutyEntity;
    }

    public static Set<MedicalDutyTO> map2TOs(Set<MedicalDutyEntity> medicalDutyEntities) {
        return medicalDutyEntities.stream().map(MedicalDutyMapper::toMedicalDutyTO).collect(Collectors.toSet());
    }
}
