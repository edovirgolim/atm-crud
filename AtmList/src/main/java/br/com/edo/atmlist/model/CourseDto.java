/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edo.atmlist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edo Virgolim
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto {
    
    private String name;
    private List<StudentDto> studentDtoList;
    
    public CourseDto() {
        this.studentDtoList = new ArrayList<StudentDto>();
    }

    public CourseDto(String name, List<StudentDto> studentDtoList) {
        this.studentDtoList = new ArrayList<StudentDto>();
        this.name = name;
        this.studentDtoList = studentDtoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDto> getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }

    
    
    
    
}
