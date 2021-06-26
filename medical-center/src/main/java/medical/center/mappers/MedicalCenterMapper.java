package medical.center.mappers;

import medical.center.domain.MedicalCenterEntity;
import medical.center.types.MedicalCenterTO;

public class MedicalCenterMapper {

    public static MedicalCenterTO toMedicalCenterTO(MedicalCenterEntity medicalCenterEntity) {
        if (medicalCenterEntity == null)
            return null;

        return new MedicalCenterTO.MedicalCenterTOBuilder().withId(medicalCenterEntity.getId())
                .withAddress(medicalCenterEntity.getAddress())
                .withName(medicalCenterEntity.getName())
                .build();
    }

    public static MedicalCenterEntity toMedicalCenterEntity(MedicalCenterTO medicalCenterTO) {
        if (medicalCenterTO == null)
            return null;
        MedicalCenterEntity medicalCenterEntity = new MedicalCenterEntity();

        medicalCenterEntity.setAddress(medicalCenterTO.getAddress());
        medicalCenterEntity.setName(medicalCenterTO.getName());

        return medicalCenterEntity;
    }

}
