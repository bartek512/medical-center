package medical.center.types;

import medical.center.domain.Address;

public class MedicalCenterTO {

    private Long id;

    private String name;

    private Address address;


    public MedicalCenterTO(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static MedicalCenterTOBuilder builder() {
        return new MedicalCenterTOBuilder();
    }


    public static final class MedicalCenterTOBuilder {
        private Long id;
        private String name;
        private Address address;

        public MedicalCenterTOBuilder() {
        }

        public MedicalCenterTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public MedicalCenterTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MedicalCenterTOBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public MedicalCenterTO build() {
            return new MedicalCenterTO(id, name, address);
        }
    }
}
