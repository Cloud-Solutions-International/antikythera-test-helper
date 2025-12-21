# Antikythera Test Helper Guide

Test fixture classes for Antikythera test generation, refactoring validation, and examples.

## Quick Start

```java
// Load test fixture via AntikytheraRunTime
String className = "sa.com.cloudsolutions.antikythera.testhelper.refactoring.SimpleCalculatorDup";
CompilationUnit cu = AntikytheraRunTime.getCompilationUnit(className);
```

## Setup and Configuration

### Loading Configuration

Before using test helpers, initialize Settings with your `generator.yml` configuration:

```java
// Load default generator.yml from classpath
Settings.loadConfigMap();

// OR load from custom file
File customConfig = new File("/path/to/custom-generator.yml");
Settings.loadConfigMap(customConfig);
```

**Configuration Properties:**
- `base_path` - Source code location (e.g., "src/main/java")
- `base_package` - Root package for AUT (e.g., "com.example.app")
- `output_path` - Where generated tests go
- `dependencies` - Artifact IDs and JAR files
- `variables` - Custom variables (supports `${ENV_VAR}` and `${USERDIR}`)

**Override Properties:**
```java
// Override base_path to point to test-helper
Path testHelperRoot = Paths.get("../antikythera-test-helper").toAbsolutePath();
Settings.setProperty(Settings.BASE_PATH, testHelperRoot.resolve("src/main/java").toString());
```

### Preprocessing Source Files

After configuring Settings, preprocess all Java files to build the compilation unit cache:

```java
// Parse all .java files in BASE_PATH and cache them
AbstractCompiler.preProcess();
```

**What `preProcess()` does:**
1. Walks through all `.java` files in `Settings.getBasePath()`
2. Compiles each file using JavaParser
3. Resolves interfaces and builds type solver cache
4. Stores CompilationUnits in AntikytheraRunTime

**Reset Parser:**
```java
// Reset type solver and parser configuration
AbstractCompiler.reset();
```

### Complete Setup Example

```java
@BeforeAll
static void setup() throws IOException {
    Settings.loadConfigMap(new File("src/test/resources/generator.yml"));
    AbstractCompiler.preProcess();
}

@BeforeEach
void setUp() {
    // Now use any test helper class
    CompilationUnit cu = AntikytheraRunTime.getCompilationUnit("sa.com.cloudsolutions.antikythera.testhelper.evaluator.Hello");
    assertNotNull(cu);
}
```

**That's it!** The test helpers are already in the classpath, so no path overrides needed.



## Package Structure

### Antipatterns (`antipatterns`)
Test fixtures demonstrating Spring test anti-patterns for refactoring:

- `HeavyweightUnitTest` - `@SpringBootTest` with only mocks → convert to unit test
- `InefficientControllerTest` - `@SpringBootTest` with MockMvc → use `@WebMvcTest`
- `InefficientRepositoryTest` - `@SpringBootTest` with repository → use `@DataJpaTest`
- `LegacyContextTest` - Legacy `@ContextConfiguration` usage
- `UnsafeIntegrationTest` - Server integration without proper config

**Used by**: antikythera-examples (cleanunit), bertie (dedup)

### Evaluator (`evaluator`)
Test classes for expression evaluation engine testing:

**Core Classes**:
- `Hello` - Simple methods for basic evaluation (15+ tests)
- `Conditional` - If/else statements and ternary operators
- `Loops` - For/while loop constructs
- `TryCatch` - Exception handling patterns
- `Static` - Static members and methods (70+ tests)

**Domain Objects**:
- `Person`/`PersonExt` - Inheritance testing
- `Employee` - Complex domain model
- `Contact`/`IContact` - Interface testing

**Advanced**:
- `Opt` - Optional/nullable handling (100+ tests)
- `Reflective` - Reflection and introspection (30+ tests)
- `Autowired` - Spring dependency injection (100+ tests)
- `Functional` - Lambda and functional programming
- `Queries` - JPA query testing

**Enums**:
- `Status` - Simple enum (100+ tests across parsers/HQL)
- `MultiFieldEnum` - Complex enum with multiple fields

