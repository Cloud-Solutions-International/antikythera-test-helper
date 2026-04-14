package sa.com.cloudsolutions.antikythera.testhelper.repository;

import sa.com.cloudsolutions.antikythera.testhelper.evaluator.BranchingCombinations;
import java.util.List;

public interface CombinationRepository {

    List<String> findActive(Long id, boolean active, boolean deleted);

    List<String> findActiveByDiagnosisType(Long id, boolean active, boolean deleted, String diagnosisType);

    List<BranchingCombinations.ProblemRecord> findAllRecords();

    List<BranchingCombinations.ProblemRecord> findOpenRecords();
}
