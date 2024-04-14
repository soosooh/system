package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Registration {
    private int year = 2024;
    private int semester = 2;

    @Size(min = 7, max = 7, message = "교과목 코드는 정확히 7자리여야 합니다.")
    @NotEmpty(message="교과목 코드는 비어있을 수 없습니다.")
    private String courseCode;

    @NotEmpty(message="교과목명은 비어있을 수 없습니다.")
    private String courseName;

    @NotEmpty(message="교과구분은 비어있을 수 없습니다.")
    private String courseType;

    @NotEmpty(message="담당 교수는 비어있을 수 없습니다.")
    private String professor;

    @NotNull(message="학점은 비어있을 수 없습니다.")
    private Integer credit;
}