**Used by**: antikythera (core), antikythera-examples, bertie

### Model (`model`)
JPA entity test fixtures:

- `User` - Primary test entity with vehicles relationship (80+ tests)
- `Vehicle`, `Car` - Entity relationships
- `Cat`, `Dog`, `Animal` - Simple inheritance hierarchy
- `FakeEntity` - Mock entity for evaluator tests
- `FoodIngredient` - Unused

**Example**:
```java
// User entity with JPA annotations
@Entity
@Table(name = "users")
public class User {
    @Id private Long id;
    private String username;
   private String email;
    @OneToMany(mappedBy = "owner") 
    private List<Vehicle> vehicles;
}
```

**Used by**: antikythera (parser/HQL), antikythera-examples, bertie

### Parser (`parser`)
- `Empty` - Minimal class for parser testing (100+ tests)

### Refactoring (`refactoring`)
Duplication detector test fixtures with *Dup (duplicated) and *Clean (refactored) pairs:

- `SimpleCalculatorDup` / `SimpleCalculatorClean`
- `UserValidatorDup` / `UserValidatorClean`
- `StaticUtilsDup` / `StaticUtilsClean`
- `FileProcessorDup` / `FileProcessorClean`
- `ReportGeneratorDup` / `ReportGeneratorClean`

**Example Usage**:
```java
@Test
void testSimpleCalculatorRefactoring() throws IOException {
    // Load test fixture
    String className = "sa.com.cloudsolutions.antikythera.testhelper.refactoring.SimpleCalculatorDup";
    CompilationUnit cu = AntikytheraRunTime.getCompilationUnit(className);
    
    // Analyze for duplicates
    DuplicationReport report = analyzer.analyzeFile(cu, sourceFile);
    assertTrue(report.hasDuplicates());
    
    // Run refactoring
    RefactoringEngine.RefactoringSession session = engine.refactorAll(report);
    assertTrue(session.getSuccessful().size() > 0);
    
    // Verify helper method was extracted
    String refactoredCode = Files.readString(sourceFile);
    assertTrue(refactoredCode.contains("private "));
}
```

**Used by**: bertie

### Repository (`repository`)
- `UserRepository` - JPA repository (10+ tests)
- `FakeRepository` - Mock repository for evaluator
- `AnimalRepository`, `VehicleRepository`, `FoodIngredientRepository` - Unused

### Service (`service`)
- `FakeService` - Mock service for evaluator (4 tests)
- `UserService` - Test service for refactoring tests (6 tests in bertie)

## DepSolver (`depsolver`)
Dependency resolution test fixtures:

- `DummyAnnotation`, `DummyClass` - Annotation processing
- `ConcreteImplementation`, `InterfaceA/B/C` - Unused
- `ArrayAnnotation` - Unused

## Usage by Project

| Project | Test Helpers Used | Purpose |
|---------|-------------------|---------|
| **antikythera** | 52 classes | Core evaluator, parser, generator, depsolver |
| **antikythera-examples** | 18 classes | Query optimization, test refactoring (cleanunit) |
| **bertie** | 15 classes | Duplication detector validation (dedup) |

> **Note**: The `com.raditha` package does NOT exist in antikythera:
> - `com.raditha.cleanunit.*` → antikythera-examples
> - `com.raditha.dedup.*` → bertie
> - `com.raditha.hql.*` → hql-parser (external)

## Most Used Classes

1. **Empty** (100+) - Universal minimal test fixture
2. **Opt** (100+) - Optional/nullable testing
3. **Autowired** (100+) - Spring injection testing
4. **Static** (70+) - Static member testing
5. **Status** (100+) - Enum testing
6. **User** (80+) - Primary JPA entity
7. **Reflective** (30+) - Reflection testing

## Unused Classes

19 classes are not currently used in tests:
- depsolver: `ArrayAnnotation`, `ConcreteImplementation`, `InterfaceA/B/C`
- evaluator: `FakeSpecification`, `IContact`, `MultiFieldEnum`
- model: `FoodIngredient`
- refactoring: All `*Clean` classes (reference implementations)
- repository: `AnimalRepository`, `FoodIngredientRepository`, `VehicleRepository`
