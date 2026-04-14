package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings({"java:S106", "unused", "java:S1192"})
public class BranchingCombinations {

    private final CombinationRepository repository;
    private ProblemQuery query;
    private List<String> values;

    public BranchingCombinations(CombinationRepository repository) {
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

    public void deletedByDirect(ProblemRecord record) {
        String source = record.getSource();
        String deletedBy = record.getDeletedBy();

        if ("ALL".equals(source) || "OPEN".equals(source)) {
            System.out.println(source);
        } else {
            System.out.println("OPEN");
        }

        if (deletedBy != null && !deletedBy.isEmpty()) {
            System.out.println("DELETED");
        } else {
            System.out.println("ACTIVE");
        }
    }

    public void sequentialProblemStrings(Long id) {
        List<String> active = repository.findActive(id, true, true);
        List<String> byDiagnosis = repository.findActiveByDiagnosisType(id, true, true, "test");

        if (!CollectionUtils.isEmpty(active)) {
            System.out.println("Found active records");
        }

        if (!CollectionUtils.isEmpty(byDiagnosis)) {
            System.out.println("Found diagnosis records");
        }
    }

    public void deletedByLookup(Long id) {
        List<ProblemRecord> allRecords = repository.findAllRecords();
        List<ProblemRecord> openRecords = repository.findOpenRecords();
        DoctorDirectoryEntry entry = repository.lookup();

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

@Repository
interface CombinationRepository {
    List<String> findActive(Long id, boolean active, boolean deleted);
    List<String> findActiveByDiagnosisType(Long id, boolean active, boolean deleted, String diagnosisType);
    List<ProblemRecord> findAllRecords();
    List<ProblemRecord> findOpenRecords();
    DoctorDirectoryEntry lookup();
}
