package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Registration;
import kr.ac.hansung.cse.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/result")
    public String showResult(Model model) {
        // 2024년도 2학기에 해당하는 데이터만 가져오기 위한 쿼리
        List<Registration> registration = registerService.getCoursesByGroup(2024, 2);
        model.addAttribute("courses", registration);
        return "result";
    }


    @GetMapping("/registration")
    public String createRegister(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }

    @PostMapping("/doneregister")
    public String doRegister(Model model, @Valid Registration registration, BindingResult result) {
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                if ("credit".equals(error.getField()) && "typeMismatch".equals(error.getCode())) {
                    // credit 필드에 타입 불일치 오류가 있는 경우
                    model.addAttribute("creditError", "학점은 숫자로 입력해주세요.");
                } else {
                    // 다른 필드의 일반적인 검증 오류 메시지
                    model.addAttribute(error.getField() + "Error", error.getDefaultMessage());
                }
            }
            return "registration"; // 오류가 있는 경우, 폼 페이지로 돌아가기
        }

        registration.setYear(2024); //년도에 2024 추가
        registration.setSemester(2); //학기에 2 추가
        registerService.insert(registration);
        return "doneregister";
    }

}
