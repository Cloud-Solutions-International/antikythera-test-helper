package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Repository;
import sa.com.cloudsolutions.antikythera.testhelper.model.FakeEntity;
import sa.com.cloudsolutions.antikythera.testhelper.repository.FakeRepository;

import java.util.List;

@SuppressWarnings({"java:S106", "unused", "java:S1192"})
public class BranchingCombinations {

    private final FakeRepository repository;
    private ProblemQuery query;
    private List<String> values;

    public BranchingCombinations(FakeRepository repository) {
        this.repository = repository;
    }

    public void sequentialDirect() {
        String diagnosisType = query.getDiagnosisType();
        if ("TYPE_SET".equals(diagnosisType)) {
            System.out.println("TYPE_SET");
        } else {
            System.out.println("TYPE_EMPTY");
        }

        if (CollectionUtils.isEmpty(values)) {
            System.out.println("VALUES_EMPTY");
        } else {
            System.out.println("VALUES_PRESENT");
        }
    }

    public void deletedByDirect(ProblemRecord pr) {
        String source = pr.getSource();
        String deletedBy = pr.getDeletedBy();

        if ("ALL".equals(source) || "OPEN".equals(source)) {
            System.out.println(source);
        } else {
            System.out.println("CLOSED");
        }

        if (deletedBy != null && !deletedBy.isEmpty()) {
            System.out.println("DELETED");
        } else {
            System.out.println("ACTIVE");
        }
    }

    public void sequentialProblemStrings(Integer id) {
        List<String> active = repository.findActive(id);
        List<String> byDiagnosis = repository.findSleeping(id);

        if (!CollectionUtils.isEmpty(active)) {
            System.out.println("Found active records");
        }

        if (!CollectionUtils.isEmpty(byDiagnosis)) {
            System.out.println("Found diagnosis records");
        }
    }

    public void deletedByLookup(Integer id) {
        List<FakeEntity> allRecords = repository.findAll();
        List<FakeEntity> openRecords = repository.findAllByName("name");
        FakeEntity entry = repository.findById(id).orElse(null);

        if (!CollectionUtils.isEmpty(allRecords)) {
            System.out.println("All records found");
        }

        if (!CollectionUtils.isEmpty(openRecords)) {
            System.out.println("Open records found");
        }

        if (entry != null) {
            System.out.println("Directory entry found");
        }
    }

    public static class ProblemRecord {
        private String source;
        private String deletedBy;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDeletedBy() {
            return deletedBy;
        }

        public void setDeletedBy(String deletedBy) {
            this.deletedBy = deletedBy;
        }
    }

    public static class DoctorDirectoryEntry {
        private String doctorId;
        private String name;

        public String getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(String doctorId) {
            this.doctorId = doctorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ProblemQuery {
        private String diagnosisType;

        public String getDiagnosisType() {
            return diagnosisType;
        }

        public void setDiagnosisType(String diagnosisType) {
            this.diagnosisType = diagnosisType;
        }
    }

    public void setQuery(ProblemQuery query) {
        this.query = query;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
