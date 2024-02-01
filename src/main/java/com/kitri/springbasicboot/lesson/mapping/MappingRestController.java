package com.kitri.springbasicboot.lesson.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController //응답할때 responseBody 로 보내주겠다는 의미, 뷰호출X, 클래스 레벨에서 선언했으므로 아래 모든것들이 적용받음
@RequestMapping("/students") // localhost:8080/students/ 다 받음 , ReqyestMapping은 클래스레벨에서 URL을 필터함
public class MappingRestController {

    static HashMap<Long, Student> students = new HashMap<>();

    static {
        students.put(1L, new Student(1L, "살바도르 달리"));
        students.put(2L, new Student(2L, "빈센트 반 고흐"));
        students.put(3L, new Student(3L, "데이비드 호크니"));
        students.put(4L, new Student(4L, "노먼 록웰"));
    }

    // RestApi 는 URL 구분
    // /students/2 << 학생하나조회 GET
    // /students << 학생 전제조회 GET
    // /students << 학생추가 POST
    // /students/2 << 학생 업데이트 PUT
    // /students/2 <<  학생 삭제 DELETE

    @GetMapping("/student")
    public String student(){
        return  "학생";
    }

    // 학생 1명 조회
    @GetMapping("/{id}") //<< 동적인 값으로 받겠다
    public Student getStudent(@PathVariable long id){
        return students.get(id);
        //객체를 반환했는데 스프링이 JSON 형태로 반환함
    }

    @GetMapping("") //<< 동적인 값으로 받겠다
    public ArrayList<Student> getAll(){
        return new ArrayList<>(students.values());
        //객체를 반환했는데 스프링이 JSON 형태로 반환함
    }

    @PostMapping(path = "", consumes = {"application/json"}) //<< consumes 해당하는 요청만 처리하겠다, 요청하는 타입을 제한
    public long addStudent(){
        new Student(5L, "에드워드 호퍼");
        return 3L;
    }

    @GetMapping(path = "/produces", produces = {"application/json"}) // << 서버에서 응답하는 타입을 제안할때 produces
    public String  produces(){
        return "OK";
    }

}
