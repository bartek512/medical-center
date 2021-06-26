package medical.center.types;

import medical.center.domain.enums.Specialization;

public class SpecializationTO {

    private Long id;

    private Specialization name;

    public SpecializationTO(Long id, Specialization name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Specialization getName() {
        return name;
    }

    public void setName(Specialization name) {
        this.name = name;
    }

    public static SpecializationTOBuilder builder() {
        return new SpecializationTOBuilder();
    }


    public static final class SpecializationTOBuilder {
        private Long id;
        private Specialization name;

        public SpecializationTOBuilder() {
        }


        public SpecializationTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SpecializationTOBuilder withName(Specialization name) {
            this.name = name;
            return this;
        }

        public SpecializationTO build() {
            return new SpecializationTO(id, name);
        }
    }
}
