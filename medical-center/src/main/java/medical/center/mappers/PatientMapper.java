package medical.center.mappers;

import medical.center.domain.Address;
import medical.center.domain.PatientEntity;
import medical.center.types.PatientTO;

import java.util.Set;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientTO toPatientTO(PatientEntity patientEntity) {
        if (patientEntity == null)
            return null;

        return new PatientTO.PatientTOBuilder().withId(patientEntity.getId())
                .withCity(patientEntity.getAddress().getCity()).withStreet(patientEntity.getAddress().getStreet())
                .withPostalCode(patientEntity.getAddress().getPostalCode())
                .withFirstName(patientEntity.getFirstName())
                .withLastName(patientEntity.getLastName())
                .withEmail(patientEntity.getEmail())
                .withTelephoneNumber(patientEntity.getTelephoneNumber())
                .withDateOfBrth(patientEntity.getDateOfBirth())
                .withSex(patientEntity.getSex()).build();
    }

    public static PatientEntity toPatientEntity(PatientTO patientTO) {
        if (patientTO == null)
            return null;
        PatientEntity patientEntity = new PatientEntity();
        Address address = new Address();
        address.setStreet(patientTO.getStreet());
        address.setCity(patientTO.getCity());
        address.setPostalCode(patientTO.getPostalCode());


        patientEntity.setAddress(address);
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setDateOfBirth(patientTO.getDateOfBrth());
        patientEntity.setSex(patientTO.getSex());

        return patientEntity;
    }

    public static Set<PatientTO> map2TOs(Set<PatientEntity> patientEntities) {
        return patientEntities.stream().map(PatientMapper::toPatientTO).collect(Collectors.toSet());
    }

    public static Set<PatientEntity> map2Entities(Set<PatientTO> patientTOS) {
        return patientTOS.stream().map(PatientMapper::toPatientEntity).collect(Collectors.toSet());
    }
}
