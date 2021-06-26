package medical.center.mappers;

import medical.center.domain.Address;
import medical.center.domain.DoctorEntity;
import medical.center.types.DoctorTO;

import java.util.Set;
import java.util.stream.Collectors;

public class DoctorMapper {

    public static DoctorTO toDoctorTO(DoctorEntity doctorEntity) {
        if (doctorEntity == null)
            return null;



        return new DoctorTO.DoctorTOBuilder().withId(doctorEntity.getId())
                .withCity(doctorEntity.getAddress().getCity()).withStreet(doctorEntity.getAddress().getStreet())
                .withPostalCode(doctorEntity.getAddress().getPostalCode())
                .withPaymentPerHour(doctorEntity.getPaymentPerHour())
                .withMedicalDutyTOS(doctorEntity.getMedicalDuty())
                .withSpecializations(SpecializationMapper.map2TOs(doctorEntity.getSpecializations()))
                .withFirstName(doctorEntity.getFirstName())
                .withLastName(doctorEntity.getLastName())
                .withEmail(doctorEntity.getEmail())
                .withTelephoneNumber(doctorEntity.getTelephoneNumber()).build();
    }

    public static DoctorEntity toDoctorEntity(DoctorTO doctorTO) {
        if (doctorTO == null)
            return null;
        DoctorEntity doctorEntity = new DoctorEntity();
        Address address = new Address();
        address.setStreet(doctorTO.getStreet());
        address.setCity(doctorTO.getCity());
        address.setPostalCode(doctorTO.getPostalCode());

        doctorEntity.setSpecializations(SpecializationMapper.map2Entities(doctorTO.getSpecializations()));
        doctorEntity.setPaymentPerHour(doctorTO.getPaymentPerHour());
        doctorEntity.setAddress(address);
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());

        return doctorEntity;
    }

    public static Set<DoctorTO> map2TOs(Set<DoctorEntity> doctorEntities) {
        return doctorEntities.stream().map(DoctorMapper::toDoctorTO).collect(Collectors.toSet());
    }

    public static Set<DoctorEntity> map2Entities(Set<DoctorTO> doctorTOs) {
        return doctorTOs.stream().map(DoctorMapper::toDoctorEntity).collect(Collectors.toSet());
    }

}
