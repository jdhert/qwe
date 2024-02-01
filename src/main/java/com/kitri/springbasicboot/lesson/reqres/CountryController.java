package com.kitri.springbasicboot.lesson.reqres;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
//@RequestMapping("/countries")
public class CountryController {

    static HashMap<String, Country> countries = new HashMap<>();
    static {
        countries.put("한국", new Country("한국", "서울"));
        countries.put("미국", new Country("미국", "워싱턴DC"));
        countries.put("프랑스", new Country("프랑스", "파리"));
        countries.put("몽골", new Country("몽골", "울란바토르"));
        countries.put("아르헨티나", new Country("아르헨티나", "부에노스 아이레스"));
    }

    @GetMapping
    public ArrayList<Country> countries(){
        return new ArrayList<>(countries.values());
    }

//    @PostMapping("") // requestParam(객체 타입을 못받음)은 JSON으로 못받음
//    public Country addCountry(@RequestParam String name, @RequestParam String capital){
//        countries.put(name,new Country(name, capital));
//        return countries.get(name);
//    }

    //@PostMapping("") //
    public Country addCountry2(@RequestBody Country country){
        countries.put(country.getName(), country);
        return countries.get(country.getName());
    }

    @PostMapping("") // Model Attribute는 바디에 안담아야 받을수 있음 JSON으로 오는걸 처리못함
    // ModelAttribute는 입력값을 객체로 반환 해줌
    public Country addCountry3(@ModelAttribute Country country){
        countries.put(country.getName(), country);
        return countries.get(country.getName());
    }

    @PostMapping("/4") // Model Attribute는 바디에 안담아야 받을수 있음 JSON으로 오는걸 처리못함
    public ResponseEntity<Country> addCountry4(@ModelAttribute Country country){
        // 좀더 커스터마이징 해서 보내고 싶으면 ResponseEntity 사용
        countries.put(country.getName(), country);
        return new ResponseEntity<>(countries.get(country.getName()), HttpStatus.UNAUTHORIZED); // 상태코드 조작 가능함
//        return ResponseEntity.ok(countries.get(country.getName()));
    }
}
