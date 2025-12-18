package org.amigoscode.Exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExerciseTest {

    private final Exercise exercise = new Exercise();

    // -------------------- 1. getGrade --------------------

    @ParameterizedTest
    @CsvSource({
            "90, A",
            "91, A",
            "100, A",
            "80, B",
            "81, B",
            "89, B",
            "70, C",
            "71, C",
            "79, C",
            "60, D",
            "61, D",
            "69, D",
            "50, E",
            "51, E",
            "59, E",
            "49, F",
            "0, F",
            "1, F"
    })
    void canGetTheCorrectGrade(int grade, String expectedGrade) {
        var actual = exercise.getGrade(grade);
        assertThat(actual).isEqualTo(expectedGrade);
    }

    @ParameterizedTest
    @CsvSource({
            "102",
            "-10",
            "-1",
            "9009"
    })
    void willThrowWhenInvalidGrade(int grade) {
        assertThatThrownBy(() -> exercise.getGrade(grade))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Score must be between 0 and 100");
    }

    // -------------------- 2. countVowels --------------------

    @Test
    void countVowelsWhenValidName() {
        var result = exercise.countVowels("Yusuf");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void countVowelsWhenNull() {
        var result = exercise.countVowels(null);
        assertThat(result).isZero();
    }

    // -------------------- 3. isValidStudentId --------------------

    @ParameterizedTest
    @CsvSource({
            "S1234, true",
            "S0001, true",
            "A1234, false",
            "S123, false",
            "'', false"
    })
    void isValidStudentId(String id, boolean expected) {
        var result = exercise.isValidStudentId(id);
        assertThat(result).isEqualTo(expected);
    }

    // -------------------- 4. calculateAverage --------------------

    @Test
    void calculateAverageWhenGivenValues() {
        var result = exercise.calculateAverage(List.of(1, 2, 3, 4, 5));
        assertThat(result).isEqualTo(3.0);
    }

    @Test
    void calculateAverageWhenEmpty() {
        var result = exercise.calculateAverage(List.of());
        assertThat(result).isEqualTo(0.0);
    }

    @Test
    void calculateAverageWhenNull() {
        var result = exercise.calculateAverage(null);
        assertThat(result).isEqualTo(0.0);
    }

    // -------------------- 5. generateUsername --------------------

    @Test
    void generateUsernameFromFullName() {
        var result = exercise.generateUsername("John Smith");
        assertThat(result).isEqualTo("jsmith");
    }

    @Test
    void generateUsernameWhenInvalidInput() {
        var result = exercise.generateUsername("John");
        assertThat(result).isEmpty();
    }

    // -------------------- 6. getTopStudents --------------------

    @Test
    void getTopStudentsAboveThreshold() {
        var students = List.of(
                new Student("Alex", 18),
                new Student("Jamila", 99),
                new Student("Yusuf", 38)
        );

        var result = exercise.getTopStudents(students, 50);

        assertThat(result)
                .containsExactly(  new Student("Yusuf", 38),
                        new Student("Alex", 18));
    }

    @Test
    void getTopStudentsWhenNull() {
        var result = exercise.getTopStudents(null, 50);
        assertThat(result).isEmpty();
    }

    // -------------------- 7. hasDuplicateNames --------------------

    @Test
    void hasDuplicateNamesWhenDuplicatesExist() {
        var students = List.of(
                new Student("Alex", 10),
                new Student("alex", 20)
        );

        var result = exercise.hasDuplicateNames(students);
        assertThat(result).isTrue();
    }

    @Test
    void hasDuplicateNamesWhenUnique() {
        var students = List.of(
                new Student("Alex", 10),
                new Student("Jamila", 20)
        );

        var result = exercise.hasDuplicateNames(students);
        assertThat(result).isFalse();
    }

    // -------------------- 8. reverseCourses --------------------

    @Test
    void reverseCoursesCorrectly() {
        var courses = List.of("Math", "Physics", "Chemistry");

        var result = exercise.reverseCourses(courses);

        assertThat(result).containsExactly("Chemistry", "Physics", "Math");
    }

    @Test
    void reverseCoursesWhenNull() {
        var result = exercise.reverseCourses(null);
        assertThat(result).isEmpty();
    }

    // -------------------- 9. hasPassed --------------------

    @ParameterizedTest
    @CsvSource({
            "50, true",
            "49, false",
            "100, true"
    })
    void hasPassedCorrectly(int score, boolean expected) {
        var result = exercise.hasPassed(score);
        assertThat(result).isEqualTo(expected);
    }

    // -------------------- 10. assignBadge --------------------

    @Test
    void assignBadgeWhenHelpful() {
        var result = exercise.assignBadge(true);
        assertThat(result).isEqualTo("Star Student");
    }

    @Test
    void assignBadgeWhenNotHelpful() {
        var result = exercise.assignBadge(false);
        assertThat(result).isEqualTo("Needs Improvement");
    }
}
