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
public class DepartmentDto {
    
    private String name;
    private List<CourseDto> courseDtoList;
    
    public DepartmentDto() {
        this.courseDtoList = new ArrayList<CourseDto>();
    }

    public DepartmentDto(String name) {
        this.courseDtoList = new ArrayList<CourseDto>();
        this.name = name;
    }

    public DepartmentDto(String department, List<CourseDto> courseDtoList) {
        this.courseDtoList = new ArrayList<CourseDto>();
        this.name = department;
        this.courseDtoList = courseDtoList;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String department) {
        this.name = department;
    }

    public List<CourseDto> getCourseDtoList() {
        return courseDtoList;
    }

    public void setCourseDtoList(List<CourseDto> courseDtoList) {
        this.courseDtoList = courseDtoList;
    }
    
}
